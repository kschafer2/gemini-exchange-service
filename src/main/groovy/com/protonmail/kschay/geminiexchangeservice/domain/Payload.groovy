package com.protonmail.kschay.geminiexchangeservice.domain

class Payload {
    String request
    String nonce = System.currentTimeMillis().toString()

    Payload(final String request) {
        this.request = request
    }
}
