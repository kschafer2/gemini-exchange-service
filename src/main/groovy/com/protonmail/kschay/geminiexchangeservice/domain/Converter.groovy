package com.protonmail.kschay.geminiexchangeservice.domain

import java.text.DecimalFormat
import java.text.ParseException

class Converter {
    static BigDecimal toBigDecimal(String value) {
        DecimalFormat format = new DecimalFormat()
        format.setParseBigDecimal(true)
        try {
            return (BigDecimal) format.parse(value)
        } catch (ParseException ignored) {
            return BigDecimal.ZERO
        }
    }
}
