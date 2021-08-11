package com.huawei.mapper.master;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lizhe
 * @date 2021-05-07 20:46
 */
@Mapper
public interface MasterUserMapper {
    String selectUserByUserName(int id);
}
