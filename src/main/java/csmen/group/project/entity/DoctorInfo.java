package csmen.group.project.entity;

public class DoctorInfo {
    private Integer id;
    private Integer HID;
    private String name;
    private String password;
    private String sex;
    private String phone_number;
    private String id_number;
    private String faculty;
    private String profession;
    private String political;
    private String expertise;
    private String description;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHID() {
        return HID;
    }

    public void setHID(Integer HID) {
        this.HID = HID;
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DoctorInfo(Integer id, Integer HID, String name, String password, String sex, String phone_number, String id_number, String faculty, String profession, String political, String expertise, String description, String status) {
        this.id = id;
        this.HID = HID;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.phone_number = phone_number;
        this.id_number = id_number;
        this.faculty = faculty;
        this.profession = profession;
        this.political = political;
        this.expertise = expertise;
        this.description = description;
        this.status = status;
    }

    public DoctorInfo() {
    }
}
