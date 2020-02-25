package com.agony.dao2;

import com.agony.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * desc
 *
 * @author agony
 * @date 2020/2/25 22:31
 */
public interface UserJpaTwo extends JpaRepository<User, Integer> {
}
