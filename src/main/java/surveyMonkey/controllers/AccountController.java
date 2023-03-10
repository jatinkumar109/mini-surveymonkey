package surveyMonkey.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {





    @GetMapping("/signup")
    public String signUpForm(Model model) {
        return "signupForm";
    }

    @PostMapping("/signup")
    public String signUpSubmit(Model model) {
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login (Model model) {
        return "login";
    }




}
