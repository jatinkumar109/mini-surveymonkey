package surveyMonkey;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * This class handles the Multiple Choice type of Questions
 */
@Entity
public class MultipleChoiceQuestion extends Question {

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

    @ElementCollection(targetClass=String.class)
    private final ArrayList<String> answers = new ArrayList<>();


    public MultipleChoiceQuestion(String question, ArrayList<String> options) {
        super(question,questionType,options);
    }

    /**
     * Allows the surveyor to set the answer to the multiple choice question
     * @param answer
     * @return answer
     */
    public boolean setAnswer(String answer){
        return answers.add(answer);
    }

    /**
     * Allows the surveyor to get the answer of the multiple choice question
     */
    @Override
    public ArrayList<String> getAnswers(){
        return answers;
    }
}
