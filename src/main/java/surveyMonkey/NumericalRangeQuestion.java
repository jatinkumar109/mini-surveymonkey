package surveyMonkey;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class handles the Numerical Range type of Questions
 */
@Entity
public class NumericalRangeQuestion extends Question {


    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.NUMERICAL_RANGE;
    @ElementCollection(targetClass=String.class)
    private List<String> answers= new ArrayList<>();

    public NumericalRangeQuestion(String question, int lowerBound, int upperBound) {
        super(question,questionType,lowerBound,upperBound);
    }
    /**
     * Allows the surveyor to set the answer of the numerical range question
     */
    public boolean setAnswers(Float answers) {
        return this.answers.add(answers.toString());
    }
}


