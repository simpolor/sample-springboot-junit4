package io.simpolor.testing.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoTextMaker {

    private String testingWord = "님께서 출력하셨습니다.";

    public String makeWord(String name){
        return name + testingWord;
    }
}
