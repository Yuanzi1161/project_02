package com.etoak.java.bean;

public class EtEmployeeInfo {

    private Integer id;
    // 姓名
    private String name;
    // 员工编号
    private String etoakNo;
    // 性别
    private String gender;
    // 年龄
    private Integer age;
    // 工作年限
    private Integer workTime;
    // 薪水
    private Integer salary;
    // 所在城市
    private String city;
    // 工作地点
    private String workPlace;
    // 工作状态
    private String status;

    public Integer getId() {
        return id;
    }

    public EtEmployeeInfo() {

    }

    public EtEmployeeInfo(String name, String etoakNo, String gender, Integer age, Integer workTime, Integer salary, String city, String workPlace, String status) {
        this.name = name;
        this.etoakNo = etoakNo;
        this.gender = gender;
        this.age = age;
        this.workTime = workTime;
        this.salary = salary;
        this.city = city;
        this.workPlace = workPlace;
        this.status = status;
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

    public String getEtoakNo() {
        return etoakNo;
    }

    public void setEtoakNo(String etoakNo) {
        this.etoakNo = etoakNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
