package io.simpolor.testing.component;

import org.junit.Assert;
import org.junit.Test;

public class DemoTextMakerTest {

    @Test
    public void testMakeWord(){

        // given
        String name = "단순색";

        // when
        DemoTextMaker textMaker = new DemoTextMaker();

        // then
        Assert.assertEquals("단순색님께서 출력하셨습니다.", textMaker.makeWord(name));
    }
}
