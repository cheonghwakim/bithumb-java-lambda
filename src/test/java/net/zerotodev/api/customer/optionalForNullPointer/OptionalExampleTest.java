package net.zerotodev.api.customer.optionalForNullPointer;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OptionalExampleTest {

    @Data class Address {
        private final String street;
        private final String city;
        private final String zipcode;
    }

    @Data class Member {
        private final Long id;
        private final String name;
        private final Address address;
    }

    @Data class Order {
        private final Long id;
        private final Date date;
        private final Member member;
    }

    /* 주문을 한 회원이 살고 있는 도시를 반환한다. */
    public String getCityOfMemberFromOrder(Order order){
        return Optional.ofNullable(order)
                .map(Order::getMember) // Member까지 옴
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("Seoul");  // Null이면 Seoul로 대체
    }

    /* 주어진 시간(분) 내에 생성된 주문을 한 경우에만 해당 회원 정보를 반환한다. */ // -> 회원을 반환 (객체!)
    public Optional<Member> getMemberIfOrderWithin(Order order, int min){
        // 바로 return 때려버리는 이유: ex. 바로 int a = 3; 처럼 변수 선언 해버리면 스택을 잡아먹음. 
        // 메모리 스택 잡아먹지 않고 바로 return하기 위함
        return Optional.ofNullable(order)
                .filter(o -> o.getDate().getTime() > System.currentTimeMillis() - min * 1000) // 걸러낸다 => filter
                .map(Order::getMember);
    }

    @Test
    void optionalMethodTest() {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a); // optional은 a가 아님. 랩핑되어 있는 상태 (ex. 택배박스)
        Integer integerValue = optional.get(); // 택배박스는 한 번 오픈해서 버려야 함

        assertThat(integerValue, is(equalTo(10)));

        Optional<Integer> emptyOptional = Optional.empty(); // 빈 상자는 null은 아님 (비어있는 개념) (Optional은 Container 개념이라고 생각하면 됨)
        Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        assertThat(val, is(equalTo(0)));

        Integer orElse =  emptyOptional.orElse(0); // 단위 값이면 얘를
        assertThat(orElse, is(equalTo(0)));

        Integer orElseGet = emptyOptional.orElseGet(() -> 0); // 연산이 들어가면 얘를 사용
        assertThat(orElseGet, is(equalTo(0)));

    }
}
