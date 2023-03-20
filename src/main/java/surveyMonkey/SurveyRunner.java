package surveyMonkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import surveyMonkey.models.MultipleChoiceQuestion;
import surveyMonkey.models.NumericalRangeQuestion;
import surveyMonkey.models.OpenEndedQuestion;
import surveyMonkey.models.Survey;
import surveyMonkey.repositories.SurveyRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class handles and controls the operations of a survey.
 */

@SpringBootApplication

public class SurveyRunner {

    private static final Logger log = LoggerFactory.getLogger(SurveyRunner.class);

    public static void main(String[] args){
        SpringApplication.run(SurveyRunner.class);
    }

    /**
     * Saves and fetches customer from a survey
     * @param repository
     * @return
     */
    @Bean
    public CommandLineRunner demo(SurveyRepository repository) {
        return (args) -> {
            // save a few questions
            MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("how you feelin today",new ArrayList<String>(Arrays.asList("MCQ1 option1", "MCQ1 option2", "MCQ1 option3")));
            OpenEndedQuestion q2 = new OpenEndedQuestion("do you know the method?");
            NumericalRangeQuestion q3 = new NumericalRangeQuestion("How many question in this survey", Integer.parseInt("1"), Integer.parseInt("10"));
            Survey survey = new Survey("Test Survey", new ArrayList<>(Arrays.asList(q1,q2,q3)));
            repository.save(survey);


            //Creating fitness survey


            MultipleChoiceQuestion q1_2 = new MultipleChoiceQuestion("How often do you exercise?", new ArrayList<String>(Arrays.asList("Not at all" , "1-2 days a week", "3-4 days a week", "5-6 days a week", "Everyday")));
            MultipleChoiceQuestion q2_2 = new MultipleChoiceQuestion("What exercises do you do?", new ArrayList<String>(Arrays.asList("Walk", "Running", "Gym", "Swim", "Other")));
            MultipleChoiceQuestion q3_2 = new MultipleChoiceQuestion("How would you describe your energy levels?", new ArrayList<String>(Arrays.asList("UP & DOWN", "Lethargic", "Ok", "Excellent")));
            MultipleChoiceQuestion q4_2 = new MultipleChoiceQuestion("Would you like to" , new ArrayList<String>(Arrays.asList("Gain weight", "Lose weight", "Reshape", "Maintain")));
            MultipleChoiceQuestion q5_2 = new MultipleChoiceQuestion("How much would you like to gain/trim to achieve your ideal weight", new ArrayList<String>(Arrays.asList("Less than 5 kgs", "5-10 kgs", "10-20 kgs" , "20-30 kgs","30 + ")));
            OpenEndedQuestion q6_2 = new OpenEndedQuestion("What type of fitness classes are you interested in? ");
            OpenEndedQuestion q7_2 = new OpenEndedQuestion("Please list down all the medical conditions you have if any");
            NumericalRangeQuestion q8_2 = new NumericalRangeQuestion("How would you rate this survey", Integer.parseInt("1"), Integer.parseInt("10"));
            Survey fitnessSurvey = new Survey("Fitness Survey", new ArrayList<>(Arrays.asList(q1_2, q2_2, q3_2, q4_2, q5_2, q6_2, q7_2, q8_2)));
            repository.save(fitnessSurvey);

            //Creating Online Learning Survey
            MultipleChoiceQuestion q1_3 = new MultipleChoiceQuestion("How do you feel overall about virtual/online education?", new ArrayList<String>(Arrays.asList("Poor", "Below Average", "Average", "Good", "Excellent")));
            MultipleChoiceQuestion q2_3 = new MultipleChoiceQuestion("Do you have access to a device for learning online? ", new ArrayList<String>(Arrays.asList("Yes", "Yes, but it doesn't work so well", "No, I share with others")));
            MultipleChoiceQuestion q3_3 = new MultipleChoiceQuestion("What device do you use for virtual/online education?", new ArrayList<String>(Arrays.asList("Laptop", "Desktop", "Tablet", "Smartphone")));
            NumericalRangeQuestion q4_3 = new NumericalRangeQuestion("How many hours do you spend each day on an average on virtual/online education?", Integer.parseInt("1"), Integer.parseInt("15"));
            MultipleChoiceQuestion q5_3 = new MultipleChoiceQuestion("How effective has remote learning been for you?", new ArrayList<String>(Arrays.asList("Not at all effective", "Slightly Effective", "Moderately Effective", "Very Effective", "Extremely Effective")));
            OpenEndedQuestion q6_3 = new OpenEndedQuestion(" How stressful was virtual/online learning for you during the COVID-19 pandemic?");
            OpenEndedQuestion q7_3 = new OpenEndedQuestion("What school did you attend?");
            Survey onlineLearningSurvey = new Survey("Online Learning Survey", new ArrayList<>(Arrays.asList(q1_3, q2_3, q3_3, q4_3, q5_3, q6_3, q7_3)));
            repository.save(onlineLearningSurvey);

            // fetch all surveys
            log.info("Surveys found with findAll():");
            log.info("-------------------------------");
            for (Survey surv : repository.findAll()) {
                log.info(surv.getId().toString());
            }
            log.info("");
        };
    }
}
