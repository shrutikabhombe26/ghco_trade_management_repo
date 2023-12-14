package ghco.trade.GHCOTradeManagement.services;

import ghco.trade.GHCOTradeManagement.constant.TradeConstants;
import ghco.trade.GHCOTradeManagement.dto.TradeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeCalculateService {

    public void calculateTrade() throws Exception {
        List<TradeDTO> tradeList = ConsumerService.getCSVData();
        if(tradeList.isEmpty()){
            System.out.println("Please check CSV as there are no records");
        }
        Map<String,Double> mapByBBgId = new HashMap<String,Double>();
        for(TradeDTO dto : tradeList){
            if(dto.getAction().equalsIgnoreCase("CANCEL")){
                continue;
            }
            dto.setPrice(convertToUSD(dto.getPrice(),dto.getCurrency()));
            if(mapByBBgId.get(dto.getBbgCode()) == null){
                mapByBBgId.put(dto.getBbgCode(),getPnLAmount(dto));
            } else {
                Double previousAmount = mapByBBgId.get(dto.getBbgCode());
                previousAmount = previousAmount + getPnLAmount(dto);
                mapByBBgId.put(dto.getBbgCode(),previousAmount);
            }

        }
        Double finalPnLAmount = 0.0;
        for (var entry : mapByBBgId.entrySet()) {
            System.out.println(entry.getKey() + "  P/L is " + entry.getValue()+" USD");
            finalPnLAmount = finalPnLAmount + entry.getValue();
        }
        System.out.println("Aggregated Profit and Loss is "+ finalPnLAmount +" USD");

    }

    public Double convertToUSD(Double amount, String currency){
        return (amount * TradeConstants.getCurrencyConversionMap().get(currency));
    }

    public static Double getPnLAmount(TradeDTO dto){
        Double amount = dto.getPrice() * dto.getVolume();
        return (dto.getSide().equalsIgnoreCase("S")) ? amount : (0 - amount);

    }
}
