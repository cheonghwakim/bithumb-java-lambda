package net.zerotodev.api.customer.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {
    @DisplayName("Stream isEmpty() Count")
    @Test
    void streamIsEmptyTest() {
        Stream<String> stream = Arrays.asList("Apple", "Orange", "").stream(); // 문자열인데 끊임없이 흐른다. (.stream()을 붙이면 Apple, Orange, "" 값이 반복해서 끊임없이 흐른다.)
        // .stream()을 안 붙이면 blocking 붙이면 non blocking

        // String.isEmpty()
        int emptyStrings = (int) stream.filter(String::isEmpty).count();

        assertThat(emptyStrings, is(equalTo(1)));
    }
}
