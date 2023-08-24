package pgObjAutoPanda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CtcFrmPgObj {

	WebDriver driver;
	public CtcFrmPgObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Name input field
	@FindBy(id="g3-name")
	WebElement nameFld;
		
	//Email input field
	@FindBy(id="g3-email")
	WebElement emailFld;
		
	//Message input field
	@FindBy(name="g3-message")
	WebElement msgTxtFld;
		
	//Contact me button
	@FindBy(xpath="//form[contains(@class,'contact-form')]//button[contains(@class,'wp-block-button')]")
	WebElement ctcMeBtn;
	
	public WebElement inptName() {
		return nameFld;
	}
	
	public WebElement inptEmail() {
		return emailFld;
	}
	
	public WebElement inptMsgTxt() {
		return msgTxtFld;
	}
	
	public WebElement ctcMeBtn() {
		return ctcMeBtn;
	}
}
