package ExecFlipkartSrch;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mthdsFlipkart.FlktSrch;
import mthdsFlipkart.Waits;
import pgObjFlipkart.FlktPgObj;

public class FlpkrtSrchExe {

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		//WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver=driver;
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("Landing Page title is: "+driver.getTitle());
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());	
	}
	
	@Parameters({"itmNme"})
	@Test
	public void srchItm(String itmNme) {
		FlktPgObj flpkrtPg=new FlktPgObj(driver);
		FlktSrch flkrtSrch=new FlktSrch(driver);
		Waits wait=new Waits(driver);
		
		//Checking for Sign In Pop up for to close
		if (flkrtSrch.isElementPresent(driver,flpkrtPg.sgnClsBtnn())) {
			flpkrtPg.sgnClsBtn().click();
		}
		
		//Checking Flipkart text at left side top of the page
		if (flkrtSrch.isElementPresent(driver,flpkrtPg.flktTxtLogo())) {
			System.out.println("Flipkart Logo is displayed at the top left of the page.");
		}
		
		flpkrtPg.srchBox().sendKeys(itmNme);
		flpkrtPg.srchIcon().click();
		wait.ExpcitWtClck(flpkrtPg.frstItm(), 10);
		System.out.println("Total "+flpkrtPg.itmsCunt().size()+" items are displaying in this page.");
		System.out.println("First item name is: "+flpkrtPg.frstPrdtNme().getText());
		String productName=flpkrtPg.frstPrdtNme().getText();
		flpkrtPg.frstPrdtNme().click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		wait.ExpcitWtClck(flpkrtPg.prdtNme(), 10);
		System.out.println("Title of the page: "+driver.getTitle());
		Assert.assertEquals("APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com", driver.getTitle());
		Assert.assertEquals(productName,flpkrtPg.prdtNme().getText());
		System.out.println(flpkrtPg.prdtNme().getText());
		Assert.assertEquals(productName,flpkrtPg.prdtNme().getText());
	}
	
	@AfterClass
	public void cls() {
		driver.quit();
	}
}
