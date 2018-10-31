package jdk8.jdk8_in_action.lambdasinaction.chap6;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class MyCollectorImpl2<T> implements Collector<T, Set<T>, Map<T, T>>{
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
        return (set1, set2)->{
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        return (set)->{
            HashMap<T, T> map = new HashMap();
            set.stream().forEach((item)->map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        HashSet<String> set = new HashSet<>();
        set.addAll(list);

        Map<String, String> map = set.stream().collect(new MyCollectorImpl2<>());
        System.out.println(map);
    }
}
