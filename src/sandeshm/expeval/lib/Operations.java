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

    public int computeMultipleOperands(List<Integer> operands, List<String> operators, Operations op) {
        int result = op.evaluate(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = op.evaluate(operators.get(i), result, operands.get(i + 1));
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
}