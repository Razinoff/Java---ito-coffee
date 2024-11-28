package org.example;

public class StringProcessor {
    // Метод 1
    public static String repeatString(String s, int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N не может быть отрицательным.");
        }
        if (s == null) {
            throw new IllegalArgumentException("Строка не может быть null.");
        }
        String result = "";
        for (int i = 0; i < N; i++) {
            result += s;
        }
        return result;
    }

    // Метод 2
    public static int countOccurrences(String mainString, String subString) {
        if (subString == null || subString.length() == 0) {
            throw new IllegalArgumentException("Подстрока не может быть пустой или null.");
        }
        int count = 0;
        int index = 0;
        //Метод indexOf в Java по документации возвращает -1, если искомая подстрока не найдена в строке
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        return count;
    }

    // Метод 3
    public static String replaceDigits(String input) {
        if (input == null || input.length() == 0) {
            throw new NullPointerException("Input string of the replace method has a null value.");
        }
        return input
                .replace("1", "один")
                .replace("2", "два")
                .replace("3", "три");
    }

    // Метод 4
    public static String removeEverySecondChar(StringBuilder sb) {
        if (sb == null) {
            throw new IllegalArgumentException("Строка не может быть null.");
        }
        for (int i = 1; i < sb.length(); i++) {
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }


    // Метод 5

}



