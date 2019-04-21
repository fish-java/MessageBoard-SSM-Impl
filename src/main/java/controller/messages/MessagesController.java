package controller.messages;

import controller.Config;
import dao.MessageDao;
import entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessageDao messageDao;

    @GetMapping
    public List<Message> getMessage(
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
            @RequestParam(required = false) Date since,
            @RequestParam(defaultValue = "update_datetime") String sort,
            @RequestParam Integer page){
        Integer offset = (page - 1) * Config.defaultPageSize;

        List<Message> messages = messageDao.selectOrderByLimitAndOffset(
                since, sort, Config.defaultPageSize, offset);
        return messages;
    }
}
