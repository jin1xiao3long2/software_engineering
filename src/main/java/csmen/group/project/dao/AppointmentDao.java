package csmen.group.project.dao;

import csmen.group.project.entity.AppointmentInfo;
import org.apache.ibatis.annotations.Param;

import javax.print.Doc;
import java.util.List;

public interface AppointmentDao {
	AppointmentInfo findByDID(@Param("DID") Integer DID);
	
	int updateAppointment(AppointmentInfo app);
}
