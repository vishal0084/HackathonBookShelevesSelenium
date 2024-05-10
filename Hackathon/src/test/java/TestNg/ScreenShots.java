package TestNg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	
	public WebDriver driver;
	private int g=1;

	//Constructor
	public ScreenShots(WebDriver driver) {
		this.driver = driver;
	}
	
public void screenShoot() throws IOException {
	
	
		
    	// Create a TakesScreenshot instance
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	// Get the screenshot as an OutputType.FILE
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	// Define the target file
   		File trg = new File("C:\\Users\\2320203\\eclipse-workspace\\Hackathon\\testNgScreenshot\\ss"+g+".png");
   		// Copy the screenshot to the target file
   		FileUtils.copyFile(src,trg);
   		g+=1;
    }

}
