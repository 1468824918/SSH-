package com.lanou.del.domain;

import java.util.Date;

/**
 * Created by dllo on 17/11/18.
 */
public class Clazz {
    private String classId;
    private String className;
    private Student studentName;
    private String company;
    private double pay;
    private String post;
    private Date onDutyDate;
    private String describe;

    public Clazz() {
    }

    public Clazz(String className, Student studentName) {
        this.className = className;
        this.studentName = studentName;
    }

    public String getClassId() {
        return classId;
    }

    public Clazz(String classId, String className, Student studentName, String company, double pay, String post, Date onDutyDate, String describe) {
        this.classId = classId;
        this.className = className;
        this.studentName = studentName;
        this.company = company;
        this.pay = pay;
        this.post = post;
        this.onDutyDate = onDutyDate;
        this.describe = describe;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Student getStudentName() {
        return studentName;
    }

    public void setStudentName(Student studentName) {
        this.studentName = studentName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", studentName=" + studentName +
                ", company='" + company + '\'' +
                ", pay=" + pay +
                ", post='" + post + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", describe='" + describe + '\'' +
                '}';
    }
}
