package sandeshm.expeval.lib;

import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Created by sandeshm on 2/8/14.
 */
public class ExpressionTest {
    @Test
    public void testValueExpressionEquality() throws Exception {
        ValueExpression actual = new ValueExpression(2.0);
        ValueExpression expected = new ValueExpression(2.0);

        assertEquals(expected, actual);
    }

    @Test
    public void testValueExpressionInequality() throws Exception {
        ValueExpression actual = new ValueExpression(2.0);
        ValueExpression expected = new ValueExpression(3.0);

        assertFalse(expected.equals(actual));
    }

    @Test
    public void testSimpleExpressionEquality() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.0), new Plus());
        Expression expected = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.0), new Plus());

        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleExpressionInequality() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.0), new Plus());
        Expression expected = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.1) , new Plus());

        assertFalse(expected.equals(actual));
    }

    @Test
    public void testToEvaluateValueExpression() throws Exception {
        Expression valueExpression = new ValueExpression(2.0);
        Expression expected = new ValueExpression(2.0);

        assertEquals(expected, valueExpression.evaluateExpression());
    }

    @Test
    public void testEvaluateExpression() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.0), new Plus());
        Expression expected = new ValueExpression(5.0);

        assertEquals(expected, actual.evaluateExpression());
    }

    @Test
    public void testEvaluateExpressionForSubtraction() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(7.0), new ValueExpression(3.0), new Subtract());
        Expression expected = new ValueExpression(4.0);

        assertEquals(expected, actual.evaluateExpression());
    }

    @Test
    public void testEvaluateExpressionForMultiplication() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(7.0), new ValueExpression(3.0), new Multiply());
        Expression expected = new ValueExpression(21.0);

        assertEquals(expected, actual.evaluateExpression());
    }

    @Test
    public void testEvaluateExpressionForDivision() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(9.0), new ValueExpression(3.0), new Divide());
        Expression expected = new ValueExpression(3.0);

        assertEquals(expected, actual.evaluateExpression());
    }

    @Test
    public void testEvaluateExpressionForPowerOf() throws Exception {
        Expression actual = new SimpleExpression(new ValueExpression(2.0),new ValueExpression(3.0), new Power());
        Expression expected = new ValueExpression(8.0);

        assertEquals(expected, actual.evaluateExpression());
    }

//    @Test
//    public void testEvaluateExpressionForMultipleOperators() throws Exception {
//       Expression actual = new SimpleExpression(
//               new SimpleExpression( new ValueExpression(2.0),new ValueExpression(3.0),new Plus() ).evaluateExpression(),
//               new ValueExpression(5.0),new Plus());
//    }
}
