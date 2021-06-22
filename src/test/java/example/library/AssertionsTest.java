package example.library;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Junit Assert 와 Assertions 의 차이는 expected 위치가 다름
 */
public class AssertionsTest {

    @Test
    public void testAssertionsIsEqualTo() {

        String actual = "a";

        Assertions.assertThat(actual).isEqualTo("a");
    }

    @Test
    public void testAssertionsIsNotEqualTo() {

        String actual = "a";

        Assertions.assertThat(actual).isNotEqualTo("b");
    }

    @Test
    public void testAssertionsIsEqualsToByArray() {

        String[] actual = new String[]{"a", "b", "c"};

        Assertions.assertThat(actual).isEqualTo(new String[]{"a", "b", "c"});
    }

    @Test
    public void testAssertIsSameAs() {

        String actual = "abc";

        Assertions.assertThat(actual).isSameAs("abc");
    }

    @Test
    public void testAssertIsNotSameAs() {

        String actual = "abc";

        Assertions.assertThat(actual).isNotSameAs("zxc");
    }

    @Test
    public void testAssertionsIsNull() {

        String actual = null;

        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void testAssertionsIsNotNull() {

        String actual = "abc";

        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void testAssertionsIsEmpty() {

        String actual = "";

        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    public void testAssertionsIsNotEmpty() {

        String actual = "abc";

        Assertions.assertThat(actual).isNotEmpty();
    }

    @Test
    public void testAssertionsIsTrue() {

        boolean actual = true;

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void testAssertionsIsFalse() {

        boolean actual = false;

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void testAssertionsBetween() {

        int actual = 6;

        Assertions.assertThat(actual).isBetween(5, 10);
    }

    @Test
    public void testAssertionsContains() {

        String actual = "abc";

        Assertions.assertThat(actual).contains("ab");
    }


}
