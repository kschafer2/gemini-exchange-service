package com.protonmail.kschay.geminiexchangeservice.domain

class PlaceOrderPayload extends Payload {

    Symbol symbol
    String amount
    String price
    Side side
    String type
    Object[] options

    PlaceOrderPayload(ExecuteOrder executeOrder) {
        super(GeminiEndpoints.NEW_ORDER.uri())

        this.symbol = executeOrder.symbol
        this.amount = executeOrder.amount
        this.price = executeOrder.price
        this.side = executeOrder.side
        this.type = Type.EXCHANGE_LIMIT.displayName
        this.options = List.of(Options.IMMEDIATE_OR_CANCEL.displayName).toArray()
    }
}
