package com.protonmail.kschay.geminiexchangeservice.domain;

public interface OrderClient {

    Order placeOrder(ExecuteOrder executeOrder);
}
