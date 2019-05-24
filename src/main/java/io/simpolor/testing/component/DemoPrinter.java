package io.simpolor.testing.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoPrinter {

    @Autowired
    private DemoTextMaker demoTextMaker;

    @Autowired
    private DemoDelay demoDelay;

    @Async
    public void print(String name) {

        demoDelay.doDelay(3000);

        log.info(":::: Print :::: {}", demoTextMaker.makeWord(name));
    }
}
