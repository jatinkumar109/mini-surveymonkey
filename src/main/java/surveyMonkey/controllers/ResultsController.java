
/**
 *
 * for m3
 *
 *
package surveyMonkey.controllers;

import surveyMonkey.models.*;
import surveyMonkey.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ResultsController {

    @Autowired
    private AnswerRepository repository;
    private MultipleChoiceQuestion mcq;
    private NumericalRangeQuestion nrq;

    @RequestMapping("/Results")
    public void getStatistics(Model model, @ModelAttribute Question question)
    {
        if(question.getQuestionType() == mcq.getQuestionType()) {
            List<List<Object>> results = new ArrayList<List<Object>>();
            List answers;
            answers = new ArrayList<>((Integer) question.getAnswers());
            for (int i = 0; i < answers.size(); i++) {
                List<Object> data = new ArrayList<Object>();
                data.add(answers.get(i).toString());
                data.add((repository.findByQandA(answers.get(i).toString(), question)).size());
                results.add(data);
            }
            model.addAttribute("pieChart", results);
        }

        if(question.getQuestionType() == nrq.getQuestionType()){

            List results = new ArrayList<>();

            Answers answer = null;
            int numbers = question.getAnsSize();
            Set<Answers> questionAnswer = (Set<Answers>) question.getAnswers();
            Integer[] array = new Integer[questionAnswer.size()];
            int r = 0;
            for (Answers i: questionAnswer) {
                System.out.println(Integer.parseInt(i.getAnswer()));
                array[r++] = Integer.parseInt(i.getAnswer());
            }
            results.add(numbers);
            results.add(array);

            model.addAttribute("histogram", results);
        }
    }
}
 */

