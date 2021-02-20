package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Pay_Bills extends AccountSummary{
    @FindBy(css = "#sp_payee")
        public WebElement dropDownPayee;
    @FindBy(css ="#sp_account")
        public WebElement dropDownAccount;
    @FindBy(css = "#sp_amount")
        public WebElement amount;
    @FindBy(css = "#sp_date")
        public WebElement date;
    @FindBy(css = "#sp_description")
        public WebElement description;
    @FindBy(xpath = "//input[@type='submit']")
        public WebElement payButton;
    @FindBy(css = "#alert_content>span")
        public WebElement paymentWarning;
    Select selectPayee=new Select(dropDownPayee);
    Select selectAccount=new Select(dropDownAccount);

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayeeTab;

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(css = "#np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement payeeAddedMessage;

    @FindBy(css = "#add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(xpath = "(//div[@class='span12'])[2]//li[3]")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropdown;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement  calculateCostsButton;





    public void makePayment(String payee,String accountType,String amount,String date,String description){
    selectPayee.selectByValue(payee);
    selectAccount.selectByVisibleText(accountType);
    this.amount.sendKeys(amount);
    this.date.sendKeys(date);
    this.description.sendKeys(description);
    payButton.click();
    }
}
