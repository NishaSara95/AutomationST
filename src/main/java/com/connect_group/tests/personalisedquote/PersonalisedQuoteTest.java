package com.connect_group.tests.personalisedquote;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.FinanceCalculatorPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import com.connect_group.tests.modelselect.ModelSelectTest;

public class PersonalisedQuoteTest extends BaseTest {
	protected Logger logger = Logger.getLogger(ModelSelectTest.class.getName());
	private ModelSelectPage modelSelectPage;
	private FilterByPage filterByPage;
	private PersonalisedQuotePage personalisedQuotePage;
	private FinanceCalculatorPage financeCalculatorPage;

	@BeforeEach
	void setupAndNavigateToUrl() {
		modelSelectPage = new ModelSelectPage(driver);
		filterByPage = new FilterByPage(driver);
		personalisedQuotePage = new PersonalisedQuotePage(driver);
		financeCalculatorPage = new FinanceCalculatorPage(driver);

		open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
		financeCalculatorPage.handleCookieConsent();
		financeCalculatorPage.closeQuesPopup();
	}

	// Task 4: Test method to Select any model from the model selection page and confirm the “Personalise Quote” page has loaded. Change the dropdown value for the Engine Dropdown from the default engine selected. 

	@Test @Order(1)
	void test1_selectEngineForCarModel(){
		try {
		modelSelectPage.selectCarModel("Range Rover Velar");
		assertTrue(personalisedQuotePage.verifyPersonalisedQuoteTitle());
		modelSelectPage.selectDropDownForEngine("P400e Petrol Plug-in Electric Hybrid",1262,338);
		logger.info("Selecting engine car model is verified");

		}
		catch (Exception e) {
			logger.info("Selecting engine car model is not verified");
			fail("Selecting engine car model is not verified" + e.getMessage());

		}
	}
	
	
	// Task 5 Test method to click on tool tip icon and verify the information pop
	// up modal displayed
	@Test @Order(2)
	void test2_verifyFinanceProductToolTip() {
		
		try {
		
		modelSelectPage.selectCarModel("Range Rover Velar");
		assertTrue(personalisedQuotePage.verifyPersonalisedQuoteTitle());
		personalisedQuotePage.clickToolTipIcon();
		assertTrue(personalisedQuotePage.isInfoPopUpDisplayed());
		personalisedQuotePage.clickCloseBtn();
		logger.info("Tool tip icon information pop is verified successfully");
		}
		
		catch (Exception e) {
			logger.info("Tool tip icon information pop is not verified");
			fail("Tool tip icon information pop is not verified" + e.getMessage());

		}
	}
}
