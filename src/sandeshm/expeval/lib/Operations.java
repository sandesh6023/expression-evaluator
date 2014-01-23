package sandeshm.expeval.lib;

import java.util.ArrayList;
import java.util.List;

class Operations {

    public int evaluate(String operator, int operand1, int operand2) {
        int result = 0;
        if (operator.equals("+"))
            result = operand1 + operand2;
        if (operator.equals("-"))
            result = operand1 - operand2;
        if (operator.equals("/"))
            result = operand1 / operand2;
        if (operator.equals("*"))
            result = operand1 * operand2;
        if (operator.equals("^"))
            result = (int) Math.pow(operand1, operand2);
        return result;
    }

    public List<String> getOperators(String[] splittedExp, List<Integer> operands) {
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp) {
            try {
                operands.add(Integer.parseInt(s));
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        return operators;
    }

    public int computeMultipleOperands(List<Integer> operands, List<String> operators) {
        Operations operate = new Operations();
        int result = operate.evaluate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = operate.evaluate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }

    public int evaluateMultipleOperands(String[] splittedExpression) {
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperators(splittedExpression, operands);

        int result = computeMultipleOperands(operands, operators);
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
        int result = evaluateExpressionWithParanthesis(expressionInBrackets);
        exprWithBracket.replace(startIndex, endIndex + 1, Integer.toString(result));
        return exprWithBracket.toString();
    }

    public int evaluateExpressionWithParanthesis(String expression) throws Exception {
        if (!expression.contains(" ")) return Integer.parseInt(expression);

        String[] data = expression.split(" ");
        int result;
        if (expression.contains("(")) {
            String res = evaluateWithBrackets(expression);
            return evaluateExpressionWithParanthesis(res);
        }
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperators(data, operands);
        result = computeMultipleOperands(operands, operators);
        return result;
    }
}