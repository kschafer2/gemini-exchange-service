package com.protonmail.kschay.geminiexchangeservice

import com.fasterxml.jackson.databind.ObjectMapper
import com.protonmail.kschay.geminiexchangeservice.domain.*
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

import javax.crypto.Mac

import static com.protonmail.kschay.geminiexchangeservice.domain.GeminiEndpoints.*

@Component
class GeminiClientImpl extends GeminiPrivateClient implements GeminiClient {

    GeminiClientImpl(GeminiProperties geminiProperties,
                     WebClient webClient,
                     ObjectMapper objectMapper,
                     Mac mac) {
        super(geminiProperties, webClient, objectMapper, mac)
    }

    @Override
    List<Balance> getBalances() {
        return postForFlux(new Payload(GET_AVAILABLE_BALANCES.uri()), Balance.class) as List<Balance>
    }

    @Override
    Fee getFee() {
        return postForMono(new Payload(GET_NOTIONAL_VOLUME.uri()), Fee.class) as Fee
    }

    @Override
    Order placeOrder(final ExecuteOrder executeOrder) {
        return postForMono(new PlaceOrderPayload(executeOrder), Order.class) as Order
    }

    @Override
    Ticker getTicker(final Symbol symbol) {
        return getForMono(GET_TICKER.uri() + symbol, Ticker.class) as Ticker
    }

    @Override
    SimpleTicker getSimpleTicker(final Symbol symbol) {
        return getForMono(GET_SIMPLE_TICKER.uri() + symbol, SimpleTicker.class) as SimpleTicker
    }
}
