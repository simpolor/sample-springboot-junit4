package io.simpolor.test.repository;

import io.simpolor.test.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemoRepositoryDataJpaTest {
	
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

	@Test
	public void testDemoFindAll() {

		// when
		List<Demo> demoList = demoRepository.findAll();

		// then
		Assert.assertNotNull(demoList);
		Assert.assertThat(0, is(lessThan(demoList.size())));
	}

	@Test
	public void testDemoFindById() {

		// given
		long seq = 3810;


		// when
		Demo demo = demoRepository.findById(seq).get();

		// then
		Assert.assertNotNull(demo);
		Assert.assertThat(0L, is(lessThan(demo.getSeq())));
		// Assert.assertEquals(0L, is(demo.getSeq()));

	}

}
