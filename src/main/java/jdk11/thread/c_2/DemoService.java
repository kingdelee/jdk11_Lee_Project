package jdk11.thread.c_2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Async
    public void a() throws InterruptedException {
        while(true){
            System.out.println("this a demo");
            Thread.sleep(1000);
        }
    }

    @Async
    public void b() throws InterruptedException {
        while(true){
            System.out.println("this a demo");
            Thread.sleep(1000);
        }
    }


}
