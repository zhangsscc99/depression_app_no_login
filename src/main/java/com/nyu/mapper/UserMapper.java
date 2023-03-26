package com.nyu.mapper;

import com.nyu.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Insert("insert into user (name, account_id, token, gmt_create, gmt_modified) values (#(name), #(accountId), #(token), #(gmtCreate), #(gmtModified)")

    public void insert(User user);
}
