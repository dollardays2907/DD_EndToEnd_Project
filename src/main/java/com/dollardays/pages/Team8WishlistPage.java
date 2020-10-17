package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.testcases.BaseTest;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Team8WishlistPage extends BaseTest {
	
	WebDriver driver;
	
	public Team8WishlistPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
		
	@FindBy (xpath= "//input[@placeholder='Search by organization or wishlist name']")
	//Search by Organization or wishlist name bar(SBOWNBar)
	WebElement SBSearchbar;
	
	public WebElement SBTextField() {		
		return SBSearchbar;		
	}
	
	@FindBy(xpath="//input[@placeholder='City, state and/or zip code']")
	//Search by City,State and/or zipcode
	WebElement CSZTestbar;
	
	public WebElement CSZTextfield() {
		return CSZTestbar;	
	}
	
	@FindBy(xpath="/html/body/div[3]/div/div/div[4]/div/button")
	WebElement Searchbtn;
	
	public WebElement Searchbtn() {		
		return Searchbtn;
	}
	
	@FindBy(xpath="//a[@class='btn btn-lg btn-primary']")
	WebElement Craeteawishlistbtn;
	
	public String ValidateCreateawishlistbtn() {
	Craeteawishlistbtn.click();
	return driver.getTitle();	
	}
	
	@FindBy(xpath="//a[@class='btnviewAll']")
	WebElement Viewallprojectsbtn;
	
	@FindBy(xpath="//h2[contains(text(),'All Projects')]")
	WebElement Allprojectstxt;
	
	public WebElement Allprojectstext() {
		return Allprojectstxt;
	}
	
	public boolean InspectViewallprojectsbtn() {
		Viewallprojectsbtn.click();
		return Allprojectstext().isDisplayed();
		}
	
	@FindBy(xpath="//div[@id='wishlistmidblock']//div[@class='container']//div[1]//div[1]//div[1]//a[1]")
	//Ann Arbor Public Schools ad
	WebElement DonateNowbtnAnn;
	
	public String InspectDonateNowbtnAnn() {
		DonateNowbtnAnn.click();
		return driver.getTitle();
		}
	
	@FindBy(xpath="//div[@id='wishlistmidblock']//div[@class='row']//div[2]//div[1]//div[1]//a[1]")
	//Education Relief Packs ad
	WebElement DonateNowbtnEf;
	
	public String InspectDonDonateNowbtnEf() {
		DonateNowbtnEf.click();
		return driver.getTitle();
		}
	
	@FindBy(xpath="//div[@class='row']//div[3]//div[1]//div[1]//a[1]")
	// Polk County Middle School 7th Grade ad
	WebElement DonateNowbtnPCMS;
	
	public String InspectDonateNowbtnPCMS() {
		DonateNowbtnPCMS.click();
		return driver.getTitle();
		}
	@FindBy(className="header-wishlist")
	WebElement Wishlistimg;
	
	@FindBy(className="dropdown-menu")
	WebElement WishlistDropdown;
	
	public WebElement VerifyWishlistimg() {
		Wishlistimg.click();
		return WishlistDropdown;
	}
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/h3[1]/span[1]/a[1]")
	WebElement Returntowishlist;
	
	@FindBy(linkText="Wishlist Cart")
	WebElement Wishlistcartbtn;
	
	public boolean VerifyWishlistcartbtn() {
		Wishlistimg.click();
		Wishlistcartbtn.click();
		return Returntowishlist.isDisplayed();
	}
	
	@FindBy(linkText="Learn More")
	WebElement Learnmorebtn;
	
	public String VerifyLearnmorebtn() {
		Learnmorebtn.click();
		return driver.getTitle();
	}
	
	@FindBy(xpath="//input[@class='iagree btn']")
	WebElement popupokbtn;
	
	public WebElement getpopupbtn() {
		return popupokbtn;
	}
	
	@FindBy(xpath="//h2[contains(text(),'No matching wishlist found.')]")
	WebElement Nomatchingwishlistfoundtxt;
	
	@FindBy(xpath="//li[@class='suggest-txt']")
	WebElement Noresultfoundnulltxt;
	
	@FindBy(xpath="//h2[contains(text(),'Wishlist Results')]")
	WebElement Wishlistresults;
	
	public WebElement getAdCount() {
		return Wishlistresults;
	}
	
	@FindBy(xpath = "//a[normalize-space(.)='Wishlist']")
	private WebElement wishList;
	@FindBy( linkText = "Donate Today")
	private WebElement donateToday;

	public WebElement getWishList() {
		return wishList;
	}
	public WebElement getDonateToday() {
		return donateToday;
	}
	//********************5
	@FindBy(xpath = "//a[contains(text(),'Create a Wishlist')]")
	private WebElement createWishListButton1;
	public WebElement getWishListButton1() {
		return wishList;
	}
	 //************
	
	@FindBy( xpath = "//input[@placeholder='Search for items in bulk']")
	
	private WebElement searchButton1;
	public WebElement getSearchBar() {
		return searchButton1;
	}	
	
	@FindBy( xpath = "//span[contains(text(),'wipes')]")
	
	private WebElement wipesOption;
	public WebElement getWipesOption() {
		return wipesOption;
	}	
		
	@FindBy( xpath = "//a[contains(text(),'Create a Wishlist')]")
	private WebElement createWishListButton;
	public WebElement getWishListButton() {
		return createWishListButton1;
	}
	//********************
	 
		
			 
			
		@FindBy( xpath = "//input[@placeholder='City, state and/or zip code']")
		private WebElement searchButton2;
		public WebElement getsearchButton2() {
			return searchButton2;
		}
		
		//WebElement alert1 = driver.findElement(By.xpath("//div[@class='cookie-bar-btn']"));
		//alert1.click();
		//driver.switchTo().alert().accept();
		//crated by A
		@FindBy( xpath = "//div[@class='cookie-bar-btn']")
		private WebElement privacyPolicyAlert;
		
		@FindBy( xpath = "/html/body/div[3]/div/div/div[3]/div/input")
		
		private WebElement searchCity;
		public WebElement getsearchCity() {
			return  searchCity;
		}
		
		//searchCity.sendKeys("Chandler");
		@FindBy( xpath = "/html/body/div[3]/div/div/div[4]/div/button")
		private WebElement searchButton3;
		public WebElement getsearchButton3() {
			return searchButton3;
		}
		public WebElement getPrivacyPolicyAlert() {
			return privacyPolicyAlert;
		}
		public void setPrivacyPolicyAlert(WebElement privacyPolicyAlert) {
			this.privacyPolicyAlert = privacyPolicyAlert;
		}
		

	
	public boolean Searchbartest(String Input) throws InterruptedException {
		Thread.sleep(1000);
		Team8Homepage Home=new Team8Homepage(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		getpopupbtn().click();
		Thread.sleep(1000);
		SBTextField().sendKeys(Input);
		Thread.sleep(1000);
		Searchbtn().click();
		Thread.sleep(2000);
		return Nomatchingwishlistfoundtxt.isDisplayed();
		
	}
	
	public boolean CityStateZipTextfield(String Input) throws InterruptedException {
		Thread.sleep(1000);
		Team8Homepage Home=new Team8Homepage(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		getpopupbtn().click();
		Thread.sleep(1000);
		 CSZTextfield().sendKeys(Input);
		Thread.sleep(1000);
		Searchbtn().click();
		Thread.sleep(2000);
		return Nomatchingwishlistfoundtxt.isDisplayed();
		
	}
	
	public boolean CityStateZipTextfieldValidInput(String Input) throws InterruptedException {
		Thread.sleep(1000);
		Team8Homepage Home=new Team8Homepage(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		getpopupbtn().click();
		Thread.sleep(1000);
		 CSZTextfield().sendKeys(Input);
		Thread.sleep(1000);
		Searchbtn().click();
		Thread.sleep(2000);
		return Wishlistresults.isDisplayed();
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
