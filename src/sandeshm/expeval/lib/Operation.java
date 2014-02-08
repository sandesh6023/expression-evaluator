package sandeshm.expeval.lib;


public abstract class Operation {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    abstract double evaluateExpression(ValueExpression leftExpr, ValueExpression rightExpr);
}
