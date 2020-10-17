
package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.Team8Homepage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;

public class HomePageTestcaseTeam8 extends BaseTest {

	@DDDataProvider(datafile = "testdata/testdatateam8.json", runmode = "", sheetName = "", testcaseID = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = JsonReader.class)
	public void testBigBoxSchoolSupplies(Map<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {

		ExtentTestManager.getTest().log(Status.INFO, "BigBoxSchoolSupplies testcase");
		Thread.sleep(1000);

		LoginPage login = new LoginPage(driver);
		login.login(datatable.get("usernme"), Base64.decrypt(datatable.get("password")));

		Team8Homepage page = new Team8Homepage(driver);
		page.getBigBoxSchoolSupplies().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);
	}

	@Test
	public void testForwardBackpacks()
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {

		ExtentTestManager.getTest().log(Status.INFO, "ForwardBackpacks testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getForwardBackpacks().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);
	}

	/*@Test
	public void testBigBoxFlipFlops()
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {

		ExtentTestManager.getTest().log(Status.INFO, "BigBoxFlipFlops testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getBigBoxFlipFlops().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);
	}*/

	@Test
	public void testPPEGear() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "PPEGear testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getPPEGear().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void tetsTravelSize() throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {

		ExtentTestManager.getTest().log(Status.INFO, "TravelSize testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getTravelSize().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);
	}

	@Test
	public void testBackpack() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "Backpack testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getBackpacks().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testSchoolSupplies() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "SchoolSupplies testcase");
		Thread.sleep(1000);
		
		Team8Homepage page = new Team8Homepage(driver);
		page.getSchoolSupplies().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testBlankets() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "Blankets testcase");
		Thread.sleep(1000);
		
		Team8Homepage page = new Team8Homepage(driver);
		page.getBlankets().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testBabyLink() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "Baby Link testcase");
		Thread.sleep(1000);
		
		Team8Homepage page = new Team8Homepage(driver);
		page.getBabyLink().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testFood() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "Food testcase");
		Thread.sleep(1000);
		
		Team8Homepage page = new Team8Homepage(driver);
		page.getFood().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testElectronics() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "Electronics testcase");
		Thread.sleep(1000);
		
		Team8Homepage page = new Team8Homepage(driver);
		page.getElectronics().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testToysGames() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "Toysgames testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getToysGames().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testFlipFlops() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "FlipFlops testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getFlipFlops().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testKidsClothing() throws InterruptedException {
		
		
		ExtentTestManager.getTest().log(Status.INFO, "kidsclothing testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getKidsClothing().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testShoes() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "shoes testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getShoes().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testMedicine() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "Medicine testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getMedicine().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testFirstAid() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "first aid testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getFirstAid().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testOralCare() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "oralcare testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getOralCare().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testHygieneKits() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "HygieneKits testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getHygieneKits().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testCleaningSupplies() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "CleaningSupplies testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getCleaningSupplies().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

	@Test
	public void testKitchenDining() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "KitchenDining testcase");
		Thread.sleep(1000);

		Team8Homepage page = new Team8Homepage(driver);
		page.getKitchenDining().click();

		String title = driver.getTitle();
		System.out.println("title - " + title);

	}

}
