package io.simpolor.test.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DemoDelay {

    @Async
    public void doDelay(long ms) {

        long nano = TimeUnit.MILLISECONDS.toNanos(ms);

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime laterTime = nowTime.plusNanos(nano);

        log.info("doDelay Start");
        while (laterTime.isAfter(LocalDateTime.now())){
            // while 문을 이용해서 지연을 시킴
        }
        log.info("doDelay End");
    }
}
