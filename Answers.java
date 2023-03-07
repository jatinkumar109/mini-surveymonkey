/*
Answers is a class that will be used to store all the user's answers for a single survey
@author: Peter Tanyous
@Version: 1, March 6, 2023
 */
public class Answers {
    //Array of strings to store the answer strings for survey questions
    private String[] answers;

    /**
     * Constructor of Answers class
     * @param noOfAnswers the number of answers that the class will have (depends on
     *                    the survey these answers belong to.
     */
    public Answers(int noOfAnswers){
        answers = new String[noOfAnswers];
    }

    /**\
     *
     * @param answers an array that holds all the answers, this constructor could be used to assign the filled array of answers
     *                instead of adding strings to it.
     */
    public Answers(String[] answers){
        this.answers = answers;
    }

    /**
     * function addAnswer is used to add an answer to an array.
     * Answers are assumed to be added in order, so they can be acessed using array index.
     * @param answer: String answer to be added to the array of answers
     */
    public void addAnswer(String answer) {
        for (int i = 0; i < this.answers.length; i++) {
            if (this.answers[i] == null) {
                this.answers[i] = answer;
                break;
            }
        }
    }

    /**
     * function getAnswers() returns the string array of answers
     * @return the string array of answers.
     */
    public String[] getAnwers(){
        return this.answers;
    }

    /**
     * function setAnswers can be used to reset the answers array with a newly initialized one.
     * @param answers to re-set the answers array
     */
    public void setAnswers(String[] answers){
        this.answers = answers;
    }

}