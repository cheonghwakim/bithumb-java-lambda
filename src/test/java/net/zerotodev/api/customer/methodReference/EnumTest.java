package net.zerotodev.api.customer.methodReference;

import java.util.function.DoubleBinaryOperator;

public class EnumTest { // Enum: 열거할 때 사용

    private final String symbole; // final을 붙이면
    private final DoubleBinaryOperator op;

    enum Opperation{
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        TIMES("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);
    }
}
