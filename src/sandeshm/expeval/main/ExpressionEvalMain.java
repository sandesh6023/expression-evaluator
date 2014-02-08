package sandeshm.expeval.main;

import sandeshm.expeval.lib.Expression;

public class ExpressionEvalMain {
    public static void main(String[] args) throws Exception {
        Expression operate = new Expression();
        System.out.println(operate.evaluateExpression(args[0]));
    }
}

