package surveyMonkey;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class OpenEndedQuestion extends Question {

    @ElementCollection(targetClass=String.class)
    private ArrayList<String> answer = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

    public OpenEndedQuestion(String question) {
        super(question,questionType);
    }

    public boolean setAnswer(String answer){
       return this.answer.add(answer);
    }
}
