package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import factory.BaseClass;

public class BookShelvesPage {
	WebDriver driver;

	// Constructor
	public BookShelvesPage(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
		By searchMsg = By.className("withsubtext");
		By excludeChkBox = By.xpath("//*[@id=\"filters-form\"]/div[2]/div");
		By validationExclude = By.xpath("//li[@data-option-name='In Stock Only']");
		By sortDrp= By.xpath("//*[@id='search-results']/div[2]/div[1]/div/div/div/div/div[2]/div[1]");//To hover
		By sortOptions = By.xpath("//*[@class=\"sortoptions\"]/li");
		By validationSort = By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span");
		By categoryDrp = By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]"); //To hover
		By categoryOptions = By.xpath("//*[@class=\"clearfix options\"]/li[@class=\"option \"]");	
		By validationCategory = By.xpath("//*[@class=\"list\"]/li/span[@class=\"text\"]");
		By popup = By.id("authentication_popup");
		By popup_close = By.xpath("//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]");
	 
		
		//Methods
		public void closePopup() {
			if(driver.findElement(popup).isDisplayed()) {
				driver.findElement(popup_close).click();
			}
		}
		public boolean isInSearchPage() {
			boolean flag = driver.findElement(searchMsg).isDisplayed();
			return flag;
		}
		public void clickOnExludeChkBox() throws InterruptedException {
			driver.findElement(excludeChkBox).click();
			Thread.sleep(3000);
		}
		public boolean checkExcluded() {
			boolean flag = driver.findElement(validationExclude).isDisplayed();
			return flag;
		}
		public void selectSort(String sort) throws InterruptedException {
			BaseClass.mouseHover(driver.findElement(sortDrp));
			Thread.sleep(2000);
			List<WebElement> optionsList = driver.findElements(sortOptions);
			for(WebElement wbe:optionsList) {
				if(wbe.getText().equalsIgnoreCase(sort)) {
					wbe.click();
				}
			}
			Thread.sleep(2000);
		}
		public boolean checkSort(String opt) {
			boolean flag = driver.findElement(validationSort).getText().equalsIgnoreCase(opt);
			return flag;
		}
		public void selectCategory(String category) throws InterruptedException {
			BaseClass.mouseHover(driver.findElement(categoryDrp));
			Thread.sleep(2000);
			List<WebElement> optionsList = driver.findElements(categoryOptions);
			for(WebElement wbe:optionsList) {
				if(wbe.getAttribute("data-option-name").equalsIgnoreCase(category)) {
					wbe.click();
				}
			}
			Thread.sleep(2000);
		}
		public boolean checkCategory(String category) {
			List<WebElement> selectedList = driver.findElements(validationCategory);
			for(WebElement wbe: selectedList) {
				if(wbe.getText().equalsIgnoreCase(category)) {
					return true;
				}
			}
			return false;
		}
		public void displayItems(int maxIterate) {
			System.out.println("");
			System.out.println("Printing first 3 Bookshelves in High to Low order: ");
			System.out.println("");
			for(int i=1;i<=maxIterate;i++) {
				String proName = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div/span")).getText();
				String proFrom = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div/div[2]")).getText();
				String strikePrice = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div[2]/strike")).getText();
				String currPrice = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div[2]/span")).getText();
				String emiFromText = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div[3]")).getText();
				String emiPrice = driver.findElement(By.xpath("//*[@id='search-results']/div[3]/ul/li["+i+"]/div/div[5]/a/div[3]/span")).getText();
				System.out.println(proName+"  "+proFrom+"  "+strikePrice+"    "+currPrice+"    "+ emiFromText+"    "+emiPrice);
			}
		}
}