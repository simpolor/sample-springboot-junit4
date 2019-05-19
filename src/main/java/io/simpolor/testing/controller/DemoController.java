package io.simpolor.testing.controller;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    private DemoService demoService;
    public DemoController(@Autowired DemoService demoService){
        this.demoService = demoService;
    }

    @RequestMapping(value = "/totalcount", method = RequestMethod.GET)
    public long demoTotalCount() {
        return demoService.totalcount();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Demo> demoList() {
        return demoService.list();
    }

    @RequestMapping(value = "/{seq}", method = RequestMethod.GET)
    public Demo demoView(@PathVariable long seq) {
        return demoService.view(seq);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Demo demoWrite(@RequestBody Demo demo) {
        return demoService.write(demo);
    }

    @RequestMapping(value = "/{seq}", method = RequestMethod.PUT)
    public Demo demoModify(@PathVariable long seq, @RequestBody Demo demo) {
        demo.setSeq(seq);
        return demoService.modify(demo);
    }

    @RequestMapping(value = "/{seq}", method = RequestMethod.DELETE)
    public long demoDelete(@PathVariable long seq) {
        return demoService.delete(seq);
    }
}
