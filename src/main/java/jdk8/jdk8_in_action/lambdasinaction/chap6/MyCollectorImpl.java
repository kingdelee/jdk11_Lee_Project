package jdk8.jdk8_in_action.lambdasinaction.chap6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class MyCollectorImpl<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (set, item) -> {set.addAll(item); return set;};
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {

        return Function.identity();
    }


    // IDENTITY_FINISH 则不会执行finisher
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "welcome");
        Set<String> set = list.stream().collect(new MyCollectorImpl<>());
        set.forEach(System.out::println);
    }
}
