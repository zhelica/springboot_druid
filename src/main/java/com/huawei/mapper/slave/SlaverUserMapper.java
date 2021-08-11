package com.huawei.mapper.slave;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lizhe
 * @date 2021-05-07 20:46
 */
@Mapper
public interface SlaverUserMapper {
    String selectUserByUserName(int id);
}
