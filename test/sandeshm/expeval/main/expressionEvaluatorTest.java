package sandeshm.expeval.main;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import sandeshm.expeval.lib.expressionEvaluator;

public class expressionEvaluatorTest {
    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + 3");
        double expected = 5.0;
        assertEquals(actual,expected);
    }

    @Test
    public void testEvaluateExpressionShouldSubtractNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("10 - 3");
        double expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldDivideNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("12 / 3");
        double expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldMultiplyNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("12 * 3");
        double expected = 36;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldEvaluateNumberToPower() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 ^ 4");
        double expected = 16;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + 4 + 7 * 2");
        double expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands2() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + 4 - 3 * 2");
        double expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands3() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 ^ 4 - 3 * 2");
        double expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands4() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 ^ 4 - 4 / 4");
        double expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + (3 * 5)");
        double expected = 17;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets2() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + (3 * 5) + (4 * 2)");
        double expected = 25;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets3() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("2 + (5 - 3 ) + (2 ^ 2)");
        double expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets4() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("(2 + 5)");
        double expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("1 + ((2 + 5) + 1)");
        double expected = 9;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets2() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("1 + (((2 + 5) + 1) * 5)");
        double expected = 41;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets3() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        double actual = eval.evaluateExpression("(3 + (6 * 9) + 1)");
        double expected = 58;
        assertEquals(actual, expected);
    }
}
