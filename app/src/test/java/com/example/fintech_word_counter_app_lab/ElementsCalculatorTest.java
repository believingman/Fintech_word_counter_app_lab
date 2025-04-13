package com.example.fintech_word_counter_app_lab;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Test class for checking ElementsCalculator logic
public class ElementsCalculatorTest {

    // Kuriamas objektas, kurį testuosime
    private ElementsCalculator calculator = new ElementsCalculator();

    @Test
    public void testEmptyText() {
        // 1. Kai tekstas tuščias - tikimasi 0 žodžių ir 0 simbolių
        String input = "";
        assertEquals(0, calculator.getWordsCount(input));
        assertEquals(0, calculator.getCharsCount(input));
    }

    @Test
    public void testNormalText() {
        // 2. Įvedus normalų tekstą ("Hello world") - 2 žodžiai, 11 simbolių
        String input = "Hello world";
        assertEquals(2, calculator.getWordsCount(input));
        assertEquals(11, calculator.getCharsCount(input));
    }

    @Test
    public void testOnlySpaces() {
        // 3. Tik tarpai - 0 žodžių, 3 simboliai
        String input = "   ";
        assertEquals(0, calculator.getWordsCount(input));
        assertEquals(3, calculator.getCharsCount(input));
    }

    @Test
    public void testOnlyTabs() {
        // 4. Tik skirtukai/tabuliacijos simboliai
        String input = "\t\t";
        assertEquals(0, calculator.getWordsCount(input));
        assertEquals(2, calculator.getCharsCount(input));
    }

    @Test
    public void testOnlySymbols() {
        // 5. Tik simboliai (!@#$%) – laikomi 1 žodžiu pagal dabartinę logiką
        String input = "!@#$$%";
        assertEquals(1, calculator.getWordsCount(input));
        assertEquals(6, calculator.getCharsCount(input));
    }

    @Test
    public void testSymbolsInWords() {
        // 6. Simboliai žodžių viduje
        String input = "He@llo wo#rld";
        assertEquals(2, calculator.getWordsCount(input));
        assertEquals(13, calculator.getCharsCount(input));
    }

    @Test
    public void testMultipleSpacesBetweenWords() {
        // 7. Keli tarpai tarp žodžių
        String input = "Hello   world";
        assertEquals(2, calculator.getWordsCount(input));
        assertEquals(13, calculator.getCharsCount(input));
    }

    @Test
    public void testMixedSpacesAndTabs() {
        // 8. Mišrūs tarpai ir tabuliacijos tarp žodžių
        String input = "Hello \t world";
        assertEquals(2, calculator.getWordsCount(input));
        assertEquals(13, calculator.getCharsCount(input));
    }

    @Test
    public void testSingleLongWord() {
        // 9. Vienas labai ilgas žodis
        String input = new String(new char[1000]).replace('\0', 'a');
        assertEquals(1, calculator.getWordsCount(input));
        assertEquals(1000, calculator.getCharsCount(input));
    }

    @Test
    public void testTextWithNewlines() {
        // 10. Naujos eilutės simbolis tarp žodžių
        String input = "Hello\nworld";
        assertEquals(2, calculator.getWordsCount(input));
        assertEquals(11, calculator.getCharsCount(input));
    }
}
