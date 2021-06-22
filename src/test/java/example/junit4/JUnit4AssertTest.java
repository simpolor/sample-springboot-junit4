package example.junit4;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JUnit4AssertTest {

    @Test
    public void testAssertEqual() {

        String actual = "a";

        Assert.assertEquals("a", actual);
    }

    @Test
    public void testAssertNotEqual() {

        String actual = "a";

        Assert.assertNotEquals("b", actual);
    }

    @Test
    public void testAssertSame() {

        String actual = "abc";

        Assert.assertSame("abc", actual);
    }

    @Test
    public void testAssertNotSame() {

        String actual = "zxc";

        Assert.assertNotSame("abc", actual);
    }

    @Test
    public void testAssertNull() {

        String actual = null;

        Assert.assertNull(actual);
    }

    @Test
    public void testAssertNotNull() {

        String actual = "abc";

        Assert.assertNotNull(actual);
    }

    @Test
    public void testAssertBoolean() {

        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void testAssertArrayEquals() {

        String[] actual = new String[]{"a", "b", "c"};

        Assert.assertArrayEquals(new String[]{"a", "b", "c"}, actual);
    }

    @Test
    public void testAssertThat() {

        int actual = 10;

        // assertThat Method를 이용하여 org.hamcrest.CoreMatchers Library를 사용할 수 있음
        Assert.assertThat(actual, CoreMatchers.is(10));
    }

    // @Test
    public void testAssertFail() {

        Assert.fail();

        Assert.fail("Message Fail");
    }

}
