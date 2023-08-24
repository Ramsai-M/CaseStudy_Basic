package pgObjAutoPanda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HmPgPgObj {

	WebDriver driver;
	public HmPgPgObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Contact button
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement ctcBtn;
	
	public WebElement ctcBtn() {
		return ctcBtn;
	}
}
