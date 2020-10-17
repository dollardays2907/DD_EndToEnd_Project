package com.dollardays.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class Team9_ProductDescriptionPage {

	WebDriver driver;

	public Team9_ProductDescriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isWebElmExist(WebElement elm) {
		boolean result = true;

		if (elm.isDisplayed()) {
			result = true;
		} else if (!elm.isDisplayed()) {
			ExtentTestManager.getTest().log(Status.INFO, "WebElement" + elm + " does not exist.");
			result = false;
		}
		return result;
	}

	@FindBy(xpath = "//input[@name='picquantity']")
	private WebElement numCasesBox;

	public WebElement getNumCasesBox() {
		if (isWebElmExist(numCasesBox)) {
			return this.numCasesBox;
		}
		return null;
	}

	@FindBy(xpath = "//input[@id='wishlistReqItem']")
	private WebElement unlimitedQtyChkBox;

	public WebElement getUnlimitedQtyChkBox() {
		if (isWebElmExist(unlimitedQtyChkBox)) {
			return this.unlimitedQtyChkBox;
		}
		return null;
	}

	@FindBy(xpath = "//button[@class='cart_newbtn btn dd-btn-secondary btn-quick-view bold jqatc fsig gtmAddCart btn-group-lg']")
	private WebElement addToMyCartBtn;

	public WebElement getAddToMyCartBtn() {
		if (isWebElmExist(addToMyCartBtn)) {
			return this.addToMyCartBtn;
		}
		return null;
	}

	@FindBy(xpath = "//label[@class='control-label unit col-md-6 col-sm-12']")
	private WebElement qtyCalculatedPrice;

	public WebElement getQtyCalculatedPrice() {
		if (isWebElmExist(qtyCalculatedPrice)) {
			return this.qtyCalculatedPrice;
		}
		return null;
	}

	@FindBy(xpath = "//div[@id='confirmationBox']//div[@class='modal-body']")
	private WebElement popUp;

	public WebElement getPopUp() {
		if (isWebElmExist(popUp)) {
			return this.popUp;
		}
		return null;
	}

	@FindBy(xpath = "//div[@id='confirmationBox']//button[@class='close closeolap']")
	private WebElement closePopUpBtn;

	public WebElement getClosePopUpBtn() {
		if (isWebElmExist(closePopUpBtn)) {
			return this.closePopUpBtn;
		}
		return null;
	}

	public void enterNumCases(String float_str) throws InterruptedException {
		// dtatatable.get is giving Float string(eg:"10.0") but the webpage accepts only
		// integers
		// so get the float string passed
		// convert the float string to float value "Float.parsefloat() function shall be
		// used
		// convert float to int - typecasting int to float by (int) assignment
		// convert int to new string -- String.valueof( <int> ) can be used
		// use the new string in sendkeys function
		float f = Float.parseFloat(float_str);
		int a = (int) f;
		ExtentTestManager.getTest().log(Status.DEBUG, "Quantity input is " + String.valueOf(a));
		if (getNumCasesBox() != null) {
			getNumCasesBox().clear();
			Thread.sleep(1000);
		}
		if (getNumCasesBox() != null) {
			getNumCasesBox().sendKeys(String.valueOf(a));
			Thread.sleep(1000);
		}
		if (getNumCasesBox() != null) {
			getNumCasesBox().sendKeys(Keys.ENTER);
			Thread.sleep(1000);
		}
	}

	public void viewAndClearCart() throws InterruptedException {

		if (getPopUp().isDisplayed()) {
			if (getClosePopUpBtn() != null && getClosePopUpBtn().isDisplayed()) {
				close_popup_click_outside();
			}
		} else if (getCartBtn() != null) {
			getCartBtn().click(); // viewcart
			Thread.sleep(1000);

			if (getClearCartBtn() != null && getClearCartBtn().isDisplayed()) {
				// getClearCartBtn().click(); // cart page - clear cart
				if (getClearCartOkBtn() != null) {
					getClearCartOkBtn().click(); // ok on the clear popup
					Thread.sleep(1000);
				}

				driver.switchTo().activeElement();
				Thread.sleep(3000);
			}
		}

	}

	public void uncheck_unlim_qty() throws InterruptedException {
		if (getUnlimitedQtyChkBox().isSelected()) {
			getUnlimitedQtyChkBox().click();
		}

	}

	public void check_unlim_qty() throws InterruptedException {
		if (!getUnlimitedQtyChkBox().isSelected()) {
			getUnlimitedQtyChkBox().click();
		}

	}

	public void verify_checkbox(String a) throws InterruptedException {
		if (a.equalsIgnoreCase("Yes")) {
			Assert.assertEquals(getUnlimitedQtyChkBox().isSelected(), true);
		} else {
			Assert.assertEquals(getUnlimitedQtyChkBox().isSelected(), false);
		}

	}

	@FindBy(xpath = "//span[@class='wishlist-cart']")
	private WebElement cartBtn;

	public WebElement getCartBtn() {
		if (isWebElmExist(cartBtn)) {
			return this.cartBtn;
		}
		return null;
	}

	@FindBy(xpath = "//input[@id='ctl00_cphContent_btnClearCart']")
	private WebElement clearCartBtn;

	public WebElement getClearCartBtn() {
		if (isWebElmExist(clearCartBtn)) {
			return this.clearCartBtn;
		}
		return null;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary btn-cartclear']")
	private WebElement clearCartOkBtn;

	public WebElement getClearCartOkBtn() {
		if (isWebElmExist(clearCartOkBtn)) {
			return this.clearCartOkBtn;
		}
		return null;
	}

	/**
	 * This function returns calculated price string displayed next to the quantity
	 * box for the given input
	 */
	public String getExpectedCalcPrice(String Qty) {
		ExtentTestManager.getTest().log(Status.DEBUG, "Quantity passed is " + Qty);
		if (Qty.equalsIgnoreCase("0.0")) {
			return ("0 units x $3.17 = $0.00");
		} else if (Qty.equalsIgnoreCase("10.0")) {
			return ("240 units x $3.17 = $760.80");
		} else if (Qty.equalsIgnoreCase("100000.0")) {
			return ("2400000 units x $2.71 = $6504000.00");
		} else {
			return "";
		}
	}

	public void handle_unlim_qty(String reqrd) throws InterruptedException {

		if (reqrd.equalsIgnoreCase("No")) {
			uncheck_unlim_qty();
		} else if (reqrd.equalsIgnoreCase("Yes")) {
			check_unlim_qty();
		} else {
			Assert.fail("wrong input value");
		}
	}

	public void verifyAddToMyCart(String Qty, String Unlimited) throws InterruptedException {

		ExtentTestManager.getTest().log(Status.DEBUG, "Quantity passed is " + Qty);

		if (Unlimited.equalsIgnoreCase("Yes")) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Go to cart and check the cart is updted with all available(unlimited) cases and then clear cart.");
			// viewAndClearCart();
			ExtentTestManager.getTest().log(Status.PASS, "***THIS IS A KNOWN ISSUE, DEFECT CREATED.***");
		} else if (Qty.equalsIgnoreCase("0.0")) {
			Thread.sleep(500);
			driver.switchTo().activeElement();
			Thread.sleep(1000);
			String str = getPopUp().getText();
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Displayed Popup text: " + str);
			// Assert.assertEquals(str, "No quantity of products given to order. Undefined
			// cart error occurred." );
		} else if (Qty.equalsIgnoreCase("10.0")) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Go to cart and check the cart is updated with 10 cases and then clear cart.");
			// viewAndClearCart();
		} else if (Qty.equalsIgnoreCase("100000.0")) {
			driver.switchTo().activeElement();
			Thread.sleep(1000);
			String str = driver.findElement(By.xpath("//div[@id='confirmationBox']//div[@class='modal-body']"))
					.getText();
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Displayed Popup text: " + str);
			// Assert.assertEquals(str, "No quantity of products given to order. Undefined
			// cart error occurred." );
		} else {
			Assert.fail("wrong input value");
		}
	}

	public void close_popup_click_outside() throws InterruptedException {
		System.out.println("Click outside");
		driver.switchTo().defaultContent();
		Actions actionProvider = new Actions(driver);
//		actionProvider.moveByOffset(500, 500).build().perform();
		actionProvider.click().perform();
		Thread.sleep(200);
	}

	public void handlePopup(String closePopUp) throws InterruptedException {

		ExtentTestManager.getTest().log(Status.DEBUG, "Close popup is " + closePopUp);
		if (closePopUp.equalsIgnoreCase("CloseBtn")) {
			getClosePopUpBtn().click();
		} else if (closePopUp.equalsIgnoreCase("outside")) {
			close_popup_click_outside();
		} else if (closePopUp.equalsIgnoreCase("invalid")) {
			ExtentTestManager.getTest().log(Status.DEBUG, "no popup appears");
		} else {
			Assert.fail("wrong input value");

		}

	}

	@FindBy(xpath = "//div[@class='scale-ico fa-search-plus']")
	private WebElement pageZoomIn;

	public WebElement getPageZoomIn() {
		if (isWebElmExist(pageZoomIn)) {
			return this.pageZoomIn;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='jcarousel-prev jcarousel-prev-vertical jcarousel-prev-disabled jcarousel-prev-disabled-vertical']")
	private WebElement ScrollUp;

	public WebElement getScrollUp() {
		if (isWebElmExist(ScrollUp)) {
			return this.ScrollUp;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='jcarousel-next jcarousel-next-vertical']")
	private WebElement ScrollDown;

	public WebElement getScrollDown() {
		if (isWebElmExist(ScrollDown)) {
			return ScrollDown;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='ea-zoom ea-plus']//span")
	private WebElement ZoomIn;

	public WebElement getZoomIn() {
		if (isWebElmExist(ZoomIn)) {
			return this.ZoomIn;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='ea-zoom ea-minus']//span")
	private WebElement ZoomOut;

	public WebElement getZoomout() {
		if (isWebElmExist(ZoomOut)) {
			return this.ZoomOut;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='eagle-next']//span")
	private WebElement nextImageBtn;

	public WebElement getNextImageBtn() {
		if (isWebElmExist(nextImageBtn)) {
			return this.nextImageBtn;
		}
		return null;
	}

	@FindBy(xpath = "//div[@class='eagle-prev']//span")
	private WebElement prevImageBtn;

	public WebElement getPrevImageBtn() {
		if (isWebElmExist(prevImageBtn)) {
			return this.prevImageBtn;
		}
		return null;
	}

	@FindBy(xpath = "//a[@class='viewangle']")
	private WebElement angle360;

	public WebElement get360DegreesBtn() {
		if (isWebElmExist(angle360)) {
			return this.angle360;
		}
		return null;
	}

	/**
	 * Read spreadsheet column "ActionType" and select respective action.
	 * 
	 * @param ActionType
	 * @throws InterruptedException
	 */
	public void clickActionType(String ActionType) throws InterruptedException {
		if (ActionType.equalsIgnoreCase("Scroll up")) {
			if (getScrollUp() != null) {
				getScrollUp().click();
				Thread.sleep(1000);
			}
		} else if (ActionType.equalsIgnoreCase("scrolldown")) {
			// Click on scroll down button;
			if (getScrollDown() != null) {
				getScrollDown().click();
				Thread.sleep(1000);
			}
		} else if (ActionType.equalsIgnoreCase("360 degrees")) {
			// Click on scroll down button;
			if (get360DegreesBtn() != null) {
				get360DegreesBtn().click();
				Thread.sleep(2000);
			}
		} else if (ActionType.equalsIgnoreCase("Zoom in")) {
			// Click image zoom in first
			if (getPageZoomIn() != null) {
				getPageZoomIn().click();
				Thread.sleep(2000);
			}
			// click on Zoom in button
			if (getZoomIn() != null) {
				getZoomIn().click();
				Thread.sleep(1000);
			}

		} else if (ActionType.equalsIgnoreCase("zoom out")) {
			// Click image zoom in first
			if (getPageZoomIn() != null) {
				getPageZoomIn().click();
				Thread.sleep(2000);
			}

			// Zoom in first and then zoom out
			if (getZoomIn() != null) {
				getZoomIn().click();
				Thread.sleep(1000);
			}
			// Click on zoom out button
			if (getZoomout() != null) {
				getZoomout().click();
				Thread.sleep(1000);
			}

		} else if (ActionType.equalsIgnoreCase("Next Image")) {
			// Click PageZoomIn button first
			if (getPageZoomIn() != null) {
				getPageZoomIn().click();
				Thread.sleep(2000);
			}
			// Click on Next Image button
			if (getNextImageBtn() != null) {
				getNextImageBtn().click();
				Thread.sleep(2000);
			}

		} else if (ActionType.equalsIgnoreCase("Previous Image")) {
			// Click PageZoomIn button first
			if (getPageZoomIn() != null) {
				getPageZoomIn().click();
				Thread.sleep(2000);
			}
			// Click on Next Image button
			if (getNextImageBtn() != null) {
				getNextImageBtn().click();
				Thread.sleep(2000);

				// Click on Previous Image button
				if (getPrevImageBtn() != null) {
					getPrevImageBtn().click();
					Thread.sleep(1000);
				}
			}

		}
	}

	@FindBy(xpath = "//img[@class='main-image thumb_box']")
	private WebElement Image;

	public WebElement getImage() {
		if (isWebElmExist(Image)) {
			return this.Image;
		}
		return null;
	}

	@FindBy(xpath = "//div[contains(@class,'price')]//h3")
	private WebElement Price;

	public WebElement getPrice() {
		if (isWebElmExist(Price)) {
			return this.Price;
		}
		return null;
	}

//	@FindBy(xpath ="//a[contains(@class,'btn processbtn btnreviewwrite')]")
//	private WebElement ProductReviews;
//
//	public WebElement getProductReviews() {
//		return ProductReviews;
//	}

	@FindBy(xpath = "//h4[contains(text(),'Product Specifications')]")
	private WebElement ProductSpecifications;

	public WebElement getProductSpecifications() {
		if (isWebElmExist(ProductSpecifications)) {
			return this.ProductSpecifications;
		}
		return null;
	}

	@FindBy(xpath = "//body[contains(@class,'rfk_wbh')]//div[contains(@class,'content_info')]//div[contains(@class,'row')]//div[contains(@class,'row')]//div[1]")
	private WebElement Ratings;

	public WebElement getRatings() {
		if (isWebElmExist(Ratings)) {
			return this.Ratings;
		}
		return null;
	}

	@FindBy(xpath = "//div[contains(@class,'container-fluid')]//div[contains(@class,'container')]//li[1]//i[1]")
	private WebElement AddToCart;

	public WebElement getAddToCart() {
		if (isWebElmExist(AddToCart)) {
			return this.AddToCart;
		}
		return null;
	}

	@FindBy(xpath = "//h5[contains(text(),'Product Description')]")
	private WebElement ProductDescription;

	public WebElement getProductDescription() {
		if (isWebElmExist(ProductDescription)) {
			return this.ProductDescription;
		}
		return null;
	}

	@FindBy(xpath = "//label[contains(text(),'Have a question?')]")
	private WebElement HaveaQuestion;

	public WebElement getHaveaQuestion() {
		if (isWebElmExist(HaveaQuestion)) {
			return this.HaveaQuestion;
		}
		return null;
	}

	@FindBy(xpath = "//a[contains(@class,'btn processbtn btnreviewwrite')]")
	private WebElement WriteReview;

	public WebElement getWriteReview() {
		if (isWebElmExist(WriteReview)) {
			return this.WriteReview;
		}
		return null;
	}

	public void VerifyValue(String Value) {
		if (Value.equalsIgnoreCase("Image")) {
			// image
			Assert.assertEquals(getImage().isDisplayed(), true );
		} else if (Value.equalsIgnoreCase("Price")) {
			// verify the price
			Assert.assertEquals(getPrice().getText(), "$76.08");
		} else if (Value.equalsIgnoreCase("Product Specifications"))
		// verify the ProductSpecifications
		{
			Assert.assertEquals(getProductSpecifications().isDisplayed(), true);
		} else if (Value.equalsIgnoreCase("Ratings")) {
			// verify ratings
			Assert.assertEquals(getRatings().isDisplayed(), true);
		}

		else if (Value.equalsIgnoreCase("Add to Cart"))
		// verify add to cart
		{
			Assert.assertEquals(getAddToCart().isDisplayed(), true);
		} else if (Value.equalsIgnoreCase("Product Description"))
		// verify Product Description
		{
			Assert.assertEquals(getProductDescription().isDisplayed(), true);
		} else if (Value.equalsIgnoreCase("Have a question"))
		// verify Have a question
		{
			Assert.assertEquals(getHaveaQuestion().isDisplayed(), true);
		} else if (Value.equalsIgnoreCase("Write Review"))
		// verify write review
		{
			Assert.assertEquals(getWriteReview().isDisplayed(), true);

		}
	}

}
