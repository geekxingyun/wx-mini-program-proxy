package com.xingyun.wxminiprogramproxy.business.dao.jpa;

import com.xingyun.wxminiprogramproxy.business.model.entity.WxUserBaseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Repository
public interface WxMiniProgramCustomerJpaRepository extends JpaRepository<WxUserBaseInfoEntity,Long> {
    Optional<WxUserBaseInfoEntity> findByOpenId(String openId);
    Optional<WxUserBaseInfoEntity> findByToken(String token);
}
