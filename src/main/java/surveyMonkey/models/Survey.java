package surveyMonkey.models;

import jakarta.persistence.*;
import java.util.ArrayList;

import java.util.List;


/**
 * This class is the main initiator of the survey.
 * Handles all the question and answers in the survey.
 */
@Entity
public class Survey {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Question.class)
    private List<Question> questions;
    private boolean isOpen;


    public Survey() {
        this.questions = new ArrayList<>();
        this.isOpen = true;
    }


    public Survey(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
        this.isOpen = true;
    }


    public Survey(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
        this.isOpen = true;

    }

    /**
     * Setter for the person name filling out the survey.
     */
    public void setTitle(String name) {
        this.title = name;
    }

    /**
     * Getter for person name filling out the survey.
     */
    public String getTitle() {
        return this.title;
    }


    /**
     * Getter for the survey ID.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for the questions in the survey.
     * @param questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Getter for the questions in the survey.
     */
    public List<Question> getQuestions() {
        return this.questions;
    }

    /**
     * This method closes the survey.
     */
    public void setClose() {
        this.isOpen = false;
    }
    /**
     * This method opens the survey.
     */
    public void setOpen(){this.isOpen = true;}

    public void setOpen(boolean open) {
        this.isOpen = open;
    }
    /**
     * This function is used to add a new question to the list of questions in a
     * @param questionAdded: the new Question object to be added the Survey
     */
    public void addQuestion(Question questionAdded){
        this.questions.add(questionAdded);
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public Question getQuestion(int i) {
        return this.questions.get(i);
    }
}

