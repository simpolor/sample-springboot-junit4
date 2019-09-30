package io.simpolor.testing.controller;

import io.simpolor.testing.service.DemoService;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {DemoController.class}) // 특정 컨트롤러만 로드
public class DemoWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService;

    @Test
    public void testDemoTotalcount() throws Exception {

        when(demoService.totalcount()).thenReturn(15L);

        this.mockMvc.perform(get("/demo/totalcount"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
                // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$.person.name").value("Jason"))
                // .andExpect(redirectedUrl("/messages/123"));


        /* this.mockMvc.perform(post("/demo/totalcount"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/person/1"))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("person"))
                .andExpect(flash().attributeCount(1))
                .andExpect(flash().attribute("message", "success!")); */

    }

}