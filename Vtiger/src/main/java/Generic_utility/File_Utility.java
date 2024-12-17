package Generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	public String getKeyAndValueData(String key) throws Throwable
	{
	 FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties.txt");
	 Properties pro = new Properties();
	 pro.load(fis);
	 return pro.getProperty(key);
	
	
}
	
//	public String getloginStringdata(String URL,String USERNAME, String PASSWORD) throws Throwable 
//	{
//		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties.txt");
//		 Properties pro = new Properties();
//		 pro.load(fis);
//		File_Utility flib = new File_Utility();
//		flib.getKeyAndValueData(URL);
//		flib.getKeyAndValueData(USERNAME);
		
		
		 public void getloginStringdata() throws Throwable {
		        // Retrieve values using the correct keys
		        String URL = getKeyAndValueData("url");  
		        String USERNAME = getKeyAndValueData("username"); 
		        String PASSWORD = getKeyAndValueData("password"); 
		
		
				
	}
}
