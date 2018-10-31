package jdk8.jdk8_in_action.lambdasinaction.chap5;

import jdk8.jdk8_in_action.lambdasinaction.chap4.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static jdk8.jdk8_in_action.lambdasinaction.chap4.Dish.menu;

public class Mapping{

    public static void main(String...args){

        // map
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        String[] arrayOfWords = {"Goodbye", "World"};
        String[] arrayOfWords2 = {"Goodbye", "World", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);





        List<String[]> collect = streamOfwords.map(s -> s.split("")).collect(toList());

//        <R> Stream<R> map(Function<? super T, ? extends R> mapper);


//        @Override
//        @SuppressWarnings("unchecked")
//        public final <R> Stream<R> map(Function<? super P_OUT, ? extends R> mapper) {
//            Objects.requireNonNull(mapper);
//            return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE,
//                    StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) {
//                @Override
//                Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
//                    return new Sink.ChainedReference<P_OUT, R>(sink) {
//                        @Override
//                        public void accept(P_OUT u) {
//                            downstream.accept(mapper.apply(u));
//                        }
//                    };
//                }
//            };
//        }


//        List<String> collect1 = streamOfwords.flatMap((String line) -> Arrays.stream(line.split(""))).collect(toList());


//        @Override
//        public final <R> Stream<R> flatMap(Function<? super P_OUT, ? extends Stream<? extends R>> mapper) {
//            Objects.requireNonNull(mapper);
//            return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE,
//                    StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) {
//                @Override
//                Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
//                    return new Sink.ChainedReference<P_OUT, R>(sink) {
//                        // true if cancellationRequested() has been called
//                        boolean cancellationRequestedCalled;
//
//                        @Override
//                        public void begin(long size) {
//                            downstream.begin(-1);
//                        }
//
//                        @Override
//                        public void accept(P_OUT u) {
//                            try (Stream<? extends R> result = mapper.apply(u)) {
//                                if (result != null) {
//                                    if (!cancellationRequestedCalled) {
//                                        result.sequential().forEach(downstream);
//                                    }
//                                    else {
//                                        var s = result.sequential().spliterator();
//                                        do { } while (!downstream.cancellationRequested() && s.tryAdvance(downstream));
//                                    }
//                                }
//                            }
//                        }
//
//                        @Override
//                        public boolean cancellationRequested() {
//                            // If this method is called then an operation within the stream
//                            // pipeline is short-circuiting (see AbstractPipeline.copyInto).
//                            // Note that we cannot differentiate between an upstream or
//                            // downstream operation
//                            cancellationRequestedCalled = true;
//                            return downstream.cancellationRequested();
//                        }
//                    };
//                }
//            };
//        }

//        <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

//        System.out.println(arrayOfWords2[0].split("")[0]);

//        System.out.println(streamOfwords.distinct().collect(toList()));
//        System.out.println(Arrays.stream(arrayOfWords2).map(s -> s.split("")).distinct().collect(toList()));
//        System.out.println(Arrays.stream(arrayOfWords2).map(s -> s.split("")).map(Arrays::stream).distinct().collect(toList()));




        // flatMap
        words.stream()
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(System.out::println);

        int [] a = new int[]{1,2};

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }

    @Test
    public void t1(){
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",  "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(list.stream().map(item -> Arrays.stream(item.split(" "))).count());
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(list.stream().flatMap(item -> Arrays.stream(item.split(" "))).count());

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());

        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());


    }


}
