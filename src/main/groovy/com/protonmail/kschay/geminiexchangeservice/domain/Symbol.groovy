package com.protonmail.kschay.geminiexchangeservice.domain

enum Symbol {
    BTCUSD,
    ETHUSD,
    ETHBTC,
    ZECUSD,
    ZECBTC,
    ZECETH,
    ZECBCH,
    ZECLTC,
    BCHUSD,
    BCHBTC,
    BCHETH,
    LTCUSD,
    LTCBTC,
    LTCETH,
    LTCBCH,
    BATUSD,
    DAIUSD,
    OXTUSD,
    BATBTC,
    DAIBTC,
    LINKBTC,
    OXTBTC,
    BATETH,
    DAIETH,
    LINKETH,
    OXTETH,
    LINKUSD

    Currency base() {
        final def symbolString = toString()

        if(symbolString.length() == 6) {
            return Currency.valueOf(symbolString.substring(0, 3))
        }
        else if(symbolString.length() == 7) {
            try {
                return Currency.valueOf(symbolString.substring(0, 4))
            } catch(IllegalArgumentException ignored) {
                return Currency.valueOf(symbolString.substring(0, 3))
            }
        }
        return null
    }

    Currency quote() {
        final def symbolString = toString()

        if(symbolString.length() == 6) {
            return Currency.valueOf(symbolString.substring(3))
        }
        else if(symbolString.length() == 7) {
            try {
                return Currency.valueOf(symbolString.substring(4))
            } catch(IllegalArgumentException ignored) {
                return Currency.valueOf(symbolString.substring(3))
            }
        }
        return null
    }
}