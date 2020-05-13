//package com.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * UserDetailsService: Spring Security User Service
// *
// * @author agony
// * @date 2020/5/4 22:02
// */
//@Service
//public class UserService implements UserDetailsService {
//    @Autowired
//    UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.loadUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Username Not Found!");
//        }
//        user.setRoles(userMapper.getUserRoleByUid(user.getId()));
//        return user;
//    }
//}
