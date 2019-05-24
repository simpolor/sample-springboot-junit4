package io.simpolor.testing.controller;

import io.simpolor.testing.component.DemoTextMaker;
import io.simpolor.testing.domain.Demo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoRestTemplateTest {

    @LocalServerPort
    private int port;

    @MockBean
    private DemoTextMaker demoTextMaker;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDemoView(){

        System.out.println("port : " + port);

        ResponseEntity<Demo> response = restTemplate.getForEntity(
                "http://localhost:"+port+"/demo/1", Demo.class
        );
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        // Assertions.assertThat(response.getBody().getName()).isNotNull();
    }

    @Test
    public void testDemoModify() throws Exception{

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);

            log.info("demoTextMaker.makeWord(String name) : " + arg0.toString());
            log.info("- arg0 : " + arg0.toString());

            return arg0.toString();
        }).when(demoTextMaker).makeWord(anyString());

        String url = "http://localhost:"+port+"/demo/3894";
        HttpHeaders headers = new HttpHeaders();
        Demo demo = new Demo();
        demo.setName("simpolor");
        demo.setAge(19);

        HttpEntity<Demo> requestEntity = new HttpEntity<Demo>(demo, headers);

        ResponseEntity<Demo> response
                = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Demo.class);

        log.info("response.getStatusCode() : "+response.getStatusCode());
        log.info("response.getHeaders() : "+response.getHeaders());
        log.info("response.getBody() : "+response.getBody());

        Thread.sleep(3000);

        // Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Assertions.assertThat(response.getBody()).isNotNull();
        // Assertions.assertThat(response.getBody().getName()).isNotNull();
    }

}
