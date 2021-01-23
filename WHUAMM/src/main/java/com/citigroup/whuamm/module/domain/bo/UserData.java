package com.citigroup.whuamm.module.domain.bo;

import com.citigroup.whuamm.module.domain.entity.UserEntity;
import com.citigroup.whuamm.module.domain.status.Status;

import java.util.Objects;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 18:05
 */
public class UserData {
    public static UserEntity convert(User from, UserEntity to)
    {
        if (Objects.isNull(from))
        {
            return to;
        }
        if (Objects.isNull(to))
        {
            to = new UserEntity();
        }
        to.setId(from.getId());
        to.setAccess(from.getAccess());
        to.setAddress(from.getAddress());
        to.setBirthday(from.getBirthday());
        to.setCardId(from.getCardId());
        to.setGender(from.getGender());
        to.setInformation(from.getInformation());
        to.setRealName(from.getRealName());
        to.setPhoto(from.getPhoto());
        to.setPhone(from.getPhone());
        to.setPassword(from.getPassword());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setStatus(Status.OK);
        return to;
    }

    public static User convert(UserEntity from,User to)
    {
        if (Objects.isNull(from))
        {
            return to;
        }
        if (Objects.isNull(to))
        {
            to = new User();
        }
        to.setId(from.getId());
        to.setAccess(from.getAccess());
        to.setAddress(from.getAddress());
        to.setBirthday(from.getBirthday());
        to.setCardId(from.getCardId());
        to.setGender(from.getGender());
        to.setInformation(from.getInformation());
        to.setRealName(from.getRealName());
        to.setPhoto(from.getPhoto());
        to.setPhone(from.getPhone());
        to.setPassword(from.getPassword());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        return to;
    }
}
