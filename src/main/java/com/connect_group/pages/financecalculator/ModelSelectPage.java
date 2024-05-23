package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModelSelectPage extends BasePage {

	public ModelSelectPage(WebDriver driver) {
		super(driver);
	}

	private WebElement getModelSelectNameplateContainer() {
		return until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fc-nameplates__nameplates']")));
	}
	
	private List<WebElement> getCarNamesTitles(){
		return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//h2[@class='fc-nameplate__title']")));
		
	}

	private WebElement getChangeVehicleBtn() {
		return getDriver().findElement(By.xpath("//a[@data-test-id='change-vehicle_cta']"));
	}
	
	private WebElement getEngineDropdown() {
		return until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id='dropdown__button-engines']")));
	}
	
	public List<WebElement> getAllEngines() {
		return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//ul[@id='dropdown__list-engines']/li/a")));
	}
	
	public List<WebElement> getAllNameplates() {
		return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector(".fc-nameplates__nameplateContainer .fc-cta__cta--size-primary")));
	}
	
	private WebElement getTestDriveCloseBtn() {
		return getDriver().findElement(By.xpath("//*[@class='icon-close icon-close-message']"));

	}

	public boolean isInitialized() {
		return getModelSelectNameplateContainer().isDisplayed();
	}
	

	public List<WebElement> getAllVehiclesModels() {

		return until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='fc-nameplate__imageOverlay']")));

	}

	
	
	// Method to get count of all vehicles
	public int getVehicleModelsCount() {
		return  getAllVehiclesModels().size();
	}
	
	
	// Method to select a model from vehicles model
	public void selectCarModel(String name) {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		for(int i=0; i<getCarNamesTitles().size();i++) {
			WebElement carName = getCarNamesTitles().get(i);
			if(carName.getText().equalsIgnoreCase(name)) {
			
				String selectCarXPath = String.format("(//h2[@class='fc-nameplate__title'])[%d]/parent::div/preceding-sibling::div[1]", i+1);
				WebElement carElement = getDriver().findElement(By.xpath(selectCarXPath));
                carElement.click();
                break;
			}
		}
		
	}
	
	
	// Method to click Change Vehicle button
	public void changeVehicle() {
		getChangeVehicleBtn().click();
	}
	
	//Method to close test drive button
	public void closeTestDriveBtn() {


	if(isElementPresent(By.xpath("//*[@class='icon-close icon-close-message']"))) {
		getTestDriveCloseBtn().click();
	}
	}
	
	// Method to select dropdown value for Engin dropdown
	
	public void selectDropDownForEngine(String name, int x, int y) throws InterruptedException {
		scrollWindow(x,y);
		waitForElementToAppear(getEngineDropdown());
		Thread.sleep(3000);
		getEngineDropdown().click();
		for (WebElement engine : getAllEngines()) {
			if(engine.getText().equalsIgnoreCase(name)) {
				engine.click();
				break;
			}
		}
		
;	}

}