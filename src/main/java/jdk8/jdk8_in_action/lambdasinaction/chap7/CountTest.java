//package jdk8.jdk8_in_action.lambdasinaction.chap7;
//
//import org.openjdk.jmh.annotations.BenchmarkMode;
//
//@BenchmarkMode(Mode.Throughput)
//public class CountTest {
//
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyJDK() {
//        long evens = integersJDK.stream().filter(each -> each % 2 == 0).count();
//        Assert.assertEquals(SIZE / 2, evens);
//    }
//
//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    public void serialLazyGSC() {
//        long evens = integersGSC.count(each -> each % 2 == 0);
//        Assert.assertEquals(SIZE / 2, evens);
//    }
//
//    private static final int SIZE = 1_000_000;
//    public final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
//    public final FastList<Integer> integersGSC = new FastList<>(Interval.oneTo(SIZE));
//}
