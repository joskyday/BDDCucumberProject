package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = "button#signin_button")
    public WebElement signin_button;

    @FindBy(css = "input[id='user_login']")
    public WebElement username;

    @FindBy(css = "#user_password")//input[id='user_password']
    public WebElement password;

    @FindBy(css="input[type=\'submit\']")
    public WebElement submitbutton;
    @FindBy(css = "button#details-button")
    public WebElement advancedbutton;

    @FindBy(css = "a#proceed-link")
    public WebElement proceedwebpage;

    @FindBy(css = "div.alert.alert-error")
    public WebElement wrongCredentials;

    public void login(){
        signin_button.click();
        username.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        submitbutton.click();
        try{
            advancedbutton.click();
            proceedwebpage.click();
        }catch (Exception e){

        }

    }
    public void login(String username,String password)  {
        signin_button.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitbutton.click();
        try {
            advancedbutton.click();
            proceedwebpage.click();
        }catch (NoSuchElementException e){

        }
    }




}
