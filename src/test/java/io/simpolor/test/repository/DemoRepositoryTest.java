package io.simpolor.test.repository;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoRepository.class})
public class DemoRepositoryTest {

	@Autowired
	private DemoRepository demoRepository;

	@Test
	public void testSelectDemoTotalcount() {

		// when
		long result = demoRepository.count();


		// then
		Assert.assertNotNull(result);
		Assert.assertEquals(3L, result);
	}

}
