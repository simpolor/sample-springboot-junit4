package io.simpolor.testing.repository;

import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;

/***
 * ContextConfiguration를 사용하기 위해서는
properties에 아래 설정이 필요하다.
 * spring.main.allow-bean-definition-overriding=true
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestingApplication.class, DemoRepository.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemoRepositoryContextConfigurationTest {
	
	@Autowired
	private DemoRepository demoRepository;
	
	@Test
	public void testDemoCount() {

		// when
		long result = demoRepository.count();


		// then
		Assert.assertNotNull(result);
		System.out.println("result : "+result);
	}

}
