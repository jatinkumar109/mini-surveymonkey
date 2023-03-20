package surveyMonkey.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import surveyMonkey.models.Survey;

/**
 * Interface class for survey.
 */
public interface SurveyRepository  extends CrudRepository<Survey, Long> {
    Survey findById(@Param("id") int id);

}




