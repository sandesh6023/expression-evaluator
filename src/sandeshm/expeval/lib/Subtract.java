package sandeshm.expeval.lib;

/**
 * Created by sandeshm on 2/8/14.
 */
public class Subtract extends Operation {
    @Override
    public double evaluateExpression(ValueExpression leftExpr, ValueExpression rightExpr) {
        return leftExpr.getValue() - rightExpr.getValue();
    }
}
