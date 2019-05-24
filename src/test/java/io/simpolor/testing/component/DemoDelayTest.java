package io.simpolor.testing.component;

import org.junit.Test;

public class DemoDelayTest {

    @Test
    public void testDoDelay(){
        DemoDelay demoDelay = new DemoDelay();
        demoDelay.doDelay(5000);
    }
}
