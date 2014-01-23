package sandeshm.expeval.lib;

public class expressionEvaluator {
    public int evaluateExpression(String expression) {
        String[] splittedExpression = expression.split(" ");
        Operations operate = new Operations();

        return operate.evaluateMultipleOperands(splittedExpression);
    }
}
