package sandeshm.expeval.lib;

/**
 * Created by sandeshm on 2/8/14.
 */
public class Operator {
    public double evaluate(String operator, double operand1, double operand2) {
        double result = 0;
        if (operator.equals("+"))
            result = operand1 + operand2;
        if (operator.equals("-"))
            result = operand1 - operand2;
        if (operator.equals("/"))
            result = operand1 / operand2;
        if (operator.equals("*"))
            result = operand1 * operand2;
        if (operator.equals("^"))
            result = Math.pow(operand1, operand2);
        return result;
    }

}
