package example.junit;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class JUnitAssertions {

    @Test
    public void testAssertionsIsEqualTo() {

        String str = "a";

        Assertions.assertThat(str)
                .isEqualTo("a");
    }

    @Test
    public void testAssertionsIsNotEqualTo() {

        String str = "a";

        Assertions.assertThat(str)
                .isNotEqualTo("b");
    }

    @Test
    public void testAssertionsIsEqualsToByArray() {

        String[] strArr = new String[]{"a", "b", "c"};

        Assertions.assertThat(strArr)
                .isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    public void testAssertIsSameAs() {

        String str = "abc";

        Assertions.assertThat(str)
                .isSameAs("abc");
    }

    @Test
    public void testAssertIsNotSameAs() {

        String str = "abc";

        Assertions.assertThat(str)
                .isNotSameAs("zxc");
    }

    @Test
    public void testAssertionsIsNull() {

        String str = null;

        Assertions.assertThat(str)
                .isNull();
    }

    @Test
    public void testAssertionsIsNotNull() {

        String str = "abc";

        Assertions.assertThat(str)
                .isNotNull();
    }

    @Test
    public void testAssertionsIsEmpty() {

        String str = "";

        Assertions.assertThat(str)
                .isEmpty();
    }

    @Test
    public void testAssertionsIsNotEmpty() {

        String str = "abc";

        Assertions.assertThat(str)
                .isNotEmpty();
    }

    @Test
    public void testAssertionsIsTrue() {

        boolean check = true;

        Assertions.assertThat(check)
                .isTrue();
    }

    @Test
    public void testAssertionsIsFalse() {

        boolean check = false;

        Assertions.assertThat(check)
                .isFalse();
    }

    @Test
    public void testAssertionsBetween() {

        int num = 6;

        Assertions.assertThat(num)
                .isBetween(5, 10);
    }

    @Test
    public void testAssertionsContains() {

        String str = "abc";

        Assertions.assertThat(str)
                .contains("ab");
    }


}
