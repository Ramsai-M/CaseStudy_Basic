package mthdsFlipkart;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	WebDriver driver;
	public Waits(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement ExpcitWtClck(WebElement ele,int scnds) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(scnds));
		return w.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
