package sandeshm.expeval.lib;

public class expressionEvaluator {
    public int evaluateExpression(String expression) {
        String[] values = expression.split(" ");
        Operations operate = new Operations();
        int operand1 = Integer.parseInt(values[0]);
        int operand2 = Integer.parseInt(values[2]);
        String operator = values[1];

        return operate.evaluate(operator, operand1, operand2);
    }
}
