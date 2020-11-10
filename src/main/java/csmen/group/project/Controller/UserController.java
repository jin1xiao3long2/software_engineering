package csmen.group.project.Controller;

import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

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
            return "public/Fail";
        }
        Integer id = uu.getId();
        HttpSession session = request.getSession();
        session.setAttribute("aname",user.getName());
        session.setAttribute("apassword", user.getPassword());
        session.setAttribute("id",id);
//        get image
        model.addAttribute("user",uu);
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

    @RequestMapping("/settings/{id}")
    public String settings(@PathVariable("id") Integer id, Model model) {
        UserInfo user = ud.findByid(id);
        user.setId(id);
        if(user == null){
            return "public/Fail";
        }
        model.addAttribute("user",user);
        return "Settings";
    }

    @RequestMapping("/getPassword")
    public String getPassword() {
        return "GetPassword";
    }

    @RequestMapping("/changePassword")
    public String changePassword(UserInfo user, Model model) {
        UserInfo uu = ud.findByname(user);
        if(uu == null){
            return "public/Fail";
        }
//        get image
        model.addAttribute("user",uu);
        return "/ChangePassword";
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

    @RequestMapping("/update")//修改
    @ResponseBody
    public boolean updateUser(UserInfo user) {
        int i = ud.updateUser(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/changePasswd")
    @ResponseBody
    public boolean changePasswd(UserInfo user){
        System.out.println(user.getId()+user.getPassword());
        int i = ud.changePasswd(user);
        System.out.println(user.getId()+user.getPassword());
        if(i > 0)
            return true;
        else
            return false;
    }
//    @RequestMapping("gologin") 进行用户检测判断
}
