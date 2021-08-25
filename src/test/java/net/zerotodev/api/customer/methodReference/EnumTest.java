package net.zerotodev.api.customer.methodReference;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import java.util.function.DoubleBinaryOperator;

public class EnumTest { // Enum: 열거할 때 사용

    @RequiredArgsConstructor // 생성자를 만듦 => 밑의 final이 붙여진 symbol과 op를 사용해서 (lombok 공부하기!)
    enum Operation {

        PLUS("+", (x, y) ->  x + y),
        MINUS("-", (x, y) ->  x - y),
        TIMES("*", (x, y) ->  x * y),
        DIVIDE("/", (x, y) ->  x / y);

        private final String symbol;
        private final DoubleBinaryOperator op;

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {return op.applyAsDouble(x, y);} // 함수 명은 apply라고 정해져있음

    }

    @DisplayName("Enum 을 테스트한다!")
    @Test
    void enumTest() {
        assertThat(Operation.PLUS.apply(5, 7), is(equalTo(12.0)));
        assertThat(Operation.MINUS.apply(5, 7), is(equalTo(-2.0)));
        assertThat(Operation.TIMES.apply(5, 7), is(equalTo(35.0)));
        assertThat(Operation.DIVIDE.apply(10, 5), is(equalTo(2.0)));
    }
}
