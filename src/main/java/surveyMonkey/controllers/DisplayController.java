package surveyMonkey.controllers;
import surveyMonkey.models.Question;
import surveyMonkey.repositories.AnswerRepository;
import surveyMonkey.models.Answers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class DisplayController {

    private final AnswerRepository repositories;
    private Question question;
    private Object display;
    private Question[] questions;


    DisplayController(AnswerRepository repositories) {
        this.repositories = repositories;
    }

    @GetMapping("/displayAnswers")
    List<Answers> all() {
        List<Answers> answers = (List<Answers>) repositories.findAll();
        List<Answers> display = new ArrayList<>();
        for (Question question : questions) {
            Object answer = question.getAnswers();
            if (answers instanceof List) {
                display.addAll((List<Answers>) answers);
            } else if (answers instanceof Answers) {
                display.add((Answers) answers);
            }
        }
        return display;
    }
}

