package ma.irisi.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GetwayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GetwayApplication.class, args);
	}
	@Bean
	 public RouteLocator customRouteLocator(RouteLocatorBuilder builder)  {
	 return builder.routes()
	  .route("path_route", r -> r.path("/Commandes/**").uri("http://localhost:8092"))
	  .route("path_route", r -> r.path("/CommandeItems/**").uri("http://localhost:8095"))
	  .build();
	 }
}