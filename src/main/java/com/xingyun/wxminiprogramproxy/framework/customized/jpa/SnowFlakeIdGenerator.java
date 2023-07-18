package com.xingyun.wxminiprogramproxy.framework.customized.jpa;

import com.xingyun.wxminiprogramproxy.framework.util.SnowFlakeUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/7
 * @apiNote
 */
public class SnowFlakeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return SnowFlakeUtils.nextId();
    }
}
