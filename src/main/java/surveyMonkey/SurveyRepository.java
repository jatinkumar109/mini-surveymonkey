package surveyMonkey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface class for survey.
 */
public interface SurveyRepository  extends CrudRepository<Survey, Integer> {
    Survey findById(@Param("id") int id);

}




