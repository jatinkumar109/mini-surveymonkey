package surveyMonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class handles and controls the survey operations.
 */
@RestController
public class SurveyController {

    private SurveyRepository repository;

    @Autowired
    public SurveyController(SurveyRepository repository){
        this.repository = repository;

    }

    /**
     * This method starts a survey and saves it in a repository.
     * @return
     */
    @RequestMapping(value = "/survey",method = RequestMethod.POST)
    public Survey createSurvey(){ //Need to account for the request bodies data being sent, need to have discussion of how this will look
        Survey survey = new Survey();
        repository.save(survey);
        return survey;
    }
    
    @RequestMapping(value = "/survey",method = RequestMethod.GET)
    public Survey getSurvey(){
        return repository.findById(1);
    }
}