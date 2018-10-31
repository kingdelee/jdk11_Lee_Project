package jdk11.map.tree;

//import jdk11.map.HashMap;
//import jdk11.map.Map;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestM {

    @Test
    public void t1(){

        Map map = new HashMap();


        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "a";
        p2.name = "b";
        map.put(p1, "1");
        map.put(p2, "2");


        System.out.println(map.toString());




    }



}


class Person{
    public  String name;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}