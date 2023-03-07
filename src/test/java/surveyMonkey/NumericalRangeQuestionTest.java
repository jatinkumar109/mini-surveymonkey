package surveyMonkey;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumericalRangeQuestionTest {
    NumericalRangeQuestion rq1 = new NumericalRangeQuestion("2+3?", 1, 10);

    @Test
    public void setAnswerTest(){
        assertTrue(rq1.setAnswers(5F));
    }

    @Test
    public void getUpperBoundTest(){
        float UB = rq1.getUpperBound();
        assertEquals(UB, 10);

    }

    @Test
    public void getLowerBoundTest(){
        float LB = rq1.getLowerBound();
        assertEquals(LB,1);
    }
}
