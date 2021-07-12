package Demos;
import org.testng.annotations.DataProvider;

public class DataForTests {
	@DataProvider(name="DataForPost")
	public Object[][] dataForPost()
	{
//		Object[][] data=new Object[2][2];
//		data[0][0]="my 5th book";
//		data[0][1]="desc";
//		data[1][0]="my 6th book";
//		data[1][1]="desc 6th";
//		return data;
		return new Object[][] {
			{"aaa","bbbb"},
			{"ccc","ddd"}
		};
		
	}
	@DataProvider(name="DeleteData")
	public Object[] dataForDelete()
	{
		return new Object[] {
				12};
	}

}
