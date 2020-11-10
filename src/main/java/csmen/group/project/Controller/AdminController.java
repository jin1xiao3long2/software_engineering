package csmen.group.project.Controller;


import csmen.group.project.dao.AdminDao;
import csmen.group.project.dao.DoctorDao;
import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.AdminInfo;
import csmen.group.project.entity.DoctorInfo;
import csmen.group.project.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class AdminController {

    @Resource
    AdminDao ad;
    @Resource
    UserDao ud;
    @Resource
    DoctorDao dd;

    @RequestMapping("/admin")
    public String AdminLogin() {
        return "AdminControll/AdminLogin";
    }

    @RequestMapping("/admingologin")
    public String AdminGoLogin(AdminInfo admin,
                               HttpServletRequest request,
                               Model model){
        AdminInfo aa = ad.login(admin);
        if(aa == null){
            model.addAttribute("msg","admin login error");
            return "public/False";
        }
        Integer HID = aa.getHID();
        String privilege = aa.getPrivilege();
        HttpSession session = request.getSession();
        session.setAttribute("aname",aa.getName());
        session.setAttribute("apassword",aa.getPassword());
        model.addAttribute("admin", aa);
        List<UserInfo> userList = null;
        List<DoctorInfo> doctorList = null;
        List<AdminInfo> adminList = null;
        if(privilege.equals("Hyper")) {
            userList = ud.findAll();
            doctorList = dd.findAll();
            adminList = ad.findAll();
            model.addAttribute("ulist", userList);
            model.addAttribute("dlist",doctorList);
            model.addAttribute("alist",adminList);
        }else if(privilege.equals("Hospital")){
            doctorList = dd.findByHID(HID);
            model.addAttribute("dlist",doctorList);
        }else if(privilege.equals("Commulity")){
            userList = ud.findAll();
            model.addAttribute("ulist",userList);
        }else{
            return "Public/False";
        }
        return "AdminControll/ControllIndex";
    }
}
