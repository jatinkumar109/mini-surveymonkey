package surveyMonkey;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the Open Ended type of Questions
 */
@Entity
public class OpenEndedQuestion extends Question {

    @ElementCollection(targetClass=String.class)
    private ArrayList<String> answer = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

    public OpenEndedQuestion(String question) {
        super(question,questionType);
    }

    /**
     * Allows the surveyor to set the answer of the numerical range question
     */
    public boolean setAnswer(String answer){
       return this.answer.add(answer);
    }

}