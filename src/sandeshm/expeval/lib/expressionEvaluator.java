package sandeshm.expeval.lib;

public class expressionEvaluator {
    public double evaluateExpression(String expression) throws Exception {
        Operations operate = new Operations();
        String newExpression = operate.replaceExpression(expression);

//        String[] expressionParts = newExpression.split(" ");
//        if (expression.contains("(")) {
//            return operate.evaluateExpressionWithParantheses(newExpression);
//        }
        return operate.evaluateExpressionWithoutBrackets(newExpression);

    }
}
