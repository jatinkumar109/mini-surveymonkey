package surveyMonkey.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * This class handles the Multiple option type of Questions
 */
@Entity
public class MultipleChoiceQuestion extends Question {


    private List<String> options;
    private List<String> answers;





    private static final String QUESTION_TYPE = "MC";


    public MultipleChoiceQuestion(){
        this.options = new ArrayList<>();
        this.answers = new ArrayList<>();
    }
    public MultipleChoiceQuestion(String questionText) {
        super(questionText);
        this.options = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public MultipleChoiceQuestion(String questionText,List<String> options) {
        super(questionText);
        this.options = options;
        this.answers = new ArrayList<>();
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    public void addOption(String option) {
        this.options.add(option);
    }

    public void setAnswer(String answer){
        this.answers.add(answer);
    }
    public void setAnswers(List<String> answers){
        this.answers = answers;
    }
    public List<String> getAnswers() {
        return this.answers;
    }


    @Override
    public String getType() {
        return QUESTION_TYPE;
    }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "question=" + this.getQuestionText() +
                "options=" + this.options +
                ", answers=" + this.answers +
                '}';
    }
}