package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Groupmember;
import com.sdu.kkkkk.entity.GroupmemberKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ASUS on 2018/6/4.
 */
public interface GroupmemberRepository extends JpaRepository<Groupmember,GroupmemberKey>{
    //List<Groupmember> findGroupmembersBySid(String sid);
    @Query("select gid from Groupmember gp where gp.sid = ?1")
    List<Integer> findGidsBySid(String sid);
}