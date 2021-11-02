package edu.hccs.project;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CourseList {
    public CourseList() {
    }

    private ArrayList<Course> courseList = new ArrayList();

    public void addCourse(Course course){
        courseList.add(course);
    }

    public ArrayList<Course> getCourse() {
        return courseList;
    }

    public void setCourse(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courseList=" + courseList +
                '}';
    }
}
