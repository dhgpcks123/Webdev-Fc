package com.example.demo;

import com.example.demo.adapter.*;
import com.example.demo.aop.AopBrowser;
import com.example.demo.decorator.*;
import com.example.demo.facade.Ftp;
import com.example.demo.facade.Reader;
import com.example.demo.facade.SftpClient;
import com.example.demo.facade.Writer;
import com.example.demo.observer.Button;
import com.example.demo.observer.IButtonListener;
import com.example.demo.proxy.Browser;
import com.example.demo.proxy.BrowserProxy;
import com.example.demo.proxy.IBrowser;
import com.example.demo.singleton.AClazz;
import com.example.demo.singleton.BClazz;
import com.example.demo.singleton.SocketClient;
import com.example.demo.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        //Strategy패턴
        Encoder encoder = new Encoder();
        //base64
        EncodingStrategy base64 = new Base64Strategy();
        //normal
        EncodingStrategy normal = new NomalStrategy();

        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println("base64Result = " + base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println("normalResult = " + normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println("appendResult = " + appendResult);
        /*
       //파사드 패턴 적용 전!
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDictory();
        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();
        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();
         */
        //파사드 패턴 적용 후!
        /*
        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
         */

        //옵저버 패턴
        /*
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");
         */


        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */
        /*
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        //캐싱 된 결과만 보여준다. 약간 싱글톤이랑 좀 비슷한 구조처럼 생겼네.
        //프록시 패턴이라고 함. 없으니까 new하고 한번 하고 나면 계속 있으니까 있는 것 계속 줌.
        */

        //프록시 패턴으로 하는 AOP
        //특정 메서드 전 후로, 특정 request. 전 후로 기능을 넣게 도와주는 게 AOP
        //비슷한 걸로는 인터셉터가 있는 것 같다.
        //스프링 AOP말고 프록시패턴으로 AOP를 만들 수 있다.
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        /*
            AtomicLong은 Long 자료형을 갖고 있는 Wrapping클래스 이다.
            Thread-safe로 구현되어 있어 멀티쓰레드에서 synchronized 없이 사용할 수 있다. 또한 synchronized보다 적은 비용으로 동시성을 보장할 수 있다.
            ...어 그러면 Long Wrapper클래스가 있는데 +동시성 문제 해결한 랩퍼 클래스인가? AtomicLong
            어 그런가보다 Atomic 인티져, 불리언 등등도 다 있네!
            --> AtomicLong... 한번 보기나 하자
         */

        /*
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    System.out.println("after");
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
            );
        aopBrowser.show();
        System.out.println("loading time : "+end.get());
        aopBrowser.show();
        System.out.println("loading time : "+end.get());
         */

        /*
        ICar audi = new Audi(1000);
        audi.showPrice();
        //a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        //a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
         */
        //데코레이터! 기본적인 뼈대는 건드리지 않고, 부가적인 걸 추가하는 것!
    }
}
