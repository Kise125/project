package edu.hccs.project;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class ListStudents {
    public ListStudents() {
    }

    private ArrayList<Student> listStudents = new ArrayList();

    public void addStudent(Student st){
        listStudents.add(st);
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public  ArrayList<Student> searchName(String name) {
        String stuName = name.trim();
        ArrayList<Student> stuList = new ArrayList<>();
        if (!listStudents.isEmpty()) {
            for (int i = 0; i < listStudents.size(); i++) {
                if (stuName.trim().equalsIgnoreCase(listStudents.get(i).getFirstName())) {
                    stuList.add(listStudents.get(i));
                }
            }
        }
        return stuList;
    }

    public  ArrayList<Student> searchCourseNO(String courseNO)  {
        String course = courseNO.trim();
        ArrayList<Student> courseList = new ArrayList<>();
        listStudents.forEach(e->{
            for (int i = 0; i< e.getCourseList().getCourse().size();i++){
                if(e.getCourseList().getCourse().get(i).getCourseNo().equals(course)) {

                courseList.add(e);
                }
            }

        });
    return courseList;
    }

}
