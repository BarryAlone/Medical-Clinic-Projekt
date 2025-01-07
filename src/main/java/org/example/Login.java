package org.example;

import java.util.Scanner;

public class Login {
    private final String username = "halyna";
    private final String password = "kochamogurki";


    public boolean logIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wprowadź nazwę użytkownika: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Wprowadź hasło: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Logowanie powiodło się!");
            return true;
        } else if (!inputUsername.equals(username)) {
            System.out.println("Nieprawidłowa nazwa użytkownika.");
        } else if (!inputPassword.equals(password)) {
            System.out.println("Nieprawidłowe hasło użytkownika.");
        }
        return false;
    }
}

