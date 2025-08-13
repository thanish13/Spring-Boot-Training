package com.example.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaDemoRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("kafka:demo?brokers=localhost:29092")
                .routeId("kafka-demo-route")
                .log("Received from Kafka: ${body}")
                .process(exchange -> {
                    String message = exchange.getIn().getBody(String.class);
                    String transformed = "Processed: " + message;
                    exchange.getIn().setBody(transformed);
                })
                .log("Final Output: ${body}");
    }
}
