package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkk on 2018/6/4.
 */
public interface GroupRepository extends JpaRepository<Group,String> {
    Group findGroupByGid(int gid);
}
