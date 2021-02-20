package com.zerobank.stepdefinitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;



import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void beforetest(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    @After
    public void theend(){
        Driver.closeDriver();
        System.out.println("end of test");
    }
}
