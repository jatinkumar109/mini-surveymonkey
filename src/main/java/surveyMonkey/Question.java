package surveyMonkey;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * This class handles all the type of questions
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private final String question;
    private final QuestionType questionType;
    private ArrayList options;
    private int lowerBound;
    private int upperBound;
    private ArrayList answer;


    /**
     * constructor for open-ended question
     * @param question strong question
     * @param questionType enum
     */
    public Question(String question, QuestionType questionType) {
        this.question = question;
        this.questionType = questionType;
    }

    /**
     * constructor for MCQ question
     * @param question string question
     * @param questionType enum
     * @param options choices
     */
    public Question(String question, QuestionType questionType, ArrayList options) {
        this.question = question;
        this.questionType = questionType;
        this.options = options;
    }

    /**
     * constructor for numerical question
     * @param question string for question string
     * @param questionType enum
     * @param lowerBound for answer
     * @param upperBound for answer
     */
    public Question(String question, QuestionType questionType, int lowerBound, int upperBound) {
        this.question = question;
        this.questionType = questionType;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Getter the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Getter for the question type
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Getter for the question options
     */
    public ArrayList<String> getOptions() { return options; }

    /**
     * Assigns the minimum value for the numerical range questions
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * Assigns the maximum value for the numerical range questions
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Allows the surveyor to get the answer of the questions
     */
    public List<String> getAnswers() { return answer; }

}