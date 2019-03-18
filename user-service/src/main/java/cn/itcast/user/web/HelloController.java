package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Young
 * @date 2019/3/11 19:05
 * @description：
 */
@RestController
@Slf4j
@RequestMapping("user")
public class HelloController {

    @Autowired
    private UserService userServie;

    @GetMapping("/{id}")
    public User hello(@PathVariable("id") Long id){
        log.debug("hello method is running");
        return userServie.queryById(id);
    }

}
