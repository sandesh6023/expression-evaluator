package sandeshm.expeval.main;

import sandeshm.expeval.lib.Parser;

public class ExpressionEvalMain {
    public static void main(String[] args) throws Exception {
        System.out.println(Parser.create(args[0]).getExpression().evaluate());
    }
}

