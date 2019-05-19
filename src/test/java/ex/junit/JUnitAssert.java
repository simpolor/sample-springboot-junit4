package ex.junit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JUnitAssert {

    @Test
    public void testAssertEqual() {
        String str = "a";
        Assert.assertEquals("a", str);
    }

    @Test
    public void testAssertNotEqual() {
        String str = "a";
        Assert.assertNotEquals("b", str);
    }

    @Test
    public void testAssertSame() {
        String str = "abc";
        Assert.assertSame("abc", str);
    }

    @Test
    public void testAssertNotSame() {
        String str = "zxc";
        Assert.assertNotSame("abc", str);
    }

    @Test
    public void testAssertNull() {
        String str = null;
        Assert.assertNull(str);
    }

    @Test
    public void testAssertNotNull() {
        String str = "abc";
        Assert.assertNotNull(str);
    }

    @Test
    public void testAssertBoolean() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void testAssertArrayEquals() {
        String[] strArr = new String[]{"a", "b", "c"};
        Assert.assertArrayEquals(new String[]{"a", "b", "c"}, strArr);
    }

    @Test
    public void testAssertThat() {

        int num = 10;

        // assertThat Method를 이용하여 org.hamcrest.CoreMatchers Library를 사용할 수 있음
        Assert.assertThat(num, CoreMatchers.is(10));
    }

    // @Test
    public void testAssertFail() {
        Assert.fail();
        Assert.fail("Message Fail");
    }

}
