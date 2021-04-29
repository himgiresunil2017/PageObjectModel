package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class RegisterAccountPage extends BasePage{
	
	
		WebDriver driver;
		
		public RegisterAccountPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="input-firstname")
		private WebElement firstName;
		
		@FindBy(xpath="//input[@name='lastname']")
		private WebElement lastName;
		
		@FindBy(css="input[placeholder='E-Mail']")
		private WebElement email;
		
		@FindBy(name="telephone")
		private WebElement telephone;
		
		@FindBy(css="input[name='password']")
		private WebElement password;
		
		@FindBy(css="#input-confirm")
		private WebElement confirmPassword;
		
		@FindBy(name="newsletter")
		private List<WebElement> radioNewsLetter;
		
		@FindBy(name="agree")
		private WebElement agreecheckbox;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement btncontinue;
		
		/**
		* method to enter the First Name
		* @param text
		**/
		
		public void enterFirstName(String text){
			waitTillElementIsVisible(firstName);
			clear(firstName);
			sendKeys(firstName,text);
		}
		/**
		* method to enter the Last Name
		* @param text
		**/
		
		public void enterLastName(String text){
			waitTillElementIsVisible(lastName);
			clear(lastName);
			sendKeys(lastName,text);
		}
		/**
		* method to enter the Email
		* @param text
		**/
		public void enterEmail(String text){
			waitTillElementIsVisible(email);
			clear(email);
			sendKeys(email, text);
		}
		/**
		* method to enter the telephone
		* @param text
		**/
		public void enterTelephone(String text){
			waitTillElementToBeClickable(telephone);
			telephone.clear();
			telephone.sendKeys(text);
		}
		/**
		* method to enter the Password
		* @param text
		**/
		public void enterPassword(String text){
			waitTillElementToBeClickable(password);
			clear(password);
			sendKeys(password,text);
		}
		/**
		* method to enter the Confirm Password
		* @param text
		**/
		public void enterConfirmPassword(String text){
			waitTillElementToBeClickable(confirmPassword);
			clear(confirmPassword);
			sendKeys(confirmPassword,text);
		}

		/**
		* method to select the radio button
		* @param text
		**/
		public void selectRadioNewsLetter(String value){
			selectRadioButton(radioNewsLetter,value);
		}
		
		/**
		* method to select the check box
		* @param text
		**/
		public void clickAgreeCheckbox(){
			waitTillElementToBeClickable(agreecheckbox);
			click(agreecheckbox);
		}
		
		/**
		* method to click the submit button
		* @param text
		**/
		public void clickContinueButton(){
			waitTillElementToBeClickable(btncontinue);
			click(btncontinue);
		}
		
		public void click(WebElement elem) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", elem);
		}
}
