package com.example.demo.aop;

import com.example.demo.proxy.Html;
import com.example.demo.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    //AOP의 특징 전, 후의 메소드가 있다.
    private String url;
    private Html html;
    //앞과 뒤를 체크해보자.
    private Runnable before;
    private Runnable after;
    //들어가보면 @FunctionalInterface가 적혀있다.
    //    public abstract void run();
    // @FunctionalInterface는 하나의 메서드만 가지고 있는 인터페이스를 말한다.
    // 부적절한 메서드를 추가하거나 다른 인터페이스를 상속받으면 컴파일 에러 발생!
    // 얘는 꼭 하나의 메서드만!!!!!!! 왜 필요할까?
    // 함수형 개발 방식은 행위에 해당하는 부분도 값으로 취급 가능하다.
    // JS에서 함수도 변수에 담아서 넘기는 게 가능했던 것과 비슷한 말인가?
    // 자바에서 의미하는 기본형의 데이터 Integer나 String만 값이 아니라 행위(로직)-함수도
    // 값으로 취급할 수 있게 되었다는 이야기.
    // Java 8 부터 함수형 메서드를 사용할 수 있게 해줬음. @FunctionalInterface
    // -> 예제는 FunctionalInterface 패키지를 보자. 봐도 잘 모루겠당...

    public AopBrowser(String url, Runnable before, Runnable after){
        this.url =url;
        this.before = before;
        this.after = after;
    }
    @Override
    public Html show() {
        before.run();
        if(html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : "+ url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        after.run();
        System.out.println("AopBrowser html cache : " + url);
        return html;
    }
}
