package sandeshm.expeval.lib;

import java.util.List;

public class ValueExpression implements Expression {
    List<Double> operands;
    List<String> operators;
    private double value;

    public ValueExpression(List<Double> operands, List<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public ValueExpression(double value) {
        this.value = value;
    }



    public double computeMultipleOperands() {
        Operator operate = new Operator();
        double result = operate.evaluate(operators.get(0), operands.get(0), operands.get(1));

        for (int i = 1; i < operators.size(); i++) {
            result = operate.evaluate(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }


    public double evaluate() throws Exception {
        if (operands.size() == 1 && operators.size() == 0)
            return operands.get(0);

        double result = computeMultipleOperands();
        return result;
        //return null;
    }

    public static ValueExpression create(List<Double> operands, List<String> operators) {
        return new ValueExpression(operands,operators);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueExpression that = (ValueExpression) o;

        if (this.getValue() == that.getValue())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = operands != null ? operands.hashCode() : 0;
        result = 31 * result + (operators != null ? operators.hashCode() : 0);
        return result;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Expression evaluateExpression() {
        return new ValueExpression(this.value);
    }

    //    public double evaluate(String ValueExpression) throws Exception {
//        ValueExpression = prettify(ValueExpression);
//        if(ValueExpression.contains("("))
//            ValueExpression = evaluateExpressionWithParantheses(ValueExpression);
//        String[] splittedExpression = ValueExpression.split(" ");
//        getOperands(splittedExpression);
//        getOperators(splittedExpression);
//
//        if (operands.size() == 1 && operators.size() == 0)
//            return operands.get(0);
//
//        double result = computeMultipleOperands();
//        return result;
//    }
//
//
//    public String evaluateExpressionWithParantheses(String expression) throws Exception {
//        Double result;
//        while (expression.contains("(")) {
//            int startIndex = expression.lastIndexOf("(");
//            int lastIndex = expression.indexOf(")", startIndex);
//            String expressionInBrackets = expression.substring(startIndex + 1, lastIndex);
//            result = evaluate(expressionInBrackets);
//            expression = expression.replace("(" + expressionInBrackets + ")", result.toString());
//        }
//        return expression;
//    }


}