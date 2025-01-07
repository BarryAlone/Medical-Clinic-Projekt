package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<String> search(String nazwaFiltru, String daneFiltrujące) {
        List<String> wyniki = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("pacjenci.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] dane = line.split(" ");

                switch (nazwaFiltru.toLowerCase()) {
                    case "id":
                        if (dane[0].equalsIgnoreCase(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    case "imie":
                        if (dane[1].equalsIgnoreCase(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    case "nazwisko":
                        if (dane[2].equalsIgnoreCase(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    case "pesel":
                        if (dane[3].equals(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    case "numer":
                        if (dane[4].equals(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    case "kod":
                        if (dane[5].equals(daneFiltrujące)) {
                            wyniki.add(line);
                        }
                        break;

                    default:
                        throw new IllegalArgumentException("Nieznany filtr: " + nazwaFiltru);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wyniki.isEmpty()) {
            throw new RuntimeException("Brak wyników dla filtru: " + nazwaFiltru + " = " + daneFiltrujące);
        }

        return wyniki;
    }
}


