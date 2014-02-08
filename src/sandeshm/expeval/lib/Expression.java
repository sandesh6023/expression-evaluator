package sandeshm.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    List<Double> operands;
    List<String> operators;

    public double computeMultipleOperands() {
        Operator operate = new Operator();
        double result = operate.evaluate(operators.get(0), operands.get(0), operands.get(1));

        for (int i = 1; i < operators.size(); i++) {
            result = operate.evaluate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }

    private boolean isOperator(String s) {
        String possibleOperators = "+-*/^";
        return possibleOperators.contains(s);
    }

    public void getOperators(String[] splittedExp) {
        this.operators = new ArrayList<String>();
        for (String s : splittedExp) {
            if (isOperator(s))
                this.operators.add(s);
        }
    }

    private void getOperands(String[] splittedExpression) {
        this.operands = new ArrayList<Double>();
        for (String s : splittedExpression) {
            if (!isOperator(s))
                this.operands.add(Double.parseDouble(s));
        }
    }

    public double evaluateExpression(String Expression) throws Exception {
        Expression = replaceExpression(Expression);
        if(Expression.contains("("))
            Expression = evaluateExpressionWithParantheses(Expression);
        String[] splittedExpression = Expression.split(" ");
        getOperands(splittedExpression);
        getOperators(splittedExpression);

        if (operands.size() == 1 && operators.size() == 0)
            return operands.get(0);

        double result = computeMultipleOperands();
        return result;
    }


    public String evaluateExpressionWithParantheses(String expression) throws Exception {
        Double result;
        while (expression.contains("(")) {
            int startIndex = expression.lastIndexOf("(");
            int lastIndex = expression.indexOf(")", startIndex);
            String expressionInBrackets = expression.substring(startIndex + 1, lastIndex);
            result = evaluateExpression(expressionInBrackets);
            expression = expression.replace("(" + expressionInBrackets + ")", result.toString());
        }
        return expression;
    }

    public String replaceExpression(String expression) {
            return expression.trim().replaceAll(" +", "")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\(", "(")
                .replaceAll("\\)", ")")
                .replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -")
                .replaceAll("^ - ", "-")
                .replaceAll("\\( - ", "(-");
    }
}