package com.example.demo;

import com.example.demo.adapter.*;
import com.example.demo.singleton.AClazz;
import com.example.demo.singleton.BClazz;
import com.example.demo.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {
/*
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가? : " + aClient.equals(bClient));
 */
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
//        connect(cleaner); // 220V -> 110V로 바꿔줘야 해. 어댑터를 만들어보자!

        //어댑터를 하나 사옵니다.
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
