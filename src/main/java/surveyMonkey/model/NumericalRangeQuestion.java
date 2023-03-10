package surveyMonkey.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This class handles the Numerical Range type of Questions
 */
@Entity
public class NumericalRangeQuestion extends Question {


    private  int min;
    private  int max;
    private List<Integer> answers;



    private static final String QUESTION_TYPE = "NR";


    public NumericalRangeQuestion() {
        this.answers = new ArrayList<>();

    }


    public NumericalRangeQuestion(String questionText, int min, int max) {
        super(questionText);
        this.min = min;
        this.max = max;
        this.answers = new ArrayList<>();

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    @Override
    public void setAnswer(String answer){
        this.answers.add(Integer.parseInt(answer));
    }
    public void setAnswers(List<Integer> answers){
        this.answers = answers;
    }
    public List<Integer> getAnswers() {
        return answers;
    }


    @Override
    public String getType() {
        return QUESTION_TYPE;
    }

    @Override
    public String toString() {
        return "NumericalRangeQuestion{" +
                "question=" + getQuestionText() +
                "min=" + min +
                ", max=" + max +
                ", answers=" + answers +
                '}';
    }
}


