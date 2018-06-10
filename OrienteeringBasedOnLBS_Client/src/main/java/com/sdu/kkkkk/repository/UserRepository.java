package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.models.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
public interface UserRepository extends JpaRepository<User,String>{
    User findBySid(String sid);

    @Transactional
    @Modifying
    @Query("update User as r set r.longitude = ?2, r.latitude = ?3 where r.sid = ?1")
    void updateLongitudeAndLatitudeBySid(String id, String longitude, String latitude);

    @Query("select sid, image, name from User u where u.name = ?1")
    List<Userinfo> findUsersByName(String name);
}
