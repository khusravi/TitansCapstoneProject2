package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class RetailPageObject extends Base {
	
	public RetailPageObject() {
		PageFactory.initElements(driver, this);
		
	}
	//Syntax for storing UI elements using PageFactory Implementation
	//@FindBy (locatorType = "locator")
	//accessModifier WebElement nameOfEmlement;
	
	//BackGround
	@FindBy (xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement testEnvironmenTitle;
	
	@FindBy (xpath = "//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy (xpath = "//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy (id = "input-email")
	private WebElement emailField;
	
	@FindBy (id = "input-password")
	private WebElement passwordField;
	
	@FindBy (xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//h2[text()='My Account']")
	private WebElement myAccountTitle;
	///////////
	//Register as an Affiliate Scenario
	@FindBy (xpath = "//a[text()='Register for an affiliate account']")
	private WebElement affiliateRegisterLink;
	
	@FindBy (id = "input-company")
	private WebElement companyInput;
	
	@FindBy (id = "input-website")
	private WebElement websiteInput;
	
	@FindBy (id = "input-tax")
	private WebElement taxInput;
	
	@FindBy (xpath = "//input[@value='cheque']")
	private WebElement chequeButton;
	
	@FindBy (xpath = "//input[@value='paypal']")
	private WebElement paypalButton;
	
	@FindBy (xpath = "//input[@value='bank']")
	private WebElement bankButton;
	
	@FindBy (id = "input-cheque")
	private WebElement chequePayeeNameInput;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement aboutUsCheckBox;

	@FindBy (xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessagePresent;
	
	///
	//Edit Affiliate Scenario
	@FindBy (xpath = "//a[text()='Edit your affiliate information']")
	private WebElement editYourAffiliateLink;
	
	@FindBy (xpath = "//input[@value='bank']")
	private WebElement bankTransferButton;
	
	@FindBy (id = "input-bank-name")
	private WebElement bankNameInput;
	
	@FindBy (id = "input-bank-branch-number")
	private WebElement bankBranchNumberInput;
	
	@FindBy (id = "input-bank-swift-code")
	private WebElement bankSwiftCodeInput;
	
	@FindBy (id = "input-bank-account-name")
	private WebElement bankAccountNameInput;
	
	@FindBy (id = "input-bank-account-number")
	private WebElement bankAccountNumberInput;
	
	//Edit your account info Scenario
	@FindBy (xpath = "//a[text()='Edit your account information']")
	private WebElement editAccountInfoLink;

	@FindBy (id = "input-firstname")
	private WebElement firstNameInput;
	
	@FindBy (id = "input-lastname")
	private WebElement lastNameInput;
	
	@FindBy (id = "input-email")
	private WebElement emailInput;
	
	@FindBy (id = "input-telephone")
	private WebElement phoneInput;
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successfullAccountUpdateMessage;


	//writing methods for above UI elements
	public boolean isTestEnvironmentTitlePresent() {
		if(testEnvironmenTitle.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}
	public void enterEmailAndPassword(String emailValue, String passwordValue) {
		emailField.sendKeys(emailValue);
		passwordField.sendKeys(passwordValue);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean isMyAccountTitlePresent() {
		if(myAccountTitle.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnAffiliateRegisterLink() {
		affiliateRegisterLink.click();
	}
	public void enterCompanyInput(String companyValue) {
		companyInput.sendKeys(companyValue);
	}
	
	public void enterWebsiteInput(String websiteValue) {
		websiteInput.sendKeys(websiteValue);
	}
	
	public void enterTaxInput(String taxValue) {
		taxInput.sendKeys(taxValue);
	}
	
//	public void clickOnChequeButton() {
//		chequeButton.click();
//	}
	public void selectpaymentMethod(String paymentType) {
		if (paymentType.trim().equalsIgnoreCase("cheque")) {
			if (chequeButton.isSelected()) {
				chequeButton.click();

		} else if (paymentType.trim().equalsIgnoreCase("paypal")) {
			paypalButton.click();
		} else {
			bankButton.click();
			}
		}
			
	}
				

//	@FindBy (xpath = "//input[@value='cheque']")
//	private WebElement chequeButton;
	
	
	public void enterChequePayeeName(String chequePayeeValue) {
		chequePayeeNameInput.sendKeys(chequePayeeValue);
	}
	
	public void clickOnAboutUsCheckBox() {
		aboutUsCheckBox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public boolean isSuccessMessagePresent() {
		if(successMessagePresent.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	//edit Affiliate Scenario
	public void clickOnEditYourAffiliateLink() {
		editYourAffiliateLink.click();
	}
	
	//radio Butto selection
	public void clickOnBankTransferButton() {
		bankTransferButton.click();
	}
	
	public void enterBankName(String bankNameValue) {
		WebDriverUtility.clearText(bankNameInput);
		bankNameInput.sendKeys(bankNameValue);
	}
	
	public void enterBankBranchNumber(String bankBranchNumberValue) {
		bankBranchNumberInput.clear();
		bankBranchNumberInput.sendKeys(bankBranchNumberValue);
	}
	
	public void enterBankSwiftCode(String bankSwiftCodeValue) {
		bankSwiftCodeInput.clear();
		bankSwiftCodeInput.sendKeys(bankSwiftCodeValue);
	}
	
	public void enterBankAccountName(String bankAccountNameValue) {
		WebDriverUtility.clearText(bankAccountNameInput);
		bankAccountNameInput.sendKeys(bankAccountNameValue);
	}
	
	public void enterBankAccountNumber(String bankAccountNumberValue) {
		WebDriverUtility.clearText(bankAccountNumberInput);
		bankAccountNumberInput.sendKeys(bankAccountNumberValue);
	}
	
//	public void clickOnContinueBtn() {
//	continueBtn.click();
//}
//
//public boolean isSuccessMessagePresent() {
//	if(isSuccessMessagePresent.isDisplayed()) {
//		return true;
//	}else {
//		return false;
//	}
//}
	
	//editAccInfo Scenario
	public void clickOnEditAccountInfoLink() {
		editAccountInfoLink.click();
	}
	
	public void enterFirstNameInput(String firstNameValue) {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstNameValue);
	}
	public void enterLastNameInput(String lastNameValue) {
		lastNameInput.clear();
		lastNameInput.sendKeys(lastNameValue);
	}
	public void enterEmailInput(String emailValue) {
		emailInput.clear();
		emailInput.sendKeys(emailValue);
	}
	public void phoneInput(String phoneValue) {
		phoneInput.clear();
		phoneInput.sendKeys(phoneValue);
	}
	
	public String getSuccessMessage() {
		String actualMessage = successfullAccountUpdateMessage.getText();
		return actualMessage;
	}

//	public boolean iSuccessMessagePresent() {
//		if(successMessagePresent.isDisplayed()) {
//			return true;
//		}else {
//			return false;
//		}
//	}

}
