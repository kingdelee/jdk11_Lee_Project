package jdk11.thread.c_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Config {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        DemoService bean = ac.getBean(DemoService.class);
        bean.a();
        bean.b();

    }

}
