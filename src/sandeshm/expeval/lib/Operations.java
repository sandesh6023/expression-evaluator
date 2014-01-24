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

    public List<String> getOperators(String[] splittedExp, List<Double> operands) {
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp) {
            try {
                operands.add(Double.parseDouble(s));
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        return operators;
    }

    public double computeMultipleOperands(List<Double> operands, List<String> operators) {
        Operations operate = new Operations();
        double result = operate.evaluate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = operate.evaluate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }

    public double evaluateMultipleOperands(String[] splittedExpression) {
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = getOperators(splittedExpression, operands);

        double result = computeMultipleOperands(operands, operators);
        return result;
    }

    public String evaluateWithBrackets(String expression) throws Exception {
        StringBuffer exprWithBracket = new StringBuffer(expression);
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                startIndex = i;
            }
            if (expression.charAt(i) == ')') {
                endIndex = i;
                break;
            }
        }
        String expressionInBrackets = expression.substring(startIndex + 1, endIndex);
        double result = evaluateExpressionWithParanthesis(expressionInBrackets);
        exprWithBracket.replace(startIndex, endIndex + 1, Double.toString(result));
        return exprWithBracket.toString();
    }

    public double evaluateExpressionWithParanthesis(String expression) throws Exception {
        String exp = replaceExpression(expression);
        double result;
        if (expression.contains("(")) {
            String res = evaluateWithBrackets(expression);
            return evaluateExpressionWithParanthesis(res);
        }
        if (!exp.contains(" ")) return Double.parseDouble(exp);
        String[] data = exp.split(" ");

        List<Double> operands = new ArrayList<Double>();
        List<String> operators = getOperators(data, operands);
        result = computeMultipleOperands(operands, operators);
        return result;
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