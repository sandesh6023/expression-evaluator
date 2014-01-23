package sandeshm.expeval.lib;

class Operations{

    public int evaluate(String operator,int operand1,int operand2){
        int result = 0;
        if (operator.equals("+")) {
            result = add(operand1, operand2);
        }
        if (operator.equals("-")) {
            result = subtract(operand1, operand2);
        }
        if (operator.equals("/")) {
            result = divide(operand1, operand2);
        }
        if (operator.equals("*")) {
            result = multiply(operand1, operand2);
        }
        if (operator.equals("^")) {
           result = evaluatePower(operand1, operand2);
        }
        return result;
    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }
    public int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }
    public int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }
    public int evaluatePower(int operand1, int operand2) {
        return (int) Math.pow(operand1,operand2);
    }
}


