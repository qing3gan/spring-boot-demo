package com.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/4 16:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    /**
     * 加密: 散列函数（散列算法，哈希函数）【MD5，SHA】
     */
    @Test
    public void testPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("dba"));
        System.out.println(passwordEncoder.encode("user"));
        System.out.println(passwordEncoder.encode("other"));
    }
}
