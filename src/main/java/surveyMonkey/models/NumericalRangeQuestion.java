package surveyMonkey.models;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


/**
 * This class handles the Numerical Range type of Questions
 */
@Entity
public class NumericalRangeQuestion extends Question {


    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.NUMERICAL_RANGE;
    @ElementCollection(targetClass=String.class)
    private List<String> answers= new ArrayList<>();
    private float lowerBound;
    private float upperBound;

    /**
     * Default constructor
     */
    public NumericalRangeQuestion() {
        super();
    }

    /**
     * Constructor with specified question
     * @param question the question text
     * @param lowerBound
     * @param upperBound
     */
    public NumericalRangeQuestion(String question, float lowerBound, float upperBound) {
        super(question);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Get the minimum boundary for a question of type number_question
     * @return String
     */
    public Float getLowerBound() {
        return this.lowerBound;
    }

    /**
     * Get the maximum boundary for a question of type number_question
     * @return the maximum value
     */
    public Float getUpperBound() { return this.upperBound; }

    public List<String> getAnswers() {
        return this.answers;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public boolean setAnswer(String answer) {
        if(Float.parseFloat(answer) <= this.upperBound && Float.parseFloat(answer) >= lowerBound) {
            this.answers.add(answer);
            return true;
        }
        return false;
    }
}


