package ex.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5OrderTest {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("> @BeforeAll");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("> @AfterAll");
    }

    @BeforeEach
    public void setUp() {
        System.out.println(">> @BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println(">> @AfterEach");
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
