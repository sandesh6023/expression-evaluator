package sandeshm.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String expression;

    private Parser(String expression) {
        this.expression = expression;
    }

    private boolean isOperator(String s) {
        String possibleOperators = "+-*/^";
        return possibleOperators.contains(s);
    }

    public List<String> getOperators() {
        List<String> operators = new ArrayList<String>();
        String[] splittedExp = expression.split(" ");
        for (String s : splittedExp) {
            if (isOperator(s))
                operators.add(s);
        }
        return operators;
    }
    private List<Double> getOperands() {
        List<Double> operands = new ArrayList<Double>();
        String[] splittedExp = expression.split(" ");

        for (String s : splittedExp) {
            if (!isOperator(s))
                operands.add(Double.parseDouble(s));
        }
        return operands;
    }
    public ValueExpression getExpression(){
        return ValueExpression.create(getOperands(), getOperators());
    }

    public static Parser create(String text) {
        String parserText = text.trim().replaceAll(" +", "")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\(", "(")
                .replaceAll("\\)", ")")
                .replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -")
                .replaceAll("^ - ", "-")
                .replaceAll("\\( - ", "(-");
        return new Parser(parserText);

    }
}
