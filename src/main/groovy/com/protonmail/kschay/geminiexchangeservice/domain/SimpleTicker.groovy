package com.protonmail.kschay.geminiexchangeservice.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class SimpleTicker {
    String ask
    String bid
}
