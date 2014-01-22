package sandeshm.expeval.lib;


public class expressionEvaluator {
    public int evaluateExpression(String expression) {
        String[] values = expression.split(" ");
        Operations operate = new Operations();
        int result = 0;
        int operand1 = Integer.parseInt(values[0]);
        int operand2 = Integer.parseInt(values[2]);
        String operator = values[1];

        if (operator.equals("+")) {
            return result = operate.add(operand1, operand2);
        }
        if (operator.equals("-")) {
            result = operate.subtract(operand1, operand2);
        }
        if (operator.equals("/")) {
            result = operate.divide(operand1, operand2);
        }
        if (operator.equals("*")) {
            result = operate.multiply(operand1, operand2);
        }
        if (operator.equals("^")) {
            result = operate.evaluatePower(operand1, operand2);
        }
        return result;
    }
}
