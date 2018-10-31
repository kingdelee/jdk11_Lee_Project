package jdk11.map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Client2 {

    private static final Logger logger = LogManager.getLogger(Client.class);


    public static void main(String[] args) {

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(10, 1);
//        map.put(10, 2);

//        logger.info(map.get(10));

        Map<Father, Integer> map = new HashMap<>();
//        Map<Father, Integer> map = new HashMap<>();

        Father f1 = new Father("f1");
        f1.setHashcode(1);
        Father f2 = new Father("f2");
        f2.setHashcode(1);
        Father f3 = new Father("f3");
        f2.setHashcode(1);
        Father f4 = new Father("f4");
        f2.setHashcode(1);
        Father f5 = new Father("f5");
        f2.setHashcode(1);
        Father f6 = new Father("f6");
        f2.setHashcode(1);
        Father f7 = new Father("f7");
        f2.setHashcode(1);
        Father f8 = new Father("f8");
        f2.setHashcode(1);
        Father f9 = new Father("f9");
        f2.setHashcode(1);

        map.put(f1, 1);
        map.put(f2, 2);
        map.put(f3, 3);
        map.put(f4, 4);
        map.put(f5, 5);
        map.put(f6, 6);
        map.put(f7, 7);
        map.put(f8, 8);
        map.put(f9, 9);
        map.put(new Father("10", 1), 10);
        map.put(new Father("11", 1), 11);
        map.put(new Father("12", 1), 12);
        map.put(new Father("13", 1), 13);
        map.put(new Father("14", 1), 14);
        map.put(new Father("15", 1), 15);
        map.put(new Father("16", 1), 16);
        map.put(new Father("17", 1), 17);
        map.put(new Father("18", 1), 18);
        map.put(new Father("19", 1), 19);
        map.put(new Father("20", 1), 20);
        map.put(new Father("21", 1), 21);
        logger.info(map.get(f1));
        logger.info(map.get(f2));
        logger.info(map.get(new Father("21", 1)));

//        int i = 10;
//        logger.info(i >= 1 << 16);
//
//        logger.info(i++);
//        logger.info(++i);

//        logger.info(1 << 30);
    }
}
