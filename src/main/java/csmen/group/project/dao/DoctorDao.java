package csmen.group.project.dao;

import csmen.group.project.entity.DoctorInfo;

import java.util.List;

public interface DoctorDao {

    DoctorInfo login(DoctorInfo docter);

    List<DoctorInfo> findAll();

    List<DoctorInfo> findByHID(Integer HID);
}
