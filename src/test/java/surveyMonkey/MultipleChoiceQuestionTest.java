package surveyMonkey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surveyMonkey.model.MultipleChoiceQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoiceQuestionTest {
    private MultipleChoiceQuestion mcQuestion;

    @BeforeEach
    public void setUp() {
        List<String> options = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
        mcQuestion = new MultipleChoiceQuestion("What is your favorite color?", options);


    }

    @Test
    public void testGetOptions() {
        List<String> options = mcQuestion.getOptions();
        Assertions.assertEquals(3, options.size());
        Assertions.assertTrue(options.contains("Red"));
        Assertions.assertTrue(options.contains("Green"));
        Assertions.assertTrue(options.contains("Blue"));
    }

    @Test
    public void testAddOption() {
        mcQuestion.addOption("Yellow");
        List<String> options = mcQuestion.getOptions();
        Assertions.assertEquals(4, options.size());
        Assertions.assertTrue(options.contains("Yellow"));
    }

    @Test
    public void testGetAnswers() {
        mcQuestion.setAnswer("1");
        mcQuestion.setAnswer("2");
        List<String> answers = mcQuestion.getAnswers();
        Assertions.assertEquals(2, answers.size());
        Assertions.assertTrue(answers.contains("1"));
        Assertions.assertTrue(answers.contains("2"));
    }

    @Test
    public void testSetAnswers() {
        mcQuestion.setAnswers(List.of("1", "2"));
        List<String> answers = mcQuestion.getAnswers();
        Assertions.assertEquals(2, answers.size());
        Assertions.assertTrue(answers.contains("1"));
        Assertions.assertTrue(answers.contains("2"));
    }

    @Test
    public void testGetType() {
        Assertions.assertEquals("MC", mcQuestion.getType());
    }
}
