package com.huawei.service.impl;


import com.huawei.mapper.master.MasterUserMapper;
import com.huawei.mapper.slave.SlaverUserMapper;
import com.huawei.service.MasterUserService;
import com.huawei.service.SlaverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhe
 * @date 2021-05-07 20:53
 */
@Service
public class SlaverUserServiceImpl implements SlaverUserService {
    @Autowired
    private SlaverUserMapper slaverUserMapper;

    @Override
    public String selectUserByUserName(int id) {
        return slaverUserMapper.selectUserByUserName(id);
    }
}
