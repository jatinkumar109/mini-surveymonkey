package surveyMonkey;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the Open Ended type of Questions
 */
@Entity
public class OpenEndedQuestion extends Question {

    @ElementCollection(targetClass=String.class)
    private List<String> answer = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.OPEN_ENDED;

    public OpenEndedQuestion() {
        super();
    }

    public OpenEndedQuestion(String question) {
        super(question);
    }

    /**
     * Getter for answers
     * @return
     */
    public List<String> getAnswers() {
        return this.answer;
    }

    /**
     * Getter for the question types
     * @return
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Setter for the answers
     */
    public boolean setAnswer(String answer) {
        return this.answer.add(answer);
    }

}