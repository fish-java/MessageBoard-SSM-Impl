package controller.users;

import dao.UserDao;
import entity.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.Verifier;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class Users {
    @Autowired
    private UserDao userDao;

    @PostMapping
    public ResponseEntity createUser(
            @RequestBody User user) {
        Map resultMessage = new HashMap();

        // 检查用户名是否合法
        if(!Verifier.isValidName(user.getUsername())){
            resultMessage.put("message", "name should start with alphabet and no special char");
            return ResponseEntity.status(HttpStatus.valueOf(404)).body(resultMessage);
        }

        // 创建一个随机字符串作为token
        String token = RandomStringUtils.randomAlphanumeric(30);
        user.setToken(token);

        // id应该由数据库自行创建
        // 如果客户端设置了id，应该予以清除
        user.setId(null);

        int res = userDao.insert(user);
        if(res != 1){ // 说明插入失败
            resultMessage.put("message", "failed to insert to database");
            return ResponseEntity.status(404).body(resultMessage);
        }

        // 到这步说明一切正常，创建成功，把创建好的数据返回给客户端
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(user);
    }
}
