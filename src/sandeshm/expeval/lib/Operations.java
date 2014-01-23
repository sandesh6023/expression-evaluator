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

    public int computeMultipleOperands(List<Integer> operands, List<String> operators, Operations operate) {
        int result = operate.evaluate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = operate.evaluate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }

    public int evaluateMultipleOperands(String[] splittedExpression) {
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperators(splittedExpression, operands);

        Operations op = new Operations();
        int result = computeMultipleOperands(operands, operators, op);
        return result;
    }

    public int evaluateExpressionWithParanthesis(String Expression) {
        StringBuffer expression = new StringBuffer(Expression);
        int FinalResult = 0;
        int startIndex = expression.indexOf("(");
        int endIndex = expression.indexOf(")");

        if (startIndex == -1)
            FinalResult = evaluateMultipleOperands(Expression.split(" "));

        else if (startIndex > 0) {
            String newstr = expression.substring(startIndex + 1, endIndex);
            Integer result = evaluateMultipleOperands(newstr.split(" "));
            StringBuffer ModifiedStr = expression.replace(startIndex, endIndex + 1, result.toString());
            return evaluateExpressionWithParanthesis(ModifiedStr.toString());
        }
        return FinalResult;
    }
}