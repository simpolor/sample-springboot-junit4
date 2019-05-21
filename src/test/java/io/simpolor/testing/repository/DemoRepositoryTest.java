package io.simpolor.testing.repository;

import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// @ExtendWith(SpringExtension.class) //junit5 버전 사용
@RunWith(SpringRunner.class)
@DataJpaTest
// @ContextConfiguration(classes = {TestDatabaseAutoConfiguration.class, DemoRepository.class, Demo.class})
@AutoConfigureTestDatabase
		(replace = AutoConfigureTestDatabase.Replace.NONE) // 메모리 데이터베이스가 아닌 실제 데이터베이스를 테스트하는 어노테이션
// @MybatisTest
public class DemoRepositoryTest {
	
	@Autowired
	private DemoRepository demoRepository;
	
	@Test
	void testSelectDemoCount() {

		// given


		// when
		long result = demoRepository.count();


		// then
		Assert.assertNotNull(result);
		Assert.assertEquals(84, result);
	}

	@Test
	void testSelectDemo() {

		// given
		long seq = 1;


		// when
		Demo demo = demoRepository.findById(seq).get();
		if(demo != null) {
			System.out.println("demo.seq : "+demo.getSeq());
			System.out.println("demo.name : "+demo.getName());
			System.out.println("demo.age : "+demo.getAge());
		}

		// then
		Assert.assertNotNull(demo);
		Assert.assertEquals(1, demo.getSeq());

	}

}
