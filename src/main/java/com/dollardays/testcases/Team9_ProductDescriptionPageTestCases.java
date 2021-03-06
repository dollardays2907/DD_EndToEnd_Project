package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team9_ProductDescriptionPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class Team9_ProductDescriptionPageTestCases extends BaseTest {

		
	/**
	 * This function runs all the Product description test cases.
	 * @param datatable
	 * @throws Exception
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Product Details", testcaseID = "", runmode = "")
	@Test(groups = { "lsn-test-one" }, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_DD_PDP_ProductDetails_Cases(Hashtable<String, String> datatable) throws Exception {

		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " + datatable.get("TestCase"));
		runPreConditions(datatable);
		Thread.sleep(500);
		
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Verify " + datatable.get("Verify Value"));
		pdp_page.VerifyValue(datatable.get("Verify Value"));
		Thread.sleep(1000);
	}

}
