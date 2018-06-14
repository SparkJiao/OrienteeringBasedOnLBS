package com.sdu.kkkkk.repository;

import com.sdu.kkkkk.entity.Wechat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkk on 2018/6/4.
 */
public interface WechatRepository extends JpaRepository<Wechat,Integer> {

    Wechat findWechatByGid(int gid);

    //Wechat save(Wechat group);
}
