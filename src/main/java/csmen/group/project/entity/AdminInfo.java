package csmen.group.project.entity;

public class AdminInfo {

    private Integer id;
    private String name;
    private String password;
    private String privilege;
    private Integer HID;

    public AdminInfo() {
    }

    public AdminInfo(Integer id, String name, String password, String privilege, Integer HID) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.privilege = privilege;
        this.HID = HID;
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

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Integer getHID() {
        return HID;
    }

    public void setHID(Integer HID) {
        this.HID = HID;
    }


}
