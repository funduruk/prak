package com.example.prak.Entities;

import freemarker.core.LocalContext;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_id")
    private long Student_ID;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    private String email;

    @Column(name = "residence")
    private String residence;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "enrollment_date")
    private LocalDate enrollment_date;

    @Column(name = "status")
    private String status;


    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getMiddlename(){
        return middlename;
    }

    public void setMiddlename(String middlename){
        this.middlename = middlename;
    }
    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getPhonenumber(){
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    public String getResidence(){
        return residence;
    }

    public void setResidence(String residence){
        this.residence = residence;
    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDate getBirthdate(){
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate){
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return id + "|" + lastname + "|" + middlename + "|" + lastname + "|" + phonenumber + "|" + birthdate + "|" + email + "|" + status;

    }
}