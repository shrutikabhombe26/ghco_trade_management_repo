package ghco.trade.GHCOTradeManagement.services;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import ghco.trade.GHCOTradeManagement.constant.TradeConstants;
import ghco.trade.GHCOTradeManagement.dto.TradeDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerService {

    public static List<TradeDTO> tradeList;

    public static List<TradeDTO> getCSVData() throws Exception {
       if(tradeList == null || tradeList.isEmpty()) {
            return readDataLineByLine(TradeConstants.TRADE_FILE_PATH);
        } else {
            return tradeList;
        }


    }

    public static List<TradeDTO> readDataLineByLine(String file) {
        List<TradeDTO> tradeList = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);

            Map<String, String> mapping = new HashMap<String, String>();
            mapping.put("TradeID", "tradeId");
            mapping.put("BBGCode", "bbgCode");
            mapping.put("Currency", "currency");
            mapping.put("Side", "side");
            mapping.put("Price", "price");
            mapping.put("Volume", "volume");
            mapping.put("Portfolio", "portfolio");
            mapping.put("Action", "action");
            mapping.put("Account", "account");
            mapping.put("Strategy", "strategy");
            mapping.put("User", "user");
            mapping.put("TradeTimeUTC", "tradeTimeUTC");
            mapping.put("ValueDate", "valueDate");

            System.out.println("....................");

            HeaderColumnNameTranslateMappingStrategy<TradeDTO> strategy =
                    new HeaderColumnNameTranslateMappingStrategy<TradeDTO>();
            strategy.setType(TradeDTO.class);
            strategy.setColumnMapping(mapping);

            CsvToBean csvToBean = new CsvToBean();
            csvToBean.setMappingStrategy(strategy);
            csvToBean.setCsvReader(csvReader);

            tradeList = csvToBean.parse();

            for (TradeDTO e : tradeList) {
                System.out.println(e);
            }
        } catch (Exception e) {
            e.getMessage();
        }
            return tradeList;
        }

    public static void writeCsvFile(String filePath, List<TradeDTO> tradeList, Boolean isAppend) throws Exception {
        try (Writer writer = new FileWriter(filePath, isAppend);){
             CSVPrinter csvPrinter = new CSVPrinter(writer,CSVFormat.DEFAULT);
             if(!isAppend){
             csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("TradeID", "BBGCode", "Currency", "Side", "Price", "Volume", "Portfolio", "Action", "Account", "Strategy", "User", "TradeTimeUTC", "ValueDate")) ;

            }

            for (TradeDTO tradeDTO : tradeList) {
                csvPrinter.printRecord(
                        tradeDTO.getTradeId(),
                        tradeDTO.getBbgCode(),
                        tradeDTO.getCurrency(),
                        tradeDTO.getSide(),
                        tradeDTO.getPrice(),
                        tradeDTO.getVolume(),
                        tradeDTO.getPortfolio(),
                        tradeDTO.getAction(),
                        tradeDTO.getAccount(),
                        tradeDTO.getStrategy(),
                        tradeDTO.getUser(),
                        tradeDTO.getTradeTimeUTC(),
                        tradeDTO.getValueDate()
                );
            }
            csvPrinter.flush();
        }
    }
}
