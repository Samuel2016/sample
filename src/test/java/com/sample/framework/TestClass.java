package com.sample.framework;

import framework.sample.Basepage;
import org.testng.annotations.Test;

public class TestClass extends Basepage {

    // Call this class from testng xml file with appropriate parameters
    // Then pass some arguments using getproperty method from mvn for CI
    // Used sonar lint for Java code standard 

    private final Add addPage = new Add();
    private final Edit editPage = new Edit();
    private final LoginPage loginPage = new LoginPage();


    @Test(priority = 1)
    public void testOne() {

        loginPage.user1();
        addPage.addTest1();
        editPage.editTest1();

    }

    @Test(priority = 2)
    public void testTwo() {

        loginPage.user2();
        addPage.addTest2();
        editPage.editTest2();

    }

    @Test(priority = 3)
    public void testThree() {

        loginPage.user1();
        addPage.addTest3();
        editPage.editTest3();

    }

}
