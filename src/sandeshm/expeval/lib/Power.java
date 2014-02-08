package sandeshm.expeval.lib;

public class Power extends Operation {

    @Override
    public double evaluateExpression(ValueExpression  leftExpr, ValueExpression rightExpr) {
        return Math.pow(leftExpr.getValue() , rightExpr.getValue());
    }
}
