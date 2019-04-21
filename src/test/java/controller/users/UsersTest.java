package controller.users;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class UsersTest extends AutowiredTest {

    @Test
    public void createUser() throws Exception {
        User user = new User();
        user.setUsername(RandomStringUtils.randomAlphabetic(10));
        user.setPassword("123456");

        ResultMatcher is201 = MockMvcResultMatchers.status().is(201);

        // 创建用户成功后，应该返回用户的ID
        ResultMatcher hasId = MockMvcResultMatchers.jsonPath("$.id").isNumber();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/users")
                .contentType("application/json")
                .content(JSONObject.toJSONString(user));

        // 类似于下面的结果
        // {"id":5,"username":"wpgeSGbYby","password":"123456",
        // "token":"WTW3iehc1bUzmsqUvq3csxBSweTSkn","birthday":null,
        // "email":null,"phoneNumber":null,"createTime":null}
        mockMvc.perform(builder)
                .andExpect(is201)
                .andExpect(hasId);
//
//        System.out.println(mockMvc.perform(builder).
//                andReturn().getResponse().getContentAsString());
    }
}