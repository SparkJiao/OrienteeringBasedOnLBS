package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.FriendKey;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jnlp.IntegrationService;

/**
 * Created by ASUS on 2018/5/7.
 */
public interface FriendRepository extends JpaRepository<Friend,FriendKey> {
}
