package de.predic8.checkout.api;

import de.predic8.checkout.service.CheckStockCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class CheckStockCountController {

  @Autowired
  CheckStockCountService checkStockCountService;

  @GetMapping
  public String getStockCount() {
    return checkStockCountService.getStockCount();
  }

}
