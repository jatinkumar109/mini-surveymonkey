package surveyMonkey;

import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
public class MultipleChoiceQuestion extends Question {


    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

    @ElementCollection(targetClass=String.class)
    private final ArrayList<String> answers = new ArrayList<>();

    public MultipleChoiceQuestion(String question, ArrayList<String> options) {
        super(question,questionType,options);
    }

    public boolean setAnswer(String answer){
        return answers.add(answer);
    }

    @Override
    public ArrayList<String> getAnswers(){
        return answers;
    }
}
