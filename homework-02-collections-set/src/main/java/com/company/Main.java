package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@gmailbox.ru == HeLLO@GMAILbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@gmailbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */
    public static void main(String[] args) {
        //TODO: write code here
        EmailListApp emailListApp = new EmailListApp();
        emailListApp.init();
    }
}