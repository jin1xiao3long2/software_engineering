package csmen.group.project.Controller;

import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class myController {

    //    @Resource
//    private AdminDao ad;
    @Resource
    private UserDao ud;


    @RequestMapping("")
    public String HomePage() {
        return "Home";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/gologin")
    public String gologin(UserInfo user, HttpServletRequest request, Model model) {
        UserInfo uu = ud.login(user);
        if(uu == null){
            return "public/False";
        }
        HttpSession session = request.getSession();
        session.setAttribute("aname",user.getName());
        session.setAttribute("apassword", user.getPassword());
//        get image
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping("/gologout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


    @RequestMapping("/register")
    public String register() {
        return "Register";
    }

    @RequestMapping("/settings")
    public String settings() {
        return "Settings";
    }

    @RequestMapping("/getPassword")
    public String getPassword() {
        return "GetPassword";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(UserInfo user) {
        int i = ud.addUser(user);
        if (i > 0)
            return true;
        else
            return false;
    }
//    @RequestMapping("gologin") 进行用户检测判断
}
