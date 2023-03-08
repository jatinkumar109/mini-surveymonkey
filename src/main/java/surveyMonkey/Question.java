package surveyMonkey;
import java.util.ArrayList;
import jakarta.persistence.*;

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

    public String getQuestion() {
        return question;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public ArrayList<String> getOptions() { return options; }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public ArrayList getAnswers() { return answer; }

}