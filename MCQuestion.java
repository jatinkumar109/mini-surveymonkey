/*
Multiple choice question class for questions that give users a set of options to choose from
@author: Peter Tanyous
@Version: 1, March 6, 2023
 */
public class MCQuestion implements Question {

    //holds the question text
    private String question;

    //array that holds the possible answer options for the user
    private String[] options;

    //the answer index that the user has chosen from the options array
    private int answer;

    /**
     * Constructor MCQuestion to create the MCQuestion
     * @param question : String the text question
     * @param options: String Array that holds the possible options. Expected to be initialized on construction.
     */
    public MCQuestion(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    /**
     * function getOptions() returns the answer options to the user.
     * @return the array of answers options
     */
    public String[] getOptions() {
        return this.options;
    }

    /**
     * function answer allows user to input the index answer of the array of options
     * @param index: integer index that represents the chosen option from the array of options
     */
    public void answer(int index) {
        if(index<this.options.length){
            this.answer = index;
        }

    }

    /**
     * function getChosenOption() returns the String option answer chosen by the user
     * @return the String option answer chosen by the user
     */
    public String getChosenOption(){
        return this.options[answer];
    }

    /**
     * function getQuestion gets the question text
     * @return String question text
     */
    @Override
    public String getQuestion() {
        return this.question;
    }

    /**
     * function setQuestion to edit or reset question text
     * @param newQuestion: String parameter that holds the question string to be set
     */
    @Override
    public void setQuestion(String newQuestion) {

    }

    /**
     * function getAnswer gets the answer chosen by  the user
     * @return String that holds the answer option chosen by the user.
     */
    @Override
    public String getAnswer() {
        return this.options[answer];
    }

}