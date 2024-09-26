package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EmailListApp {
    public void init() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isRunning = true;
            EmailList list = new EmailList();


            while (isRunning) {
                String line = reader.readLine() + " ";
                String[] split = line.split(" ", 2);
                String command = split[0];
                String toDo = split[1];
                switch (command) {
                    case "LIST":
                        List<String> emails = list.getSortedEmails();
                        for (String email : emails) {
                            System.out.println(email);
                        }
                        break;
                    case "ADD":
                        list.add(toDo);
                        System.out.println("Добавлен email " + toDo);
                        break;
                    case "EXIT":
                        isRunning = false;
                        break;
                    default:
                        ConsoleHelper.writeMessage("Неправильная команда");
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
