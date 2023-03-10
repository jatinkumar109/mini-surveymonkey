package surveyMonkey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import surveyMonkey.model.*;
import surveyMonkey.repo.SurveyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This class handles and controls the survey operations.
 * Creating Survey
 * Closing Survey
 */
@Controller
public class SurveyController {

    private SurveyRepository repository;

    @Autowired
    public SurveyController(SurveyRepository repository) {
        this.repository = repository;

    }


    @GetMapping("/createSurvey")
    public String createSurvey(Model model) {
        model.addAttribute("survey", new Survey());
        return "createSurvey";
    }

    @PostMapping("/createSurveySubmit")
    public String createSurveySubmit(Model model,
                                     @ModelAttribute Survey survey
    ) {
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        // process the form data
        return "surveyCreated";
    }

    @GetMapping("/addQuestions")
    public String addQuestions(Model model) {
        Survey survey = repository.findById(1L).get();
        model.addAttribute("title", survey.getTitle());

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        NumericalRangeQuestion numericalRangeQuestion = new NumericalRangeQuestion();
        OpenEndedQuestion openEndedQuestion = new OpenEndedQuestion();
        model.addAttribute("multipleChoiceQuestion", multipleChoiceQuestion);
        model.addAttribute("numericalRangeQuestion", numericalRangeQuestion);
        model.addAttribute("openEndedQuestion", openEndedQuestion);

        return "addQuestions";
    }

    @PostMapping("/addMultipleChoiceQuestion")
    public String addMultipleChoiceQuestion(Model model,
                                            @ModelAttribute MultipleChoiceQuestion mcQ) {
        Survey survey = repository.findById(1L).get();
        survey.addQuestion(mcQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());

        // process the form data
        return "questionAdded";
    }

    @PostMapping("/addNumericalRangeQuestion")
    public String addNumericalRangeQuestion(Model model,
                                            @ModelAttribute NumericalRangeQuestion nrQ) {
        Survey survey = repository.findById(1L).get();
        survey.addQuestion(nrQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());

        // process the form data
        return "questionAdded";
    }

    @PostMapping("/addOpenEndedQuestion")
    public String addOpenEndedQuestion(Model model,
                                       @ModelAttribute OpenEndedQuestion oeQ) {
        // Create a new OpenEndedQuestion object
        Survey survey = repository.findById(1L).get();
        survey.addQuestion(oeQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());

        // process the form data
        return "questionAdded";
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/fillSurvey")
    public String fillSurvey(Model model) {
        Survey survey = repository.findById(1L).get();
        model.addAttribute("survey", survey);
        // process the form data
        return "fillSurvey";
    }
    @PostMapping("/submitSurvey")
    public String submitSurvey(Model model, HttpServletRequest request) {
        Long surveyId = Long.parseLong(request.getParameter("surveyId"));
        Survey survey = repository.findById(surveyId).get();
        for (Question question : survey.getQuestions()) {
            String answer = request.getParameter("answer-" + question.getId());
            System.out.println(answer);
            question.setAnswer(answer);
        }
        repository.save(survey);
        for (Question question : survey.getQuestions()) {
            System.out.println(question);

        }
        return "/submitSurvey";
    }



}






