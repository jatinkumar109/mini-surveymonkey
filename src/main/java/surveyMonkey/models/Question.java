package surveyMonkey.models;
import jakarta.persistence.*;

import java.util.Set;


/**
 * This class handles all the type of questions
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionText;
    private Set<Answers> answers;


    public Question() {}


    public Question(String question) {
        this.questionText = question;
    }

    /**
     * Getter for the ID
     * @return
     */
    public Integer getId() {
        return id;
    }


    /**
     * Setter for ID
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Getter for all question types
     * @return
     */
    public String getQuestionText() {
        return questionText;
    }


    /**
     * Setter for Questions
     * @param questionText
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public abstract boolean setAnswer(String object);

    public abstract String getQuestionType();

    public abstract Object getAnswers();

    public int getAnsSize() {
        return answers.size();
    }
}