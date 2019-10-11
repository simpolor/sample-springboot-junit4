package io.simpolor.testing.controller;

import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={TestingApplication.class})
@WebMvcTest(controllers = {DemoController.class})
public class DemoWebMvcTest {

    @MockBean
    private DemoService demoService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemoTotalCount() throws Exception {

        // given
        when(demoService.totalcount()).thenReturn(2L);


        // when
        /*MvcResult result = this.mockMvc.perform(get("/demo/totalcount"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .content()
                                .string("2")

                )
                .andReturn();*/

        MvcResult result = this.mockMvc.perform(get("/demo/totalcount"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$")
                                .value(is(2))
                )
                .andReturn();

        /*
        System.out.println("-- header");
        for(String header :  result.getResponse().getHeaderNames()){
            System.out.println(header+"  : "+result.getResponse().getHeader(header));
        }

        System.out.println("-- body");
        System.out.println( result.getResponse().getContentAsString());
        */

    }

    @Test
    public void testDemoView() throws Exception {

        // given
        long seq = 50L;
        Demo demo = new Demo(seq, "sypark", 15);

        when(demoService.view(seq)).thenReturn(demo);


        // when
        MvcResult result = this.mockMvc.perform(get("/demo/50"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.age")
                                .value(is(15))
                )
                .andReturn();

        /*
        System.out.println("-- header");
        for(String header :  result.getResponse().getHeaderNames()){
            System.out.println(header+"  : "+result.getResponse().getHeader(header));
        }

        System.out.println("-- body");
        System.out.println( result.getResponse().getContentAsString());
        */

    }

    /*@Test
    public void testDemoList() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/list"))
                .andExpect(status().isOk())
                .andExpect(
                        *//*MockMvcResultMatchers
                                .jsonPath("$")
                                .value(hasSize(84))*//*
                        MockMvcResultMatchers
                                .jsonPath("$[0].name")
                                .value(is("지랑남"))

                )
                .andReturn();

    }*/

}