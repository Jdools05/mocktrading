package xyz.jdools05.mocktrading.enumerators;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {
    @JsonProperty(value = "buy")
    BUY("buy"),

    @JsonProperty(value = "sell")
    SELL("sell");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }
}
