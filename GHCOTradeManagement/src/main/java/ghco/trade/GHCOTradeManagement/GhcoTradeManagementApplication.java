package ghco.trade.GHCOTradeManagement;

import ghco.trade.GHCOTradeManagement.controller.TradeController;

import java.util.Scanner;

public class GhcoTradeManagementApplication {

	public static void main(String[] args) throws Exception {
		TradeController tradeController = new TradeController();
		tradeController.displayMenu();
	}
}
