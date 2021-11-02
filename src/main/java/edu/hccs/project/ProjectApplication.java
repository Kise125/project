package edu.hccs.project;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

@SpringBootApplication
public class ProjectApplication {
	public static ListStudents parseJSOn(String url) throws ParseException {
		Client client =Client.create();
		WebResource webResource = client.resource(url);
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		if(clientResponse.getStatus() !=200)
		{
			throw new RuntimeException("Failed" + clientResponse.toString());
		}
		JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
		Iterator<Object> it = jsonArray.iterator();
		ListStudents studentList = new ListStudents();
		while(it.hasNext())
		{
			JSONObject jsonObject = (JSONObject) it.next();
			int id = Integer.parseInt(jsonObject.get("id").toString());
			String name = jsonObject.get("first_name").toString();
			String gender =jsonObject.get("gender").toString();
			String email = jsonObject.get("email").toString();

			JSONArray courseListObject = (JSONArray) jsonObject.get("course");
			CourseList courseList = new CourseList();

			if(courseListObject!= null)
			{
				Iterator<Object> a = courseListObject.iterator();
				while (a.hasNext())
				{
					JSONObject courseObject = (JSONObject) a.next();
					String courseNo = courseObject.get("courseNo").toString();
					String grade = courseObject.get("grade").toString();
					int creditHours = Integer.parseInt(courseObject.get("creditHours").toString());
					Course course = new Course(courseNo,grade,creditHours);
					courseList.addCourse(course);
				}
			}
			Student student = new Student(id,name,gender,email,courseList);
			studentList.addStudent(student);
		}
		return studentList;
	}


	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
		ListStudents listStudents = parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student_course.json");
//		System.out.println(listStudents.getListStudents());
//		System.out.println(listStudents.searchName("aida"));
		System.out.println(listStudents.searchCourseNO("CS12"));
		listStudents.getListStudents().forEach(e->{
			if(!e.getCourseList().getCourse().isEmpty()){
				System.out.println("Name:" + e.getFirstName() + "\t GPA: " + e.calGPA());
			} else {
				System.out.println("Cannot calculate");
			}

		});

	}

}

