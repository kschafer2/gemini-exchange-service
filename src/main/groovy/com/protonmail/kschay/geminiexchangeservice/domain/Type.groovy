package com.protonmail.kschay.geminiexchangeservice.domain

enum Type {
    EXCHANGE_LIMIT("exchange limit")

    String displayName

    private Type(String displayName) {
        this.displayName = displayName
    }
}