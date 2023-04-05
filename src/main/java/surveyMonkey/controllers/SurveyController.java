package surveyMonkey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import surveyMonkey.models.*;
import surveyMonkey.repositories.SurveyRepository;

import java.util.Iterator;

/**
 * This class handles and controls the survey operations.
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
        model.addAttribute("surveyID",survey.getId());

        model.addAttribute("title", survey.getTitle());
        //model.addAttribute("surveyID", survey.getId());

        // process the form data
        return "surveyCreated";
    }

    @PostMapping("/addQuestions")
    public String addQuestions(Model model,
                               @RequestParam("surveyID") Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        model.addAttribute("title",survey.getTitle());
        model.addAttribute("surveyID",survey.getId());
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
                                            @ModelAttribute MultipleChoiceQuestion mcQ,
                                            @RequestParam("surveyID")Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(mcQ);
        repository.save(survey);

        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }

    @PostMapping("/addNumericalRangeQuestion")
    public String addNumericalRangeQuestion(Model model,
                                            @ModelAttribute NumericalRangeQuestion nrQ,
                                            @RequestParam("surveyID")Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(nrQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }

    @PostMapping("/addOpenEndedQuestion")
    public String addOpenEndedQuestion(Model model,
                                       @ModelAttribute OpenEndedQuestion oeQ,
                                       @RequestParam("surveyID")Long surveyID) {
        // Create a new OpenEndedQuestion object
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(oeQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/fillSurvey")
    public String fillSurvey(@RequestParam("surveyID") Long surveyID, Model model) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        // process the form data
        return "fillSurvey";
    }
    @PostMapping("/submitSurvey")
    public String submitSurvey(Model model, HttpServletRequest request) {
        Long surveyId = Long.parseLong(request.getParameter("surveyID"));
        Survey survey = repository.findById(surveyId).get();
        for (Question question : survey.getQuestions()) {
            String answer = request.getParameter("answer-" + question.getId());
            System.out.println(answer);
            question.setAnswer(answer);
        }

        for (Question question : survey.getQuestions()) {
            System.out.println(question);

        }
        repository.save(survey);
        return "/submitSurvey";
    }
    @GetMapping("/listSurveys")
    public String getSurveys(Model model) {
        Iterable<Survey> surveys = repository.findAll();
        model.addAttribute("surveys", surveys);
        return "listSurveys";
    }

    @GetMapping("/listClosedSurveys")
    public String getClosedSurveys(Model model) {
        Iterable<Survey> surveys = repository.findAll();
        Iterator<Survey> closedSurveys = surveys.iterator();
        while (closedSurveys.hasNext()) {
            Survey survey = closedSurveys.next();
            if (survey.getIsOpen() == true) {
                closedSurveys.remove();
            }

        }
        model.addAttribute("closedSurveys", closedSurveys);
        return "listClosedSurveys";
    }
    @GetMapping("/displayResults")
    public String displayResults(@RequestParam("surveyID") Long surveyID, Model model) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        return "displayResults";
    }
}