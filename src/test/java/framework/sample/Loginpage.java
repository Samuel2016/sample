package framework.sample;

public class Loginpage extends Basepage {

    public Loginpage() {
        super();
    }

    public Loginpage user1() {

        System.out.println("using user1");

        return new Loginpage();
    }

    public Loginpage user2() {

        System.out.println("using user2");

        return new Loginpage();
    }

}
