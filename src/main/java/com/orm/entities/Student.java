package com.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
    @Id
    private int studentId;
    private String sName;
    private String sCity;

    public Student(int studentId, String sName, String sCity) {
        this.studentId = studentId;
        this.sName = sName;
        this.sCity = sCity;
    }

    public Student(){

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }
}
