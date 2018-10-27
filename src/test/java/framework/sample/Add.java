package framework.sample;

public class Add extends Basepage {

    public Add() {
        super();
    }

    public Add addtest1() {

        System.out.println("Added 1st data");

        return new Add();
    }

    public Add addtest2() {

        System.out.println("Added 2nd data");

        return new Add();
    }

    public Add addtest3() {

        System.out.println("Added 3rd data");

        return new Add();
    }
}
