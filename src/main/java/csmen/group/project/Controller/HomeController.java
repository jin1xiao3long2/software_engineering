package csmen.group.project.Controller;


import csmen.group.project.dao.DoctorDao;
import csmen.group.project.entity.DoctorInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;


import java.util.List;

@Controller
public class HomeController {

    @Resource
    DoctorDao dd;

    @RequestMapping("/home")
    public String Home(){
        return "Home";
    }

    @RequestMapping("/queryfind")
    public String QueryFind(@RequestParam("query") String text, Model model){
        List<DoctorInfo> DoctorList = dd.queryBynameAndinfo(text);
        model.addAttribute("doctorlist",DoctorList);
        
        return "/QueryResult";
    }
}
