package AutoPandaExe;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mthdsAutoPanda.Waits;
import pgObjAutoPanda.CtcFrmPgObj;
import pgObjAutoPanda.FrmSubPgObj;
import pgObjAutoPanda.HmPgPgObj;

public class ExecAutoPandaCtcFrm {

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
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.manage().window().maximize();
		System.out.println("Landing Page title is: "+driver.getTitle());
		Assert.assertEquals("Want to practice test automation? Try these demo sites! | Automation Panda", driver.getTitle());	
	}
	
	@Test(priority=1)
	public void ctcPg() {
		HmPgPgObj hmPg=new HmPgPgObj(driver);
		hmPg.ctcBtn().click();
		Assert.assertEquals("Contact | Automation Panda", driver.getTitle());
		System.out.println(driver.getTitle());
	}
	
	@Parameters({"name","email","msgTxt"})
	@Test(priority=2)
	public void frmCrtn(String name,String email,String msgTxt) {
		CtcFrmPgObj ctcFrm=new CtcFrmPgObj(driver);
		Waits wait=new Waits(driver);
		ctcFrm.inptName().sendKeys(name);
		ctcFrm.inptEmail().sendKeys(email);
		ctcFrm.inptMsgTxt().sendKeys(msgTxt);
		wait.ExpcitWtClck(ctcFrm.ctcMeBtn(), 10);
		ctcFrm.ctcMeBtn().click();
	}
	
	@Test(priority=3)
	public void succMsg() {
		FrmSubPgObj frmSub=new FrmSubPgObj(driver);
		Waits wait=new Waits(driver);
		wait.ExpcitWtClck(frmSub.msgSuccTxt(), 10);
		Assert.assertEquals("Your message has been sent",frmSub.msgSuccTxt().getText());
		System.out.println("Success Message: "+frmSub.msgSuccTxt().getText());
	}
	
	@AfterClass
	public void cls() {
		driver.quit();
	}
}
