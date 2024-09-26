package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private Map<String, String> map;
    private Set<String> set;

    public PhoneBook() {
        map = new HashMap<>();
        set = new TreeSet<>();
    }

    public void addContact(String name, String phone) {
        // TODO проверь корректность формата имени и телефона
        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
        if (checkName(name) && checkPhone(phone) && !name.isEmpty() && !phone.isEmpty()) {
            String string = map.get(name);
            if (map.containsKey(name)) {
                map.put(name, string + ", " + phone);
            } else if (checkValue(phone)) {
                removeValue(phone);
                map.put(name,phone);
            } else {
                map.put(name, phone);
            }

        }
        set.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            set.add(entry.getKey() + " - " + entry.getValue());
        }
    }


    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet
        Set<String> getSet = new TreeSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                getSet.add(entry.getKey() + " - " + entry.getValue());
            }
        }
        return getSet;
    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку

        for (String string : set) {
            String[] split = string.split(" - ");
            if (split[0].equals(phone)) {
                return string;
            }
        }
        return "";
    }

    public Set<String> getAllContacts() {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet
        return set;
    }

    public boolean checkName(String name) {
        if (name.matches("[a-zA-Zа-яА-Я]*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPhone(String phone) {
        if (phone.matches("^7\\d{10}")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkValue(String phone) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().contains(phone))
                return true;
        }
        return false;
    }

    private void removeValue(String phone) {
        StringBuilder end = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().contains(phone)) {
                String[] split = entry.getValue().split(",");
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].equals(phone)) {
                        if (end == null) {
                            end = new StringBuilder(split[i]);
                        } else {
                            end.append(",").append(split[i]);
                            if (i == split.length - 1) {
                                entry.setValue(end.toString());
                            }
                        }
                    }
                }
            }
        }

    }
}
