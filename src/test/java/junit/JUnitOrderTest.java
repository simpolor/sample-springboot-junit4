package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitOrderTest {

	@BeforeClass
	public static void setUpBeforeClass()  {
		System.out.println("> @BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("> @AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println(">> @Before");
	}

	@After
	public void tearDown() {
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
