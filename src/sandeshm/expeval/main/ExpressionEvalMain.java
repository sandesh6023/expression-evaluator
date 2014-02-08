package sandeshm.expeval.main;

import sandeshm.expeval.lib.Operations;

public class ExpressionEvalMain {
    public static void main(String[] args) throws Exception {
        Operations operate = new Operations();
        String newExpression = operate.replaceExpression(args[0]);
        System.out.println(operate.evaluateExpression(newExpression));
    }
}

