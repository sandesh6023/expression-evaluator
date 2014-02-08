package sandeshm.expeval.lib;

public class Power implements Operation {

    @Override
    public double evaluateExpression(Expression  leftExpr, Expression rightExpr) {
        return Math.pow(leftExpr.evaluateExpression().getValue() , rightExpr.evaluateExpression().getValue());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }
}
