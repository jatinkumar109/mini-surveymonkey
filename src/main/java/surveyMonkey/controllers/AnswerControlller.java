package surveyMonkey.controllers;
import surveyMonkey.repositories.AnswerRepository;
import surveyMonkey.models.Answers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class AnswerController {

    private final AnswerRepository repositories;


    AnswerController(AnswerRepository repositories) {
        this.repositories = repositories;
    }

    @GetMapping("/answers")
    List<Answers> all() {
        return (List<Answers>) repositories.findAll();
    }
}

