package io.simpolor.testing.controller;

import io.simpolor.testing.service.DemoService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoController.class, DemoService.class}) // 특정 클래스와 함께 단위 테스트하는 어노테이션
// @WebAppConfiguration
@AutoConfigureMockMvc
class DemoMockBeanWebMvcTest2 {

    @MockBean
    private DemoService demoService;

    @Autowired
    private DemoController demoController;

    // @Autowired
    // private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    /*@Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }*/

    @Test
    public void testDemoTotalcount() throws Exception {

        when(demoService.totalcount()).thenReturn(10L);

        this.mockMvc.perform(get("/demo/totalcount"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

}