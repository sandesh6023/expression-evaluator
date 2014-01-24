package sandeshm.expeval.main;

import sandeshm.expeval.lib.expressionEvaluator;

public class ExpressionEvalMain {
    public static void main(String[] args) throws Exception {
        expressionEvaluator eval = new expressionEvaluator();
        if (!(eval.validateBracketsInExpression(args[0]))) {
            System.out.println("Enter valid expression ");
            System.exit(0);
        }
        System.out.println(eval.evaluateExpression(args[0]));
    }
}
