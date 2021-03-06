package io.simpolor.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DemoMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDemoView() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/1"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.name")
                                .value(is("하니"))
                )
                .andReturn();

        System.out.println("-- header");
        for(String header :  result.getResponse().getHeaderNames()){
            System.out.println(header+"  : "+result.getResponse().getHeader(header));
        }

        System.out.println("-- body");
        System.out.println( result.getResponse().getContentAsString());
    }

    @Test
    public void testDemoViewByNull() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/50"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.name")
                                .value(is(nullValue()))
                )
                .andReturn();
    }

    @Test
    public void testDemoList() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/list"))
                .andExpect(status().isOk())
                .andExpect(
                        /*MockMvcResultMatchers
                                .jsonPath("$")
                                .value(hasSize(84))*/
                        MockMvcResultMatchers
                                .jsonPath("$[0].name")
                                .value(is("하니"))

                )
                .andReturn();

    }

}