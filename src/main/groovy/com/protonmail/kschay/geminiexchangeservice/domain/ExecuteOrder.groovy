package com.protonmail.kschay.geminiexchangeservice.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import java.math.RoundingMode

import static Converter.toBigDecimal
import static com.protonmail.kschay.geminiexchangeservice.domain.Side.BUY

@JsonIgnoreProperties(ignoreUnknown = true)
class ExecuteOrder {
    Symbol symbol
    String amount
    Fee fee
    String price
    Side side
    String type
    Object[] options

    void convertAmount() {
        if(side == null || price == null || toBigDecimal(price) <= BigDecimal.ZERO) {
            return
        }
        amount = calculateAmount(deductTakerFee(amount).toPlainString())
    }

    boolean amountIsBelowTradeMinimum() {
        return toBigDecimal(amount) < symbol.base().tradeMinimum
    }

    private String calculateAmount(String value) {
        return toBigDecimal(value)
                .divide(toBigDecimal(price), 8, RoundingMode.DOWN)
                .toPlainString()
    }

    private BigDecimal deductTakerFee(String value) {
        return toBigDecimal(value)
                .divide(getMultiplier(fee.takerFeeBps), scale, RoundingMode.DOWN)
    }

    private static BigDecimal getMultiplier(final Integer bpsFee) {
        def multiplier = BigDecimal.ONE.add(toDecimal(bpsFee))
        return multiplier
    }

    private static BigDecimal toDecimal(final Integer bpsFee) {
        def decimal = BigDecimal.valueOf(bpsFee)
                .divide(BigDecimal.valueOf(10000))
        return decimal
    }

    private Integer getScale() {
        if(symbol.quote() == Currency.USD && side == BUY) return 2
        return 8
    }
}
