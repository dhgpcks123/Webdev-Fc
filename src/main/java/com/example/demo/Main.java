package com.example.demo;

import com.example.demo.adapter.*;
import com.example.demo.aop.AopBrowser;
import com.example.demo.proxy.Browser;
import com.example.demo.proxy.IBrowser;
import com.example.demo.singleton.AClazz;
import com.example.demo.singleton.BClazz;
import com.example.demo.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        //BrowserProxy를 활용한 cache기능!
        IBrowser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loding time : " + end.get());
        aopBrowser.show();
        System.out.println("loding time : " + end.get());
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
