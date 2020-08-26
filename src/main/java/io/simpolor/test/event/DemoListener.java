package io.simpolor.test.event;

import io.simpolor.test.component.DemoPrinter;
import io.simpolor.test.domain.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoListener {

    @Autowired
    private DemoPrinter demoPrinter;

    @Async
    @EventListener
    public void testDemoEventListener(DemoEvent demoEvent){

        // log.info("demoEvent : "+demoEvent.getState().getName());

        if(demoEvent.getState().isInsert()){
            log.info("DemoEventListener Insert");
        }else if(demoEvent.getState().isUpdate()){
            log.info("DemoEventListener Update");
        }else if(demoEvent.getState().isDelete()){
            log.info("DemoEventListener Delete");
        }

        demoPrinter.print(demoEvent.getName());

    }
}
