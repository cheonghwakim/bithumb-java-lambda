package net.zerotodev.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class myPredicateTest {

    @Test
    void main() {
        List<String> list = new ArrayList<>();
        list.add("Bithumb"); // !empty
        list.add("");
        list.add("KakaoTalk");
        list.add("");
        list.add("Bitcamp");

        Predicate<String> predicate = s -> !s.isEmpty(); // 값이 있는 것을 return해라

        List<String> newList = filterList(list, predicate);

        assertThat(newList, is(equalTo(Arrays.asList("Bithumb", "KakaoTalk", "Bitcamp"))));


        Predicate<String> filter = s -> s.contains("Talk"); // talk을 포함하고 있는 것을 return해라
        List<String> talkList = filterList(list, filter);
        assertThat(talkList, is(equalTo(Arrays.asList("kakaoTalk"))));

        List<Integer> intList = Arrays.asList(1, 4, 6, 7, 8); // data
        Predicate<Integer> integerFilter = e -> e % 2 == 0; // function은 거의 형태가 e -> e 임 파라미터로 들어온 건 쓰라고 있는 것
        List<Integer> evenList = filterList(intList, integerFilter);
        assertThat(evenList, is(equalTo(Arrays.asList(4, 6, 8))));
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {  // <T>: 들어오는 애, List<T>: return값
        List<T> newList = new ArrayList<>();
        for(T str: list){
            if(predicate.test(str)){
                newList.add(str);
            }
        }
        return newList;
    }

}