package com.protonmail.kschay.geminiexchangeservice.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Balance {
    Currency currency
    String amount
    String available
}
