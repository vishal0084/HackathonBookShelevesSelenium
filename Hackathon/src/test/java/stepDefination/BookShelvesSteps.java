package stepDefination; 
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BookShelvesPage;
import pageObject.HomePage;

public class BookShelvesSteps {
	WebDriver driver = BaseClass.getDriver();
	HomePage hp;
	BookShelvesPage bsp;
	String categoryName;
	String sbOption;

	@Given("the user is on the Urban Ladder home page")
	public void the_user_is_on_the_urban_ladder_home_page() {
		hp = new HomePage(driver);
		boolean sourcepage = hp.isInHomePage();
		Assert.assertEquals(sourcepage, true);
		BaseClass.getLogger().info("User Successfully entered Homepage");
	}
 
	@When("the user searches {string} on the search bar")
	public void the_user_searches_on_the_search_bar(String productName) {
		hp.searchSend(productName);
		BaseClass.getLogger().info("User Searched for bookshelves price less than 15000");
	}
 
	@When("the user clicks on search button")
	public void the_user_clicks_on_search_button() throws InterruptedException {
		hp.clickSearchBtn();
		BaseClass.getLogger().info("User clicked on search button");
	}

	@Then("gets redirected to the search page")
	public void gets_redirected_to_the_search_page() {
		bsp = new BookShelvesPage(driver);
		bsp.closePopup();
		boolean targetpage = bsp.isInSearchPage();
		Assert.assertEquals(targetpage, true);	
		BaseClass.getLogger().info("User Successfully redirected to Search Page");
	}


	@When("selects Exclude Out Of Stock")
	public void selects_exclude_out_of_stock() throws InterruptedException {
		bsp.clickOnExludeChkBox();
		BaseClass.getLogger().info("User clicked on exclude Out of Stock");
	}
 
	@When("Sort by as {string}")
	public void sort_by_as(String sortByOption) throws InterruptedException {
		sbOption = sortByOption;
		bsp.selectSort(sortByOption);
		BaseClass.getLogger().info("User clicked on a filter to sort the price in high to low Order");
	}
 
	@When("Chooses any category like {string}")
	public void chooses_any_category_like(String category) throws InterruptedException {
		bsp.selectCategory(category);
		categoryName = category;
		BaseClass.getLogger().info("User selected a category Bookshelves from the catergory Section");
	}

	@Then("Check if the correct options are chosen")
	public void check_if_the_correct_options_are_chosen() {
		boolean check1 = bsp.checkExcluded();  
		boolean check2 = bsp.checkSort(sbOption);
		boolean check3 = bsp.checkCategory(categoryName);
		if(check1 && check2 && check3) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
 
	@Then("Display top {int} items and print in the console")
	public void display_top_items_and_print_in_the_console(Integer int1) {
		bsp.displayItems(3);
	}
 
}
