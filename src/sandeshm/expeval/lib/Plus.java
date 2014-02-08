package sandeshm.expeval.lib;

public class Plus extends Operation{
    @Override
    public double evaluateExpression(ValueExpression leftExpr, ValueExpression rightExpr) {
        return leftExpr.getValue() + rightExpr.getValue();
    }
}
