package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Login login = new Login();

        // Próba logowania
        if (login.logIn()) {
            System.out.println("Wykonuję resztę programu...");

            Search search = new Search();
            // Dostępne nazwy filtru to: (id, imie, nazwisko, pesel, numer, kod)
            // Przykładowe dane: (1 Jan Kowalski 12345678901 123456789 123-45)
            //
            // Id, to numer pacjenta na liście. Imie oraz nazwisko muszą być z dużej literty, pesel, numer(telefonu) oraz kod(pocztowy)
            // musząmieć kolejno: 11, 9, oraz 5 cyfr. W przypadku kodu, po 3 musi być myślnik (tak jak pokazano w przykładowych danych)
            try {
                List<String> wyniki = search.search("nazwisko", "kowalski");

                List<String> wyniki1 = search.search("id", "1");
                for (String wynik : wyniki) {
                    System.out.println(wynik);
                }
                System.out.println("-------------------------------------------------------------");
                for (String wynik1 : wyniki1) {
                    System.out.println(wyniki1);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------------------------------------------------");

            try {
                List<String> wyniki0 = search.search("BŁĘDNY FILTR", "1");
                for (String wynik0 : wyniki0) {
                    System.out.println(wynik0);
                }
                System.out.println("-------------------------------------------------------------");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------------------------------------------------");
            try {
                List<String> wyniki0 = search.search("nazwisko", "BŁĘDNE NAZWISKO");
                for (String wynik0 : wyniki0) {
                    System.out.println(wynik0);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("-------------------------------------------------------------");

            Termin termin = new Termin();

            termin.pokazTerminy();


            //Dni tygodnia są od 0 do 4. Kolejno od poniedziałku do piątku.
            termin.zarezerwujTermin(0, 8, 1);
            termin.zarezerwujTermin(1, 10, 5);
            termin.zarezerwujTermin(3, 14, 13);

            System.out.println("\nPo rezerwacjach:");
            termin.pokazTerminy();

            termin.anulujTermin(0, 8);
            System.out.println("\nPo anulowaniu terminu:");
            termin.pokazTerminy();
        } else {
            System.out.println("Zakończenie programu.");
        }

    }
}