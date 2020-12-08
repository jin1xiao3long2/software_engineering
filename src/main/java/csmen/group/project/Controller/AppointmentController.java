package csmen.group.project.Controller;


import csmen.group.project.dao.*;
import csmen.group.project.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

@Controller
public class AppointmentController {
		@Resource 
		DoctorDao dd;
		
		@Resource
		HospitalDao hd;
		
		@Resource
		AppointmentDao ad;
		
		@RequestMapping("/doAppointment")
		public String DoAppointment(@RequestParam("hospital") String hospital, @RequestParam("expertise") String expertise, Model model)
		{
			//System.out.println(hospital + " " + expertise);
			List<HospitalInfo> HospitalList = hd.querybynameAndinfo(hospital);
			if(HospitalList.size() != 0)
			{
				System.out.println("hospital +1");
			}
			
			List<DoctorInfo> DoctorList = dd.findByExpertise(expertise);
			if(DoctorList.size() != 0)
			{
				System.out.println("doctor + 1");
			}
			
			int match = 0;
			List<AppointmentInfo> appointments = new ArrayList<AppointmentInfo>();
			appointments.clear();
			for(int i = 0; i < DoctorList.size(); i++)
			{
				for(int j = 0; j < HospitalList.size(); j++)
				{
					if(DoctorList.get(i).getHID() == HospitalList.get(j).getHID())
					{
						match++;
						AppointmentInfo appInfo = ad.findByDID(DoctorList.get(i).getDID());
						System.out.println(appInfo.getTimestart());
						appointments.add(appInfo);
					}
				}
			}
			model.addAttribute("appointmentinfo", appointments);
			model.addAttribute("appointmentinfosize", appointments.size());
			if(match == 0)
			{
				return "/Public/Fail";
			}
			else
			{
				return "/AppointmentQueryResult";
			}
		}
		
		@RequestMapping("/selectDoctor/{DID}")
		public String SelectDoctor(@PathVariable("DID") Integer DID, Model model)
		{
			AppointmentInfo app = ad.findByDID(DID);
			if(app.getMaxpatients() - app.getCurrentpatients() > 0)
			{
				int neoCurP = app.getCurrentpatients()+1;
				app.setCurrentpatients(neoCurP);
				if(ad.updateAppointment(app) > 0)
				{
					return "/AppointmentSuccess";
				}
				else
				{
					return "/Public/Fail";
				}
			}
			else
			{
				return "/Public/Fail";
			}
		}
}
