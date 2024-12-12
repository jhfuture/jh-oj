package com.jhfuture.jhojbackenduserservice.controller.inner;


import com.jh.jhojbackendmodel.model.entity.User;
import com.jhfuture.jhojbackendserviceclient.service.UserFeignClient;
import com.jhfuture.jhojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


/**
 * 用户服务,最好加上 implements UserFeignClient 方便标识
 *
 *
 */
@RestController
@RequestMapping("/inner")
public class UserInnerController  implements UserFeignClient {

    @Resource
    UserService userService;

    /**
     * 通过 id 获取用户
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") Long userId){
        return userService.getById(userId);
    }

    /**
     * 通过 ids 获取用户列表
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList){
        return userService.listByIds(idList);
    }



}
