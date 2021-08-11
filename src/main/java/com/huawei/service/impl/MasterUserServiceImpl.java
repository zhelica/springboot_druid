package com.huawei.service.impl;


import com.huawei.mapper.master.MasterUserMapper;
import com.huawei.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhe
 * @date 2021-05-07 20:53
 */
@Service
public class MasterUserServiceImpl implements MasterUserService {
    @Autowired
    private MasterUserMapper masterUserMapper;

    @Override
    public String selectUserByUserName(int id) {
        return masterUserMapper.selectUserByUserName(id);
    }
}
