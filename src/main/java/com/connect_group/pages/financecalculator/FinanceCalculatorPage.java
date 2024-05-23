package com.connect_group.pages.financecalculator;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.connect_group.pages.BasePage;

public class FinanceCalculatorPage extends BasePage {

	private WebElement getMonthlyPaymentButton() {
		return getDriver().findElement(By.xpath("//button[@aria-label='MONTHLY PAYMENT']"));
	}

	private WebElement getDeposit() {
		return getDriver().findElement(By.id("deposit"));
	}

	private WebElement getAcceptValueButton() {
		return getDriver().findElement(By.xpath("//button[@class='fc-cta__cta fc-cta__cta--primary']"));
	}

	private WebElement getSliderMin() {
		return getDriver().findElement(By.id("handle_min"));
	}

	private WebElement getSliderMax() {
		return getDriver().findElement(By.id("handle_max"));
	}

	private WebElement getSliderControl() {
		return getDriver().findElement(By.xpath("//div[@class='fc-range-slider__range-slider__controls']"));
	}

	private WebElement getfinanceCalcTitle() {

		return getDriver().findElement(By.xpath("//div[@data-test-id='models-page-title']"));
	}

	private WebElement getfinanceCount() {
		return getDriver().findElement(By.xpath("//div[@class='fc-filter-bar-disclaimer__disclaimer__count']"));
	}

	private WebElement getAcceptCookies() {
		return getDriver().findElement(By.xpath("//button[@id='truste-consent-button']"));
	}

	private WebElement getCloseBtn() {
		return getDriver().findElement(By.cssSelector("#psyma_close_button_link"));
	}

	private WebElement getTestDriveCloseBtn() {
		return getDriver().findElement(By.xpath("//*[@class='icon-close icon-close-message']"));

	}

	private WebElement getFilterBar() {
		return getDriver().findElement(By.xpath("//*[@class='fc-filter-bar__cta']"));

	}

	public FinanceCalculatorPage(WebDriver driver) {
		super(driver);

	}

	// Method to check Finance Title is initialised
	public boolean isFinanceTitleInitialized() {
		waitForElementToAppear(getfinanceCalcTitle());
		return getfinanceCalcTitle().isDisplayed();
	}

	// Method to click Monthly Payment Btn
	public void clickMonthlyPaymentBtn() {

		getMonthlyPaymentButton().click();
	}

	// Method to enter Monthly Deposit
	public void enterDeposit(String depValue) {
		getDeposit().clear();
		getDeposit().sendKeys(depValue);
	}

	// Method to close test drive button
	public void closeTestDriveBtn() {

		if (isElementPresent(By.xpath("//*[@class='icon-close icon-close-message']"))) {
			getTestDriveCloseBtn().click();
		}
	}

	// Method to click Accept button
	public void clickAcceptValueBtn() {
		closeTestDriveBtn();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getAcceptValueButton());

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(getAcceptValueButton()));

		acceptButton.click();
	}

	// Method to get value of Finance count result
	public int getFinanceCountResult() {

		String resultText = getfinanceCount().getText();
		String[] split = resultText.split(" ");
		return Integer.parseInt(split[0]);

	}

	// Method to handle cookie consent

	public void handleCookieConsent() {
		if (isElementPresent(By.xpath("//button[@id='truste-consent-button']"))) {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(getAcceptCookies()));
			getAcceptCookies().click();

		}
	}

	// Method to close website question popup
	public void closeQuesPopup() {
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if (isElementPresent(By.cssSelector("#psyma_close_button_link"))) {
			waitForElementToAppear(getCloseBtn());
			getCloseBtn().click();

		}

	}

}
