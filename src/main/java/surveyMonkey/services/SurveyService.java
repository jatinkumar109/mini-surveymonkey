package surveyMonkey.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import surveyMonkey.repositories.SurveyRepository;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
}