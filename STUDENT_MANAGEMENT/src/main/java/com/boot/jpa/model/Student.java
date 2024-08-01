package com.boot.jpa.model;
 
import jakarta.persistence.*;

 
@Entity
@Table(name="myScholars")
public class Student {
 
	@Id    
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOLAR_SEQ")    
	  @SequenceGenerator(name = "SCHOLAR_SEQ", sequenceName = "SCHOLAR_SEQ", allocationSize = 1)  
    private int sid;
    private String fName;
    private String lName;
    private String email;
    private int age;
    private String course;
 
    public Student() {
    }
 
    public Student(String fName, String lName, String email, int age, String course) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.age = age;
        this.course = course;
    }
 
 
    public int getSid() {
        return sid;
    }
 
    public void setSid(int sid) {
        this.sid = sid;
    }
 
    public String getfName() {
        return fName;
    }
 
    public void setfName(String fName) {
        this.fName = fName;
    }
 
    public String getlName() {
        return lName;
    }
 
    public void setlName(String lName) {
        this.lName = lName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public String getCourse() {
        return course;
    }
 
    public void setCourse(String course) {
        this.course = course;
    }
 
    // toString method for easy logging or debugging
    @Override
    public String toString() {
        return "Student{ " +
                "sid=" + sid +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", course=' " + course + '\'' +
                '}';
    }
}