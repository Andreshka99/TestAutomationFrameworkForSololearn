package org.example;

import java.util.Random;

public class RandomCredentialsGenerator {

    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;':\",./<>?";

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 12;

    private static final Random random = new Random();

    // Генерация случайного email
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com", "msn.com"};
        String[] firstNames = {"jane", "john", "mary", "mark", "jennifer", "david", "susan", "richard"};
        String[] lastNames = {"smith", "jones", "davis", "brown", "wilson", "taylor", "clark", "martin"};

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String domain = domains[random.nextInt(domains.length)];
        String randomNumber = Integer.toString(random.nextInt(1000));
        String email = firstName + "." + lastName + randomNumber + "@" + domain;

        return email.toLowerCase();
    }

    // Генерация случайного пароля
    public static String generateRandomPassword() {
        int passwordLength = MIN_PASSWORD_LENGTH + random.nextInt(MAX_PASSWORD_LENGTH - MIN_PASSWORD_LENGTH + 1);
        StringBuilder passwordBuilder = new StringBuilder();

        // Генерация пароля с использованием разных символов
        passwordBuilder.append(getRandomCharacters(2, UPPER_CASE_LETTERS));
        passwordBuilder.append(getRandomCharacters(2, LOWER_CASE_LETTERS));
        passwordBuilder.append(getRandomCharacters(2, NUMBERS));
        passwordBuilder.append(getRandomCharacters(2, SYMBOLS));

        // Дополнение пароля случайными символами до заданной длины
        passwordBuilder.append(getRandomCharacters(passwordLength - passwordBuilder.length(), LOWER_CASE_LETTERS + UPPER_CASE_LETTERS + NUMBERS + SYMBOLS));

        // Перемешивание символов пароля
        String password = passwordBuilder.toString();
        char[] passwordCharacters = password.toCharArray();
        for (int i = passwordCharacters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordCharacters[index];
            passwordCharacters[index] = passwordCharacters[i];
            passwordCharacters[i] = temp;
        }

        return new String(passwordCharacters);
    }

    // Генерация случайной строки из заданных символов
    private static String getRandomCharacters(int length, String characters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }
}
