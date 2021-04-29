package com.crm.qa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private static final int WAIT= 30;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
	}

	/**
	 * method for webelement to be visible
	 * @param elem
	 */
	public void waitTillElementIsVisible(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public void waitTillElementToBeClickable(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	public void clear(WebElement elem) {
		elem.clear();
	}
	
	public void sendKeys(WebElement elem,String keysToSend) {
		elem.sendKeys(keysToSend);
	}
	
	public void selectRadioButton(List<WebElement> elems,String value) {
		for(WebElement elem : elems) {
			String text = elem.getAttribute("value");
			if(text.equals(value)){
				elem.click();	
				break;
			}
		}	
	}
	
	public void click(WebElement elem) {
		elem.click();
	}
	
	public void click(By elem) {
		driver.findElement(elem).click();
	}
	
	public void selectByVisibleText(WebElement elem,String text) {
		Select select = new Select(elem);
		select.selectByVisibleText(text);
	}
	

}
