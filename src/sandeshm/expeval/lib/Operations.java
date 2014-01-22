package sandeshm.expeval.lib;

class Operations{
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
