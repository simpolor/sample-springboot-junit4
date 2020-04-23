package io.simpolor.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.service.DemoService;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void testDemoList() throws Exception {

        // given
        List<Demo> demoList = new ArrayList<>();
        demoList.add(new Demo(1, "홍길동", 15));
        demoList.add(new Demo(2, "김철수", 19));
        demoList.add(new Demo(3, "김영희", 17));
        demoList.add(new Demo(4, "단순색", 32));

        when(demoService.list()).thenReturn(demoList);

        // when, than
        this.mockMvc.perform(
                get("/demo/list")
                .header("Accept-Language", "ko-KR")

        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$")
                                .value(hasSize(4))
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$[0].seq")
                                .value(is(1))
                )
                .andReturn();

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

    @Test
    public void testDemoPost() throws Exception {

        // given
        long seq = 50L;
        Demo demo = new Demo(seq, "sypark", 15);

        when(demoService.write(demo)).thenReturn(demo);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(demo);

        // when
        this.mockMvc.perform(post("/demo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                //.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.seq")
                                .value(is(50))
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.name")
                                .value(is("sypark"))
                )
                .andExpect(
                        MockMvcResultMatchers
                                .jsonPath("$.age")
                                .value(is(15))
                )
                .andReturn();
    }

    @Test
    public void testDemoInterceptor() throws Exception {

        // Method method = TestInternalController.class.getMethod("testMethod");
        // TestInternalController controller = new TestInternalController();
        // HandlerMethod handlerMethod = new HandlerMethod(controller, method);

        // MockHttpServletRequest request = new MockHttpServletRequest();
        // MockHttpServletResponse response = new MockHttpServletResponse();

        // val actual = interceptor.preHandle(request, response, handlerMethod);
    }

}