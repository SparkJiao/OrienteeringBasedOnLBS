package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.FriendKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.jnlp.IntegrationService;
import java.util.List;

/**
 * Created by ASUS on 2018/5/7.
 */
public interface FriendRepository extends JpaRepository<Friend,FriendKey> {

    @Query("select sid_1, sid_2 from Friend f where f.sid_1 = ?1 or f.sid_2 = ?1")
    List<Friend> findBySid(String sid);

}
