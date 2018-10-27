package framework.sample;

import org.testng.annotations.Test;

public class Testclass extends Basepage {

    // Call this class from testng xml file with appropriate parameters
    // Then pass some arguments using getproperty method from mvn for CI
    // Used sonar lint for Java code standard 

    @Test(priority = 1)
    public void testOne() {

        loginpage.user1();
        addPage.addtest1();
        editPage.edittest1();

    }

    @Test(priority = 2)
    public void testTwo() {

        loginpage.user2();
        addPage.addtest2();
        editPage.edittest2();

    }

    @Test(priority = 3)
    public void testThree() {

        loginpage.user1();
        addPage.addtest3();
        editPage.edittest3();

    }

}
