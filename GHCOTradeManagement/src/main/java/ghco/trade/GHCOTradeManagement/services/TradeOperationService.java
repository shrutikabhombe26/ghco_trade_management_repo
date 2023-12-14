package ghco.trade.GHCOTradeManagement.services;

import ghco.trade.GHCOTradeManagement.constant.TradeConstants;
import ghco.trade.GHCOTradeManagement.constant.UUIDUtil;
import ghco.trade.GHCOTradeManagement.dto.TradeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ghco.trade.GHCOTradeManagement.services.ConsumerService.writeCsvFile;

public class TradeOperationService {
    Scanner scanner = new Scanner(System.in);
    public void displayData() throws Exception {

        System.out.println("Reading csv data");
        ConsumerService.getCSVData();

    }

    public void addDataToCSV() throws Exception {
        System.out.println("Add the below values for creating new trade entry. Leave it blank and press enter if you want to skip it.");
        System.out.println();
        Boolean tradeIdMatched = false;
        System.out.print("BBGCode : ");
        scanner = new Scanner(System.in);
        String BBGCode = scanner.nextLine();
        System.out.print("Currency : ");
        String Currency = scanner.nextLine();
        System.out.print("Side : ");
        String Side = scanner.nextLine();
        System.out.print("Price : ");
        String Price = scanner.nextLine();
        System.out.print("Volume : ");
        String Volume = scanner.nextLine();
        System.out.print("Portfolio : ");
        String Portfolio = scanner.nextLine();
        System.out.print("Account : ");
        String Account = scanner.nextLine();
        System.out.print("Strategy : ");
        String Strategy = scanner.nextLine();
        System.out.print("User : ");
        String User = scanner.nextLine();
        System.out.print("TradeTimeUTC : ");
        String TradeTimeUTC = scanner.nextLine();
        System.out.print("ValueDate : ");
        String ValueDate = scanner.nextLine();

        TradeDTO tradeDTO = new TradeDTO();
        tradeDTO.setTradeId(UUIDUtil.generateUUId());
        tradeDTO.setBbgCode(BBGCode);
        tradeDTO.setCurrency(Currency);
        tradeDTO.setSide(Side);
        tradeDTO.setPrice(Double.parseDouble(Price));
        tradeDTO.setVolume(Integer.parseInt(Volume));
        tradeDTO.setPortfolio(Portfolio);
        tradeDTO.setAccount(Account);
        tradeDTO.setStrategy(Strategy);
        tradeDTO.setUser(User);
        tradeDTO.setTradeTimeUTC(TradeTimeUTC);
        tradeDTO.setValueDate(ValueDate);
        tradeDTO.setAction("NEW");
        System.out.println("Creating for "+tradeDTO.getTradeId());
        List<TradeDTO> tradeList = new ArrayList<>();
        tradeList.add(tradeDTO);
        writeCsvFile(TradeConstants.TRADE_FILE_PATH, tradeList,true);
        System.out.println("New Trade entry added successfully "+ tradeDTO.toString());
    }

