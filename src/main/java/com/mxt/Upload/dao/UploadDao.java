package com.mxt.Upload.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UploadDao {

    @Select("select res form test.Answer where title=SSRF1 and select")
    public  String SSRF1();

}
