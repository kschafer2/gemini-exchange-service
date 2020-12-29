package com.protonmail.kschay.geminiexchangeservice.domain

interface TickerClient {
    Ticker getTicker(Symbol symbol)

    SimpleTicker getSimpleTicker(Symbol symbol)
}