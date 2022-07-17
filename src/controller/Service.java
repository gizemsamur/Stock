package controller;

import java.util.ArrayList;
import java.util.List;

import model.Stock;

public class Service {
	public List<Stock> stocks;

	public Service() {
		stocks = new ArrayList<>();
	}

	public void save(Stock stock) {
		stocks.add(stock);
	}

	public void update(Stock stock) {
		for (int i = 0; i < stocks.size(); i++) {
			Stock stc = stocks.get(i);
			if (stc.getStokKodu().equals(stock.getStokKodu())) {
				stocks.set(i, stock);
				break;
			}
		}
	}

	public void delete(Stock stock) {
		for (int i = 0; i < stocks.size(); i++) {
			Stock stc = stocks.get(i);
			if (stc.getStokKodu().equals(stock.getStokKodu())) {
				stocks.remove(i);
				break;
			}
		}
	}

	public List<Stock> getStocks() {

		return stocks;
	}

}
