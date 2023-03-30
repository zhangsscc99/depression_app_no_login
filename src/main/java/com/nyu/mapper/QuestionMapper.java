package com.nyu.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public class QuestionMapper {
    @Insert("insert into (title, description, gmt_create, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmt_create}, #{gmt_modified}, #{creator}, #{tag}")
    public void create(Question question);
}
