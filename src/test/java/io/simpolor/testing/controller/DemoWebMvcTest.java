package io.simpolor.testing.controller;

import io.simpolor.testing.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
// @WebMvcTest(controllers = {DemoController.class}) // 특정 컨트롤러만 로드
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

    }

    @Test
    public void testDemo2Totalcount() throws Exception {

        when(demoService.totalcount()).thenReturn(15L);

        this.mockMvc.perform(get("/demo2/totalcount"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

}