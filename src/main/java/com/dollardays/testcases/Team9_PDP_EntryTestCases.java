package com.dollardays.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team9_ProductDescriptionPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class Team9_PDP_EntryTestCases extends BaseTest {

	
	/**
	 * This function runs all the Entry test cases.
	 * 
	 * @param datatable
	 * @throws Exception
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Entry", testcaseID = "", runmode = "")
	@Test(groups = { "lsn-test-one" }, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_DD_PDP_Entry_Cases(Hashtable<String, String> datatable) throws Exception {

		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " + datatable.get("TestCase"));
		runPreConditions(datatable);

		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1 : Enter Quantity: " + datatable.get("Qty"));
		// 1. CLEAR QTY NUM CASES BOX
		pdp_page.getNumCasesBox().clear();
		Thread.sleep(1000);
		// 2. ENTER value
		pdp_page.getNumCasesBox().sendKeys(datatable.get("Qty"));
		Thread.sleep(1000);
		pdp_page.getNumCasesBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// 3. VERIFY NOTHING HAPPENED BY READING QTY NUM CASES WEBELEMENT
		ExtentTestManager.getTest().log(Status.INFO, "Verify Quantity is not displayed.");
		Assert.assertEquals(pdp_page.getNumCasesBox().getText(), "");
		Thread.sleep(1000);
	}

}
