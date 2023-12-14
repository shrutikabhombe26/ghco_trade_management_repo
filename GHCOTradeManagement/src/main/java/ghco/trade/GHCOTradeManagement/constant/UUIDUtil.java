package ghco.trade.GHCOTradeManagement.constant;

import java.util.UUID;

public class UUIDUtil {
    public static String generateUUId() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().replace("-","");
        System.out.println("Your UUID is: " + uuidAsString);
        return uuidAsString;
    }
}
