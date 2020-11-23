package csmen.group.project.dao;

import csmen.group.project.entity.DoctorInfo;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao {

    DoctorInfo login(DoctorInfo doctor);

    List<DoctorInfo> findAll();

    List<DoctorInfo> findByHID(Integer HID);

    DoctorInfo findByid(Integer id);

    int updateDoctor(DoctorInfo doctor);

    int delDoctor(Integer id);

    int addDoctor(DoctorInfo doctor);
}
