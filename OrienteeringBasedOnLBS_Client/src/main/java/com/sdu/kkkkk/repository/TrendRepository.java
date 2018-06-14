package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
public interface TrendRepository extends JpaRepository<Trend,Integer>{

    Trend deleteByTid(int tid);

    List<Trend> findTrendsBySid(String sid);

    //@Query("select tid, content, video, photo, sid, time from Trend t where t.sid in ?2 order by time")
    List<Trend> findTrendsBySidInOrderByTime(List<String> sids);

}
