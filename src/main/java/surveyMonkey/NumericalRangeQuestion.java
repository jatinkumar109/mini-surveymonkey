package surveyMonkey;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NumericalRangeQuestion extends Question {

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.NUMERICAL_RANGE;
    @ElementCollection(targetClass=String.class)
    private List<String> answers= new ArrayList<>();

    public NumericalRangeQuestion(String question, int lowerBound, int upperBound) {
        super(question,questionType,lowerBound,upperBound);
    }

    public boolean setAnswers(Float answers) {
        return this.answers.add(answers.toString());
    }
}
