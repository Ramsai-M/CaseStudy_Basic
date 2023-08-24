package pgObjAutoPanda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrmSubPgObj {

	WebDriver driver;
	public FrmSubPgObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Get Message sent text
	@FindBy(id="contact-form-success-header")
	WebElement msgSuccTxt;
	
	public WebElement msgSuccTxt() {
		return msgSuccTxt;
	}
}
