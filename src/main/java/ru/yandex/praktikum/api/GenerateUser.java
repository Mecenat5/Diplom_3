package ru.yandex.praktikum.api;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateUser {
    public static String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String RANDOM_PASSWORD = RandomStringUtils.randomNumeric(6);
    public static String RANDOM_INCORRECT_PASSWORD = RandomStringUtils.randomNumeric(2);
    public static String RANDOM_NAME = RandomStringUtils.randomAlphabetic(5);
}
