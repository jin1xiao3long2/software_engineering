package csmen.group.project.entity;

public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String phone_number;
    private String id_number;

    public UserInfo() {
    }

    public UserInfo(Integer id, String name, String password, String sex, String phone_number, String id_number) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.phone_number = phone_number;
        this.id_number = id_number;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }
}
