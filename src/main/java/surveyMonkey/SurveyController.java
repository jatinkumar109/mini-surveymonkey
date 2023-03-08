package surveyMonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {

    private SurveyRepository repository;

    @Autowired
    public SurveyController(SurveyRepository repository){
        this.repository = repository;

    }

    @RequestMapping(value = "/survey",method = RequestMethod.POST)
    public Survey createSurvey(){
        Survey survey = new Survey();
        repository.save(survey);
        return survey;
    }

    @RequestMapping(value = "/survey",method = RequestMethod.GET)
    public Survey getSurvey(){
        return repository.findById(1);
    }
}