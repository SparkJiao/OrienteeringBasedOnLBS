package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment deleteByCid(int cid);

    //@Query("select cid, tid, time, content, sid, name, rsid, rname from Comment where sid in ?2 and rsid in ?2 and tid = ?1")
    List<Comment> findCommentsByTidAndSidInAndRsidInOrderByTime(int tid, List<String> sids1, List<String> sids2);

    @Query("select tid from Comment c where c.sid = ?1 or c.rsid = ?1")
    List<Integer> findTidsBySid(String sid);

    List<Comment> findCommentsByTidInAndSidInAndRsidInAndTimeAfterOrderByTime(List<Integer> tids, List<String> sids1, List<String> sids2, Date time);
}
