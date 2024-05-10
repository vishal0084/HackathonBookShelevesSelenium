package TestNg;
import pageObject.BookShelvesPage;
import pageObject.GiftCardPage;
import pageObject.HomePage;
import org.testng.annotations.Test;
import factory.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BookShelvesTest {
	Properties p;
	WebDriver driver;
	BookShelvesPage bsp;
	GiftCardPage gcp;
	HomePage hp;
	ScreenShots sc;
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		driver = BaseClass.initilizeBrowswer();
		p=BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		sc = new ScreenShots(driver);
	}
	
	@Test(priority = 1)
	public void homePageValidation() throws InterruptedException, IOException {
		hp = new HomePage(driver);
		boolean sourcepage = hp.isInHomePage();
		sc.screenShoot();
		Assert.assertEquals(sourcepage, true);
	}
	
	@Test(priority = 2, dependsOnMethods = {"homePageValidation"})
	public void provideDetailInTheSearchBar() throws InterruptedException, IOException {
		hp.searchSend("bookshelves under 15000");
		sc.screenShoot();
	}
	
	@Test(priority = 3)
	public void clickOnSearchBtn() throws IOException, InterruptedException {
		hp.clickSearchBtn();
	}
	
	@Test(priority = 4, dependsOnMethods = {"clickOnSearchBtn"})
	public void closingLoginDetailPage() throws IOException {
		bsp = new BookShelvesPage(driver);
		sc.screenShoot();
		bsp.closePopup();		
	}
	
	@Test(priority = 5, dependsOnMethods = {"closingLoginDetailPage"})
	public void clickOnExludeChkBoxOption() throws InterruptedException, IOException {
	
		bsp.clickOnExludeChkBox();
		sc.screenShoot();
	}
	
	@Test(priority = 6)
	public void selectingSort() throws InterruptedException, IOException {
		bsp.selectSort("Price: High to Low");
		sc.screenShoot();
	}
	
	@Test(priority = 7)
	public void selectingCategory() throws IOException, InterruptedException {
		bsp.selectCategory("Bookshelves");
		sc.screenShoot();
	}
	
	@Test(priority = 8)
	public void displayItemsInTheConsole() throws IOException {	
		bsp.displayItems(3);
		sc.screenShoot();
	}
	
	@AfterClass
	public void closing() {
		driver.quit();
	}
	
}
