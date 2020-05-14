package by.epam.pronovich.homework01.task07;

import by.epam.pronovich.homework01.task07.annotation.ProdCode;

public class ProRunner {

    @ProdCode
    public void testMeth() {
        System.out.println("successful start Test");
    }

    @ProdCode
    private void secondTest() {
        System.out.println("successful start secondTest");
    }

    public void methThatNotStart() {
        System.out.println("dont start");
    }
}
