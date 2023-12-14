package ghco.trade.GHCOTradeManagement.constant;

import java.util.HashMap;
import java.util.Map;

public class TradeConstants {

    public static final String TRADE_FILE_PATH = "src/main/resources/sample_trades.csv";

    public static  Map<String, Double> CURRENCY_CONVERSION_MAP;
    public static Map<String, Double> getCurrencyConversionMap() {
        if(CURRENCY_CONVERSION_MAP == null){
            CURRENCY_CONVERSION_MAP = new HashMap<String, Double>();
            CURRENCY_CONVERSION_MAP.put("GBP",1.26);
            CURRENCY_CONVERSION_MAP.put("INR",0.012);
            CURRENCY_CONVERSION_MAP.put("EUR",1.09);
            CURRENCY_CONVERSION_MAP.put("JPY",0.0070);
            CURRENCY_CONVERSION_MAP.put("KRW",0.00077);
            CURRENCY_CONVERSION_MAP.put("NOK",0.093);
            CURRENCY_CONVERSION_MAP.put("USD",1.0);
        }
        return CURRENCY_CONVERSION_MAP;
    }
}
