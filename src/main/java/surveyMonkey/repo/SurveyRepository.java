package surveyMonkey.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import surveyMonkey.model.Survey;

/**
 * Interface class for survey.
 */
public interface SurveyRepository  extends CrudRepository<Survey, Long> {

}




