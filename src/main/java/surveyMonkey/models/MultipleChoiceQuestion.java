package surveyMonkey.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * This class handles the Multiple Choice type of Questions
 */
@Entity
public class MultipleChoiceQuestion extends Question {

    @Enumerated(EnumType.ORDINAL)
    private static final QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

    @ElementCollection(targetClass=String.class)
    private final List<String> answers = new ArrayList<>();

    @ElementCollection(targetClass=String.class)
    private List<String> options = new ArrayList<>();


    public MultipleChoiceQuestion() {
        super();
    }

    /**
     * Constructor with specified question
     * @param question the question text
     * @param options the possible options to choose from
     */
    public MultipleChoiceQuestion(String question, ArrayList<String> options) {
        super(question);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getQuestionType() {
        return questionType.name();
    }

    /**
     * Adds a new answer
     * @param option String
     */
    public boolean setAnswer(String option) {
        return this.answers.add(option);
    }

    public boolean addAnswers(List<String> options) {
        return this.answers.addAll(options);
    }

    @Override
    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "question=" + this.getQuestionText() +
                "options=" + this.options +
                ", answers=" + this.answers +
                '}';
    }
}
