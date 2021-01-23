package com.citigroup.whuamm.module.domain.mapper;

import com.alibaba.fastjson.JSONArray;
import com.citigroup.whuamm.module.domain.bo.User;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;

/**
 * @author 李国鹏
 * @version 1.0.0
 * @date 2021/1/23 18:24
 */
public class UserDetailMapper {
    public static Map<String,Object> buildMap(User user)
    {
        Map<String,Object> map = Maps.newLinkedHashMap();
        if(Objects.isNull(user))
        {
            return map;
        }
        map.put("id",user.getId());
        map.put("access",user.getAccess());
        map.put("password",user.getPassword());
        map.put("address",user.getAddress());
        map.put("birthday",user.getBirthday());
        map.put("cardId",user.getCardId());
        map.put("email",user.getEmail());
        map.put("gender",user.getGender());
        map.put("information",user.getInformation());
        map.put("name",user.getName());
        map.put("phone",user.getPhone());
        map.put("photo",user.getPhoto());
        map.put("realName",user.getRealName());
        return map;
    }
}
