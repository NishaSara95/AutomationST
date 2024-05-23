package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalisedQuotePage extends BasePage {

  public PersonalisedQuotePage(WebDriver driver) {
    super(driver);
  }
  
  private WebElement getPersonalisedQuoteTitle() {
		return getDriver().findElement(By.cssSelector("#product-navigator__title"));
	}
  
  private WebElement getToolTipIcon() {
		return getDriver().findElement(By.cssSelector("#product"));
	}
  
  private WebElement getInfoPopup() {
		return getDriver().findElement(By.xpath("//div[@id='modalTitle_PCP']"));
	}
  
  private WebElement getCloseBtn() {
		return getDriver().findElement(By.cssSelector("#modal-close-btn"));
	}
  

  // Method to verify Personalised quote Title
	public boolean verifyPersonalisedQuoteTitle() {
		waitForElementToAppear(getPersonalisedQuoteTitle());
		return getPersonalisedQuoteTitle().isDisplayed();
	}
	
	
	
	// Method to click Tool tip icon
	
	public void clickToolTipIcon() {
		getToolTipIcon().click();
	}
	
	// Method to verify Information popup opened and displayed
	public boolean isInfoPopUpDisplayed() {
		waitForElementToAppear(getInfoPopup());
		return getInfoPopup().isDisplayed();
	}
	
	//Method to click close Button from popup 
	
		public void clickCloseBtn() {
			getCloseBtn().click();
		}
		
	
  
}