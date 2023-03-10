package surveyMonkey;

import org.junit.Test;
import surveyMonkey.model.OpenEndedQuestion;

import java.util.List;
import static org.junit.Assert.*;

public class OpenEndedQuestionTest {

    @Test
    public void testGetQuestionText() {
        String questionText = "What is your favorite color?";
        OpenEndedQuestion question = new OpenEndedQuestion(questionText);
        assertEquals(questionText, question.getQuestionText());
    }



    @Test
    public void testSetAnswer() {
        OpenEndedQuestion question = new OpenEndedQuestion("What is your favorite color?");
        String answer = "Blue";
        question.setAnswer(answer);
        List<String> answers = question.getAnswers();
        assertEquals(1, answers.size());
        assertEquals(answer, answers.get(0));
    }

    @Test
    public void testSetAnswers() {
        OpenEndedQuestion question = new OpenEndedQuestion("What is your favorite color?");
        List<String> answers = List.of("Red", "Green", "Blue");
        question.setAnswers(answers);
        assertEquals(answers, question.getAnswers());
    }

    @Test
    public void testGetType() {
        OpenEndedQuestion question = new OpenEndedQuestion("What is your favorite color?");
        assertEquals("OE", question.getType());
    }
}
