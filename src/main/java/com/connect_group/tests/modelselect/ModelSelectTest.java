package com.connect_group.tests.modelselect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.FinanceCalculatorPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;

public class ModelSelectTest extends BaseTest {

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

	// Task 1: Test method to validate that the number of vehicles models is equal
	// to 7
	@Test
	void verifyVehicleModelCount() {

		try {
			assertTrue(modelSelectPage.isInitialized());
			assertEquals(modelSelectPage.getVehicleModelsCount(), 7);
			logger.info("Number of vehicles models is verified successfully");

		}

		catch (Exception e) {
			logger.info("Number of vehicles models is not verified");
			fail("Number of vehicles models is not verified" + e.getMessage());

		}

	}

	// Task 3: Select a model from the model selection page and confirm the
	// “Personalise Quote” page has loaded.

	@Test
	void selectCarModelTC() {
		try {
			modelSelectPage.selectCarModel("Range Rover Sport");
			assertTrue(personalisedQuotePage.verifyPersonalisedQuoteTitle());
			modelSelectPage.changeVehicle();
			modelSelectPage.selectCarModel("Range Rover Velar");
			logger.info("Personalised Quote page has loaded and verified successfully");

		}

		catch (Exception e) {
			logger.info("Personalised Quote page has not loaded and verified");
			fail("Personalised Quote page has not loaded and verified" + e.getMessage());

		}

	}
	
	
	
}
