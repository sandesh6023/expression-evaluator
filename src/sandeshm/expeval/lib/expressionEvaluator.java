package sandeshm.expeval.lib;

public class expressionEvaluator {
    public int evaluateExpression(String expression) throws Exception {
        int isParanthesisInExpr = expression.indexOf('(');
        String[] splittedExpression = expression.split(" ");
        Operations operate = new Operations();

        if (isParanthesisInExpr != -1)
            return operate.evaluateExpressionWithParanthesis(expression);

        return operate.evaluateMultipleOperands(splittedExpression);
    }
}
