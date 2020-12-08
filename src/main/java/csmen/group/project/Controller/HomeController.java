package csmen.group.project.Controller;


import csmen.group.project.dao.*;
import csmen.group.project.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;

import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    DoctorDao dd;
    
    @Resource
    HospitalDao hd;
    
    @Resource
    DiseaseDao did;

    @RequestMapping("/home")
    public String Home(){
        return "Home";
    }

    @RequestMapping("/queryfind")
    public String QueryFind(@RequestParam("query") String text, Model model){
        List<DoctorInfo> DoctorList = dd.queryBynameAndinfo(text);
        if(DoctorList != null)
        {
        	model.addAttribute("doctorlist",DoctorList);
        	model.addAttribute("doctorsize", DoctorList.size());
        }
        	//  model.addAttribute("doctorlist1", DoctorList);//referrence
        List<HospitalInfo> HospitalList = hd.querybynameAndinfo(text);
        if(HospitalList != null)
        {
        	model.addAttribute("hospitallist", HospitalList);
        	model.addAttribute("hospitalsize", HospitalList.size());
        }
        
        List<DiseaseInfo> DiseaseList = did.querybynameandinfo(text);
        if(DiseaseList != null)
        {
        	model.addAttribute("diseaselist", DiseaseList);
        	model.addAttribute("diseasesize", DiseaseList.size());
        	System.out.println("GOT IT");
        }
        return "/QueryResult";
    }
    
   
}
