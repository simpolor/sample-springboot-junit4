package io.simpolor.testing.repository;

import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackageClasses = DemoRepository.class)
@EntityScan(basePackageClasses = Demo.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemoRepositoryEnableJpaReositoriesTest {
	
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
