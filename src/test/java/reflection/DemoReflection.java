package reflection;

import io.simpolor.test.domain.Demo;
import org.springframework.test.util.ReflectionTestUtils;

public class DemoReflection {

    public static Demo exampleDemoResult(long seq, String name, int age) {
        Demo expectedDemoResult = new Demo();
        ReflectionTestUtils.setField(expectedDemoResult, "seq", seq);
        ReflectionTestUtils.setField(expectedDemoResult, "name", name);
        ReflectionTestUtils.setField(expectedDemoResult, "age", age);

        return expectedDemoResult;

    }
}
