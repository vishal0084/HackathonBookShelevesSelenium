package stepDefination;

import java.io.IOException;
import java.util.List;
import java.util.Map;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
 
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GiftCardPage;
import pageObject.HomePage;
import utilities.ExcelReader;
 
public class GiftCardSteps {
	WebDriver driver = BaseClass.getDriver();
	HomePage hp;
	GiftCardPage gcp;
 
	String excelPath = "C:\\Users\\2320203\\eclipse-workspace\\Hackathon\\src\\testData\\InputData.xlsx";
	String rName;
	String rEmail;
	String rMobile;
	String yName;
	String yEmail;
	String yMobile;
	String yAddress;
	String yPincode;
 
	@When("user clicks on Gift Cards")
	public void user_clicks_on_gift_cards() throws InterruptedException {
		hp = new HomePage(driver);
		hp.clickOnGift();
		Thread.sleep(5000);
		BaseClass.getLogger().info("User Successfully entered Homepage");
	}
 
	@Then("gets redirected to Gift Cards Page")
	public void gets_redirected_to_gift_cards_page() {
		gcp = new GiftCardPage(driver);
		boolean targetPage = gcp.isInGiftPage();
		Assert.assertEquals(targetPage, true);
	}
 
	@When("chooses an occasion {string}")
	public void chooses_an_occasion(String occ) throws InterruptedException {
		gcp = new GiftCardPage(driver);
		gcp.selectBirthdayOrAnniversary(occ);
		BaseClass.getLogger().info("User Selected Birthday/Anniversary option");
	}
 
	@When("customizes the gift card by entering the amount as {string}")
	public void customizes_the_gift_card_by_entering_the_amount_as(String string) throws InterruptedException {
		gcp.fillDetailsForGiftCard(string);
		BaseClass.getLogger().info("User Filled the required details to fill the form for the gift card");
	}
 
	@When("enters the personal details with invalid email id using {string} and {int}")
	public void enters_the_personal_details_with_invalid_email_id_using_and(String sheetName, Integer rowNumber)
			throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
 
		List<Map<String, String>> data = reader.getData(excelPath, sheetName);
		rName = data.get(rowNumber).get("recipientName");
		rEmail = data.get(rowNumber).get("recipientEmail");
		rMobile = data.get(rowNumber).get("recipientMobile");
		yName = data.get(rowNumber).get("yourName");
		yEmail = data.get(rowNumber).get("yourEmail");
		yMobile = data.get(rowNumber).get("yourMobile");
		yAddress = data.get(rowNumber).get("yourAddress");
		yPincode = data.get(rowNumber).get("yourPincode");
		Thread.sleep(3000);
		gcp.fillWrongDataInGiftCardDetail(rName,rEmail,rMobile,yName,yEmail,yMobile,yAddress,yPincode);
		BaseClass.getLogger().info("User Entered the Wrong email id");

	}
 
	@Then("capture the error message and print in console")
	public void capture_the_error_message_and_print_in_console() {
		gcp.printErrorMsg();
	}
 
	@When("update with valid email id and submit")
	public void update_with_valid_email_id_and_submit() throws InterruptedException {
		gcp.updateCorrectDetails();
		BaseClass.getLogger().info("User updated the correct value in the required field");
	}
 
	@Then("validate all the given details in the Confirm Details section")
	public void validate_all_the_given_details_in_the_Confirm_Details_section() {
		boolean validation = gcp.validateAllDetails(rName, rMobile, yName, yMobile, yAddress, yPincode);
		Assert.assertEquals(validation, true);
	}
	
	@Then("display all the details in the console")
	public void display_all_the_details_in_the_console() {
		gcp.printAllDetails();
	}
}