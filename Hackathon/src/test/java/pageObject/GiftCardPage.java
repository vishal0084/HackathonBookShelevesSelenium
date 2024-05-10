package pageObject;
 
import java.util.List; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class GiftCardPage {
	WebDriver driver;
	String recipentValidationMessage;
	String yourValidationMessage;
	
	// Constructor
	public GiftCardPage(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	By giftPageHeader = By.xpath("//*[@id=\"app-container\"]/div/main/section/h1");
	By giftCardPrice = By.id("ip_2251506436");
	By nextBtn = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button");
	By recipentName = By.id("ip_4036288348");
	By recipentEmail = By.id("ip_137656023");
	By recipentMobile = By.id("ip_3177473671");
	By yourName = By.id("ip_1082986083");
	By yourEmail = By.id("ip_4081352456");
	By yourMobile = By.id("ip_2121573464");
	By yourAddress = By.id("ip_2194351474");
	By yourPincode = By.id("ip_567727260");
	By confirmBtn = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button");
	By finalPrice = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[1]/div[2]");
	By finalRecipentDetailsList = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[1]/div[2]/div");
	By finalYourDetailsList = By.xpath("//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/section[3]/div[2]/div[2]/div[2]/div");

	public boolean isInGiftPage() {
		if(driver.findElement(giftPageHeader).getText().equalsIgnoreCase("Gift Cards")) {
			return true;
		}
		return false;
	}

	public void selectBirthdayOrAnniversary(String occ) throws InterruptedException {
		List<WebElement> occList = driver.findElements(By.xpath("//*[@id='app-container']/div/main/section/section[1]/ul/li"));
		for(int i=0;i<occList.size();i++) {
			String occHeaderText = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li["+(i+1)+"]/div/h3")).getText();
			if(occHeaderText.equalsIgnoreCase(occ)) {
				Thread.sleep(2000);
				occList.get(i).click();
			}
		}
	}

	public void fillDetailsForGiftCard(String x) throws InterruptedException {
		driver.findElement(giftCardPrice).sendKeys(x);
		Thread.sleep(1000);
		driver.findElement(nextBtn).click();
	}

	public void fillWrongDataInGiftCardDetail(String rName, String rEmail, String rMobile, String yName,String yEmail, String yMobile, String yAddress, String yPincode) throws InterruptedException {
		driver.findElement(recipentName).sendKeys(rName);
		driver.findElement(recipentEmail).sendKeys(rEmail);
		driver.findElement(recipentMobile).sendKeys(rMobile);
		driver.findElement(yourName).sendKeys(yName);
		driver.findElement(yourEmail).sendKeys(yEmail);
		driver.findElement(yourMobile).sendKeys(yMobile);
		driver.findElement(yourAddress).sendKeys(yAddress);
		driver.findElement(yourPincode).sendKeys(yPincode);
		Thread.sleep(2000);
		driver.findElement(confirmBtn).click();
		Thread.sleep(3000);
	}

	public void printErrorMsg() {
		recipentValidationMessage = driver.findElement(recipentEmail).getAttribute("validationMessage");
		yourValidationMessage = driver.findElement(yourEmail).getAttribute("validationMessage");
		if(!recipentValidationMessage.isEmpty()) {
			System.out.println(recipentValidationMessage);
		}
		if(!yourValidationMessage.isEmpty()) {
			System.out.println(yourValidationMessage);
		}
	}

	public void updateCorrectDetails() throws InterruptedException {
		if(!recipentValidationMessage.isEmpty()) {
			driver.findElement(recipentEmail).clear();
			driver.findElement(recipentEmail).sendKeys("test@123");
		}
		if(!yourValidationMessage.isEmpty()) {
			driver.findElement(yourEmail).clear();
			driver.findElement(yourEmail).sendKeys("test@67123");
		}
		Thread.sleep(2000);
		driver.findElement(confirmBtn).click();
	}

	public boolean validateAllDetails(String rName, String rMobile, String yName, String yMobile, String yAddress, String yPincode) {
		List<WebElement> recipentDetailList = driver.findElements(finalRecipentDetailsList);
		List<WebElement> yourDetailList = driver.findElements(finalYourDetailsList);
		boolean flag1= recipentDetailList.get(0).getText().equalsIgnoreCase(rName);
//		boolean flag2= recipentDetailList.get(1).getText().equalsIgnoreCase(rEmail);
		boolean flag3= recipentDetailList.get(2).getText().equalsIgnoreCase(rMobile);
		boolean flag4= yourDetailList.get(0).getText().equalsIgnoreCase(yName);
//		boolean flag5= yourDetailList.get(1).getText().equalsIgnoreCase(yEmail);
		boolean flag6= yourDetailList.get(2).getText().equalsIgnoreCase(yMobile);
		boolean flag7= yourDetailList.get(3).getText().equalsIgnoreCase(yAddress);
		boolean flag8= yourDetailList.get(4).getText().contains(yPincode);
		if(flag1&&flag3&&flag4&&flag6&&flag7&&flag8) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public void printAllDetails() {
		String finalPrice1 = driver.findElement(finalPrice).getText();
		System.out.println(finalPrice1);
		List<WebElement> recipentDetailList = driver.findElements(finalRecipentDetailsList);
		List<WebElement> yourDetailList = driver.findElements(finalYourDetailsList);
		for(WebElement wb:recipentDetailList) {
			String det = wb.getText();
			System.out.println(det);
		}
		for(WebElement wb:yourDetailList) {
			String det = wb.getText();
			System.out.println(det);
		}
		
	}
	
}