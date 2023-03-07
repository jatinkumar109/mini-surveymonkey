package surveyMonkey;

import org.junit.Before;
import org.junit.Test;
import surveyMonkey.MultipleChoiceQuestion;
import surveyMonkey.QuestionType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion mcq;

    @Before
    public void initialize() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Toronto");
        options.add("Calgary");
        options.add("Ottawa");
        options.add("Edmonton");
        mcq = new MultipleChoiceQuestion("whats the capital of Canada", options);
    }

    @Test
    public void methodTest(){
        assertEquals(mcq.getOptions().get(0), "Toronto");
    }

    @Test
    public void testAddAnswer() {
        assertTrue(mcq.setAnswer("Ottawa"));
        assertEquals(mcq.getAnswers().get(0), "Ottawa");
    }

    @Test
    public void testGetQuestionType() {
        assertEquals(mcq.getQuestionType(), QuestionType.MULTIPLE_CHOICE);
    }
}