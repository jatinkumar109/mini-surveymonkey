package surveyMonkey.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the Open Ended type of Questions
 */
@Entity
public class OpenEndedQuestion extends Question {

    private List<String> answers;

    public OpenEndedQuestion() {
        this.answers = new ArrayList<>();
    }

    public OpenEndedQuestion(String questionText) {
        super(questionText);
        this.answers = new ArrayList<>();

    }
    @Override
    public void setAnswer(String answer){
        this.answers.add(answer);
    }
    public void setAnswers(List<String> answers){
        this.answers = answers;
    }
    public List<String> getAnswers() {
        return answers;
    }





    @Override
    public String getType() {
        return "OE";
    }

    @Override
    public String toString() {
        return "OpenEndedQuestion{" +
                "question=" + getQuestionText() +
                "answers=" + answers +
                '}';
    }
}