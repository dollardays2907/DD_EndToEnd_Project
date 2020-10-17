package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team9_ProductDescriptionPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class Team9_PDP_PopUpTestCases extends BaseTest {

	/**
	 * This function runs all the Quantity entry popup test cases.
	 * 
	 * @param datatable
	 * @throws Exception
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Popup", testcaseID = "", runmode = "")
	@Test(groups = { "test-one-popup" }, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_DD_PDP_Quantity_Cases(Hashtable<String, String> datatable) throws Exception {
		
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " + datatable.get("TestCase"));
		runPreConditions(datatable);

		ExtentTestManager.getTest().log(Status.INFO, "Quantity is " + datatable.get("Qty"));

		// real test steps
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1 : Enter Quantity: " + datatable.get("Qty"));
		pdp_page.enterNumCases(datatable.get("Qty"));
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO,
				"Displayed Calculated price is: " + pdp_page.getQtyCalculatedPrice().getText());
		ExtentTestManager.getTest().log(Status.INFO,
				"Expected Calculated price is: " + pdp_page.getExpectedCalcPrice(datatable.get("Qty")));

		ExtentTestManager.getTest().log(Status.INFO, "Step 2 :Check/Uncheck Unlimited quantity.");
		pdp_page.handle_unlim_qty(datatable.get("Unlimited Check?"));
		Thread.sleep(1000);
		pdp_page.verify_checkbox(datatable.get("Unlimited Check?"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 3 : Click on add to my cart button");
		pdp_page.getAddToMyCartBtn().click();
		Thread.sleep(1000);
		pdp_page.verifyAddToMyCart(datatable.get("Qty"), datatable.get("Unlimited Check?"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 4 : Close the popup if needed.");
		pdp_page.handlePopup(datatable.get("Close Popup?"));
		Thread.sleep(1000);
	}

}
