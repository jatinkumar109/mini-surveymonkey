import java.util.Arrays;

public class temp_Testing {
    public static void main(String[] args) {

        MCQuestion first = new MCQuestion("What group age do you belong to?", new String[]{"10-15", "15-28", "28+"});
        System.out.println(first.getQuestion());
        first.answer(1);
        System.out.println(first.getAnswer());

        TextQuestion second = new TextQuestion("What is your name");
        System.out.println(second.getQuestion());
        second.answer("Peter");
        System.out.println(second.getAnswer());

        Answers answer = new Answers(new String[] {first.getAnswer(), second.getAnswer()});
        System.out.println(Arrays.toString(answer.getAnwers()));

    }
}