package framework.sample;

import org.testng.annotations.BeforeMethod;


public class Basepage {

    protected Loginpage loginpage;
    protected Add addPage;
    protected Edit editPage;

    @BeforeMethod
    public void beforeMethod() {

        loginpage = new Loginpage();
        addPage = new Add();
        editPage = new Edit();

    }

}
