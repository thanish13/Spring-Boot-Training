package org.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("Microservice1",r->r.path("/serviceA/**")
                        .uri("http://localhost:8081/"))
                .route("Microservice2",r->r.path("/serviceB/**")
                        .uri("http://localhost:8082/")).build();
    }
}
