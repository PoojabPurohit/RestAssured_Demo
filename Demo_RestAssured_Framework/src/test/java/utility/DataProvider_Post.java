package utility;

import org.testng.annotations.DataProvider;

public class DataProvider_Post {
	
	@DataProvider(name="user_data")
	public Object[][] Data_For_createUser()
	{
		Object[][] newUser=new Object[2][2];
		newUser[0][0]= "Rani";
		newUser[0][1]= "Engineer";
		
		newUser[1][0]= "Raja";
		newUser[1][1]= "Engineer";
		
		return newUser;
	}

}
