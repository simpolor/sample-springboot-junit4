package io.simpolor.testing.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.when;

public class DemoRepositoryMockTest {

	@Mock
	private DemoRepository demoRepository;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testSelectDemoTotalcount() {

		// given
		long reuturnValue = 3L;
		when(demoRepository.count()).thenReturn(reuturnValue);

		// when
		long result = demoRepository.count();


		// then
		Assert.assertNotNull(result);
		Assert.assertEquals(3L, result);
	}

}
