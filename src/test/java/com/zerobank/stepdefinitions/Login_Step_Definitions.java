package com.zerobank.stepdefinitions;

import com.zerobank.pages.Login;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class Login_Step_Definitions {


    @Given("the user is at the login page")
    public void the_user_is_at_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        //BrowserUtils.waitFor(3);

        Assert.assertTrue(Driver.get().getTitle().equals("Zero - Personal Banking - Loans - Credit Cards"));
    }

    @When("the user enters login credentials")
    public void the_user_enters_login_credentials() {
        Login login=new Login();
        login.login();
    }

    @Then("Account Summary Page Displayed")
    public void account_Summary_Page_Displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }

    @Then("Account summary page should have the title Zero – Account summary")
    public void account_summary_page_should_have_the_title_Zero_Account_summary() {
        System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().equals("Zero - Account Summary"));
    }


    @When("the user enters invalid {string} and {string}")
    public void the_user_enters_invalid_and(String username, String password)  {
        // Write code here that turns the phrase above into concrete actions
        Login login=new Login();
        login.login(username,password);
    }
    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(new Login().wrongCredentials.getText().equals("Login and/or password are wrong."));
    }












    @When("the user enters blank username or blank password")
    public void the_user_enters_blank_username_or_blank_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
