package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private final Set<String> set;

    public EmailList() {
        set = new TreeSet<>();
    }


    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // TODO принять решение добавлять аргумент email или нет должен этот метод

        if (checkEmail(email)) {
            set.add(email.toLowerCase());
        } else {
            System.out.println("Неверный формат email");
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке

        return new ArrayList<>(set);
    }

    private boolean checkEmail(String email) {
        return email.matches("\\w*\\@\\w*\\.\\w*");
    }
}