package csmen.group.project.Controller;

import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

    @RequestMapping("/register")
    public String register() {
        return "Register";
    }

    @RequestMapping("/settings")
    public String settings() {
        return "Settings";
    }

    @RequestMapping("/getPassword")
    public String getPassword(){
        return "GetPassword";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(UserInfo user){
        int i = ud.addUser(user);
        if(i > 0)
            return true;
        else
            return false;
    }
//    @RequestMapping("gologin") 进行用户检测判断
}
