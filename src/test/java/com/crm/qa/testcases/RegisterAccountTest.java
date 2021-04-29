package com.crm.qa.testcases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.RegisterAccountPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverUtils;


public class RegisterAccountTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initialization();
		driver = utils.getDriver();
	}
	
		
		@Test
		public void createAccount () {
			Map<String, String> testData = TestUtil.getTestData("register.json", "createAccount");
			RegisterAccountPage rp = new RegisterAccountPage(driver);
			rp.enterFirstName(testData.get("firstName"));
			rp.enterLastName(testData.get("lastName"));
			rp.enterEmail(testData.get("email"));
			rp.enterTelephone(testData.get("telephone"));
			rp.enterPassword(testData.get("password"));
			rp.enterConfirmPassword(testData.get("confirmPassword"));
			rp.selectRadioNewsLetter(testData.get("radioNewsLetter"));
			rp.clickAgreeCheckbox();
			rp.clickContinueButton();
			Assert.assertEquals("", "");
		}
		
		public static void main(String[] args) {
			RegisterAccountTest registerAccountTest = new RegisterAccountTest();
			registerAccountTest.createAccount();
		}


}
