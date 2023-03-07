/*
Text Questions are questions that require a text (String) answers (no options needed)
@author: Peter Tanyous
@Version: 1, March 6, 2023
 */
public class TextQuestion implements Question{

    //String question holds the question text
    private String question;
    //String answer holds the user answer to the question
    private String answer;

    /**
     * Constructor that takes question String to initialize the question String
     * @param question String that holds the new question text
     */
    public TextQuestion(String question){
        this.question = question;
    }

    /**
     * answer function that allows the user  to answer the question
     * @param answer: The text answer of the user
     */
    public void answer(String answer){
        this.answer = answer;
    }

    /**
     * getQuestion to get the question
     * @return: The question String
     */
    @Override
    public String getQuestion() {
        return this.question;
    }

    /**
     * to set or edit the quetion text.
     * @param newQuestion: String parameter that holds the question string to be set
     */
    @Override
    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    /**
     * to get the user Text answer to the question.
     * @return String user's answer
     */
    @Override
    public String getAnswer() {
        return this.answer;
    }
}
