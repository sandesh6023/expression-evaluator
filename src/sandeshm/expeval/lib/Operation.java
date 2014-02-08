package sandeshm.expeval.lib;


public interface Operation {
    abstract double evaluateExpression(Expression leftExpr, Expression rightExpr);
}
