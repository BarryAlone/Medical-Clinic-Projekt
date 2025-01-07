package org.example;

public class Termin {

    // Dwuwymiarowa tablica, gdzie pierwszy wymiar to dni tygodnia (0 - poniedziałek, 1 - wtorek, itd.)
    // A drugi wymiar to godziny (8 - 16)
    private String[][] harmonogram = new String[5][9];

    public Termin() {

        for (int i = 0; i < harmonogram.length; i++) {
            for (int j = 0; j < harmonogram[i].length; j++) {
                harmonogram[i][j] = "Wolny";
            }
        }
    }

    public void pokazTerminy() {
        String[] dniTygodnia = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek"};

        System.out.println(String.format("%-14s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s" ,
                "Dzień/Godzina", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"));
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < harmonogram.length; i++) {
            System.out.print(String.format("%-15s", dniTygodnia[i]));
            for (int j = 0; j < harmonogram[i].length; j++) {
                System.out.print(String.format("%-8s", harmonogram[i][j]));
            }
            System.out.println();
        }
    }

    public void zarezerwujTermin(int dzien, int godzina, int pacjentID) {
        if (harmonogram[dzien][godzina - 8].equals("Wolny")) {
            harmonogram[dzien][godzina - 8] = String.valueOf(pacjentID);
            System.out.println("Termin na " + dzien + " o godzinie " + godzina + " zarezerwowany dla " + pacjentID + ".");
        } else {
            System.out.println("Termin na " + dzien + " o godzinie " + godzina + " jest już zajęty.");
        }
    }

    public void anulujTermin(int dzien, int godzina) {
        if (!harmonogram[dzien][godzina - 8].equals("Wolny")) {
            System.out.println("Rezerwacja dla pacjenta " + harmonogram[dzien][godzina - 8] + " na termin " + dzien + " o godzinie " + godzina + " została anulowana.");
            harmonogram[dzien][godzina - 8] = "Wolny";
        } else {
            System.out.println("Termin na " + dzien + " o godzinie " + godzina + " jest już wolny.");
        }
    }

}

