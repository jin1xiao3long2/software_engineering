package csmen.group.project.dao;

import csmen.group.project.entity.AdminInfo;
import java.util.List;

public interface AdminDao {

    List<AdminInfo> findAll();

    AdminInfo login(AdminInfo admin);
}
