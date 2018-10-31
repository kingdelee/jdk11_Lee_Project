package jdk8.jdk8_in_action.lambdasinaction.chap5;

import jdk8.jdk8_in_action.lambdasinaction.chap4.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jdk8.jdk8_in_action.lambdasinaction.chap4.Dish.menu;

public class NumericStreams{

    public static void main(String...args){
    
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu.stream()
                           .mapToInt(Dish::getCalories)
                           .sum();
        System.out.println("Number of calories:" + calories);


        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()                                                      
                                      .mapToInt(Dish::getCalories)
                                      .max();

        int max;
        if(maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);

        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                 .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTriples =
               IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        Stream<int[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 2 == 0));


//        IntStream intStream = IntStream.rangeClosed(1, 100);


//        Stream<Integer> boxed = IntStream.rangeClosed(1, 100).boxed();


        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }
   
    public static boolean isPerfectSquare(int n){
        return Math.sqrt(n) % 1 == 0;
    }


    @Test
    public void t1(){

        // 1.判断数值是否为整数(是否包含小数位)
        double a = 12d;
        double b = 12.1d;

        System.out.println(a % 1); // 0.0
        System.out.println(b % 1); // 0.099
        System.out.println(a % 1 == 0); // true

    }

}
