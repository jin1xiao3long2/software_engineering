package csmen.group.project.dao;

import csmen.group.project.entity.AdminInfo;
import java.util.List;

public interface AdminDao {

    List<AdminInfo> findAll();

    List<AdminInfo> findByname(String name);

    AdminInfo login(AdminInfo admin);

    int addAdmin(AdminInfo admin);

    int delAdmin(Integer id);

    AdminInfo findByid(Integer id);

    int updateAdmin(AdminInfo admin);


}
