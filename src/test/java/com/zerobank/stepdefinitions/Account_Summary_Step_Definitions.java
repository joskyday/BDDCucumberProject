package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.Account_Activity;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Account_Summary_Step_Definitions {
    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> accountTypeSet) {
        AccountSummary accountSummary=new AccountSummary();
        outer:for(WebElement each: accountSummary.accountTypes){
            for(String accountType:accountTypeSet){
                if(each.getText().equals(accountType)) {
                    continue outer;
                }
            }
        }
    }
    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> CreditATable) {
        AccountSummary accountSummary=new AccountSummary();
        outer: for(WebElement tablehead:accountSummary.creditAccountTableHeads){
            for (String tablecolumnelement: CreditATable){
                if(tablehead.getText().equals(tablecolumnelement)) continue outer;
            }
        }
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummary accountSummary=new AccountSummary();
        Assert.assertTrue(accountSummary.savingsLink.isDisplayed());
        accountSummary.savingsLink.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Zero - Account Activity"));
    }
    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummary accountSummary=new AccountSummary();
        Assert.assertTrue(accountSummary.brokerageLink.isDisplayed());
        accountSummary.brokerageLink.click();
    }
    @When("the	user clicks	on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummary accountSummary=new AccountSummary();
        Assert.assertTrue(accountSummary.checkingLink.isDisplayed());
        accountSummary.checkingLink.click();
    }

    @When("the	user	clicks	on	Credit	card	link	on	the	Account	Summary	page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.creditCardLink.click();
    }
    @Then("Account	drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountType) {
        Account_Activity account_activity=new Account_Activity();
        Select selectAccount=new Select(account_activity.accountDropdownmenu);
        Assert.assertEquals(accountType,selectAccount.getFirstSelectedOption().getText());
    }
    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.loanLink.click();
    }

}
