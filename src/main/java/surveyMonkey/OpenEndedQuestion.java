package surveyMonkey;
import jakarta.persistence.*;
import java.util.ArrayList;

/**
 * This class handles the Open Ended type of Questions
 */
@Entity
public class OpenEndedQuestion extends Question {

    @ElementCollection(targetClass=String.class)
    private ArrayList<String> answer = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.OPEN_ENDED;

    public OpenEndedQuestion(String question) {
        super(question,questionType);
    }

    /**
     * Allows the surveyor to set the answer of the open-ended question
     */
    public boolean setAnswers(String answer){
       return this.answer.add(answer);
    }

    /**
     * Allows the surveyor to get the answer of the open-ended question
     */
    @Override
    public ArrayList<String> getAnswers(){
        return answer;
    }

}