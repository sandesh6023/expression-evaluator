package sandeshm.expeval.main;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import sandeshm.expeval.lib.Expression;

public class expressionEvaluatorTest {
    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbers() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + 3");
        double expected = 5.0;
        assertEquals(actual, expected);
    }


    @Test
    public void testEvaluateExpressionShouldSubtractNumbers() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("10 - 3");
        double expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldDivideNumbers() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("12 / 3");
        double expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldMultiplyNumbers() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("12 * 3");
        double expected = 36;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldEvaluateNumberToPower() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 ^ 4");
        double expected = 16;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + 4 + 7 * 2");
        double expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands2() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + 4 - 3 * 2");
        double expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands3() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 ^ 4 - 3 * 2");
        double expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands4() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 ^ 4 - 4 / 4");
        double expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + (3 * 5)");
        double expected = 17;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets2() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + (3 * 5) + (4 * 2)");
        double expected = 25;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets3() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 + (5 - 3 ) + (2 ^ 2)");
        double expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets4() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("(2 + 5)");
        double expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("1 + ((2 + 5) + 1)");
        double expected = 9;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets2() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("1 + (((2 + 5) + 1) * 5)");
        double expected = 41;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBrackets3() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("(3 + (6 * 9) + 1)");
        double expected = 58;
        assertEquals(actual, expected);
    }

    // Handling spaces
    @Test
    public void testShouldEvaluateExpressionsWithNestedBracketsAndHandleSpaces() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("(3 +          (6* 9)+ 1)");
        double expected = 58;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateExpressionsWithNestedBracketsAndHandleSpaces2() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("(3 +  ((6*       9)+ 1)+3)");
        double expected = 61;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces3() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 +                     3");
        double expected = 5.0;
        assertEquals(actual, expected);
    }

    @Test

    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces4() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 +        3 * 2");
        double expected = 10.0;
        assertEquals(actual, expected);
    }

    @Test

    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces5() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 +        (3 * 2+1)");
        double expected = 9.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces6() throws Exception {
        Expression eval = new Expression();

        double actual = eval.evaluateExpression("2 +        (2*(3 * 2+1) + 9)");
        double expected = 25.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbers() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("5     + -2");
        double expected = 3.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbersWithBrackets() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("5 + (-2 + 1)");
        double expected = 4.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbersWithBrackets2() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("5 + (-2 *(-2 + 1))");
        double expected = 7.0;
        assertEquals(actual, expected);
    }



    @Test
    public void testEvaluateExpression1() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("1 -- 2");
        double expected = 3.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpression2() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("0.5+ 0.5");
        double expected = 1.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpression3() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("(1+((1)+(1)))");
        double expected = 3.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpression4() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("33");
        double expected = 33.0;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpression5() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("((((-1))))");
        double expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void testEvaluateExpressionPowerOfNegativeNumber() throws Exception {
        Expression eval = new Expression();
        double actual = eval.evaluateExpression("2 ^             -3");
        double expected = 0.125;
        assertEquals(actual, expected);
    }
}
