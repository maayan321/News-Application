package server.finance;

import java.util.ArrayList;
import java.util.List;

public class StockReport {

	private String name;
	private List<StockPrice> history = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StockPrice> getHistory() {
		return history;
	}

	public void setHistory(List<StockPrice> history) {
		this.history = history;
	}

	public void add(StockPrice price) {
		this.history.add(price);
	}

}
