package step.definition;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailPageObject;
import utilities.WebDriverUtility;

public class RetailStepDefinition extends Base{
	RetailPageObject retailPage = new RetailPageObject();
	
	//syntax @Tag("exact words of step from scenario")
	//		public void nameofMethod(){  }
	//BackGround codes
	@Given ("User is on Retail website")
	public void User_is_on_Retail_website() {
		Assert.assertTrue(retailPage.isTestEnvironmentTitlePresent());
//		Assert.assertEquals("TEK SCHOOL", retailPage.getTitle());
		logger.info("User is on Retail website");
		WebDriverUtility.takeScreenShot();
		WebDriverUtility.hardWait();	
	}
	
	@And ("User click on MyAccount")
	public void User_click_on_MyAccount() {
		retailPage.clickOnMyAccount();
		logger.info("User click on MyAccount");
		WebDriverUtility.hardWait();
	}
	
	@When ("User click on Login")
	public void User_click_on_Login() {
		retailPage.clickOnLoginOption();
		logger.info("User click on Login");
	}
	@And ("User enter username {string} and password {string}")
	public void User_enter_username_and_password(String email, String password) {
		retailPage.enterEmailAndPassword(email, password);
		logger.info("user enter username " + email + " and " + " password " + password);
		WebDriverUtility.takeScreenShot();
		WebDriverUtility.hardWait();
	}
	@And ("User click on Login button")
	public void User_click_on_Login_button() {
		retailPage.clickOnLoginButton();
		logger.info("User click on Login button");
	}
	
	@Then ("User should be logged in to MyAccount dashboard")
	public void User_should_be_logged_in_to_MyAccount_dashboard() {
		Assert.assertTrue(retailPage.isMyAccountTitlePresent());
		logger.info("User should be logged in to MyAccount dashboard");
		WebDriverUtility.takeScreenShot();
		WebDriverUtility.hardWait();
		
	}
	
	//////////////////////////////////////////////////
	//Register Scenario
	@When("User click on ‘Register for an Affiliate Account’ link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		retailPage.clickOnAffiliateRegisterLink();
		logger.info("User click on ‘Register for an Affiliate Account’ link");
	    // Write code here that turns the phrase above into concrete actions
		WebDriverUtility.hardWait();
	}
	@And("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(DataTable dataTable) {
	  
		List<Map<String, String>> affiliateForm = dataTable.asMaps(String.class, String.class);
		retailPage.enterCompanyInput(affiliateForm.get(0).get("company"));
		WebDriverUtility.hardWait();
		retailPage.enterWebsiteInput(affiliateForm.get(0).get("website"));
		WebDriverUtility.hardWait();
		retailPage.enterTaxInput(affiliateForm.get(0).get("taxID"));
		WebDriverUtility.hardWait();
		retailPage.selectpaymentMethod(affiliateForm.get(0).get("paymentMethod"));
		WebDriverUtility.hardWait();
		retailPage.enterChequePayeeName(affiliateForm.get(0).get("chequePayeeName"));
		logger.info("user filled affiliate form");
		WebDriverUtility.takeScreenShot();
		WebDriverUtility.hardWait();
		
	}
	@And("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		retailPage.clickOnAboutUsCheckBox();
		logger.info("User check on About us check box");
		WebDriverUtility.hardWait();
	}
	
	@And("User click on Continue button")
	public void User_click_on_continue_button() {
		retailPage.clickOnContinueButton();
		logger.info("User click on Continue button");
		WebDriverUtility.hardWait();
	}
	
	
	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
	Assert.assertTrue(retailPage.isSuccessMessagePresent());
	logger.info("success message is present");
	WebDriverUtility.takeScreenShot();
	WebDriverUtility.hardWait();
	}
	
	@When("User click on ‘Edit your affiliate information’ link")
	public void user_click_on_edit_your_affiliate_information_link() {
		retailPage.clickOnEditYourAffiliateLink();
		logger.info("User clicked on ‘Edit your affiliate information’ link");
	}
	
	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
		retailPage.clickOnBankTransferButton();
		logger.info("user clicked on Bank Transfer radio button");
	}
	
	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(DataTable dataTable) {
		System.out.println("============================<<<<<<<<<<<<Data Table>>>>>>>>>>>>====================");
	   List<Map<String, String>> bankInformationForm = dataTable.asMaps(String.class, String.class);
	   WebDriverUtility.hardWait();
	   retailPage.enterBankName(bankInformationForm.get(0).get("bankName")); //0=first row, bankName = one of the first row key
	   WebDriverUtility.hardWait();
	   retailPage.enterBankBranchNumber(bankInformationForm.get(0).get("abaNumber"));
	   WebDriverUtility.hardWait();
	   retailPage.enterBankSwiftCode(bankInformationForm.get(0).get("swiftCode"));
	   WebDriverUtility.hardWait();
	   retailPage.enterBankAccountName(bankInformationForm.get(0).get("accountName"));
	   WebDriverUtility.hardWait();
	   retailPage.enterBankAccountNumber(bankInformationForm.get(0).get("accountNumber"));
	   
		
		System.out.println(dataTable);
	}
	
	
	//Edit your account Scenario
	@When("User click on ‘Edit your account information’ link")
	public void user_click_on_edit_your_account_information_link() {
	    retailPage.clickOnEditAccountInfoLink();
	}
	@When("User modify below information")
	public void user_modify_below_information(DataTable dataTable) {
	    List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
	    WebDriverUtility.hardWait();
	    retailPage.enterFirstNameInput(accountInfo.get(0).get("firstname"));
	    WebDriverUtility.hardWait();
	    retailPage.enterLastNameInput(accountInfo.get(0).get("lastName"));
	    WebDriverUtility.hardWait();
	    retailPage.enterEmailInput(accountInfo.get(0).get("email"));
	    WebDriverUtility.hardWait();
	    retailPage.phoneInput(accountInfo.get(0).get("telephone"));
	    WebDriverUtility.hardWait();
	}
	@When("User click on continue button")
	public void user_click_on_continue_button() {
	    retailPage.clickOnContinueButton();
	}
	@Then("User should see a message {string}")
	public void user_should_see_a_message(String string) {
		Assert.assertEquals(string, retailPage.getSuccessMessage());
	   
	}
}
