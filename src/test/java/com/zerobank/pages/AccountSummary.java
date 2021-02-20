package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummary {

    public AccountSummary(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2.board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[@class='board'][3]//th")
    public List<WebElement> creditAccountTableHeads;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[2]")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[3]")
    public WebElement transferFundsTab;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[4]")
    public WebElement payBillsTab;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[5]")
    public WebElement myMoneyMapTab;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[6]")
    public WebElement onlineStatementsTab;

    @FindBy(xpath = "(//table//a)[1]")
    public WebElement savingsLink;

    @FindBy(xpath = "(//table//a)[3]")
    public WebElement brokerageLink;

    @FindBy(xpath = "(//table//a)[4]")
    public WebElement checkingLink;

    @FindBy(xpath = "(//table//a)[5]")
    public WebElement creditCardLink;

    @FindBy(xpath = "(//table//a)[6]")
    public WebElement loanLink;

    public void navigateTo(String tab){
        switch(tab){
            case "Account Activity":
                accountActivityTab.click();
                break;
            case "Transfer Funds":
                transferFundsTab.click();
                break;
            case "Pay Bills":
                payBillsTab.click();
                break;
            case "My Money Map":
                myMoneyMapTab.click();
                break;
            case "Online Statements":
                onlineStatementsTab.click();
                break;
        }
    }


}
