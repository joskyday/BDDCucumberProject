package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Account_Activity extends AccountSummary {

    @FindBy(css = "#aa_accountId")
    public WebElement accountDropdownmenu;
    @FindBy(xpath = "//select/option")
    public List<WebElement> dropdownElements;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> transactionColumns;

    @FindBy(xpath = "//a[normalize-space()='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(css = "input#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "input#aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "(//tbody)[2]/tr[3]/td[1]")
    public WebElement startDate;

    @FindBy(xpath = "(//tbody)[2]/tr[1]/td[1]")
    public WebElement endDate;

    @FindBy(css = "#aa_description")
    public WebElement description;

    @FindBy(xpath = "(//tbody)[2]/tr/td[2]")
    public List<WebElement> descriptionList;

    @FindBy(xpath = "(//tbody)[2]")
    public WebElement resultTable;

    @FindBy(xpath = "(//tbody)[2]/tr/td[3]")
    public List<WebElement> depositAmounts;

    @FindBy(xpath = "(//tbody)[2]/tr/td[4]")
    public List<WebElement> withdrawalAmounts;

    @FindBy(css="#aa_type")
    public WebElement dropdownType;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public List<WebElement> dateResults;



    public boolean isRecentDateToPastDate(String recent, String past) {
        boolean flag = false;
        String[] recentSplit = recent.split("-");
        String[] pastSplit = past.split("-");
        if (Integer.parseInt(recentSplit[0]) > Integer.parseInt(pastSplit[0])) flag = true;
        else if (Integer.parseInt(recentSplit[0]) < Integer.parseInt(pastSplit[0])) flag = false;
        else if (Integer.parseInt(recentSplit[0]) == Integer.parseInt(pastSplit[0])) {
            if (Integer.parseInt(recentSplit[1]) > Integer.parseInt(pastSplit[1])) flag = true;
            else if (Integer.parseInt(recentSplit[1]) < Integer.parseInt(pastSplit[1])) flag = false;
            else if (Integer.parseInt(recentSplit[1]) == Integer.parseInt(pastSplit[1])) {
                if (Integer.parseInt(recentSplit[2]) > Integer.parseInt(pastSplit[2])) flag = true;
                else if (Integer.parseInt(recentSplit[2]) < Integer.parseInt(pastSplit[2])) flag = false;
                else if (Integer.parseInt(recentSplit[2]) == Integer.parseInt(pastSplit[2])) flag = true;
            }
        }
        return flag;
    }

    public boolean isSelectedDateBetweenRange(String selected, String recent, String past) {
        boolean flag = false;
        String[] recentSplit = recent.split("-");
        String[] selectedSplit = selected.split("-");
        String[] pastSplit = past.split("-");
        if(Integer.parseInt(recentSplit[0])<1900||Integer.parseInt(recentSplit[0])>2099)
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])<1||Integer.parseInt(recentSplit[1])>12)
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==1&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==2&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>28))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==3&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==4&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>30))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==5&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==6&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>30))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==7&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==8&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==9&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>30))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==10&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==11&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>30))
            System.out.println("invalid date");
        else if(Integer.parseInt(recentSplit[1])==12&&(Integer.parseInt(recentSplit[2])<1||Integer.parseInt(recentSplit[2])>31))
            System.out.println("invalid date");
        if(Integer.parseInt(recentSplit[0])>=1900&&Integer.parseInt(recentSplit[0])<=2099&&Integer.parseInt(recentSplit[1])>=1&&Integer.parseInt(recentSplit[1])<=12&&Integer.parseInt(recentSplit[2])>=1&&Integer.parseInt(recentSplit[2])<=31) {

            if (Integer.parseInt(recentSplit[0]) > Integer.parseInt(selectedSplit[0]) && Integer.parseInt(selectedSplit[0]) > Integer.parseInt(pastSplit[0]))
                flag = true;
            else if(Integer.parseInt(recentSplit[0]) < Integer.parseInt(selectedSplit[0]) || Integer.parseInt(selectedSplit[0]) < Integer.parseInt(pastSplit[0]))
                flag=false;
            else if (Integer.parseInt(recentSplit[0]) == Integer.parseInt(selectedSplit[0]) || Integer.parseInt(selectedSplit[0]) == Integer.parseInt(pastSplit[0])) {
                if (Integer.parseInt(recentSplit[1]) > Integer.parseInt(selectedSplit[1]) && Integer.parseInt(selectedSplit[1]) > Integer.parseInt(pastSplit[1]))
                    flag = true;
                else if (Integer.parseInt(recentSplit[1]) < Integer.parseInt(selectedSplit[1]) || Integer.parseInt(selectedSplit[1]) < Integer.parseInt(pastSplit[1]))
                    flag = false;
                else if (Integer.parseInt(recentSplit[1]) == Integer.parseInt(selectedSplit[1]) || Integer.parseInt(selectedSplit[1]) == Integer.parseInt(pastSplit[1])) {
                    if (Integer.parseInt(recentSplit[2]) > Integer.parseInt(selectedSplit[2]) && Integer.parseInt(selectedSplit[2]) > Integer.parseInt(pastSplit[2]))
                        flag = true;
                    else if (Integer.parseInt(recentSplit[2]) < Integer.parseInt(selectedSplit[2]) || Integer.parseInt(selectedSplit[2]) < Integer.parseInt(pastSplit[2]))
                        flag = false;
                    else if (Integer.parseInt(recentSplit[2]) == Integer.parseInt(selectedSplit[2]) || Integer.parseInt(selectedSplit[2]) == Integer.parseInt(pastSplit[2]))
                        flag = true;
                }
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        Account_Activity account_activity = new Account_Activity();
        boolean flag = account_activity.isRecentDateToPastDate("2012-09-06", "2012-09-01");
        System.out.println(flag);

        System.out.println(account_activity.isSelectedDateBetweenRange("2012-09-05", "2012-09-06", "2012-09-04"));
        Assert.assertFalse(account_activity.isSelectedDateBetweenRange("2012-09-03", "2012-09-06", "2012-09-04"));
    }
}
