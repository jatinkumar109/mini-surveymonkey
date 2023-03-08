package surveyMonkey;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main initiator of the survey.
 * Handles all the question and answers in the survey.
 */
@Entity
public class Survey {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Question.class)
    private List<Question> questions;
    private boolean open;


    public Survey() {
        this.questions = new ArrayList<>();
        this.open = true;
    }


    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
        this.open = true;
    }


    public Survey(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
        this.open = true;

    }

    /**
     * Setter for the person name filling out the survey.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for person name filling out the survey.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for Survey ID
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Getter for the survey ID.
     */
    public Integer getId() {
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
     * This method closes/exits the survey.
     */
    public void close() {
        this.open = false;
    }


    /**
     * This function is used to add a new question to the list of questions in a
     * @param questionAdded: the new Question object to be added the Survey
     */
    public void addQuestion(Question questionAdded){
        this.questions.add(questionAdded);
    }
}

