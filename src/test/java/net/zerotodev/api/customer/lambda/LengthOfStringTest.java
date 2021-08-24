package net.zerotodev.api.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfStringTest {

    @Test // 테스트코드는 퍼포먼스 떨어지는 코드 작성해도 됨
    void main() {
        LengthOfString len = str -> {
            int l = str.length();
            System.out.println("The length of the given String is " + l);
            return l;
        };
        assertThat(len.main("Bithumb"), is(equalTo(7)));
    }
}