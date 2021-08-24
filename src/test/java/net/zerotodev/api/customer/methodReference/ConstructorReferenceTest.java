package net.zerotodev.api.customer.methodReference;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorReferenceTest {

    @Test
    void main() {
        Function<Runnable, Thread> threadGenerator = Thread::new;
        Runnable t1 = () -> System.out.println("T1 executed");
        Runnable t2 = () -> System.out.println("T2 executed");
        Thread thread1 = threadGenerator.apply(t1);  // function이니까 apply가 바로 나와야 함
        Thread thread2 = threadGenerator.apply(t2);
        thread1.start();
        thread2.start();
        
        // 이게 앞으로 우리가 해야 하는 방식
        threadGenerator
                .apply(() -> System.out.println("T3 executed"))
                .start();
    }
}