package com.agony.service;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/14 22:13
 */
public interface UserService {
    String getUserById(String id);

    void deleteUserById(String id);
}
