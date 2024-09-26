package com.company;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToDoListApp {
    public void init() {
        TodoList todoList = new TodoList();

        boolean isRunning = true;

        while (isRunning) {
            String line = ConsoleHelper.readString() + " ";
            String[] split = line.split(" ", 2);
            String choice = split[0];
            String toDo = split[1];
            switch (choice) {
                case Constants.LIST:
                    ConsoleHelper.list();
                    break;
                case Constants.ADD:
                    ConsoleHelper.add(toDo);
                    break;
                case Constants.EDIT:
                    ConsoleHelper.edit(toDo);
                    break;
                case Constants.DELETE:
                    ConsoleHelper.delete(toDo);
                    break;
                case Constants.EXIT:
                    isRunning = false;
                    break;
                default:
                    ConsoleHelper.writeMessage("Неправильная команда");
                    break;
            }
        }
    }
}
