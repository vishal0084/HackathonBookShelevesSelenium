package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.BaseClass;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By homePageSlider = By.id("homepage_slider");
	By searchBar = By.id("search");
	By searchBtn = By.id("search_button");
	By livingDrp = By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[3]/span");
	By livingSubCategory = By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li/div/a");
	By allOptionMenu = By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li/div");
	By giftSelectBtn = By.xpath("//*[@id='header']/section/div/ul[2]/li[3]/a");
	
	
	
	public boolean isInHomePage() {
		boolean targetPage = driver.findElement(homePageSlider).isDisplayed();
		return targetPage;
	}
	
	public void searchSend(String productName) {
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys(productName);
	}
	
	public void clickSearchBtn() throws InterruptedException {
		driver.findElement(searchBtn).click();
		Thread.sleep(5000);
	}
	
	public void getLivingSectionDetails() {
		BaseClass.mouseHover(driver.findElement(livingDrp));
	}
	
	public int selectSubMenu(String opt) throws InterruptedException {
		List<WebElement> optList = driver.findElements(allOptionMenu);
		Thread.sleep(2000);
		for(int i=0;i<optList.size();i++) {
			String menu = optList.get(i).getText();
			if(menu.equals(opt)) {
				System.out.println(optList.get(i).getText());
				return (i+1);
			}
		}
		return -1;
	}
	
	public void fetchSubMenuDetails(int j) {
		List<WebElement> smList = driver.findElements(By.xpath("//*[@id='topnav_wrapper']/ul/li[3]/div/div/ul/li["+(j)+"]/ul/li"));
		System.out.println("Printing the Sum Menu Details");
		for(WebElement wb:smList){
			System.out.println(wb.getText());
		}
	}
	
	public void clickOnGift() {
		driver.findElement(giftSelectBtn).click();
	}
}
