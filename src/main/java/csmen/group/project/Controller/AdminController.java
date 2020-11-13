package csmen.group.project.Controller;


import csmen.group.project.dao.AdminDao;
import csmen.group.project.dao.DoctorDao;
import csmen.group.project.dao.UserDao;
import csmen.group.project.entity.AdminInfo;
import csmen.group.project.entity.DoctorInfo;
import csmen.group.project.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.print.Doc;
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
            return "Public/Fail";
        }
        Integer HID = aa.getHID();
        String privilege = aa.getPrivilege();
        HttpSession session = request.getSession();
        session.setAttribute("aname",admin.getName());
        session.setAttribute("apassword",admin.getPassword());
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

    @RequestMapping("/adminindex")
    public String AdminIndex(AdminInfo admin, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        admin.setName((String)session.getAttribute("aname"));
        admin.setPassword((String)session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        if(aa == null){
            model.addAttribute("msg","admin login error");
            return "Public/Fail";
        }
        Integer HID = aa.getHID();
        String privilege = aa.getPrivilege();
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
            return "Public/Fail";
        }
        return "AdminControll/ControllIndex";
    }

    @RequestMapping("/goupdatedoctor/{DID}")
    public String GoUpdateDoctor(@PathVariable("DID") Integer did, Model model){
        DoctorInfo doctor = dd.findByDID(did);
        model.addAttribute("doctor",doctor);
        return "AdminControll/Update/UpdateDoctor";
    }

    @RequestMapping("/updatedoctor")
    @ResponseBody
    public boolean updatedoctor(DoctorInfo doctor){
        int i = dd.updateDoctor(doctor);
        if(i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/godeldoctor/{DID}")
    public String GoDelDoctor(@PathVariable("DID") Integer did, Model model){
        model.addAttribute("href","/adminindex");
        dd.delDoctor(did);
        return "Public/Success";
    }

    @RequestMapping("/goadddoctor")
    public String GoAddDoctor(AdminInfo admin, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        admin.setName((String)session.getAttribute("aname"));
        admin.setPassword((String)session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        model.addAttribute("admin",aa);
        return "AdminControll/Add/AddDoctor";
    }

    @RequestMapping("/adddoctor")
    @ResponseBody
    public boolean addDoctor(DoctorInfo doctor){
        int i = dd.addDoctor(doctor);
        if(i > 0)
            return true;
        else
            return false;
    }
}
