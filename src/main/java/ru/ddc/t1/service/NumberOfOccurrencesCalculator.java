package ru.ddc.t1.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;

@Service
public class NumberOfOccurrencesCalculator {

    public LinkedHashMap<Character, Integer> getNumberOfOccurrence(String str) {
        if (str != null) {
            return str.chars()
                    .mapToObj(value -> (char) value)
                    .collect((Supplier<Map<Character, Integer>>) HashMap::new,
                            (map, c) -> map.merge(c, 1, Integer::sum),
                            (map1, map2) -> {
                            })
                    .entrySet()
                    .stream()
                    .sorted((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
                            o1.getKey() - o2.getKey() :
                            o2.getValue() - o1.getValue())
                    .collect(LinkedHashMap::new,
                            (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                            (map1, map2) -> {
                            });
        } else {
            throw new IllegalArgumentException("Argument should be not null");
        }
    }
}
