package ru.ddc.t1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfOccurrencesCalculatorTest {
    private final NumberOfOccurrencesCalculator calculator = new NumberOfOccurrencesCalculator();

    @Test
    @DisplayName("aaaaabcccc")
    public void test1() {
        String testString = "aaaaabcccc";
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>() {{
            add(Map.entry('a', 5));
            add(Map.entry('c', 4));
            add(Map.entry('b', 1));
        }};

        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        List<Map.Entry<Character, Integer>> actualList = new ArrayList<>(actual.entrySet());

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("lowercase and uppercase")
    public void test2() {
        String testString = "aAbBcCdD***";
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>() {{
            add(Map.entry('*', 3));
            add(Map.entry('A', 1));
            add(Map.entry('B', 1));
            add(Map.entry('C', 1));
            add(Map.entry('D', 1));
            add(Map.entry('a', 1));
            add(Map.entry('b', 1));
            add(Map.entry('c', 1));
            add(Map.entry('d', 1));
        }};

        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        List<Map.Entry<Character, Integer>> actualList = new ArrayList<>(actual.entrySet());

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("cyrillic")
    public void test3() {
        String testString = "вВаАбБгГ";
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>() {{
            add(Map.entry('А', 1));
            add(Map.entry('Б', 1));
            add(Map.entry('В', 1));
            add(Map.entry('Г', 1));
            add(Map.entry('а', 1));
            add(Map.entry('б', 1));
            add(Map.entry('в', 1));
            add(Map.entry('г', 1));
        }};

        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        List<Map.Entry<Character, Integer>> actualList = new ArrayList<>(actual.entrySet());

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("all sorts of characters")
    public void test4() {
        String testString = "~!@#$%^&*()_+Q{}|A:\"Z<>?Ё!\"№;%:?*()_+Й/ФЯ,";
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>() {{
            add(Map.entry('!', 2));
            add(Map.entry('"', 2));
            add(Map.entry('%', 2));
            add(Map.entry('(', 2));
            add(Map.entry(')', 2));
            add(Map.entry('*', 2));
            add(Map.entry('+', 2));
            add(Map.entry(':', 2));
            add(Map.entry('?', 2));
            add(Map.entry('_', 2));
            add(Map.entry('#', 1));
            add(Map.entry('$', 1));
            add(Map.entry('&', 1));
            add(Map.entry(',', 1));
            add(Map.entry('/', 1));
            add(Map.entry(';', 1));
            add(Map.entry('<', 1));
            add(Map.entry('>', 1));
            add(Map.entry('@', 1));
            add(Map.entry('A', 1));
            add(Map.entry('Q', 1));
            add(Map.entry('Z', 1));
            add(Map.entry('^', 1));
            add(Map.entry('{', 1));
            add(Map.entry('|', 1));
            add(Map.entry('}', 1));
            add(Map.entry('~', 1));
            add(Map.entry('Ё', 1));
            add(Map.entry('Й', 1));
            add(Map.entry('Ф', 1));
            add(Map.entry('Я', 1));
            add(Map.entry('№', 1));
        }};

        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        List<Map.Entry<Character, Integer>> actualList = new ArrayList<>(actual.entrySet());

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("UTF8 characters")
    public void test5() {
        String testString = "\u00E1\u00E1\u00E1\u00E1\u00E1\u00E2\u00E2\u00E2\u00B5";
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>() {{
            add(Map.entry('\u00E1', 5));
            add(Map.entry('\u00E2', 3));
            add(Map.entry('\u00B5', 1));
        }};

        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        List<Map.Entry<Character, Integer>> actualList = new ArrayList<>(actual.entrySet());

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("exception when argument is null")
    public void when_argumentIsNull_then_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.getNumberOfOccurrence(null));
    }

    @Test
    @DisplayName("empty map when argument is blanc")
    public void when_argumentIsBlanc_then_returnsEmptyMap() {
        String testString = "";
        LinkedHashMap<Character, Integer> actual = calculator.getNumberOfOccurrence(testString);
        assertTrue(actual.isEmpty());
    }
}
