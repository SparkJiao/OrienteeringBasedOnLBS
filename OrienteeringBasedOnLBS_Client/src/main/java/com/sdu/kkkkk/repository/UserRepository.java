package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkk on 2018/4/1.
 */
public interface UserRepository extends JpaRepository<User,String>{
    User findBySid(String sid);
    User findByName(String name);
}
