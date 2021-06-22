package example.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit4OrderTest {

	@BeforeClass
	public static void setupBeforeClass()  {
		System.out.println("> @BeforeClass");
	}

	@AfterClass
	public static void teardownAfterClass() {
		System.out.println("> @AfterClass");
	}

	@Before
	public void setup() {
		System.out.println(">> @Before");
	}

	@After
	public void teardown() {
		System.out.println(">> @After");
	}

	@Test
	public void testCase1() {
		System.out.println(">>> @Test1");
	}

	@Test
	public void testCase2() {
		System.out.println(">>> @Test2");
	}
}
