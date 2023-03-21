package surveyMonkey.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import surveyMonkey.models.Answers;
import surveyMonkey.models.Question;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ans", path = "ans")
public interface AnswerRepository extends CrudRepository<Answers, Long> {

    Answers findById(long id);
    Answers findByAnswer(String answer);
    List<Answers> findByQandA(String answer, Question question);

}