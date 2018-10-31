package jdk11.map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Client {

    private static final Logger logger = LogManager.getLogger(Client.class);


    @Test
    public void t1(){
        Map<Father, Integer> map = new HashMap<>();

//        Father f1 = new Father("1", 3);
//        map.put(f1, 6);
//、        f1.setHashcode(3);
        map.put(new Father("1", 3), 1);
        map.put(new Father("2", 3), 2);
        map.put(new Father("3", 3), 3);
        map.put(new Father("4", 3), 4);
        map.put(new Father("5", 3), 5);
        Father f6 = new Father("6", 6);
        map.put(f6, 6);
//        f6.setHashcode(3);
        map.put(new Father("7", 3), 7);
        map.put(new Father("8", 3), 8);
        map.put(new Father("9", 3), 9);
        map.put(new Father("10", 3), 10);
        map.put(new Father("11", 3), 11);
        map.put(new Father("12", 3), 12);
        map.put(new Father("13", 3), 13);
        map.put(new Father("14", 3), 14);
        map.put(new Father("15", 3), 15);
        map.put(new Father("16", 3), 16);
        map.put(new Father("17", 3), 17);
        map.put(new Father("18", 3), 18);
        map.put(new Father("19", 3), 19);
        map.put(new Father("20", 3), 20);
        map.put(new Father("21", 2), 21);
        map.put(new Father("22", 2), 22);
        map.put(new Father("23", 2), 23);
        map.put(new Father("24", 2), 24);
        map.put(new Father("25", 2), 25);
        map.put(new Father("26", 2), 26);
        map.put(new Father("27", 2), 27);
        map.put(new Father("28", 2), 28);
        map.put(new Father("29", 2), 29);
        map.put(new Father("30", 2), 30);

        for (int i = 0; i < 40; i++) {
            map.put(new Father("30", 2), 30);
        }

        logger.info(map.get(new Father("5", 1)));
        logger.info(map.get(new Father("15", 1)));
        logger.info(map.get(new Father("21", 2)));
//        logger.info(map.get(f1));
    }

    public static void main(String[] args) {

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(10, 1);
//        map.put(10, 2);

//        logger.info(map.get(10));

        Map<Father, Integer> map = new HashMap<>();

        map.put(new Father("1", 1), 1);
        map.put(new Father("2", 1), 2);
        map.put(new Father("3", 1), 3);
        map.put(new Father("4", 1), 4);
        map.put(new Father("5", 1), 5);
        map.put(new Father("6", 1), 6);
        map.put(new Father("7", 1), 7);
        map.put(new Father("8", 1), 8);
        map.put(new Father("9", 1), 9);
        map.put(new Father("10", 1), 10);
        map.put(new Father("11", 1), 11);
        map.put(new Father("12", 1), 12);
        map.put(new Father("13", 1), 13);
        map.put(new Father("14", 1), 14);
        map.put(new Father("15", 1), 15);
        map.put(new Father("16", 1), 16);
        map.put(new Father("17", 2), 17);
        map.put(new Father("18", 2), 18);
        map.put(new Father("19", 2), 19);
        map.put(new Father("20", 2), 20);
        map.put(new Father("21", 2), 21);
        map.put(new Father("22", 2), 22);
        map.put(new Father("23", 2), 23);
        map.put(new Father("24", 2), 24);
        map.put(new Father("25", 2), 25);
        map.put(new Father("26", 2), 26);
        map.put(new Father("27", 2), 27);
        map.put(new Father("28", 2), 28);
        map.put(new Father("29", 2), 29);
        map.put(new Father("30", 2), 30);
        logger.info(map.get(new Father("5", 1)));
        logger.info(map.get(new Father("15", 1)));
        logger.info(map.get(new Father("21", 2)));

//        int i = 10;
//        logger.info(i >= 1 << 16);
//
//        logger.info(i++);
//        logger.info(++i);

//        logger.info(1 << 30);
    }
}

class Father {
    public String name;

    public int hashcode;

    public Father(String name, int hashcode) {
        this.name = name;
        this.hashcode = hashcode;
    }

    public Father(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    @Override
    public int hashCode() {
        return getHashcode();
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Father) obj).name) && hashcode == (((Father) obj).hashcode);
    }
}
