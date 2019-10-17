package io.simpolor.testing.service;

import io.simpolor.testing.repository.DemoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;

public class DemoServiceReflectionTest {

    private DemoRepository demoRepository = mock(DemoRepository.class);
    private DemoService demoService = new DemoService(demoRepository);

    @Test
    public void testViewsByDeclare() throws NoSuchFieldException, IllegalAccessException {

        // given
        long visit = 30L;
        demoService.setVisit(visit);

        Field field = new DemoService(demoRepository).getClass().getDeclaredField("visit");
        field.setAccessible(true);

        long result = (long)field.get(demoService);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(visit, result);
    }

    @Test
    public void testViewsByReflectionTestUtils() {

        // given
        long visit = 30L;
        ReflectionTestUtils.setField(demoService, "visit", visit);


        // when
        long result = demoService.getVisit();


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(visit, result);
    }
}