package com.protonmail.kschay.geminiexchangeservice.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Balance {
    Currency currency
    String amount
    String available

    Balance(){}

    Balance(Currency currency) {
        this.currency = currency
        this.amount = "0"
        this.available = "0"
    }
}
