package surveyMonkey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surveyMonkey.models.OpenEndedQuestion;
import surveyMonkey.models.Question;
import surveyMonkey.models.Survey;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {
    private Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey("Test Survey");
    }

    @Test
    void testGetName() {
        assertEquals("Test Survey", survey.getTitle());
    }

    @Test
    void testSetName() {
        survey.setTitle("New Survey Name");
        assertEquals("New Survey Name", survey.getTitle());
    }

    @Test
    void testGetId() {
        assertNull(survey.getId());
    }


    @Test
    void testGetQuestions() {
        List<Question> questions = new ArrayList<>();
        OpenEndedQuestion question1 = new OpenEndedQuestion("What is your name?");
        OpenEndedQuestion question2 = new OpenEndedQuestion("What is your age?");
        questions.add(question1);
        questions.add(question2);
        survey.setQuestions(questions);
        assertEquals(questions, survey.getQuestions());
    }

    @Test
    void testAddQuestion() {
        OpenEndedQuestion question = new OpenEndedQuestion("What is your favorite color?");
        survey.addQuestion(question);
        assertEquals(question, survey.getQuestions().get(0));
    }

    @Test
    void testClose() {
        survey.setClose();
        assertFalse(survey.getIsOpen());
    }
}
