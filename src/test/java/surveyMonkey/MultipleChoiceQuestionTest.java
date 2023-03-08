package surveyMonkey;

import org.junit.Before;
import org.junit.Test;
import surveyMonkey.MultipleChoiceQuestion;
import surveyMonkey.QuestionType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the functionality of the Multiple Choice Questions.
 */
public class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion mcq;

    /**
     * This method starts a mcq question to be tested for
     */
    @Before
    public void initialize() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Toronto");
        options.add("Calgary");
        options.add("Ottawa");
        options.add("Edmonton");
        mcq = new MultipleChoiceQuestion("whats the capital of Canada", options);
    }

    /**
     * Checks if the options are correctly placed in a MCQ question
     */
    @Test
    public void methodTest(){
        assertEquals(mcq.getOptions().get(0), "Toronto");
    }

    /**
     * This method checks if the answer is added to the survey question properly
     */
    @Test
    public void testAddAnswer() {
        assertTrue(mcq.setAnswer("Ottawa"));
        assertEquals(mcq.getAnswers().get(0), "Ottawa");
    }

    /**
     * This method checks the return of a proper question type
     */
    @Test
    public void testGetQuestionType() {
        assertEquals(mcq.getQuestionType(), QuestionType.MULTIPLE_CHOICE);
    }
}