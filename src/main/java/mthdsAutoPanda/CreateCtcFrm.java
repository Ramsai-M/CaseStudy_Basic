package mthdsAutoPanda;

import org.openqa.selenium.WebDriver;

import pgObjAutoPanda.CtcFrmPgObj;
import pgObjAutoPanda.FrmSubPgObj;
import pgObjAutoPanda.HmPgPgObj;

public class CreateCtcFrm {

	WebDriver driver;
	public CreateCtcFrm(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goToPg() {
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		System.out.println(driver.getTitle());
	}
	
	public void CrtCtcFrm(String name,String email,String msgTxt) {
		CtcFrmPgObj ctcFrm=new CtcFrmPgObj(driver);
		HmPgPgObj hmPg=new HmPgPgObj(driver);
		FrmSubPgObj frmSub=new FrmSubPgObj(driver);
		Waits wait=new Waits(driver);
		hmPg.ctcBtn().click();
		ctcFrm.inptName().sendKeys(name);
		ctcFrm.inptEmail().sendKeys(email);
		ctcFrm.inptMsgTxt().sendKeys(msgTxt);
		wait.ExpcitWtClck(ctcFrm.ctcMeBtn(),10);
		ctcFrm.ctcMeBtn().click();
		wait.ExpcitWtClck(frmSub.msgSuccTxt(), 10);
		System.out.println(frmSub.msgSuccTxt().getText());
	}
	
	
}
