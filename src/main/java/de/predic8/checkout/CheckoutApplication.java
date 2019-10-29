package de.predic8.checkout;

import de.predic8.checkout.config.RibbonConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@RibbonClient(name = "stock-server", configuration = RibbonConfiguration.class)
public class CheckoutApplication {

	@Bean
	public Map<String, BigDecimal> prices() {
		return new ConcurrentHashMap<>();
	}

	@Bean
	@LoadBalanced
	public RestTemplate rest() { return new RestTemplate();}

	public static void main(String[] args) {
		run(CheckoutApplication.class, args);
	}

}