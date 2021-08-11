package com.huawei.controller;


import com.huawei.service.MasterUserService;
import com.huawei.service.SlaverUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhe
 * @date 2021-05-07 20:40
 */
@RestController
@RequestMapping("/slaver/user")
@Slf4j
public class SlaverUserController {

    @Autowired
    private SlaverUserService slaverUserService;


    @PostMapping(value = "/selectUserByUserName")
    public Map<String,Object> selectUserByUserName(@RequestBody Map<String,Object> map) {
        Map<String, Object> params = (Map<String, Object>) map.get("params");
        int id = params.get("account") == null ? 1 : (int) params.get("account");
        String name = slaverUserService.selectUserByUserName(id);
        Map<String, Object> rpsMap = new HashMap<String, Object>();
        rpsMap.put("name",name);
        return rpsMap;
    }

}
