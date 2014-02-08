package sandeshm.expeval.lib;


public class Multiply implements Operation {
    @Override
    public double evaluateExpression(Expression leftExpr, Expression rightExpr) {
        return leftExpr.evaluateExpression().getValue() * rightExpr.evaluateExpression().getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }
}
