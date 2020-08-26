package io.simpolor.test.component;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DemoDelayTest {

    private CountDownLatch lock = new CountDownLatch(1);

    @Test
    public void testDoDelay() {

        DemoDelay demoDelay = new DemoDelay();
        demoDelay.doDelay(3000);
    }

    @Test
    public void testThreadSleep() throws Exception {

        Thread.sleep(3000);
        System.out.println("Do thread sleep");
    }

    @Test
    public void testCountDownLatch() throws Exception {

        lock.await(3000, TimeUnit.MILLISECONDS);
        System.out.println("Count down latch");
    }
}
