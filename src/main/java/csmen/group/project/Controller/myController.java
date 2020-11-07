package csmen.group.project.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {

    @RequestMapping("")
    public String HomePage() {
        return "Home";
    }

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }
}
