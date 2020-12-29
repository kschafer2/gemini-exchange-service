package com.protonmail.kschay.geminiexchangeservice;

import com.protonmail.kschay.geminiexchangeservice.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeminiController {
    
    private final GeminiClient geminiClient;

    public GeminiController(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    @GetMapping("/ticker/{symbol}")
    public Ticker getTicker(@PathVariable Symbol symbol) {
        return geminiClient.getTicker(symbol);
    }

    @GetMapping("/balances")
    public List<Balance> getBalances() {
        return geminiClient.getBalances();
    }

    @GetMapping("/fee")
    public Fee getFee() {
        return geminiClient.getFee();
    }

    @PostMapping("/placeOrder")
    public Order placeOrder(ExecuteOrder executeOrder) {
        return geminiClient.placeOrder(executeOrder);
    }

    @GetMapping("/simpleTicker/{symbol}")
    public SimpleTicker getSimpleTicker(@PathVariable Symbol symbol) {
        return geminiClient.getSimpleTicker(symbol);
    }
}
