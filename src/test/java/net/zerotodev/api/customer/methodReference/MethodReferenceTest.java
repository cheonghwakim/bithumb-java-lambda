package net.zerotodev.api.customer.methodReference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.comparingInt;

public class MethodReferenceTest {
    class MethodReferenceClass {
        Supplier<Date> newDate = Date::new; // 내가 뭘 입력하든 날짜를 return
        Consumer<String> print = System.out::print; // 파라미터를 받아서 그냥 그대로 출력
        Function<Object, String> objectToString = String::valueOf;

        // Integer.parseInt("10") > 10
        Function<String, Integer> stringToInteger = Integer::parseInt;

        // 2개를 받아서 큰 값을 return (2개를 받는다 => BiFunction)
        BiFunction<Integer, Integer, Integer> integerMax = Math::max;

    }

    @Test
    void listSortTest() {
        List<String> list = Arrays.asList("Apple", "Orange", "Kiwi");
        list.sort(comparingInt(String::length));
        list.forEach(System.out::println);
    }
}
