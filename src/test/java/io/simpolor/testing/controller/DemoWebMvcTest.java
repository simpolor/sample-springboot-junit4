package io.simpolor.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// @RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
// @WebMvcTest
// @SpringBootTest // springboot 통합 테스트
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoController.class)
class DemoWebMvcTest {

    // @MockBean
    // private ArticleDao articleDao;

    @MockBean
    private DemoService demoService;

    @Autowired
    private DemoController demoController;

    MockMvc mockMvc;

    @Test
    public void demoMockTest() throws Exception {

        mockMvc.perform(get("/demo/totalcount"))
            .andExpect(status().isOk());
    }

}