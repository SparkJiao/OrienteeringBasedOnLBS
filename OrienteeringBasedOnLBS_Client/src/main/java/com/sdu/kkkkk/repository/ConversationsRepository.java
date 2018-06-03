package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Conversations;
import com.sdu.kkkkk.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ASUS on 2018/5/7.
 */
public interface ConversationsRepository extends JpaRepository<Conversations,Integer> {

    @Query("from Conversations c where (c.sender = ?1 and c.receiver = ?2) or (c.sender = ?2 and c.receiver = ?1) order by time")
    List<Conversations> findConversationsBySenderAndReceiver(String sender, String receiver);


}
