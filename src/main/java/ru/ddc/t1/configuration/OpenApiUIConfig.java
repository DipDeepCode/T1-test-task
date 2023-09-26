package ru.ddc.t1.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@OpenAPIDefinition
public class OpenApiUIConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Number of occurrences calculator")
                        .description("Calculate the number of occurrences of characters in a string")
                        .version("0.0.1-SNAPSHOT")
                )

                .components(new Components()
                        .addSchemas("Map",
                                new Schema<Map<Character, Integer>>()
                                        .addProperty("a", new ObjectSchema().example(5))
                                        .addProperty("c", new ObjectSchema().example(4))
                                        .addProperty("b", new ObjectSchema().example(1)))
                        .addSchemas("BadRequestResponse",
                                new Schema<Map<String, Object>>()
                                        .addProperty("timestamp", new ObjectSchema().example("2023-09-24T19:56:22.061+00:00"))
                                        .addProperty("status", new ObjectSchema().example(400))
                                        .addProperty("error", new ObjectSchema().example("Bad Request"))
                                        .addProperty("path", new ObjectSchema().example("/occurrence/calculate")))
                );
    }
}
