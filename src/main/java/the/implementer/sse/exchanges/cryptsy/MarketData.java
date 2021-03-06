package the.implementer.sse.exchanges.cryptsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"primaryname", "secondaryname"})
public class MarketData {

    @JsonProperty("marketid")
    private int marketId;

    private String label;

    @JsonProperty("lasttradeprice")
    private BigDecimal lastTradePrice;

    private BigDecimal volume;

    @JsonProperty("lasttradetime")
    private CryptsyDate lastTradeTime;

    @JsonProperty("primarycode")
    private Currency primaryCode;

    @JsonProperty("secondarycode")
    private Currency secondaryCode;

    @JsonProperty("recenttrades")
    private List<PlacedTrade> recentTrades;

    @JsonProperty("sellorders")
    private List<CryptsyOrder> sellOrders;

    @JsonProperty("buyorders")
    private List<CryptsyOrder> buyOrders;

    public int getMarketId() {
        return marketId;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getLastTradePrice() {
        return lastTradePrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public CryptsyDate getLastTradeTime() {
        return lastTradeTime;
    }

    public Currency getPrimaryCurrency() {
        return primaryCode;
    }

    public Currency getSecondaryCurrency() {
        return secondaryCode;
    }

    public List<PlacedTrade> getRecentTrades() {
        return recentTrades;
    }

    public List<CryptsyOrder> getSellOrders() {
        return sellOrders;
    }

    public List<CryptsyOrder> getBuyOrders() {
        return buyOrders;
    }

    public static enum TradeType {
        Buy, Sell;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<CryptsyOrder> buyOrders;
        private List<CryptsyOrder> sellOrders;

        private Builder() { }

        public Builder withBuyOrders(List<CryptsyOrder> buyOrders) {
            this.buyOrders = buyOrders;
            return this;
        }

        public Builder withSellOrders(List<CryptsyOrder> sellOrders) {
            this.sellOrders = sellOrders;
            return this;
        }

        public MarketData build() {
            final MarketData marketData = new MarketData();
            marketData.buyOrders = buyOrders;
            marketData.sellOrders = sellOrders;
            return marketData;
        }
    }

}
