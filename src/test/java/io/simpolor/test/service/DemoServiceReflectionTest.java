package io.simpolor.test.service;

import io.simpolor.test.repository.DemoRepository;
import org.junit.*;
import org.mockito.*;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;


public class DemoServiceReflectionTest {

    @Mock
    private DemoRepository demoRepository;

    @InjectMocks
    private DemoService demoService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testViewsByDeclare() throws NoSuchFieldException, IllegalAccessException {

        // given
        long visit = 30L;
        demoService.setVisit(visit);

        Field field = new DemoService().getClass().getDeclaredField("visit");
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