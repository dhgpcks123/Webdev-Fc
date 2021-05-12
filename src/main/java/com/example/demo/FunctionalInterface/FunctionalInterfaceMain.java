package com.example.demo.FunctionalInterface;

import java.util.Random;

public class FunctionalInterfaceMain {
    public static void main(String[] args) {
        Random random = new Random();
        int user1 = random.nextInt(10);
        int user2 = random.nextInt(10);
        boolean check = is(()->user1<user2);
        /*
            is라는 메서드는 Functional interface인 Validator를 파라미터로 받고,
            파라미터인 validator는 () -> user < user2를 파라미터로 받는다.
            여기서 바로 행위도 값으로 취급할 수 있다는 걸 이애할 수 있는데.
            ()->user1<user2는 행위(함수)인데 넣어줄 수 있었다.

            또한 is(()->user1<user2) is(()->user1=user2)  is(()->user1+user2> 10)이렇게도 사용할 수 있다
            여기서 우리는 Validator, is를 재사용할 수 있다는 것을 알 수 있다.

            Validator... 수식 자체를 받아와서 그걸 체크하고 true나 false를 반환해준다.
            Validator 함수형인터페이스. 함수처럼..
        */
        //이렇게도 쓸 수 있다.
        Validator validator = () -> user1<user2;
        validator.test();
        //is 정의안하고 그냥 넣어서 쓸 수도 있음.

        //+ stream을 사용할 때 자주 사용하던 filter도 Functional interface이다,
        //users.stream().filter.(user->"티거".equals(user));
        /*
            패키지의 Functional Interface
            자바 패키지에서 제공하는 Functional Interface 중 몇 가지만 살펴보자.
            Supplier<T> 매개변수 없음, 리턴 타입 T
            Consumer<T> 매개변수 T, 리턴 타입 없음
            Predicate<T> 매개변수T, 리턴 타입 boolean
            Function<T, R> 매개변수 T, 리턴 타입 R
            오오오잉...
         */

    }

    public static boolean is(Validator validator){
        return validator.test();
    }



}
