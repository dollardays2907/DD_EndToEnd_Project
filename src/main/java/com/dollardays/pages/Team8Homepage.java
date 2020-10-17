package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.testcases.BaseTest;

public class Team8Homepage extends BaseTest{
	// page Factory (or) Object Repository
	WebDriver driver;

	public Team8Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[2]/a/img")
	WebElement Wishlistimg;
	
	public WebElement Wishlistimg() {
		return Wishlistimg;
	}
	
	public boolean verifyWishlistimg() throws InterruptedException {
		Thread.sleep(5000);
		Wishlistimg.click();
		Thread.sleep(5000);
		return DropDownmenu.isDisplayed();
				
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu']")
	WebElement DropDownmenu;
	

	@FindBy(linkText="Learn More")
	WebElement WLLearnMore;
	
	public WebElement WLLearnMore() {
		return WLLearnMore;
	}
	
	@FindBy(xpath = "//div[@class='mid-school-banner']//div[@class='row']//div[1]//a[1]")
	WebElement bigBoxSchoolSupplies;

	public WebElement getBigBoxSchoolSupplies() {
		return  bigBoxSchoolSupplies;
	}

	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[2]/div[1]/div/div/div[2]/a/figure/img")
	WebElement forwardBackpacks;

	public WebElement getForwardBackpacks() {
		return  forwardBackpacks;

	}

	@FindBy(xpath="/html/body/form/div[5]/div[2]/div[1]/div/div/div[3]/a/figure/img")
	WebElement bigBoxFlipFlops;

	public WebElement getBigBoxFlipFlops() {
		return bigBoxFlipFlops;
	}

	@FindBy(xpath = "//img[@title='PPE Gear, Masks + Sanitizer']")
	WebElement PPEGear;

	public WebElement getPPEGear() {
		return PPEGear;
	}

	@FindBy(xpath = "//img[@title='Travel Size']")
	WebElement TravelSize;

	public WebElement getTravelSize() {
		return TravelSize;
	}

	@FindBy(xpath = "//img[@title='Backpacks']")
	WebElement backpacks;

	public WebElement getBackpacks() {
		return backpacks;
	}

	@FindBy(xpath = "//img[@title='School Supplies']")
	WebElement schoolSupplies;

	public WebElement getSchoolSupplies() {
		return schoolSupplies;
	}

	@FindBy(xpath = "//img[@title='Blankets']")
	WebElement blankets;

	public WebElement getBlankets() {
		return blankets;
	}

	@FindBy(xpath = "//img[@title='Baby']")
	WebElement babyLink;

	public WebElement getBabyLink() {
		return babyLink;
	}

	@FindBy(xpath = "//img[@title='Food']")
	WebElement food;

	public WebElement getFood() {
		return food;
	}

	@FindBy(xpath = "//img[@title='Electronics']")
	WebElement electronics;

	public WebElement getElectronics() {
		return electronics;
	}

	@FindBy(xpath = "//img[@title='Toys + Games']")
	WebElement toysGames;

	public WebElement getToysGames() {
		return toysGames;
	}

	@FindBy(xpath = "//img[@title='Flip Flops']")
	WebElement flipFlops;

	public WebElement getFlipFlops() {
		return flipFlops;
	}

	@FindBy(xpath = "//img[@title='Kids Clothing']")
	WebElement kidsClothing;

	public WebElement getKidsClothing() {
		return kidsClothing;
	}

	@FindBy(xpath = "//img[@title='Shoes']")
	WebElement shoes;

	public WebElement getShoes() {
		return shoes;
	}

	@FindBy(xpath = "//img[@title='Medicine + Treatments']")
	WebElement medicine;

	public WebElement getMedicine() {
		return medicine;
	}

	@FindBy(xpath = "//img[@title='First Aid']")
	WebElement firstaid;

	public WebElement getFirstAid() {
		return firstaid;
	}

	@FindBy(xpath = "//img[@title='Oral Care']")
	WebElement oralCare;

	public WebElement getOralCare() {
		return oralCare;
	}

	@FindBy(xpath = "//img[@title='Hygiene Kits']")
	WebElement hygieneKits;

	public WebElement getHygieneKits() {
		return hygieneKits;
	}

	@FindBy(xpath = "//img[@title='Cleaning Supplies']")
	WebElement cleaningSupplies;

	public WebElement getCleaningSupplies() {
		return cleaningSupplies;
	}

	@FindBy(xpath = "//img[@title='Kitchen + Dining']")
	WebElement kitchenDining;

	public WebElement getKitchenDining() {
		return kitchenDining;
	}
	
	public String validateWLLearnMoreTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		WLLearnMore.click();
		Thread.sleep(5000);
		return driver.getTitle();
	}
	@FindBy(linkText="Create a Wishlist")
	WebElement CreateaWishlist;
	
	public String validateCreateaWishlistTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		CreateaWishlist.click();
		Thread.sleep(5000);
		return driver.getTitle();
		
	}
	@FindBy(linkText="Donate Today")
	WebElement WLDonatetoday;
	
	public String validateWLDonatetodayTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		WLDonatetoday.click();
		Thread.sleep(5000);
		return driver.getTitle();

}





























}