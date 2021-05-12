package com.example.demo.atomicLong;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongPrac {

    public static void main(String[] args) {
        AtomicLong atomic = new AtomicLong();
        System.out.println("atomic = " + atomic);
        //초기값이 0인 AtomicLong을 생성한다.
        AtomicLong atomic2 = new AtomicLong(10);
        System.out.println("atomic2 = " + atomic2);
        //인자의 값으로 초기화 된 AtomicLong을 생성

        //get(), set(), getAndSet()
        //
    }
}
