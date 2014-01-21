package sandeshm.expeval.main;

import org.junit.Test;
import sandeshm.expeval.lib.expressionEvaluator;

import static org.junit.Assert.assertEquals;

public class expressionEvaluatorTest {
    @Test
    public void testEvaluateExpression() throws Exception {
        expressionEvaluator eval = new expressionEvaluator();

        String actual = eval.evaluateExpression("2 + 3");
        String expected = "2 + 3";
        assertEquals(actual,expected);
    }
}
