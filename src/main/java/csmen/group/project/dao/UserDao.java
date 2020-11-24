package csmen.group.project.dao;


import csmen.group.project.entity.UserInfo;

import java.util.List;

public interface UserDao {

    List<UserInfo> findAll();

    int addUser(UserInfo user);

    UserInfo login(UserInfo user);

    UserInfo findByid(Integer id);

    List<UserInfo> findByname(String name);

    int updateUser(UserInfo user);

    UserInfo findBynameAndIDnumber(UserInfo user);

    int changePasswd(UserInfo user);

    int delUser(Integer id);

}
