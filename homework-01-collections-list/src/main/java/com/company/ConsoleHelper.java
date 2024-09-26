package com.company;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@UtilityClass
public class ConsoleHelper {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static TodoList todoList = new TodoList();

    public void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public String readString() {
        return READER.readLine();
    }

    @SneakyThrows
    public int readInt() {
        return Integer.parseInt(readString());
    }

    public void list() {
        if (!todoList.getTodos().isEmpty()) {
            for (int i = 0; i < todoList.getTodos().size(); i++) {
                writeMessage(i + " - " + todoList.getTodos().get(i));
            }
        } else {
            writeMessage("Список пуст");
        }
    }

    public void add(String toDo) {
        todoList.add(toDo);
        writeMessage("Добавлено дело " + toDo);
    }

    public void edit(String toDo) {
        String[] splitEdit = toDo.split(" ", 2);
        int index = Integer.parseInt(splitEdit[0].trim());
        String newToDo = splitEdit[1];
        String oldToDo = todoList.getTodos().get(index);
        todoList.edit(index, newToDo);
        writeMessage("Дело " + oldToDo + "заменено на " + newToDo);
    }

    public void delete(String toDo) {
        todoList.delete(Integer.parseInt(toDo.trim()));
        ConsoleHelper.writeMessage("Дело " + toDo + "удалено");
    }
}
