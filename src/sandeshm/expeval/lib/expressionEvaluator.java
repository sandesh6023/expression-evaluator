package sandeshm.expeval.lib;

public class expressionEvaluator {
    public double evaluateExpression(String expression) throws Exception {
        int isParanthesisInExpr = expression.indexOf('(');
        Operations operate = new Operations();
        String newExpression = operate.replaceExpression(expression);
        String[] splittedExpression = newExpression.split("\\s+");
        if (isParanthesisInExpr != -1)
            return operate.evaluateExpressionWithParanthesis(newExpression);

        return operate.evaluateMultipleOperands(splittedExpression);
    }
}
