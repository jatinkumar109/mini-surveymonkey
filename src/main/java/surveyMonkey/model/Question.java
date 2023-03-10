package surveyMonkey.model;
import jakarta.persistence.*;


/**
 * This class handles all the type of questions
 */
@Entity
@Table(name = "Question")
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String questionText;

    protected Question() {
    }

    public Long getId() {
        return id;
    }


    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public String toString() {
        return this.questionText;
    }

    public abstract String getType();

    public abstract void setAnswer(String object);
}