package surveyMonkey;
import java.util.ArrayList;
import jakarta.persistence.*;


/**
 * This class handles all the type of questions
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String question;


    public Question() {}


    public Question(String question) {
        this.question = question;
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
    public String getQuestion() {
        return question;
    }


    /**
     * Setter for Questions
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

}