package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    @Test
    public void testSearch() {
        try {
            Search search = new Search();
            List<String> wyniki = search.search("nazwisko", "kowalski");
            for (String wynik : wyniki) {
                System.out.println(wynik);
            }
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}