package com.citigroup.whuamm.module.dao;

import com.citigroup.whuamm.module.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 17:52
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity,String>  {
    UserEntity findByRealNameAndPassword(String userName,String password);
}
