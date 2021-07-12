package Demos;

import Utils.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {

public static void main(String args[]) {
	
	JsonPath js=new JsonPath(PayLoad.CoursePrice());
	
	// Print No of courses returned by API
	int courseCount=js.getInt("courses.size()");
	System.out.println("Total courses:"+courseCount);
	
	//Print Purchase Amount
	int purchaseAmount=js.getInt("dashboard.purchaseAmount");
	System.out.println("Purchase Amount"+purchaseAmount);
	
	//Print Title of the first course
	String titleFirstCourse=js.get("courses[0].title");
	System.out.println("Title of the first course: "+titleFirstCourse);	
	
	//Print All course titles and their respective Prices

	
}
}
