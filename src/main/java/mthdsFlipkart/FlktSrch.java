package mthdsFlipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlktSrch {

	WebDriver driver;
	public FlktSrch(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isElementPresent(WebDriver driver, By by){
		  try{
			  driver.findElement(by);
		    return true;
		  }catch(Throwable t){
		    return false;
		  }
		}
}
