package io.simpolor.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DemoWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDemoView() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/50"))
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.name")
                                .value(is(nullValue()))
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
    public void testDemoList() throws Exception {

        MvcResult result = this.mockMvc.perform(get("/demo/list"))
                .andExpect(status().isOk())
                .andExpect(
                        /*MockMvcResultMatchers
                                .jsonPath("$")
                                .value(hasSize(84))*/
                        MockMvcResultMatchers
                                .jsonPath("$[0].name")
                                .value(is("지랑남"))

                )
                .andReturn();

    }

}