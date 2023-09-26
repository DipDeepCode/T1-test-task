package ru.ddc.t1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Calculate the number of occurrences of characters in a string",
            description = "Returns map with character as key and number of occurrences as value. " +
                    "Entries in map is sorted by value descending. " +
                    "If the entries have the same value, then they are sorted by key alphabetically.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The result is calculated",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(ref = "#/components/schemas/Map"))
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "The query argument str is not specified",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(ref = "#/components/schemas/BadRequestResponse")
                            )
                    })
    })
    @GetMapping("/calculate")
    public Map<Character, Integer> calculate(
            @Parameter(
                    name = "Input string",
                    description = "The string in which the number of occurrences will be calculated"
            )
            @RequestParam String str) {
        return calculator.getNumberOfOccurrence(str);
    }
}
