package sandeshm.expeval.lib;

public class SimpleExpression implements Expression{
    private Expression leftHandSide;
    private Expression rightHandSide;
    private Operation operator;

    public SimpleExpression(Expression leftHandSide, Expression rightHandSide, Operation operator) {

        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.operator = operator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleExpression that = (SimpleExpression) o;

        if (leftHandSide != null ? !leftHandSide.equals(that.leftHandSide) : that.leftHandSide != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (rightHandSide != null ? !rightHandSide.equals(that.rightHandSide) : that.rightHandSide != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leftHandSide != null ? leftHandSide.hashCode() : 0;
        result = 31 * result + (rightHandSide != null ? rightHandSide.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public ValueExpression evaluateExpression() {
    return new ValueExpression(operator.evaluateExpression(this.leftHandSide,this.rightHandSide));
    }
}
