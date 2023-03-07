/*
Interface Question to be implemented by all types of questions that will be added to the survey
@author: Peter Tanyous
@Version: 1, March 6, 2023
 */
public interface Question {

    /**
     * to get the question string
     * @return String question
     */
    public String getQuestion();

    /**
     * to set or edit the question String
     * @param newQuestion: String parameter that holds the question string to be set
     */
    public void setQuestion(String newQuestion);

    /**
     * getAnswer() function to get the Answer chosen or written to a question.
     * @return the answer String
     */
    public String getAnswer();



}
