package testScripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import utility.CommonFunctions;
import utility.ExcelUtils;
import utility.XLPath;

public class TestCase2 extends StartBrowser{
  @Test
  public void testLogin() throws Exception {
	  CommonFunctions func = new CommonFunctions();
	  
	  ExcelUtils.setExcelFile(XLPath.Path_TestData + XLPath.File_TestData,"Sheet1");
	  String email = ExcelUtils.getCellData(1, 1);
	  String password = ExcelUtils.getCellData(1, 2);
	  
	  func.signIn(email,password);
	  func.signOut();
	  ExcelUtils.setCellData("Pass", 1, 3);
  }
}
