package com.lanou.del.domain;

/**
 * Created by dllo on 17/11/18.
 */
public class Student {
    private String studentId;
    private String studentName;

    public Student() {
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
