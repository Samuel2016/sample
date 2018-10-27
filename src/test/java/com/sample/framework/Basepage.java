package com.sample.framework;

import framework.sample.Add;
import framework.sample.Edit;
import org.testng.annotations.BeforeMethod;


public class Basepage {

    protected LoginPage loginpage;
    protected Add addPage;
    protected Edit editPage;

    @BeforeMethod
    public void beforeMethod() {

        loginpage = new LoginPage();
        addPage = new Add();
        editPage = new Edit();

    }

}
