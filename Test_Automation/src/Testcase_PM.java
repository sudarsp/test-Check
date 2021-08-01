import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Testcase_PM {

	WebDriver driver;
	//@Test
	public void tc1() throws InterruptedException
	{
		pm opm = new pm();
		driver=opm.abcde("Patch_Patch");
		//opm.refresh_content(driver);
		opm.inc(driver, "MUMTCOMSTGMEM01");
		opm.inc(driver, "CHNINITAZAVMT01");
		opm.inc(driver, "CHNINITMSKMS01");
		
		//sql_Connection sc = new sql_Connection();
		
	}
	//@Test
	public void tc2() throws InterruptedException, ClassNotFoundException, SQLException
	{
		PM_Multicheck opmc = new PM_Multicheck();
		driver=opmc.login();
		opmc.SelectPatch(driver,"Patch_check_007");
		opmc.inc(driver);		
		//sc.sqlfunc();
	}
	@Test
	public void tc3() throws InterruptedException, ClassNotFoundException, SQLException
	{
		PM_Multicheck opmc = new PM_Multicheck();
		driver=opmc.login();
		opmc.SelectPatch(driver,"Patch_check_005");
		opmc.multi_Check(driver);
		
		//sql_Connection sc = new sql_Connection();
		//sc.sqlfunc();
	}
}
