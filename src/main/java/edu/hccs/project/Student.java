package edu.hccs.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Student {
    private int id;
    private  String firstName;
    private String gender;
    private String email;
    @Autowired
    private CourseList courseList ;

    public Student(int id, String firstName, String gender, String email, CourseList courseList) {
        this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
        this.courseList = courseList;
    }

    public Student(){

    }

    public CourseList getCourseList() {
        return courseList;
    }

    public void setCourseList(CourseList courseList) {
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int exchangePoint(String grade){
        int point = 0;
        if(grade.trim().compareToIgnoreCase("A")==0){
            point =4;
        } else if (grade.trim().compareToIgnoreCase("B")==0){
            point = 3;
        } else if (grade.trim().compareToIgnoreCase("C")==0){
            point = 2;
        } else if (grade.trim().compareToIgnoreCase("D")==0){
            point = 1;
        }
        return point;
    }

    public  double calGPA() {
        double gpa = 0.0;
        int totalcreditHours = 0;
        int totalgradePoint = 0;
        if(!courseList.getCourse().isEmpty()){
            for(Course course : courseList.getCourse()){
                totalcreditHours += course.getCreditHours();
                int point = exchangePoint(course.getGrade())*course.getCreditHours();
                totalgradePoint += point;
            }
            gpa = (double)totalgradePoint/totalcreditHours;
        }
        return gpa;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
