package surveyMonkey;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Question.class)
    private List<Question> questions;
    private boolean open;


    public Survey() {
        this.questions = new ArrayList<>();
        this.open = true;
    }


    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
        this.open = true;
    }


    public Survey(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
        this.open = true;

    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }


    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public List<Question> getQuestions() {
        return this.questions;
    }


    public void close() {
        this.open = false;
    }
}

