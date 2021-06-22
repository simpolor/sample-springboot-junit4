package example.junit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.TestCase.fail;


public class JUnit4ExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * try/catch 문을 이용한 예외처리
     */
    @Test
    public void testDivisionException() {

        // try catch를 통하여 예외를 확인
        try {
            int i = 1 / 0;
            fail(); //remember this line, else 'may' false positive
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() : "+e.getMessage());
            assertThat(e.getMessage(), is("/ by zero"));
            //assert others
        }
    }

    /**
     * thrown 라이브러리를 이용한 예외처리
     */
    @Test
    public void testDivisionExpectedException() {

        // 미리 정의된 예외는 통과
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("/ by zero"));

        int i = 1 / 0;
    }

    /**
     * Junit의 expected를 이용한 예외처리
     */
    @Test(expected= ArithmeticException.class)
    public void testDivisionAnnotationException() {

        int i = 1 / 0;
    }

}
