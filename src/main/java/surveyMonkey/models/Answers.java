package surveyMonkey.models;

import jakarta.persistence.*;

@Entity
public class Answers {

    @Id
    @GeneratedValue
    private long id;

    private String answer = "";

    @ManyToOne(fetch=FetchType.LAZY)
    private Question question;

    public Answers(){
    }

    public Answers(String answer){
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    /*
    public void setQuestion(Question question) {
        this.question = question;
        question.addAnswer(this);
    }

     */

    @Override
    public String toString() {
        return answer;
    }
}