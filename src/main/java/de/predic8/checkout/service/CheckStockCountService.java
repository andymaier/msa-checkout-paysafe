package de.predic8.checkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckStockCountService {

  @Autowired
  RestTemplate restTemplate;

  public String getStockCount() {
    String port = restTemplate.getForObject("http://stock-server/stocks/port", String.class);
    System.out.println("port = " + port);
    return port;
  }

}
