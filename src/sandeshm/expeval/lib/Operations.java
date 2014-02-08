package sandeshm.expeval.lib;

import java.util.ArrayList;
import java.util.List;

class Operations {

    public double evaluate(String operator, double operand1, double operand2) {
        double result = 0;
        if (operator.equals("+"))
            result = operand1 + operand2;
        if (operator.equals("-"))
            result = operand1 - operand2;
        if (operator.equals("/"))
            result = operand1 / operand2;
        if (operator.equals("*"))
            result = operand1 * operand2;
        if (operator.equals("^"))
            result = Math.pow(operand1, operand2);
        return result;
    }

    public double computeMultipleOperands(List<Double> operands, List<String> operators) {
        Operations operate = new Operations();
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

    public List<String> getOperators(String[] splittedExp) {
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp) {
            if (isOperator(s))
                operators.add(s);
        }
        return operators;
    }

    private List<Double> getOperands(String[] splittedExpression) {
        List<Double> operands = new ArrayList<Double>();
        for (String s : splittedExpression) {
            if (!isOperator(s))
                operands.add(Double.parseDouble(s));
        }
        return operands;
    }

    public double evaluateExpressionWithoutBrackets(String[] splittedExpression) {
        List<Double> operands = getOperands(splittedExpression);
        List<String> operators = getOperators(splittedExpression);

        if (operands.size() == 1 && operators.size() == 0)
            return operands.get(0);

        double result = computeMultipleOperands(operands, operators);
        return result;
    }


    public double evaluateExpressionWithParantheses(String expression) throws Exception {
        String exp = replaceExpression(expression);
        Double result;
        if (expression.contains("(")) {
            int startIndex = expression.lastIndexOf("(");
            int lastIndex = expression.indexOf(")", startIndex);
            String expressionInBrackets = expression.substring(startIndex + 1, lastIndex);
            result = evaluateExpressionWithParantheses(expressionInBrackets);
            expression = expression.replace("(" + expressionInBrackets + ")", result.toString());
            return evaluateExpressionWithParantheses(expression);
        }
        if (!exp.contains(" ")) return Double.parseDouble(exp);
        String[] splittedExpression = exp.split(" ");
        return evaluateExpressionWithoutBrackets(splittedExpression);
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