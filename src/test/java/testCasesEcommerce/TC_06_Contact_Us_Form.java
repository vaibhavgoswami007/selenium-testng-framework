package testCasesEcommerce;

import org.testng.Assert;
import org.testng.annotations.Test;

import MMTPageObjects.ContactUsPage;
import MMTPageObjects.HomePage;
import testComponents.TestBase;

public class TC_06_Contact_Us_Form extends TestBase{
	
	@Test
	public void contactUsForm() {
		
		HomePage homePage = new HomePage(driver);
		homePage.contactButtonClick();
		
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		Assert.assertEquals(contactUsPage.getInTouchText(),"GET IN TOUCH");
		contactUsPage.fillContactForm("VG", "vgguduf@hhfm.com", "plain", "fusfsisfishfsfusrusrussjs", "D:\\Testing_Interview_Prep\\Cucumber Question.docx");
		Assert.assertEquals(contactUsPage.getAlertText(), "Press OK to proceed!");
		contactUsPage.acceptAlert();
		Assert.assertEquals(contactUsPage.getSuccessMsg(),"Success! Your details have been submitted successfully.");
		contactUsPage.clickHomeButton();
		contactUsPage.closeAdIfPresent();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
		
		
	}

}
