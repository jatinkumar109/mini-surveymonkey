package surveyMonkey;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import surveyMonkey.models.MultipleChoiceQuestion;
import surveyMonkey.models.NumericalRangeQuestion;
import surveyMonkey.models.OpenEndedQuestion;
import surveyMonkey.models.Survey;
import surveyMonkey.repositories.SurveyRepository;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class webApplicationTest {
    @Autowired
    private MockMvc  mockMvc;

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    @WithMockUser(value = "user", roles =  {"USER"})
    public void listSurvey() throws Exception {
//        this.mockMvc.perform(post("http://localhost:8080/login").with(user("user").password("password")));
        String login = this.mockMvc.perform(formLogin()).andReturn().getResponse().getContentAsString();
        String Result = this.mockMvc.perform(get("http://localhost:8080/listSurveys").with(csrf())).andReturn().getResponse().getContentAsString();//.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Fitness")));
        System.out.println("anything");
        System.out.println("anything");
        System.out.println("anything");
        System.out.println(login);
        System.out.println(Result);
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void creatingSurvey() throws Exception {
        Survey survey = new Survey();
        survey.setTitle("new Testing Survey");
        mockMvc.perform(post("/createSurveySubmit").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", survey.getTitle())
                .with(csrf()));
        Survey target = null;
        Iterable<Survey> surveys = surveyRepository.findAll();
        for(Survey s: surveys){
            if(s.getTitle().equals("new Testing Survey")){
                target = s;
            }
        }
        assert(target.getTitle().equals("new Testing Survey"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testAddQuestions() throws Exception {
        Survey s = surveyRepository.findById(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/addQuestions")
                        .param("surveyID", s.getId().toString()).with(csrf()))

                .andExpect(status().isOk())
                .andExpect(model().attributeExists("survey"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("surveyID"))
                .andExpect(model().attributeExists("multipleChoiceQuestion"))
                .andExpect(model().attributeExists("numericalRangeQuestion"))
                .andExpect(model().attributeExists("openEndedQuestion"))
                .andExpect(view().name("addQuestions"));

//        verify(surveyRepository).findById(1);
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testFillSurveyEndpoint() throws Exception {
        Survey survey = surveyRepository.findById(1);
        mockMvc.perform(MockMvcRequestBuilders.get("/fillSurvey")
                        .param("surveyID", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("fillSurvey"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("survey"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("survey"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    @Transactional
    public void testAddMultipleChoiceQuestion() throws Exception {
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("New Test Multiple Choice Question", new ArrayList<String>(Arrays.asList("Option 1", "Option 2", "Option 3")));

        mockMvc.perform(post("/addMultipleChoiceQuestion")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("surveyID", "1")
                .flashAttr("mcQ", mcq)
                .with(csrf())).andExpect(status().isOk())
                .andExpect(view().name("questionAdded"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("questions"))
                .andExpect(model().attributeExists("surveyID"));

        // retrieve the updated survey from the repository
//        Iterable<Survey> surveys = surveyRepository.findAll();
//        Survey s = surveyRepository.findById(1);
//        System.out.println(s.getTitle());
//        for (Question q: s.getQuestions()){
//            System.out.println(q.getQuestionText());
//        }
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    @Transactional
    public void testAddNumericalRangeQuestion() throws Exception {
        NumericalRangeQuestion nrq = new NumericalRangeQuestion("test numerical", 1, 10);

        mockMvc.perform(post("/addNumericalRangeQuestion")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("surveyID", "1")
                        .flashAttr("nrQ", nrq)
                        .with(csrf())).andExpect(status().isOk())
                .andExpect(view().name("questionAdded"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("questions"))
                .andExpect(model().attributeExists("surveyID"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    @Transactional
    public void testOpenEndedQuestion() throws Exception {
        OpenEndedQuestion oeq = new OpenEndedQuestion("test Open Ended");

        mockMvc.perform(post("/addOpenEndedQuestion")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("surveyID", "1")
                        .flashAttr("oeQ", oeq)
                        .with(csrf())).andExpect(status().isOk())
                .andExpect(view().name("questionAdded"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("questions"))
                .andExpect(model().attributeExists("surveyID"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    @Transactional
    public void testHistogram() throws Exception {
        OpenEndedQuestion oeq = new OpenEndedQuestion("test Open Ended");

        mockMvc.perform(get("/getActualHistograms")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("surveyID", "1" )
                        .param("questionID" , "1" )
                        .param("questiontext" ,"How often do you exercise?" )
                        .flashAttr("oeQ", oeq)
                        .with(csrf())).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    @Transactional
    public void testViewClosedSurveys() throws Exception{
        String login = this.mockMvc.perform(formLogin()).andReturn().getResponse().getContentAsString();
        String Result = this.mockMvc.perform(get("http://localhost:8080/listClosedSurveys").with(csrf())).andReturn().getResponse().getContentAsString();
        assert Result.contains("List of Closed Surveys");
    }
}
