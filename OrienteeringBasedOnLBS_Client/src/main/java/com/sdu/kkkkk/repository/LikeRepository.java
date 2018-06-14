package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Like;
import com.sdu.kkkkk.entity.LikesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by kkkkk on 2018/6/10.
 */
public interface LikeRepository extends JpaRepository<Like, LikesKey> {

    void deleteLikeByTidAndSid(int tid, String sid);

    List<Like> findLikesByTidAndSidInOrderByTime(int tid, List<String> sids);

    List<Like> findLikesByTidInAndSidInAndTimeAfterOrderByTime(List<Integer> tids, List<String> sids, Date time);

    @Query("select tid from Like l where l.sid = ?1")
    List<Integer> findTidsBySid(String sid);
}
