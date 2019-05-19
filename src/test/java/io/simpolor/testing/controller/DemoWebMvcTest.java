package io.simpolor.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.service.DemoService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// @RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
// @WebMvcTest
// @SpringBootTest // springboot 통합 테스트
// @RunWith(SpringRunner.class)
// @SpringBootTest(classes = DemoController.class)

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DemoWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void demoMockTest() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/totalcount"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("-- header");
        for(String header :  result.getResponse().getHeaderNames()){
            System.out.println(header+"  : "+result.getResponse().getHeader(header));
        }

        System.out.println("-- body");
        System.out.println( result.getResponse().getContentAsString());


    }

}