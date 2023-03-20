package surveyMonkey;

import org.junit.Test;
import surveyMonkey.models.NumericalRangeQuestion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the functionality of the Numerical Range Questions.
 */
public class NumericalRangeQuestionTest {
    NumericalRangeQuestion rq1 = new NumericalRangeQuestion("2+3?", 1, 10);

    /**
     * This method checks if the numerical input is set to
     * a survey question properly, as an answer
     */
    @Test
    public void setAnswerTest(){
        assertTrue(rq1.setAnswer("5"));
    }

    /**
     * Getter for the upper bound value of a question's answer
     */
    @Test
    public void getUpperBoundTest(){
        float UB = rq1.getMax();
        assertEquals(UB, 10);

    }

    /**
     * Getter for the lower bound value of a question's answer
     */
    @Test
    public void getLowerBoundTest(){
        float LB = rq1.getMin();
        assertEquals(LB,1);
    }
}
