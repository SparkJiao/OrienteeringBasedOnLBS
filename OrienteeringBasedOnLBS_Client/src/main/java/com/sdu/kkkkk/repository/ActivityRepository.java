package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
public interface ActivityRepository extends JpaRepository<Activity,Integer>{

    List<Activity> findActivitiesBySidEquals(String sid);
}
