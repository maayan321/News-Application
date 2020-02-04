package server.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockSimulator simulator;

	public StockReport getStockReport(int hours) {
		return simulator.generateStockReport(hours);
	}

}
