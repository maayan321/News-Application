package server.finance;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class StockSimulator {

	private static final String[] NAMES = { "Google", "Amazon", "Apple", "Facebook", "Microsoft", "Intel", "IBM" };

	private Random rand = new Random();

	public StockReport generateStockReport(int hours) {
		int index = rand.nextInt(NAMES.length);
		String name = NAMES[index];
		StockReport report = new StockReport();
		report.setName(name);
		generatePriceHistory(report, hours);
		return report;
	}

	private void generatePriceHistory(StockReport report, int hours) {
		LocalDateTime now = LocalDateTime.now();
		int basePrice = 100 + rand.nextInt(100);
		int lastPrice = basePrice;
		int hour = now.getHour();
		int minute = now.getMinute();
		for (int h = hour - hours; h <= hour; h++) {
			for (int m = 0; m < 60; m += 5) {
				if (h == hour && m > minute) {
					break;
				}
				StockPrice price = new StockPrice();
				price.setHour(h);
				price.setMinute(m);
				int change = rand.nextInt(5);
				if (rand.nextBoolean()) {
					lastPrice += change;
				} else {
					lastPrice -= change;
				}
				if (lastPrice < 0) {
					lastPrice = 0;
				}
				price.setPrice(lastPrice);
				report.add(price);
			}
		}
	}

}
