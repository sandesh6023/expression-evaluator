package sandeshm.expeval.main;

import org.junit.Test;
import sandeshm.expeval.lib.expressionEvaluator;

import static org.junit.Assert.assertEquals;

public class expressionEvaluatorTest {

    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + 3");
        int expected = 5;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldSubtractNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("10 - 3");
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldDivideNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("12 / 3");
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldMultiplyNumbers() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("12 * 3");
        int expected = 36;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldEvaluateNumberToPower() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 ^ 4");
        int expected = 16;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + 4 + 7 * 2");
        int expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands2() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + 4 - 3 * 2");
        int expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands3() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 ^ 4 - 3 * 2");
        int expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands4() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 ^ 4 - 4 / 4");
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + (3 * 5)");
        int expected = 17;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets2() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + (3 * 5) + (4 * 2)");
        int expected = 25;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets3() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("2 + (5 - 3 ) + (2 ^ 2)");
        int expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets4() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("(2 + 5)");
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets5() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        int actual = eval.evaluateExpression("(2 + 5) + (1 + 3)");
        int expected = 11;
        assertEquals(actual, expected);
    }
}
