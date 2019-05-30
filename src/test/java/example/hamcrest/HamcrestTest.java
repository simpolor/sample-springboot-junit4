package example.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.containsString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import io.simpolor.testing.domain.Demo;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

public class HamcrestTest {

	@Test
	public void hamcrestIsTest() throws Exception {
		Demo demo = new Demo();
		demo.setName("John");
		
		// JUnit Library
		assertEquals("John", demo.getName() );
		
		// Hamcrest Library
		assertThat(demo.getName(), is("John"));
	}

	@Test
	public void hamcrestisEqualToTest() throws Exception {
		Demo demo = new Demo();
		demo.setAge(16);
		
		// 전부 동일한 의미로 사용됨
		assertThat(demo, is(equalTo(demo)));
		assertThat(demo, is(demo));
		assertThat(demo, equalTo(demo));
	}

	@Test
	public void hamcrestNullTest() {
	    String str = null;

        // is는 기준 값과 결과가 일치해야 성공
	    assertThat(str, is(nullValue()));
	}

	@Test
	public void hamcrestNotNullTest() {
	    String str = "hamcrest";
	    assertThat(str, is(notNullValue()));
	}

	@Test
	public void hamcrestNotTest() {
	    String str = null;

        // not는 기준 값과 결과가 일치하지 않아야 성공
	    assertThat(str, not(notNullValue()));
	}
	
	@Test
	public void hamcrestInstanceOfTest() {
	    Map<String, String> map = new HashMap<>();

        // instance가 동일해야 성공
	    assertThat(map, instanceOf(Map.class));
	}

    @Test
	public void hamcrestNumbersTest() {
        // 크다.
		assertThat(2, greaterThan(1));

        // 크거나 같다.
        assertThat(1, greaterThanOrEqualTo(1));

        // 작다.
        assertThat(0, lessThan(1));

        // 작거나 같다
		assertThat(0, lessThanOrEqualTo(1));
	}
	
	// ---------------------------------------------------------

	private String myProperty1;
	public void setMyProperty(String property) {
	    this.myProperty1 = property;
	}

	@Test
	public void hamcrestPropertyTest() {
        // setMyProperty Method가 존재해야 성공 ( 변수명은 영향을 끼치지 않음 )
	    assertThat(this, hasProperty("myProperty"));
	}
	
	// ---------------------------------------------------------
	
	@Test
	public void hamcrestCollectionTest() {

	    Map<String, String> map = new HashMap<>();
	    map.put("foo1", "bar1");
	    map.put("foo2", "bar2");

	    // 해당 Map에 해당 key가 존재하는지 여부
	    assertThat(map, IsMapContaining.hasKey("foo1"));

        // 해당 Map에 해당 key와 value가 쌍으로 존재하는지 여부
	    assertThat(map, IsMapContaining.hasEntry("foo1", "bar1"));

        // 해당 Map에 해당 value가 존재하는지 여부
	    assertThat(map, IsMapContaining.hasValue("bar1"));
	}
	
	// ---------------------------------------------------------
	
	@Test
	public void hamcrestTextTest() {

	    String actual = "Spring";
        String actual2 = "Spring Framework 3.2";

	    // 대소문자 구분하지 않고 검색
		assertThat(actual,  equalToIgnoringCase("spring"));
		  
		// 앞뒤의 공백만 무시하여 검색
		assertThat(actual2, equalToIgnoringWhiteSpace ("  Spring Framework 3.2  "));
		  
		// 해당 문자열이 포함되는지 여부
		assertThat(actual2, containsString("Framework"));
	}

	/**
     * allOf : 내부에 선언된 모든 Matcher가 정상일 경우 통과
     * anyOf : 내부에 선언된 Matcher 중 하나 이상 정상일 경우 통과
     * both : A, B Matcher가 둘다 정상일 경우 통과
     * either : A, B Matcher 중에 하나라도 정상일 경우 통과
     * describedAs : Matcher 내부의 메세지를 변경할 수 있음
     * everyItem : 배열이나 리스트를 순회하며 Matcher가 실행
     * is : 비교 값이 같은지 여부를 판단
     * isA : 비교 값이 특정 클래스일 경우 통과
     * anything : 항상 ture를 반환하는 Matcher
     * hasItem : 배열에서 Matcher가 통과하는 값이 하나 이상 있는지 검사
     * hasItems : 배열에서 Matcher 리스트에 선언된 값이 하나 이상 있는지 검사
     * equalTo : 두 값이 같은지 여부를 체크 ( is와 동일 )
     * any : 비교 값이 Matcher의 타입과 동일한지 여부를 체크
     *       ( instanceOf와 다르게 매쳐의 값은 앞서 비교 값의 자식만 비교할 수 있음 )
     * instanceOf : 비교 값이 매쳐의 타입과 동일한지 여부를 확인
     * not : Matcher의 결과값을 뒤집거나, 같이 동일하지 않을 때 사용
     * nullValue : 비교 값이 null일 경우 통과
     * notNullValue : 비교 값이 null이 아닐 경우 통과
     * sameInstance : 비교 Matcher의 값과 같은 인스턴스일 경우 통과
     * theInstance : sameInstance와 동일
     * containString : 특정 문자열이 있는지 여부를 검사
     * startsWith : 특정 문자열로 시작하는지 검사
     * endsWith : 특정 문자열로 끝나는지 검사
	 */
	

}
