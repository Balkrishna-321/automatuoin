package organisation;

import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excell_utility;
import java_Utility.Java_Utility_Files;
import page_repo.HomePage_elements;
import page_repo.Oragnization_Addition_page;
import page_repo.Organization_Page_Elements;


public class Org_BaseClass_Test extends BaseClass{
	
	@Test
	public void OrgBaseClass_Test() throws Throwable 
	{
		HomePage_elements vhome = new HomePage_elements(driver);
		vhome.organization();
		
		Oragnization_Addition_page addorg = new Oragnization_Addition_page(driver);
		addorg.createorgbutton();
		

		Excell_utility elib = new Excell_utility();
		String orgname = elib.getexceldata("Organisation", 0, 0);
		
		Java_Utility_Files jlib = new Java_Utility_Files();
		int rannum = jlib.Random();
		
		
		
		Organization_Page_Elements orgpage = new Organization_Page_Elements(driver);
		orgpage.orgname(orgname+rannum);
		
		
		String phonumber = elib.getexceldata("Organisation", 1, 0);
		orgpage.phnum(phonumber);
		
		
		
		
		String emailid = elib.getexceldata("Organisation", 2, 0);
		orgpage.mailid(emailid);
		
		orgpage.saveordbutton();
		Thread.sleep(2000);
		
	
		
	}

}
