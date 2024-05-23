package com.connect_group.tests.financecalculator;


import com.connect_group.pages.financecalculator.FinanceCalculatorPage;

import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest extends BaseTest {


  private FinanceCalculatorPage financeCalculatorPage;

  @BeforeEach
  void setupAndNavigateToUrl() {

    financeCalculatorPage = new FinanceCalculatorPage(driver);

    open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
    financeCalculatorPage.handleCookieConsent();
    financeCalculatorPage.closeQuesPopup();
  }

  
  
}