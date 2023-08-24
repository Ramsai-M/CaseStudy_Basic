package pgObjFlipkart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlktPgObj {

	WebDriver driver;
	public FlktPgObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Sign close btn
	@FindBy(xpath="//button[contains(@class,'_2doB4z')]")
	WebElement sgnClsBtn;
		
	//Page Object SgnClsBtnn
		
	By SgnClsBtnn=By.xpath("//button[contains(@class,'_2doB4z')]");
		
	//Flipkart text left side
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement flipkartTxtLg;
	
	//Page Object Flipkart text left side
	By flipkartTxtLogo=By.xpath("//img[@title='Flipkart']");
		
	//Search box
	@FindBy(name="q")
	WebElement srchBox;
		
	//Search icon
	@FindBy(xpath="//button[@type='submit']")
	WebElement srchIcn;
		
	//List of items
	@FindBy(xpath="//div[starts-with(@class,'_1AtVbE')]//div[starts-with(@class,'_13oc-S')]")
	List<WebElement> itemsCount;
		
	//First Product
	@FindBy(xpath="//div[starts-with(@class,'_1AtVbE')][2]//div[starts-with(@class,'_13oc-S')]/div/div/a")
	WebElement frstItm;
		
	//First Product Name 
	@FindBy(xpath="//div[starts-with(@class,'_1AtVbE')][2]//div[starts-with(@class,'_13oc-S')]/div/div/a/div[2]/div[1]/div[1]")
	WebElement frstItmNme;
		
	//Product Name
	@FindBy(xpath="//div[starts-with(@class,'_1AtVbE')]/div/div[1]/h1/span")
	WebElement prdtNme;
		
	public By sgnClsBtnn() {
		return SgnClsBtnn;
	}
		
	public WebElement sgnClsBtn() {
		return sgnClsBtn;
	}
		
	public WebElement flktTxt() {
		return flipkartTxtLg;
	}
	
	public By flktTxtLogo() {
		return flipkartTxtLogo;
	}
		
	public WebElement srchBox() {
		return srchBox;
	}
		
	public WebElement srchIcon() {
		return srchIcn;
	}
		
	public List<WebElement> itmsCunt() {
		return itemsCount;
	}
		
	public WebElement frstItm() {
		return frstItm;
	}
		
	public WebElement frstPrdtNme() {
		return frstItmNme;
	}
		
	public WebElement prdtNme() {
		return prdtNme;
	}
}
