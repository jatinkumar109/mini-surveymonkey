package surveyMonkey;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import surveyMonkey.models.*;
import surveyMonkey.repositories.SurveyRepository;

import java.util.List;

/**
 * This class handles and controls the operations of a survey.
 @@ -18,17 +17,45 @@
**/
@SpringBootApplication
 public class SurveyRunner {

    private final SurveyRepository surveyRepository;


    @Autowired
    public SurveyRunner(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SurveyRunner.class, args);
    }

    @PostConstruct
    public void createInitialSurveys() {
        Survey survey1 = new Survey("Survey 1");
        //survey1.addQuestion(new MultipleChoiceQuestion("What is your favorite color?", List.of("Red", "Blue", "Green")));
        //survey1.addQuestion(new NumericalRangeQuestion("How many pets do you have?", 0, 10));
        //survey1.getQuestion(0).setAnswer("Red");
        //survey1.getQuestion(1).setAnswer("2");

        //surveyRepository.save(survey1);

        //Survey survey2 = new Survey("Survey 2");
        //survey2.addQuestion(new OpenEndedQuestion("What is your opinion on global warming?"));
        //survey2.addQuestion(new MultipleChoiceQuestion("Do you prefer cats or dogs?", List.of("Cats", "Dogs")));
        //survey2.getQuestion(0).setAnswer("Global Warming is now called Climate Change");
        //survey2.getQuestion(1).setAnswer("Cats");
        //surveyRepository.save(survey2);

    }
}



