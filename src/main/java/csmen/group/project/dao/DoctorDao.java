package csmen.group.project.dao;

import csmen.group.project.entity.DoctorInfo;
import org.apache.ibatis.annotations.Param;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao {

    DoctorInfo login(DoctorInfo doctor);

    List<DoctorInfo> findAll();

    List<DoctorInfo> findByHID(Integer HID);

    List<DoctorInfo> findByname(String name);

    List<DoctorInfo> findBynameAndHID(@Param("name")String name, @Param("HID")Integer HID);

    List<DoctorInfo> queryBynameAndinfo(@Param("text") String text);

    DoctorInfo findByid(Integer id);

    int updateDoctor(DoctorInfo doctor);

    int delDoctor(Integer id);

    int addDoctor(DoctorInfo doctor);
    
    List<DoctorInfo> findByExpertise(String expertise);
    
    String findStartTime(Integer DID);
    
    String findEndTime(Integer DID);
}
