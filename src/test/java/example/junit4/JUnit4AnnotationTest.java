package example.junit4;

import org.junit.Test;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) : junit4 버전 사용
 * @RunWith(MockitoJUnitRunner.class) : mock 테스트
 * @ExtendWith(SpringExtension.class) : junit5 버전 사용
 * @SuiteClasses({}) : 여러 클래스와 함께 단위 테스트하는 어노테이션
 * @ContextConfiguration : 여러 클래스와 함께 단위 테스트하는 어노테이션
 * @ContextConfiguration(classes = {}) : 특정 클래스와 함께 단위 테스트하는 어노테이션
 * @AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
 * : 메모리 데이터베이스가 아닌 실제 데이터베이스를 테스트하는 어노테이션
 * @MybatisTest : Mybatis를 Test 할 수 있는 어노테이션
 * @DataJpaTest : Jpa를 Test할 수 있게 도와주는 어노테이션  ( 인메모리 데이터베이스가 존재해야함 )
 * @DataMongoTest : MongoDB를 Test 할 수 있게 도와주는 어노테이션
 * @JdbcTest : Jpa와 관련된 설정을 제외한 설정을 도와주는 어노테이션
 * @AutoConfigureRestDocs : 테스트를 통해 restDoc을 뽑을 수 있는 어노테이션
 * @JsonTest : json을 쉽게 serialize, deserialize를 테스트할 수 있게 도와주는 어노테이션
 * @WebMvcTest : webmvc를 테스트할 수 있는 어노테이션
 * @RestClientTest : 외부에서 어떤 Rest API를 호출할 때 mock 대신에 대체할 수 았는 테스트 어노테이션
 * @TestPropertySource(properties = "server.port=8081") : Properties 파일을 읽어오기 위한 어노테이션
 * @SpringBootTest(classes = {DemoController.class})
 * @SpringBootTest(properties = "application.yml")
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 * @ActiveProfiles
 * @FixMethodOrder(MethodSorters.NAME_ASCENDING)
*/
public class JUnit4AnnotationTest {

    @Test // 가장 기본이 되는 테스트 어노테이션
    public void testDefault(){

        System.out.println("Test default");
    }

    @Test(timeout = 3000) // 시간초과에 대한 어노테이션
    public void testTimeout() throws InterruptedException{

        Thread.sleep(300);

        System.out.println("Test timeout");
    }

    @Test(expected = NullPointerException.class) // 기대한 예외에 대한 어노테이션
    public void testExpected() {

        System.out.println("Test expected");
        throw new NullPointerException();
        //throw new RuntimeException();
    }
}
