package ru.netology.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {

    public static int random() { // генерация случайного числа от 3 до 30
        double random = Math.random() * 28;
        int rnd = (int) random + 3;
        return rnd;
    }

    public static String genDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String genCity() {
        var cities = new String[]{
                "Архангельск", "Белгород", "Волгоград", "Екатеринбург", "Краснодар",
                "Липецк", "Москва", "Новосибирск", "Омск", "Пенза", "Рязань", "Самара",
                "Тюмень", "Ульяновск", "Челябинск", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }

    

}
