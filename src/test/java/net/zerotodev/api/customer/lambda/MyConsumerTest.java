package net.zerotodev.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MyConsumerTest {

    @Test
    void main() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 이 Consumer는 java에 있는 라이브러리임
        Consumer<Integer> consumer = System.out::println; // System.out::println => 메소드 참조
        // 파라미터가 없음 -> consumer를 실행하면 list를 print하라는 뜻임

        consumer.accept(56);
        printElements(list, consumer);
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) { // list가 실제로는 실시간으로 넘어오는 메세지/ 앞: 큰 데이터, 뒤: 어떻게 해라
        for(T t: list){
            consumer.accept(t); // 여기다가 sout 쳐도 되는데 모양 학습하기 위해 억지로 만듦
        }
    }
}