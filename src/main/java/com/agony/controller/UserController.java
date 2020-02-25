package com.agony.controller;

import com.agony.dao1.UserJpaOne;
import com.agony.dao2.UserJpaTwo;
import com.agony.model.User;
import com.agony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/14 23:09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    public String getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("deleteUserById/{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
    }

    @Autowired
    private UserJpaOne userJpaOne;

    @Autowired
    private UserJpaTwo userJpaTwo;

    @GetMapping("/multi")
    public void multi() {
        User user = new User();
        user.setName("鲁迅");
        user.setGender("男");
        user.setAge(55);
        userJpaOne.save(user);
        User user2 = new User();
        user2.setName("泰戈尔");
        user2.setGender("男");
        user2.setAge(80);
        userJpaTwo.save(user2);
    }
}
