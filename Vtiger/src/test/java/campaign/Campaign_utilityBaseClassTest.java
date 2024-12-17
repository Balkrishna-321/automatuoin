//UNABLE TO ENTER CAMPAIGN NAME IN TEXTBOX

package campaign;

import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excell_utility;
import java_Utility.Java_Utility_Files;
import page_repo.CAmpaigns_Addition_page;
import page_repo.Campaigns_Page_Elements;
import page_repo.HomePage_elements;


public class Campaign_utilityBaseClassTest extends BaseClass  {
	

	@Test
	public  void CampaignutilityBaseClassTest() throws Throwable {
		
		HomePage_elements home = new HomePage_elements(driver);
		home.moreoption();
		home.campaign();
		
		CAmpaigns_Addition_page add = new CAmpaigns_Addition_page(driver);
		add.createcampbutton();
		
		Excell_utility elib = new Excell_utility();
		String cam = elib.getexceldata("Campaign", 0, 0);
		
		Java_Utility_Files jav = new Java_Utility_Files();
		int rannum = jav.Random();
		
		System.out.println(cam+rannum);
		Campaigns_Page_Elements cp = new Campaigns_Page_Elements(driver);
		cp.campignnamebox(cam+rannum);
		cp.savecamp();
		
	

	}

	
}
