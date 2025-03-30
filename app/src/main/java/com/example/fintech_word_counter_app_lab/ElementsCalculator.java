package com.example.fintech_word_counter_app_lab;

public class ElementsCalculator {

    public static int getCharsCount(String input) {
        if (input == null) return 0;
        return input.length();
    }

    public static int getWordsCount(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split("\\s+").length;
    }
}

