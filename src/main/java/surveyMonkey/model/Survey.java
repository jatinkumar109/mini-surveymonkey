package surveyMonkey.model;

import jakarta.persistence.*;
import surveyMonkey.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main initiator of the survey.
 * Handles all the question and answers in the survey.
 */
@Entity
@Table(name = "Survey")

public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Question.class)
    private List<Question> questions;
    private String title;
    private boolean isOpen = true;

    public Long getId() {
        return id;
    }


    public Survey() {
        this.questions = new ArrayList<>();
    }
    public Survey(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void removeQuestion(Question question) {
        this.questions.remove(question);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
    public Question getQuestion(int i) {
        return this.questions.get(i);
    }
    public void printSurvey(){
        List<Question> questions = this.questions;
        for(Question question :questions){
            System.out.println(question.toString());
        }}


    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void close() {
        isOpen = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

