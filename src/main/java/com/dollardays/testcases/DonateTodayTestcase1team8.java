package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.pages.Team8WishlistPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class DonateTodayTestcase1team8 extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@DDDataProvider(datafile = "testdata/testdatateam8.xlsx", sheetName = "Sheet5",  testcaseID = "TC4", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_04_verifyDonateTodayUnderWishlist(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 4 : Verify Donate Today ");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		Thread.sleep(1000);
		System.out.println(datatable.get("UserName"));
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(2000);		
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicked on Wishlist drop down");
		Team8WishlistPage topMenuBar = new Team8WishlistPage(driver);	
        topMenuBar.getWishList().click();
        Thread.sleep(1000);
        
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Clicked on the donate today option");
		topMenuBar.getDonateToday().click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on Create wish list option");
		topMenuBar. getWishListButton1().click();
		Thread.sleep(1000);
		driver.navigate().back();
		

	}
}
