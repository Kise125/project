package edu.hccs.project;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String courseNo;
    private String grade;
    private int creditHours;

    public Course(String courseNo, String grade, int creditHours) {
        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;
    }

    public Course() {
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", grade='" + grade + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }
}
