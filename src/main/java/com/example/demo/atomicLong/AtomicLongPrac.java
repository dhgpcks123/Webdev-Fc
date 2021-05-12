package com.example.demo.atomicLong;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;

public class AtomicLongPrac {

    public static void main(String[] args) {
        AtomicLong atomic = new AtomicLong();
        System.out.println("atomic = " + atomic);
        //초기값이 0인 AtomicLong을 생성한다.
        AtomicLong atomic2 = new AtomicLong(10);
        System.out.println("atomic2 = " + atomic2);
        //인자의 값으로 초기화 된 AtomicLong을 생성

        //get(), set(), getAndSet()
        //AtomicLong값을 변경하려면 set(newValue) 메소드, 읽으러면 get을 써야한다.
        //getAndSet(newValue)는 현재 설정된 값을 리턴하고 새로운 값으로 업데이트 한다.
        AtomicLong atomic3 = new AtomicLong();
        atomic3.set(300);
        System.out.println(atomic3.get());
        System.out.println(atomic3.getAndSet(500));
        System.out.println(atomic3.get());

        //getAndUpdate, updateAndGet();
        //이건 getAndSet과 다르네. 두번 째 인자에 람다식을 전달할 수 있어서, 함수로 값을 변경할 수 있다.! 포인트네 함수로! 값 변경가능!
        //람다식 전달할 수 있단 말은.. 내부가 FunctionalInterface... 쓰는 곳이 있다는 말인가?

        AtomicLong atom = new AtomicLong(10);
        LongUnaryOperator square = (n)->n*n;
        //뭐야 LongUnaryOperator 이런 것도 있구나?
        System.out.println(atomic.getAndUpdate(square));
        //get으로 10 가지고 와서 이걸 squre 전달해서 거기다가 10값을 넣어줘서 10* 10 -> 100? .. 뭐야 이 js같은 문법은?
        AtomicLong atom2 = new AtomicLong(5);
        System.out.println(atom2.updateAndGet(square));

        //외에도 getAndIncrement ++해주는것과 getAndAdd() 현재 값에 value 값 더하는 것도 있다.
        //Decrement도 있겠지? getAndDecrement()

        //compareAndSet()
        //compareAndSet(expect, update) 기대하는 값과 동일하면 업데이트 해주고 true 반환
        //기대하는 값과 다르면 업데이트x false 반환
        System.out.println("----------------------------------");
        AtomicLong cpAt = new AtomicLong(10);
        boolean b = cpAt.compareAndSet(10, 30);
        System.out.println(b); //true
        System.out.println(cpAt.get()); // 30
        boolean b1 = cpAt.compareAndSet(25, 10);
        System.out.println(b1); //false
        System.out.println(cpAt.get()); // 30
    }
}
