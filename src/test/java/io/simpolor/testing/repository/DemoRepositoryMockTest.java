package io.simpolor.testing.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class DemoRepositoryMockTest {

	@Mock
	private DemoRepository demoRepository;
	
	@Test
	public void testSelectDemoTotalcount() {

		MockitoAnnotations.initMocks(this);

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
