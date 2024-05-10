package stepDefination;
import org.openqa.selenium.WebDriver;
 
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
 
public class LivingSectionSteps {
	WebDriver driver = BaseClass.getDriver();
	HomePage hp;
	int num;
	@When("the user hovers on the Living Menu Item")
	public void the_user_hovers_on_the_living_menu_item() throws InterruptedException {
		hp = new HomePage(driver);
	    hp.getLivingSectionDetails();
	    BaseClass.getLogger().info("User Successfully entered Homepage");
	}
	@When("Chooses any sub-menu like {string}")
	public void chooses_any_sub_menu_like(String subMenu) throws InterruptedException {
		num= hp.selectSubMenu(subMenu);
		BaseClass.getLogger().info("User choose any of the sub menu");
	}
	@Then("fetch the items under that sub-menu and print in console")
	public void fetch_the_items_under_that_sub_menu_and_print_in_console() {
	    hp.fetchSubMenuDetails(num);
	}
 
 
}