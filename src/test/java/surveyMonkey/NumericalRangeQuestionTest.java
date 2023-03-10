package surveyMonkey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surveyMonkey.model.NumericalRangeQuestion;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericalRangeQuestionTest {

    private NumericalRangeQuestion question;

    @BeforeEach
    public void setUp() {
        question = new NumericalRangeQuestion("What is your age?", 18, 100);
    }

    @Test
    public void testGetMin() {
        assertEquals(18, question.getMin());
    }

    @Test
    public void testSetMin() {
        question.setMin(21);
        assertEquals(21, question.getMin());
    }

    @Test
    public void testGetMax() {
        assertEquals(100, question.getMax());
    }

    @Test
    public void testSetMax() {
        question.setMax(110);
        assertEquals(110, question.getMax());
    }

    @Test
    public void testSetAnswer() {
        question.setAnswer("25");
        List<Integer> expected = new ArrayList<>();
        expected.add(25);
        assertEquals(expected, question.getAnswers());
    }

    @Test
    public void testSetAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("30");
        answers.add("35");
        question.setAnswers(answers);
        assertEquals(answers, question.getAnswers());
    }

    @Test
    public void testGetType() {
        assertEquals("NR", question.getType());
    }

}
