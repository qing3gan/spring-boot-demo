package com.agony.service.impl;

import com.agony.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/14 22:15
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Override
    public String getUserById(String id) {
        logger.info("get user: " + id);
        return "get user: " + id;
    }

    @Override
    public void deleteUserById(String id) {
        logger.info("delete user: " + id);
    }
}
