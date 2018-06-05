package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.FriendKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.jnlp.IntegrationService;
import java.util.List;

/**
 * Created by ASUS on 2018/5/7.
 */
public interface FriendRepository extends JpaRepository<Friend,FriendKey> {

    @Query("select sid_1 from Friend f where f.sid_2 = ?1")
    List<String> findSid_1BySid_2(String sid_2);

    @Query("select sid_2 from Friend f where f.sid_1 = ?1")
    List<String> findSid_2BySid_1(String sid_1);

    @Transactional
    @Modifying
    @Query("delete from Friend f where (f.sid_1 = ?1 and f.sid_2 = ?2) or (f.sid_2 = ?1 and f.sid_1 = ?2)")
    Friend deleteFriendBySid_1AndSid_2(String sid_1, String sid_2);
}
