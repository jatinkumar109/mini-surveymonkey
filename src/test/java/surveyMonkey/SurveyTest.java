package surveyMonkey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surveyMonkey.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {
    private Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey("Test Survey");
    }


    @Test
    public void testAddQuestions() {
        // create a new multiple choice question object
        List<String> options = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
        MultipleChoiceQuestion mcQ = new MultipleChoiceQuestion("What is your favorite color?", options);
        NumericalRangeQuestion nrQ = new NumericalRangeQuestion("What is your age?", 18, 100);
        OpenEndedQuestion oeQ = new OpenEndedQuestion("What is your favorite color?");

        // add the multiple choice question to the survey
        survey.addQuestion(mcQ);
        survey.addQuestion(nrQ);
        survey.addQuestion(oeQ);

        // assert that the survey has 3 question and it's the multiple choice question
        assertEquals(3, survey.getQuestions().size());
        assertEquals(mcQ, survey.getQuestion(0));
        assertEquals(nrQ, survey.getQuestion(1));
        assertEquals(oeQ, survey.getQuestion(2));
    }




    @Test
    void testClose() {
        survey.close();
        assertFalse(survey.isOpen());
    }
}
