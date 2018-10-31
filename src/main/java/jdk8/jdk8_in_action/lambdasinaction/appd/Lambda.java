package jdk8.jdk8_in_action.lambdasinaction.appd;

import java.util.function.Function;

public class Lambda {
    Function<Object, String> f = obj -> obj.toString();
}
