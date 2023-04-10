package surveyMonkey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import surveyMonkey.models.*;
import surveyMonkey.repositories.SurveyRepository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles and controls the survey operations.
 */
@Controller
public class SurveyController {

    private SurveyRepository repository;

    @Autowired
    public SurveyController(SurveyRepository repository) {
        this.repository = repository;

    }


    @GetMapping("/createSurvey")
    public String createSurvey(Model model) {
        model.addAttribute("survey", new Survey());
        return "createSurvey";
    }

//    @GetMapping("/getRandomHistograms")
//    public String RandomHistogram(Model model) throws IOException {
//        // Create dataset
//        double[] data = { 1.2, 2.3, 3.4, 1.5, 2.6, 3.7, 1.8, 2.9, 3.0 };
//        HistogramDataset dataset = new HistogramDataset();
//        dataset.addSeries("data", data, 10);
//        // Create chart
//        JFreeChart chart = ChartFactory.createHistogram(
//                "Histogram", "Value", "Frequency", dataset, PlotOrientation.VERTICAL, true, true, false);
//        chart.setBackgroundPaint(Color.white);
//        // Save chart as image file
//        int width = 800; /* Width of the image */
//        int height = 600; /* Height of the image */
//        BufferedImage chartImage = chart.createBufferedImage(width, height);
//        File outputFile = new File("C:/Users/peter/Desktop/winter2023/project/src/main/resources/static/histogram.png");
//        ImageIO.write(chartImage, "png", outputFile);
////        model.addAttribute()
//        return "histogramTrial";
//    }
    @GetMapping("/getRandomHistograms")
    public String RandomBarChart() throws IOException {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "data", "Category 1");
        dataset.addValue(2.0, "data", "Category 2");
        dataset.addValue(3.0, "data", "Category 3");
        dataset.addValue(4.0, "data", "Category 4");
        dataset.addValue(5.0, "data", "Category 69");

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart", "Category", "Value", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Customize chart
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.black);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setSeriesPaint(0, Color.blue);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // Save chart as image file
        int width = 800; /* Width of the image */
        int height = 600; /* Height of the image */
        BufferedImage chartImage = chart.createBufferedImage(width, height);
        File outputFile = new File("C:/Users/peter/Desktop/winter2023/project/src/main/resources/static/histogram.png");
        ImageIO.write(chartImage, "png", outputFile);

        return "histogramTrial";
    }

    @GetMapping("/getActualHistograms")
    public String ActualChart(@RequestParam("surveyID") Long surveyID, @RequestParam("questionID") Integer questionID, @RequestParam("questiontext") String questiontext ,Model model) throws IOException {
        Survey survey = repository.findById(surveyID).get();
        if (survey.getQuestionByText(questiontext) instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion qg = (MultipleChoiceQuestion) survey.getQuestionByText(questiontext); //survey.getQuestion(questionID - 1);
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            for (String option : qg.getAnswers()) {
                if (pieDataset.getKeys().contains(option)) {
                    double value = pieDataset.getValue(option).doubleValue();
                    pieDataset.setValue(option, 1 + value);
                } else {
                    pieDataset.setValue(option, 1);
                }
            }
            JFreeChart pieChart = ChartFactory.createPieChart(
                    survey.getTitle() + " : " + qg.getQuestionText(),
                    pieDataset,
                    true,
                    true,
                    false);
            BufferedImage pieBufferedImage = pieChart.createBufferedImage(500, 300);
            ByteArrayOutputStream pieBaos = new ByteArrayOutputStream();
            ImageIO.write(pieBufferedImage, "png", pieBaos);
            byte[] pieBytes = pieBaos.toByteArray();
            String pieEncodedString = java.util.Base64.getEncoder().encodeToString(pieBytes);
            model.addAttribute("chartImage", pieEncodedString);
        } else {
            NumericalRangeQuestion ng = (NumericalRangeQuestion) survey.getQuestionByText(questiontext);
            DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
            for (String option : ng.getAnswers()) {
                int columnIndex = barDataset.getColumnIndex(option);
                if (columnIndex == -1) {
                    barDataset.addValue(1, "Series 1", option);
                } else {
                    double value = barDataset.getValue(0, columnIndex).doubleValue();
                    barDataset.addValue(1 + value, "Series 1", option);
                }
            }
            JFreeChart barChart = ChartFactory.createBarChart(
                    survey.getTitle() + " : " + ng.getQuestionText(),
                    "Options",
                    "Number of Responses",
                    barDataset);
            BufferedImage barBufferedImage = barChart.createBufferedImage(500, 300);
            ByteArrayOutputStream barBaos = new ByteArrayOutputStream();
            ImageIO.write(barBufferedImage, "png", barBaos);
            byte[] barBytes = barBaos.toByteArray();
            String barEncodedString = java.util.Base64.getEncoder().encodeToString(barBytes);
            model.addAttribute("chartImage", barEncodedString);
        }
        return "histogramTrial";
    }
    public static void saveChartAsPNG(JFreeChart chart, int width, int height, String fileName) throws IOException {
        File file = new File(fileName);
        BufferedImage chartImage = chart.createBufferedImage(width, height);
        ImageIO.write(chartImage, "png", file);
    }
    @PostMapping("/createSurveySubmit")
    public String createSurveySubmit(Model model,
                                     @ModelAttribute Survey survey
    ) {
        repository.save(survey);
        model.addAttribute("surveyID",survey.getId());

        model.addAttribute("title", survey.getTitle());
        //model.addAttribute("surveyID", survey.getId());

        // process the form data
        return "surveyCreated";
    }

    @GetMapping("/closeSurvey")
    public  String closeSurvey(Model model, @RequestParam("surveyID")Long surveyID){
        Survey survey = repository.findById(surveyID).get();
        survey.setClose();
        repository.save(survey);
        return "surveyClosed";
    }

    @GetMapping("/openSurvey")
    public String openSurvey(Model model, @RequestParam("surveyID") Long surveyID){
        Survey survey = repository.findById(surveyID).get();
        survey.setOpen();
        repository.save(survey);
        return "surveyOpened";
    }

    @PostMapping("/addQuestions")
    public String addQuestions(Model model,
                               @RequestParam("surveyID") Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        model.addAttribute("title",survey.getTitle());
        model.addAttribute("surveyID",survey.getId());
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        NumericalRangeQuestion numericalRangeQuestion = new NumericalRangeQuestion();
        OpenEndedQuestion openEndedQuestion = new OpenEndedQuestion();
        model.addAttribute("multipleChoiceQuestion", multipleChoiceQuestion);
        model.addAttribute("numericalRangeQuestion", numericalRangeQuestion);
        model.addAttribute("openEndedQuestion", openEndedQuestion);

        return "addQuestions";
    }

    @PostMapping("/addMultipleChoiceQuestion")
    public String addMultipleChoiceQuestion(Model model,
                                            @ModelAttribute MultipleChoiceQuestion mcQ,
                                            @RequestParam("surveyID")Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(mcQ);
        repository.save(survey);

        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }

    @PostMapping("/addNumericalRangeQuestion")
    public String addNumericalRangeQuestion(Model model,
                                            @ModelAttribute NumericalRangeQuestion nrQ,
                                            @RequestParam("surveyID")Long surveyID) {
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(nrQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }



    @PostMapping("/addOpenEndedQuestion")
    public String addOpenEndedQuestion(Model model,
                                       @ModelAttribute OpenEndedQuestion oeQ,
                                       @RequestParam("surveyID")Long surveyID) {
        // Create a new OpenEndedQuestion object
        Survey survey = repository.findById(surveyID).get();
        survey.addQuestion(oeQ);
        repository.save(survey);
        model.addAttribute("title", survey.getTitle());
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("surveyID", survey.getId());


        // process the form data
        return "questionAdded";
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/fillSurvey")
    public String fillSurvey(@RequestParam("surveyID") Long surveyID, Model model) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        // process the form data
        return "fillSurvey";
    }
    @PostMapping("/submitSurvey")
    public String submitSurvey(Model model, HttpServletRequest request) {
        Long surveyId = Long.parseLong(request.getParameter("surveyID"));
        Survey survey = repository.findById(surveyId).get();
        for (Question question : survey.getQuestions()) {
            String answer = request.getParameter("answer-" + question.getId());
            System.out.println(answer);
            question.setAnswer(answer);
        }

        for (Question question : survey.getQuestions()) {
            System.out.println(question);

        }
        repository.save(survey);
        return "/submitSurvey";
    }
    @GetMapping("/listSurveys")
    public String getSurveys(Model model) {
        Iterable<Survey> surveys = repository.findAll();
        List<Survey> filteredSurveys = new ArrayList<>();

        for (Survey survey : surveys) {
            if (survey.getIsOpen() == true) {
                filteredSurveys.add(survey);
            }
        }

        model.addAttribute("surveys", filteredSurveys);
        return "listSurveys";
    }

    @GetMapping("/listClosedSurveys")
    public String getClosedSurveys(Model model) {
        Iterable<Survey> surveys = repository.findAll();
        List<Survey> filteredSurveys = new ArrayList<>();

        for (Survey survey : surveys) {
            if (survey.getIsOpen() == false) {
                filteredSurveys.add(survey);
            }
        }
        model.addAttribute("closedSurveys", filteredSurveys);
        return "listClosedSurveys";
    }
    @GetMapping("/displayResults")
    public String displayResults(@RequestParam("surveyID") Long surveyID, Model model) {
        Survey survey = repository.findById(surveyID).get();
        model.addAttribute("survey", survey);
        return "displayResults";
    }
}