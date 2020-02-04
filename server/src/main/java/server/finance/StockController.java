package server.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class StockController {

	@Autowired
	private StockService service;

	@RequestMapping("/finance/stock")
	public ResponseEntity<StockReport> getStockReport(@RequestParam(defaultValue = "4") int hours) {
		StockReport report = service.getStockReport(hours);
		return ResponseEntity.ok().body(report);
	}
}
