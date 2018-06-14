package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Groupnote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkk on 2018/6/4.
 */
public interface GroupnoteRepository extends JpaRepository<Groupnote, Integer>{

    List<Groupnote> findGroupnotesByGidEqualsAndGnidGreaterThanOrderByTime(int gid, int gnid);

}
