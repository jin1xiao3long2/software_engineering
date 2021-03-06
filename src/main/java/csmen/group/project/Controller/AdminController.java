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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.Console;
import java.util.Iterator;
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

    /*
    @RequestMapping("/admingologin")
    public String AdminGoLogin(AdminInfo admin,
                               HttpServletRequest request,
                               Model model) {
        AdminInfo aa = ad.login(admin);
        if (aa == null) {
            model.addAttribute("msg", "admin login error");
            return "Public/Fail";
        }
        Integer HID = aa.getHID();
        String privilege = aa.getPrivilege();
        HttpSession session = request.getSession();
        session.setAttribute("aname", admin.getName());
        session.setAttribute("apassword", admin.getPassword());
        model.addAttribute("admin", aa);
        List<UserInfo> userList = null;
        List<DoctorInfo> doctorList = null;
        List<AdminInfo> adminList = null;
        if (privilege.equals("Hyper")) {
            userList = ud.findAll();
            doctorList = dd.findAll();
            adminList = ad.findAll();
            model.addAttribute("ulist", userList);
            model.addAttribute("dlist", doctorList);
            model.addAttribute("alist", adminList);
        } else if (privilege.equals("Hospital")) {
            doctorList = dd.findByHID(HID);
            model.addAttribute("dlist", doctorList);
        } else if (privilege.equals("Commulity")) {
            userList = ud.findAll();
            model.addAttribute("ulist", userList);
        } else {
            return "Public/False";
        }
        return "AdminControll/ControllIndex";
    }

 */
    @RequestMapping("/admingologin")
    public String AdminGoLogin(AdminInfo admin,
                                  HttpServletRequest request,
                                  Model model) {
        AdminInfo aa = ad.login(admin);
        if (aa == null) {
            model.addAttribute("msg", "admin login error");
            return "Public/Fail";
        }
        Integer HID = aa.getHID();
        String privilege = aa.getPrivilege();
        HttpSession session = request.getSession();
        session.setAttribute("aname", admin.getName());
        session.setAttribute("apassword", admin.getPassword());
        model.addAttribute("admin", aa);
        //登录
        String type = null;
        if (aa.getPrivilege().equals("Hyper")) {
            List<AdminInfo> adminList = ad.findAll();
            model.addAttribute("list", adminList);
            type = "admin";
        } else if (aa.getPrivilege().equals("Hospital")) {
            List<DoctorInfo> doctorList = dd.findByHID(aa.getHID());
            model.addAttribute("list", doctorList);
            type = "doctor";
        } else if (aa.getPrivilege().equals("Commulity")) {
            List<UserInfo> userList = ud.findAll();
            model.addAttribute("list", userList);
            type = "user";
        } else {
            model.addAttribute("msg", "can't find data");
            return "Public/Fail";
        }
        model.addAttribute("type", type);
        return "AdminControll/ControllIndex";
    }




    @RequestMapping("/adminindex")
    public String AdminIndex(AdminInfo admin, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        if (aa == null) {
            model.addAttribute("msg", "admin login error");
            return "Public/Fail";
        }
        model.addAttribute("admin", aa);
        //登录
        String type = null;
        String privilege = aa.getPrivilege();

        if (aa.getPrivilege().equals("Hyper")) {
            List<AdminInfo> adminList = ad.findAll();
            model.addAttribute("list", adminList);
            type = "admin";
        } else if (aa.getPrivilege().equals("Hospital")) {
            List<DoctorInfo> doctorList = dd.findByHID(aa.getHID());
            model.addAttribute("list", doctorList);
            type = "doctor";
        } else if (aa.getPrivilege().equals("Commulity")) {
            List<UserInfo> userList = ud.findAll();
            model.addAttribute("list", userList);
            type = "user";
        } else {
            model.addAttribute("msg", "can't find data");
            return "Public/Fail";
        }
        model.addAttribute("type", type);
        return "AdminControll/ControllIndex";
    }

    @RequestMapping("/adminindexquery")
    public String AdminIndexQuery(AdminInfo admin, Model model, HttpServletRequest request,
                                  @RequestParam("type") String tt, @RequestParam("name") String name){
        HttpSession session = request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        if (aa == null) {
            model.addAttribute("msg", "admin login error");
            return "Public/Fail";
        }
        model.addAttribute("admin", aa);
        //登录
        String type = null;
        String privilege = aa.getPrivilege();
        int size = 0;
        if (tt != null) {
            if (tt.equals("admin")) {
                List<AdminInfo> adminList = null;
                if(name.equals(""))
                    adminList = ad.findAll();
                else
                    adminList = ad.findByname(name);
                model.addAttribute("list", adminList);
                type = "admin";
                size = adminList.size();
            } else if (tt.equals("doctor")) {
                List<DoctorInfo> doctorList = null;
                if(privilege.equals("Hospital")) {
                    if(name.equals(""))
                        doctorList = dd.findByHID(aa.getHID());
                    else
                        doctorList = dd.findBynameAndHID(name,aa.getHID());
                } else if(privilege.equals("Hyper"));
                {
                    if(name.equals(""))
                        doctorList = dd.findAll();
                    else
                        doctorList = dd.findByname(name);
                }
                model.addAttribute("list", doctorList);
                type = "doctor";
                size = doctorList.size();
            } else if (tt.equals("user")) {
                List<UserInfo> userList = null;
                if(name.equals(""))
                    userList = ud.findAll();
                else
                    userList = ud.findByname(name);
                model.addAttribute("list", userList);
                type = "user";
                size = userList.size();
            } else {
                model.addAttribute("msg", "can't find data");
                return "Public/Fail";
            }
            model.addAttribute("name",name);
            model.addAttribute("type", type);
            model.addAttribute("size",size);
            return "AdminControll/ControllIndex";
        }
        return "AdminControll/ControllIndex";
    }

    @RequestMapping("/goadddoctor")
    public String GoAddDoctor(AdminInfo admin, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        model.addAttribute("admin", aa);
        return "AdminControll/Add/AddDoctor";
    }

    @RequestMapping("/adddoctor")
    @ResponseBody
    public boolean AddDoctor(DoctorInfo doctor) {
        int i = dd.addDoctor(doctor);
        if (i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/godeldoctor/{id}")
    public String GoDelDoctor(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("href", "/adminindex");
        dd.delDoctor(id);
        return "Public/Success";
    }

    @RequestMapping("/goupdatedoctor/{id}")
    public String GoUpdateDoctor(@PathVariable("id") Integer id, Model model) {
        DoctorInfo doctor = dd.findByid(id);
        model.addAttribute("doctor", doctor);
        return "AdminControll/Update/UpdateDoctor";
    }

    @RequestMapping("/updatedoctor")
    @ResponseBody
    public boolean UpdateDoctor(DoctorInfo doctor) {
        int i = dd.updateDoctor(doctor);
        if (i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/goadduser")
    public String GoAddUser(AdminInfo admin, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        model.addAttribute("admin", aa);
        return "AdminControll/Add/AddUser";
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public boolean AddUser(UserInfo user) {
        int i = ud.addUser(user);
        if (i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/godeluser/{id}")
    public String GoDelUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("href", "/adminindex");
        ud.delUser(id);
        return "Public/Success";
    }

    @RequestMapping("/goupdateuser/{id}")
    public String GoUpdateUser(@PathVariable("id") Integer id, Model model) {
        UserInfo user = ud.findByid(id);
        model.addAttribute("user", user);
        return "AdminControll/Update/UpdateUser";
    }

    @RequestMapping("/updateuser")
    @ResponseBody
    public boolean UpdateUser(UserInfo user) {
        int i = ud.updateUser(user);
        if (i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/goaddadmin")
    public String GoAddAdmin(AdminInfo admin, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((String) session.getAttribute("apassword"));
        AdminInfo aa = ad.login(admin);
        model.addAttribute("admin", aa);
        return "AdminControll/Add/AddAdmin";
    }

    @RequestMapping("/addadmin")
    @ResponseBody
    public boolean AddAdmin(AdminInfo admin) {
        int i = ad.addAdmin(admin);
        if (i > 0)
            return true;
        else
            return false;
    }

    @RequestMapping("/godeladmin/{id}")
    public String GoDelAdmin(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("href", "/adminindex");
        ad.delAdmin(id);
        return "Public/Success";
    }

    @RequestMapping("/goupdateadmin/{id}")
    public String GoUpdateAdmin(@PathVariable("id") Integer id, Model model) {
        AdminInfo admin = ad.findByid(id);
        model.addAttribute("admin", admin);
        return "AdminControll/Update/UpdateAdmin";
    }

    @RequestMapping("/updateadmin")
    @ResponseBody
    public boolean UpdateAdmin(AdminInfo admin) {
        int i = ad.updateAdmin(admin);
        if (i > 0)
            return true;
        else
            return false;
    }


}
