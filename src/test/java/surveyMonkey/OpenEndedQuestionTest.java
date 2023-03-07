package surveyMonkey;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenEndedQuestionTest {
    private OpenEndedQuestion openQuestion;

    @Before
    public void initialize() {
        openQuestion = new OpenEndedQuestion("Whats your height?");
    }

    @Test
    public void testAddAnswer() {
        boolean response = openQuestion.setAnswer("6ft (big man)");
        assertEquals(response, true);
    }

    @Test
    public void testGetQuestionType() {
        assertEquals(openQuestion.getQuestionType(), QuestionType.OPEN_ENDED);
    }
}
