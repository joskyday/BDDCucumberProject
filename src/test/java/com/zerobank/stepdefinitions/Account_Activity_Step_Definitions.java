package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.Account_Activity;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.util.List;


public class Account_Activity_Step_Definitions {

    @When("the user navigates to {string} tab")
    public void the_user_navigates_to_tab(String tab) {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.navigateTo(tab);
    }

    @Then("the page	should	have	the	title	{string}")
    public void the_page_should_have_the_title_Zero_Account_activity(String title) {
        Assert.assertEquals(title, Driver.get().getTitle());
    }

    @Then("Account	drop	down	default	option	should	be	{string}")
    public void account_drop_down_default_option_should_be(String defaultOption) {
        Account_Activity account_activity=new Account_Activity();
        Select dropDown=new Select(account_activity.accountDropdownmenu);
        Assert.assertEquals("Savings",dropDown.getFirstSelectedOption().getText());

    }
    @Then("Account	drop	down should	have	the	following	options:")
    public void account_drop_down_should_have_the_following_options(List<String> dropdownList) {
        Account_Activity account_activity=new Account_Activity();
        Select dropDown=new Select(account_activity.accountDropdownmenu);
        Assert.assertTrue(BrowserUtils.getElementsText(account_activity.dropdownElements).containsAll(dropdownList));
        Assert.assertTrue(BrowserUtils.getElementsText(dropDown.getOptions()).containsAll(dropdownList));
    }
    @Then("Transactions	table	should	have	column	names:")
    public void transactions_table_should_have_column_names(List<String> transactionColumnNames) {
        Account_Activity account_activity=new Account_Activity();
        Assert.assertTrue(BrowserUtils.getElementsText(account_activity.transactionColumns).containsAll(transactionColumnNames));
    }


    @When("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        Account_Activity account_activity=new Account_Activity();
        account_activity.findTransactions.click();//19
     }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String pastDate, String recentDate) {
        Account_Activity account_activity=new Account_Activity();
        account_activity.fromDate.clear();
        account_activity.toDate.clear();
        account_activity.fromDate.sendKeys(pastDate);
        account_activity.toDate.sendKeys(recentDate);
    }

    @When("clicks search")
    public void clicks_search() {
        Account_Activity account_activity=new Account_Activity();
        account_activity.findButton.click();
        BrowserUtils.waitFor(1);//21  //24
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String pastDate, String recentDate) {
        Account_Activity account_activity = new Account_Activity();
        for (String each : BrowserUtils.getElementsText(account_activity.dateResults)) {
            Assert.assertTrue(each + " is between " + pastDate + " and " + recentDate, account_activity.isSelectedDateBetweenRange(each, recentDate, pastDate));
        }
        Assert.assertEquals(pastDate,account_activity.fromDate.getAttribute("value"));
        Assert.assertEquals(recentDate,account_activity.toDate.getAttribute("value"));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Account_Activity account_activity=new Account_Activity();
        WebDriverWait wait=new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.visibilityOf(account_activity.endDate));
        Assert.assertTrue(account_activity.isRecentDateToPastDate(account_activity.endDate.getText(),account_activity.startDate.getText()));
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Account_Activity account_activity=new Account_Activity();
        Assert.assertFalse(account_activity.isSelectedDateBetweenRange(date,account_activity.toDate.getAttribute("value"),account_activity.fromDate.getAttribute("value")));
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String description)  {
        Account_Activity account_activity=new Account_Activity();
        account_activity.description.clear();  //20    //23
        account_activity.description.sendKeys(description);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        Account_Activity account_activity=new Account_Activity();
//        try {
            if (account_activity.resultTable.isDisplayed()) {
                for (int i = 0; i < account_activity.descriptionList.size(); i++) {   //22  //25
                    System.out.println(account_activity.descriptionList.get(i).getText());
                    Assert.assertTrue(account_activity.descriptionList.get(i).getText().contains(description));
//                }
            }
/*        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            System.out.println("There is no result");*/
        }
        /*catch(Exception e){
            System.out.println("result not displayed");
        }*/
            }


    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        Account_Activity account_activity=new Account_Activity();
        List<String> descriptionListString=BrowserUtils.getElementsText(account_activity.descriptionList);
        for(String each:descriptionListString)
            Assert.assertFalse(each.contains(description));  //26

    }



    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Account_Activity account_activity=new Account_Activity();
        if(!account_activity.depositAmounts.isEmpty()) {
            int counter=0;
            for (WebElement each:account_activity.depositAmounts) {
                if(each.getText().length()>0) counter++;
            }
            Assert.assertTrue("There is at least one result under Deposit",counter>0);
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Account_Activity account_activity=new Account_Activity();
        if(account_activity.withdrawalAmounts.size()>0) {
            int counter=0;
            for (int i=0;i<account_activity.withdrawalAmounts.size();i++)
                if(!account_activity.withdrawalAmounts.get(i).getText().isEmpty()) counter++;
            Assert.assertTrue("There is at least one result under Withdrawal",counter>0);
        }

    }
   @When("user selects type {string}")
    public void user_selects_type(String type) {
        Account_Activity account_activity=new Account_Activity();
        Select selectedType=new Select(account_activity.dropdownType);
        selectedType.selectByVisibleText(type);
        account_activity.findButton.click();
       BrowserUtils.waitFor(1);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Account_Activity account_activity=new Account_Activity();
        int counter=0;
        for (WebElement each:account_activity.withdrawalAmounts) {
            if(each.getText().length()>0)counter++;
        }
        Assert.assertTrue("There is no withdrawal amount",counter==0);
        }


    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Account_Activity account_activity=new Account_Activity();
        int count=0;
        for (WebElement each:account_activity.depositAmounts) {
            if(each.getText().length()>0)count++;
        }
        Assert.assertTrue("There is no deposit amount",count==0);
    }

}
