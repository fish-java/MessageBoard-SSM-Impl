package dao;

import base.BaseTest;
import com.alibaba.fastjson.JSONObject;
import entity.Message;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.image.ImageWatched;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MessageDaoTest extends BaseTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void insert(){
        Message message = new Message();
        message.setUsername("Jan");
        message.setContent("Hello，LS");

        // 插入一条数据
        // 如果插入成功，MyBatis会将返回值传递到ID这个属性
        messageDao.insert(message);
        Assert.assertNotNull(message.getId());
    }

    @Test
    public void deleteByPrimaryKey(){

    }

    @Test
    public void selectOrderByLimitAndOffset(){
        List<Message> messages = messageDao.selectOrderByLimitAndOffset(
                new Date(22),"create_datetime",  3, 3);
        System.out.println(JSONObject.toJSONString(messages));
        // [...]
    }



//    int insertSelective(Message record);
//
//    Message selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Message record);
//
//    int updateByPrimaryKey(Message record);
}