    public void updateDataById(String tradeId) throws Exception {
        System.out.println("Update the below values. Leave it blank and press enter if you want to skip it.");
        System.out.println();
        System.out.print("BBGCode : ");
        scanner = new Scanner(System.in);
        String BBGCode = scanner.nextLine();
        System.out.print("Currency : ");
        String Currency = scanner.nextLine();
        System.out.print("Side : ");
        String Side = scanner.nextLine();
        System.out.print("Price : ");
        String Price = scanner.nextLine();
        System.out.print("Volume : ");
        String Volume = scanner.nextLine();
        System.out.print("Portfolio : ");
        String Portfolio = scanner.nextLine();
        System.out.print("Account : ");
        String Account = scanner.nextLine();
        System.out.print("Strategy : ");
        String Strategy = scanner.nextLine();
        System.out.print("User : ");
        String User = scanner.nextLine();
        System.out.print("TradeTimeUTC : ");
        String TradeTimeUTC = scanner.nextLine();
        System.out.print("ValueDate : ");
        String ValueDate = scanner.nextLine();

        TradeDTO tradeDTO = new TradeDTO();
        tradeDTO.setBbgCode(BBGCode);
        tradeDTO.setCurrency(Currency);
        tradeDTO.setSide(Side);
        tradeDTO.setPrice(Double.parseDouble(Price));
        tradeDTO.setVolume(Integer.parseInt(Volume));
        tradeDTO.setPortfolio(Portfolio);
        tradeDTO.setAccount(Account);
        tradeDTO.setStrategy(Strategy);
        tradeDTO.setUser(User);
        tradeDTO.setTradeTimeUTC(TradeTimeUTC);
        tradeDTO.setValueDate(ValueDate);

        System.out.println("Searching for "+tradeId);
        List<TradeDTO> tradeList = ConsumerService.getCSVData();
        System.out.println("Trade list size"+tradeList.size());
        Boolean needsUpdate = false;
        for (TradeDTO trade : tradeList) {
            if(trade.getTradeId().equalsIgnoreCase(tradeId)) {
                System.out.println("Match Found "+trade);
                if ((tradeDTO.getBbgCode() != null && tradeDTO.getBbgCode() != "")) {
                    trade.setBbgCode(tradeDTO.getBbgCode());
                }
                if ((tradeDTO.getCurrency() != null && tradeDTO.getCurrency() != "")) {
                    trade.setCurrency(tradeDTO.getCurrency());
                }
                if ((tradeDTO.getUser() != null && tradeDTO.getUser() != "")) {
                    trade.setUser(tradeDTO.getUser());
                }
                if ((String.valueOf(tradeDTO.getPrice()) != null && (String.valueOf(tradeDTO.getPrice())) != "")) {
                    trade.setPrice(tradeDTO.getPrice());
                }
                if ((tradeDTO.getStrategy() != null && tradeDTO.getStrategy() != "")) {
                    trade.setStrategy(tradeDTO.getStrategy());
                }
                if ((tradeDTO.getSide() != null && tradeDTO.getSide() != "")) {
                    trade.setSide(tradeDTO.getSide());
                }
                if ((tradeDTO.getValueDate() != null && tradeDTO.getValueDate() != "")) {
                    trade.setValueDate(tradeDTO.getValueDate());
                }
                if ((String.valueOf(tradeDTO.getVolume()) != null && String.valueOf(tradeDTO.getVolume()) != "")) {
                    trade.setVolume(tradeDTO.getVolume());
                }
                if ((tradeDTO.getAccount() != null && tradeDTO.getAccount() != "")) {
                    trade.setAccount(tradeDTO.getAccount());
                }
                if ((tradeDTO.getTradeTimeUTC()!= null && tradeDTO.getTradeTimeUTC() != "")) {
                    trade.setTradeTimeUTC(tradeDTO.getTradeTimeUTC());
                }
                if ((tradeDTO.getPortfolio()!= null && tradeDTO.getPortfolio() != "")) {
                    trade.setPortfolio(tradeDTO.getPortfolio());
                }
                trade.setAction("AMEND");
                needsUpdate = true;
                break;
            }
        }
        if(needsUpdate) {
            writeCsvFile(TradeConstants.TRADE_FILE_PATH, tradeList,false);
            System.out.println("Trade Updated Successfully");
        } else {
            System.out.println("No match found.Please check reference id.");
        }


    }

    public void deleteDataByTradeId(String tradeId) throws Exception {
        System.out.println("Cancelling trade for "+tradeId);
        List<TradeDTO> tradeList = ConsumerService.getCSVData();
        System.out.println("Trade list size"+tradeList.size());
        Boolean needsUpdate = false;
        for (TradeDTO trade : tradeList) {
            if(trade.getTradeId().equalsIgnoreCase(tradeId)) {
                System.out.println("Match Found.... "+trade);
                if(!trade.getAction().equalsIgnoreCase("CANCEL")) {
                    trade.setAction("CANCEL");
                    writeCsvFile(TradeConstants.TRADE_FILE_PATH, tradeList,false);
                    System.out.println("Deleted Successfully");
                    needsUpdate = true;
                    break;
                } else {
                    needsUpdate = true;
                    System.out.println("Trade is already Cancelled. No need to cancel it again.");
                }
            }
        }
        if(!needsUpdate) {
            System.out.println("No match found.Please check reference id.");
        }
    }
}
