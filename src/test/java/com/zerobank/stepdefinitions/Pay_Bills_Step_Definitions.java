package com.zerobank.stepdefinitions;

import com.zerobank.pages.Pay_Bills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Pay_Bills_Step_Definitions {
    @When("the user	completes	a successful	Pay	operation with following information:")
    public void the_user_completes_a_successful_Pay_operation_with_following_information(Map<String,String> dataTable) {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.makePayment(dataTable.get("Payee"),dataTable.get("Account"),dataTable.get("Amount"),dataTable.get("Date"),dataTable.get("Description"));

    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String warning) {
       Pay_Bills pay_bills=new Pay_Bills();
        Assert.assertTrue(pay_bills.paymentWarning.getText().equals(warning));

    }

    @When("user tries to make a payment without entering the {string} or {string}:")
    public void user_tries_to_make_a_payment_without_entering_the_or(String amount, String date) {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.makePayment("sprint","Savings",amount,date,"Amount deposited");
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String warning) {
        Pay_Bills pay_bills=new Pay_Bills();
        if(pay_bills.amount.getAttribute("value").isEmpty())
            Assert.assertEquals(warning,pay_bills.amount.getAttribute("validationMessage"));
        if(pay_bills.date.getAttribute("value").isEmpty())
            Assert.assertEquals(warning,pay_bills.date.getAttribute("validationMessage"));
    }

    @When("user tries to make a payment entering the {string}:")
    public void user_tries_to_make_a_payment_entering_the(String amount) {
        Pay_Bills pay_bills=new Pay_Bills();
            pay_bills.makePayment("sprint", "Savings", amount, "2021-02-17", "large amount of deposit");

    }

    @Then("Amount field should not accept alphabetical or special characters")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() {
        Pay_Bills pay_bills=new Pay_Bills();
        Assert.assertFalse((pay_bills.paymentWarning.isDisplayed()));
    }
    @When("user tries to make a payment entering {string}")
    public void user_tries_to_make_a_payment_entering(String date) {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.makePayment("sprint","Savings","100",date,"description");

    }
    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {
        Pay_Bills pay_bills=new Pay_Bills();

        Assert.assertTrue(pay_bills.date.getAttribute("value").isEmpty());
    }


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.addNewPayeeTab.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.payeeName.sendKeys(dataTable.get("Payee Name"));
        pay_bills.payeeAddress.sendKeys(dataTable.get("Payee Address"));
        pay_bills.payeeAccount.sendKeys(dataTable.get("Account"));
        pay_bills.payeeDetails.sendKeys(dataTable.get("Payee details"));
        pay_bills.addNewPayeeButton.click();
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        Pay_Bills pay_bills=new Pay_Bills();
        Assert.assertEquals(message,pay_bills.payeeAddedMessage.getText());
    }




    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       Pay_Bills pay_bills=new Pay_Bills();
       pay_bills.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Pay_Bills pay_bills=new Pay_Bills();
        Select selectCurrencyDropdown=new Select(pay_bills.currencyDropdown);
        Assert.assertTrue(BrowserUtils.getElementsText(selectCurrencyDropdown.getOptions()).containsAll(dataTable));
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert=Driver.get().switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Please, ensure that you have filled all the required fields with valid values."));
        System.out.println(alert.getText());
    }


    @Given("the user selected a currency {string}")
    public void the_user_selected_a_currency(String selectedCurrency) {
        Pay_Bills pay_bills=new Pay_Bills();
        Select selectCurrencyDropdown=new Select(pay_bills.currencyDropdown);
        selectCurrencyDropdown.selectByVisibleText(selectedCurrency);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Pay_Bills pay_bills=new Pay_Bills();
        pay_bills.calculateCostsButton.click();
    }

}
