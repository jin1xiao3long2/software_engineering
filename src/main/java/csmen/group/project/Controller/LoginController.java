package csmen.group.project.Controller;

import csmen.group.project.dao.DoctorDao;
import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.DoctorInfo;
import csmen.group.project.entity.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.*;

@Controller
public class LoginController {

    //    @Resource
//    private AdminDao ad;
    @Resource
    private UserDao ud;
    @Resource
    private DoctorDao dd;

    @RequestMapping("")
    public String HomePage() {
        return "Home";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login/Login";
    }

    @RequestMapping("/gologin")
    public String gologin(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("type") String type,
                          HttpServletRequest request, Model model){//此处有改动!!!
        
    	try 
    	{
	    	String path="G:/SEName/";
	    	String filename="name.txt";
	    	File f = new File(path, filename);
	    	if(f.exists())
	    	{
	    		f.delete();    	
	    	}
	    	f.createNewFile();
	    	FileWriter fw = new FileWriter(f.getAbsoluteFile());
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	bw.write(name);
	    	bw.close();
	    	System.out.println(name);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	Integer id;
        HttpSession session = request.getSession();
        if (type.equals("user")) {
            UserInfo user = new UserInfo();
            user.setName(name);
            user.setPassword(password);
            UserInfo uu = ud.login(user);
            if (uu == null) {
                model.addAttribute("msg", "Login Error");
                return "Public/Fail";
            }
            id = uu.getId();
            session.setAttribute("aname", user.getName());
            session.setAttribute("apassword", user.getPassword());
            model.addAttribute("loginer", uu);
        } else if (type.equals("doctor")) {
            DoctorInfo doctor = new DoctorInfo();
            doctor.setName(name);
            doctor.setPassword(password);
            DoctorInfo du = dd.login(doctor);
            if (doctor == null) {
                model.addAttribute("msg", "Login Error");
                return "Public/Fail";
            }
            id = du.getId();
            session.setAttribute("aname", doctor.getName());
            session.setAttribute("apassword", doctor.getPassword());
            model.addAttribute("loginer", du);
        } else {
            model.addAttribute("msg", "Login unknown error");
            return "Public/Fail";
        }

        session.setAttribute("id", id);
        session.setAttribute("type", type);
//        get image

        return "redirect:/";
    }

    @RequestMapping("/gologout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @RequestMapping("/register")
    public String register() {
        return "Login/Register";
    }

    @RequestMapping("/settings/{id}")
    public String settings(@PathVariable("id") Integer id, Model model) {
        UserInfo user = ud.findByid(id);
        user.setId(id);
        if (user == null) {
            return "Public/Fail";
        }
        model.addAttribute("user", user);
        return "Login/Settings";
    }

    @RequestMapping("/getPassword")
    public String getPassword() {
        return "Login/GetPassword";
    }

    @RequestMapping("/changePassword")
    public String changePassword(UserInfo user, Model model) {
        UserInfo uu = ud.findBynameAndIDnumber(user);
        if (uu == null) {
            return "Public/Fail";
        }
//        get image
        model.addAttribute("user", uu);
        return "Login/ChangePassword";
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
    public boolean changePasswd(UserInfo user) {
        System.out.println(user.getId() + user.getPassword());
        int i = ud.changePasswd(user);
        System.out.println(user.getId() + user.getPassword());
        if (i > 0)
            return true;
        else
            return false;
    }
//    @RequestMapping("gologin") 进行用户检测判断
    
    @RequestMapping("/goAppointment")
    public String GoAppointment()
    {
    	return "/Appointment";
    }
}
