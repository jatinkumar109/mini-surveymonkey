package surveyMonkey;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests for the functionality of the Open Ended Questions.
 */
public class OpenEndedQuestionTest {
    private OpenEndedQuestion openQuestion;

    /**
     * This method starts an open-ended question to be tested for
     */
    @Before
    public void initialize() {
        openQuestion = new OpenEndedQuestion("Whats your height?");
    }

    /**
     * This method checks if the answer is added to the survey properly
     */
    @Test
    public void testAddAnswer() {
        boolean response = openQuestion.setAnswer("6ft (big man)");
        assertEquals(response, true);
    }

    /**
     * This method checks the return of a proper question type
     */
    @Test
    public void testGetQuestionType() {
        assertEquals(openQuestion.getQuestionType(), QuestionType.OPEN_ENDED);
    }
}
