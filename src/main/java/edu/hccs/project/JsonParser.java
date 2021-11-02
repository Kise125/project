//package edu.hccs.project;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//
//public class JsonParser {
//    public static ListStudents parseJSOn(String url) throws ParseException {
//        Client client =Client.create();
//        WebResource webResource = client.resource(url);
//        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
//        if(clientResponse.getStatus() !=200)
//        {
//            throw new RuntimeException("Failed" + clientResponse.toString());
//        }
//        JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
//        Iterator<Object> it = jsonArray.iterator();
//        ListStudents listStudents = new ListStudents();
//        while(it.hasNext())
//        {
//            JSONObject jsonObject = (JSONObject) it.next();
//            int id = Integer.parseInt(jsonObject.get("id").toString());
//            String name = jsonObject.get("first_name").toString();
//            String gender =jsonObject.get("gender").toString();
//            String gpa = (String) jsonObject.get("gpa");
//            String email = jsonObject.get("email").toString();
//            Student student = new Student(id,name,gpa ,gender, email);
//            listStudents.addStudent(student);
//        }
//        return listStudents;
//    }
//    public static Student searchGender(String gender) throws ParseException {
//        ArrayList <Student> listStudents = parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json").getListStudents();
//        Student st = null;
//        for(int i = 0; i < listStudents.size(); i++)
//        {
//            if(gender.trim().equalsIgnoreCase(listStudents.get(i).getGender()))
//            {
//                st = listStudents.get(i);
//            }
//        }
//        return st;
//    }
//
//    public static void main(String[] args) throws ParseException {
//        System.out.println(parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json").getListStudents());
//        System.out.println(searchGender("Male"));
//
//    }
//}
