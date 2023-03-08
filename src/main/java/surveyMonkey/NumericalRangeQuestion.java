package surveyMonkey;
import jakarta.persistence.*;
import java.util.ArrayList;


/**
 * This class handles the Numerical Range type of Questions
 */
@Entity
public class NumericalRangeQuestion extends Question {


    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.NUMERICAL_RANGE;
    @ElementCollection(targetClass=String.class)
    private ArrayList<String> answers= new ArrayList<>();

    public NumericalRangeQuestion(String question, int lowerBound, int upperBound) {
        super(question,questionType,lowerBound,upperBound);
    }
    /**
     * Allows the surveyor to set the answer of the numerical range question
     */
    public boolean setAnswers(Float answer) {
        return this.answers.add(answer.toString());
    }

    /**
     * Allows the surveyor to get the answer of the numerical range question
     */
    @Override
    public ArrayList<String> getAnswers(){
        return answers;
    }
}


