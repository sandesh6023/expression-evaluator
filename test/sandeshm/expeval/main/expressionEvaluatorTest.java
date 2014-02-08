package sandeshm.expeval.main;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import sandeshm.expeval.lib.ValueExpression;
import sandeshm.expeval.lib.Parser;

import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluatorTest {
    @Test
    public void testEvaluateExpressionShouldReturnSumOfNumbers() throws Exception {
        Parser p = Parser.create("2 + 3");
        ValueExpression actual = p.getExpression();

        List<Double> operands = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();

        operands.add(2.0);
        operands.add(3.0);
        operators.add("+");

        ValueExpression expected = ValueExpression.create(operands, operators);
        assertEquals(actual, expected);
    }


    @Test
    public void testEvaluateExpressionShouldSubtractNumbers() throws Exception {
        Parser p = Parser.create("7 - 3");
        double actual = p.getExpression().evaluate();

        double expected = 4.0;
        assertEquals(actual, expected);
    }
//
    @Test
    public void testEvaluateExpressionShouldDivideNumbers() throws Exception {
        Parser p = Parser.create("12 / 3");
        double actual = p.getExpression().evaluate();

        double expected = 4.0;
        assertEquals(actual, expected);
    }
//
    @Test
    public void testEvaluateExpressionShouldMultiplyNumbers() throws Exception {
        Parser p = Parser.create("12 * 3");
        double actual = p.getExpression().evaluate();

        double expected = 36.0;
        assertEquals(actual, expected);
    }
//
    @Test
    public void testEvaluateExpressionShouldEvaluateNumberToPower() throws Exception {
        Parser p = Parser.create("2 ^ 3");
        double actual = p.getExpression().evaluate();

        double expected = 8.0;
        assertEquals(actual, expected);
    }
//
    @Test
    public void testShouldEvaluateMultipleOperands() throws Exception {

        Parser p = Parser.create("2 + 4 + 7 * 2");
        double actual =  p.getExpression().evaluate();
        double expected = 26;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands2() throws Exception {

        Parser p = Parser.create("2 + 4 - 3 * 2");
        double actual =  p.getExpression().evaluate();
        double expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testShouldEvaluateMultipleOperands3() throws Exception {
        Parser p = Parser.create("2 ^ 4 - 3 * 2");
        double actual =  p.getExpression().evaluate();
        double expected = 26;
        assertEquals(actual, expected);

    }

    @Test
    public void testShouldEvaluateMultipleOperands4() throws Exception {
        Parser p = Parser.create("2 ^ 4 - 4 / 4");
        double actual =  p.getExpression().evaluate();
        double expected = 3;
        assertEquals(actual, expected);

    }

    @Test
    public void testShouldEvaluateOperandsWithBrackets() throws Exception {
        Parser p = Parser.create("2 + (3 * 5)");
        double actual =  p.getExpression().evaluate();
        double expected = 3;
        assertEquals(actual, expected);

    }
//
//    @Test
//    public void testShouldEvaluateOperandsWithBrackets2() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 + (3 * 5) + (4 * 2)");
//        double expected = 25;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateOperandsWithBrackets3() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 + (5 - 3 ) + (2 ^ 2)");
//        double expected = 8;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateOperandsWithBrackets4() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("(2 + 5)");
//        double expected = 7;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateExpressionsWithNestedBrackets() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("1 + ((2 + 5) + 1)");
//        double expected = 9;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateExpressionsWithNestedBrackets2() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("1 + (((2 + 5) + 1) * 5)");
//        double expected = 41;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateExpressionsWithNestedBrackets3() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("(3 + (6 * 9) + 1)");
//        double expected = 58;
//        assertEquals(actual, expected);
//    }
//
//    // Handling spaces
//    @Test
//    public void testShouldEvaluateExpressionsWithNestedBracketsAndHandleSpaces() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("(3 +          (6* 9)+ 1)");
//        double expected = 58;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testShouldEvaluateExpressionsWithNestedBracketsAndHandleSpaces2() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("(3 +  ((6*       9)+ 1)+3)");
//        double expected = 61;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces3() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 +                     3");
//        double expected = 5.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//
//    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces4() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 +        3 * 2");
//        double expected = 10.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//
//    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces5() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 +        (3 * 2+1)");
//        double expected = 9.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionShouldReturnSumOfNumbersHandlesSpaces6() throws Exception {
//        ValueExpression eval = new ValueExpression();
//
//        double actual = eval.evaluate("2 +        (2*(3 * 2+1) + 9)");
//        double expected = 25.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbers() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("5     + -2");
//        double expected = 3.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbersWithBrackets() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("5 + (-2 + 1)");
//        double expected = 4.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionShouldReturnDifferenceBetweenNumbersWithBrackets2() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("5 + (-2 *(-2 + 1))");
//        double expected = 7.0;
//        assertEquals(actual, expected);
//    }
//
//
//
//    @Test
//    public void testEvaluateExpression1() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("1 -- 2");
//        double expected = 3.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpression2() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("0.5+ 0.5");
//        double expected = 1.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpression3() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("(1+((1)+(1)))");
//        double expected = 3.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpression4() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("33");
//        double expected = 33.0;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpression5() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("((((-1))))");
//        double expected = -1;
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testEvaluateExpressionPowerOfNegativeNumber() throws Exception {
//        ValueExpression eval = new ValueExpression();
//        double actual = eval.evaluate("2 ^             -3");
//        double expected = 0.125;
//        assertEquals(actual, expected);
//    }
}
