package com.example.demo;

import com.example.demo.singleton.AClazz;
import com.example.demo.singleton.BClazz;
import com.example.demo.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가? : " + aClient.equals(bClient));
    }
}
