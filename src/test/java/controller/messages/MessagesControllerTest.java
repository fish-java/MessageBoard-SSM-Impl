package controller.messages;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class MessagesControllerTest extends AutowiredTest {

    @Test
    public void getMessage() throws Exception{
        ResultMatcher status = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/messages")
                .param("since","1999-1-1-11-11-11")
                .param("sort","create_datetime")
                .param("page","2");

        mockMvc.perform(builder)
                .andExpect(status);
        System.out.println(mockMvc.perform(builder).
                andReturn().getResponse().getContentAsString());
    }
}