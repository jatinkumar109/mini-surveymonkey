//package surveyMonkey;
import org.junit.Test;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests for the functionality of the SurveyMonkey Controller

public class SurveyControllerTest {

    private SurveyController controller;
    private SurveyRepository repository;

    public SurveyControllerTest(SurveyRepository repository) {
        this.repository = repository;
    }

    /**
     * // Initialize the survey controller before test
    @Before
    public void initialize() {
        controller = new SurveyController(repository);
    }


     * Adds a survey and tests for presence

    @Test
    public void testAddSurvey() {
        assertEquals(controller, true);
    }


     * Tests for accesing a survey using its ID
     * and check its presence

    @Test
    public void testGetSurvey() {
        Survey surveyGet = repository.findById(1);
        assertEquals(surveyGet, true);
    }
    */

