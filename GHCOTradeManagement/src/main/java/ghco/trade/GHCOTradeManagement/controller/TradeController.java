package ghco.trade.GHCOTradeManagement.controller;

import ghco.trade.GHCOTradeManagement.services.TradeOperationService;
import ghco.trade.GHCOTradeManagement.services.TradeCalculateService;
import java.util.*;

public class TradeController {
    Scanner scanner = new Scanner(System.in);
    public void getChoiceFromUser(int operation) throws Exception {
        TradeOperationService tradeOperationService = new TradeOperationService();
        String tradeid;
        boolean exit = false;

        while (!exit) {
            try {
                switch (operation) {
                    case 1:
                        System.out.println("Display all trades from csv");
                        tradeOperationService.displayData();
                        break;
                    case 2:
                        System.out.println("Add trade to csv");
                        tradeOperationService.addDataToCSV();
                        break;
                    case 3:
                        System.out.println("Delete data from csv");
                        System.out.println("Enter the trade id");
                        tradeid = scanner.next();
                        tradeOperationService.deleteDataByTradeId(tradeid);
                        displayMenu();
                        break;
                    case 4:
                        System.out.println("Update data from csv");
                        System.out.println("Enter the trade id");
                        tradeid = scanner.next();
                        tradeOperationService.updateDataById(tradeid);
                        displayMenu();
                        break;
                    case 5:
                        System.out.println("Calculate aggregate trade profit and loss");
                        new TradeCalculateService().calculateTrade();
                        displayMenu();
                        break;
                    case 6:
                        System.out.println("Exiting the trade process.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
            displayMenu();
        }
        scanner.close();
    }

    public void displayMenu() throws Exception {
        System.out.println("Start Trading process");
        System.out.println("Enter the option from below list");
        System.out.println("1 for Display\n2 for Adding new trade\n3 for Deleting trade\n4 for Updating trade\n5 for Calculate Profit and Loss\n6 Exit");
        System.out.println("......................");
        int operation = scanner.nextInt();
        getChoiceFromUser(operation);
    }
}
