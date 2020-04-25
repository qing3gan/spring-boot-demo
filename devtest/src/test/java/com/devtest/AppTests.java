package com.devtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * RunWith: 测试运行器（测试环境.class）
 * SpringBootTest: SpringBoot测试环境
 * 对应测试类在相同包路径下
 *
 * @author agony
 * @date 2020/4/23 22:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTests {
    @Autowired
    HelloService helloService;

    @Test
    public void testHelloService() {
        String hello = helloService.sayHello("test");
        Assert.assertThat(hello, Matchers.is("Hello test"));
    }

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testHelloControllerHello() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "test")).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testHelloControllerAddBook() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setName("sanguoyanyi");
        book.setAuthor("luoguanzhong");
        ObjectMapper om = new ObjectMapper();
        String body = om.writeValueAsString(book);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testRest() {
        ResponseEntity<String> hello = testRestTemplate.getForEntity("/hello?name={0}", String.class, "test");
        Assert.assertThat(hello.getBody(), Matchers.is("Hello test"));
    }
}
