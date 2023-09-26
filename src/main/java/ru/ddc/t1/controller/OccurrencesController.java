package ru.ddc.t1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ddc.t1.service.NumberOfOccurrencesCalculator;

import java.util.Map;

@RestController
@RequestMapping("/occurrence")
public class OccurrencesController {

    private final NumberOfOccurrencesCalculator calculator;

    public OccurrencesController(NumberOfOccurrencesCalculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/calculate")
    public Map<Character, Integer> calculate(@RequestParam String str) {
        return calculator.getNumberOfOccurrence(str);
    }
}
