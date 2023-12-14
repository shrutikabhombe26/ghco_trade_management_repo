package ghco.trade.GHCOTradeManagement.dto;

public class TradeDTO {
    private String tradeId;
    private String bbgCode;
    private String currency;
    private String side;
    private double price;
    private int volume;
    private String portfolio;
    private String action;
    private String account;
    private String strategy;
    private String user;
    private String tradeTimeUTC;
    private String valueDate;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getBbgCode() {
        return bbgCode;
    }

    public void setBbgCode(String bbgCode) {
        this.bbgCode = bbgCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTradeTimeUTC() {
        return tradeTimeUTC;
    }

    public void setTradeTimeUTC(String tradeTimeUTC) {
        this.tradeTimeUTC = tradeTimeUTC;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public String toString() {
        return "TradeDTO{" +
                "tradeId='" + tradeId + '\'' +
                ", bbgCode='" + bbgCode + '\'' +
                ", currency='" + currency + '\'' +
                ", side='" + side + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", portfolio='" + portfolio + '\'' +
                ", action='" + action + '\'' +
                ", account='" + account + '\'' +
                ", strategy='" + strategy + '\'' +
                ", user='" + user + '\'' +
                ", tradeTimeUTC='" + tradeTimeUTC + '\'' +
                ", valueDate='" + valueDate + '\'' +
                '}';
    }
}