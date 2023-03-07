package surveyMonkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class SurveyRunner {

    private static final Logger log = LoggerFactory.getLogger(SurveyRunner.class);

    public static void main(String[] args){
        SpringApplication.run(SurveyRunner.class, args);
    }

    @Bean
    public CommandLineRunner demo(SurveyRepository repository) {
        return (args) -> {
            // save a few customers
            MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion("how you feelin today",new ArrayList<String>(Arrays.asList("MCQ1 option1", "MCQ1 option2", "MCQ1 option3")));
            OpenEndedQuestion oeq1 = new OpenEndedQuestion("open ended Question 1");
            NumericalRangeQuestion rangeq1 = new NumericalRangeQuestion("How many question in this survey", Integer.parseInt("1"), Integer.parseInt("10"));
            Survey survey = new Survey("Survey 1 name", new ArrayList<Question>(Arrays.asList(mcq1,oeq1,rangeq1)));
            repository.save(survey);

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Survey surv : repository.findAll()) {
                log.info(surv.getId().toString());
            }
            log.info("");
        };
    }
}
