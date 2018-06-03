package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Conversations;
import com.sdu.kkkkk.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ASUS on 2018/6/3.
 */
public interface RequestRepository extends JpaRepository<Request,Integer> {

    List<Request> findRequestByReceiver(String receiver);

    List<Request> findRequestBySender(String sender);

    @Query("update Request as r set r.state = 1 where r.rid = ?1 ")
    void agree(int rid);

    @Query("update Request as r set r.state = -1 where r.rid = ?1")
    void disagree(int rid);
}
