package com.example.demo.strategy;

public class NomalStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return text;
    }
}
