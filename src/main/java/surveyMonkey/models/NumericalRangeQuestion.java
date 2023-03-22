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
    private float min;
    private float max;

    /**
     * Default constructor
     */
    public NumericalRangeQuestion() {
        super();
    }

    /**
     * Constructor with specified question
     * @param question the question text
     * @param min
     * @param max
     */
    public NumericalRangeQuestion(String question, float min, float max) {
        super(question);
        this.min = min;
        this.max = max;
    }

    /**
     * Get the minimum boundary for a question of type number_question
     * @return String
     */
    public Float getMin() {
        return this.min;
    }

    /**
     * Get the maximum boundary for a question of type number_question
     * @return the maximum value
     */
    public Float getMax() { return this.max; }

    @Override
    public List<String> getAnswers() {
        return this.answers;
    }

    public String getQuestionType() {
        return questionType.name();
    }

    public boolean setAnswer(String answer) {
        if(Float.parseFloat(answer) <= this.max && Float.parseFloat(answer) >= min) {
            this.answers.add(answer);
            return true;
        }
        return false;
    }
}


