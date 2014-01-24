package sandeshm.expeval.lib;

public class expressionEvaluator {
    public boolean validateBracketsInExpression(String expression) {
        int exprLength = expression.length();
        int noOfOpenBrackets = 0;
        int noOfClosedBrackets = 0;
        for (int i = 0; i < exprLength; i++) {
            if (expression.charAt(i) == '(')
                noOfOpenBrackets++;
            if (expression.charAt(i) == ')')
                noOfClosedBrackets++;
        }
        if (noOfOpenBrackets == noOfClosedBrackets)
            return true;
        return false;
    }

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
