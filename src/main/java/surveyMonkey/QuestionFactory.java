package surveyMonkey;

import java.util.ArrayList;
import java.util.Map;

public class QuestionFactory {

    public static Question createQuestion(Map<String, String> questionData) {
        String questionType = questionData.get("questionType");
        String question = questionData.get("question");
        String lowerBoundStr = questionData.get("lowerBound");
        String upperBoundStr = questionData.get("upperBound");

        switch (questionType) {
            case "OPEN_ENDED":
                return new OpenEndedQuestion(question);

            case "MULTIPLE_CHOICE":
                ArrayList options = (ArrayList) parseOptions(questionData.get("options"));
                return new MultipleChoiceQuestion(question, options);

            case "NUMERICAL_RANGE":
                int lowerBound = Integer.parseInt(lowerBoundStr);
                int upperBound = Integer.parseInt(upperBoundStr);
                return new NumericalRangeQuestion(question, lowerBound, upperBound);

            default:
                throw new IllegalArgumentException("Invalid question type: " + questionType);
        }
    }

    private static Map<String, String> parseOptions(String optionsStr) {
        // TODO: Implement parsing options from string
        return null;
    }
}
