package sandeshm.expeval.main;

import sandeshm.expeval.lib.expressionEvaluator;

public class ExpressionEvalMain {
    public static void main(String[] args) {
        expressionEvaluator eval = new expressionEvaluator();
        System.out.println(eval.evaluateExpression(args[0]));
    }
}
