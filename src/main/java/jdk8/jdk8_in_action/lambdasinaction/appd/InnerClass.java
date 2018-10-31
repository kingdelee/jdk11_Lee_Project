package jdk8.jdk8_in_action.lambdasinaction.appd;

import java.util.function.Function;

public class InnerClass {
    Function<Object, String> f = new Function<Object, String>() {
        @Override
        public String apply(Object obj) {
            return obj.toString();
        }
    };
}
