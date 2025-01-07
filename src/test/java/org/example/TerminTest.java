package org.example;

import static org.junit.jupiter.api.Assertions.*;

class TerminTest {

    @org.junit.jupiter.api.Test
    void anulujTermin() {

        //Testuje tylko metodę anulujTermin() ponieważ żeby ją wykorzystać i tak trzeba wykorzystać metody: zarezerwujTermin() oraz pokazTerminy()

        Termin termin = new Termin();

        termin.zarezerwujTermin(0, 8, 1);
        termin.zarezerwujTermin(1, 10, 5);
        termin.zarezerwujTermin(3, 14, 13);

        termin.anulujTermin(0, 8);

        System.out.println("\nPo anulowaniu terminu:");
        termin.pokazTerminy();
    }
}