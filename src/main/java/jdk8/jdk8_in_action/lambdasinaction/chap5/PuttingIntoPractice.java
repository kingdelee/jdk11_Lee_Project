package jdk8.jdk8_in_action.lambdasinaction.chap5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(tr2011);

        // Query 2: What are all the unique cities where the traders work?
        List<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // Query 3: Find all traders from Cambridge and sort them by name.

        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);


        // Query 4: Return a string of all traders’ names sorted alphabetically.

        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);

        // Query 5: Are there any trader based in Milan?

        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan")
                        );
        System.out.println(milanBased);


        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);


        // Query 7: What's the highest value in all the transactions?
        int highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);
    }


    @Test
    public void t1() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        System.out.println("1-----------");
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList()).forEach(System.out::println);
//        (2) 交易员都在哪些不同的城市工作过？
        System.out.println("2-----------");
//        transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getCity).distinct().collect(toList()).forEach(System.out::println);
//        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList()).forEach(System.out::println);
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(toSet()).forEach(System.out::println);

//        (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        System.out.println("3-----------");
        transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).distinct().sorted(comparing(Trader::getName)).collect(toList()).forEach(System.out::println);
//
//        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println("4-----------");
//        transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getName).sorted().collect(toList()).forEach(System.out::println);
//        System.out.println(transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2));
        System.out.println(transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().collect(joining()));
//        (5) 有没有交易员是在米兰工作的？
        System.out.println("5-----------");
//        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().anyMatch(trader -> "Milan".equals(trader.getCity())));
        System.out.println(transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity())));
//        (6) 打印生活在剑桥的交易员的所有交易额。
        System.out.println("6-----------");
//        System.out.println(transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(transaction -> transaction.getValue()).reduce((a, b) -> a + b).get());
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
//        (7) 所有交易中，最高的交易额是多少？
        System.out.println("7-----------");
//        System.out.println(transactions.stream().max(comparing(Transaction::getValue)).get().getValue());
//        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).get());
        System.out.println(transactions.stream().mapToInt(Transaction::getValue).max().getAsInt());
//        (8) 找到交易额最小的交易。
        System.out.println("8-----------");
//        System.out.println(transactions.stream().min(comparing(Transaction::getValue)).get().getValue());
        System.out.println(transactions.stream().reduce((transaction, transaction2) -> transaction.getValue() < transaction2.getValue() ? transaction : transaction2).get().getValue());

    }

}