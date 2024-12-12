package com.jhfuture.jhojbackendserviceclient.service;


import com.jhfuture.jhojbackendcommon.common.ErrorCode;
import com.jhfuture.jhojbackendcommon.exception.BusinessException;
import com.jh.jhojbackendmodel.model.entity.User;
import com.jh.jhojbackendmodel.model.enums.UserRoleEnum;
import com.jh.jhojbackendmodel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.jhfuture.jhojbackendcommon.constant.UserConstant.USER_LOGIN_STATE;


/**
 * 用户服务
 *
 *
 */
@FeignClient(name = "jhoj-backend-user-service",path = "/api/user/inner")
public interface UserFeignClient {


    /**
     * 通过 id 获取用户
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
   User getById(@RequestParam("userId") Long userId);

    /**
     * 通过 ids 获取用户列表
     * @param idList
     * @return
     */
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);
    /**
     * 获取当前登录用户,不需要远程调用的
     *
     * @param request
     * @return
     */
   default User getLoginUser(HttpServletRequest request){
    // 先判断是否已登录
    Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
    User currentUser = (User) userObj;
    if (currentUser == null || currentUser.getId() == null) {
     throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
    }
    // 从数据库查询（追求性能的话可以注释，直接走缓存）
    long userId = currentUser.getId();
    currentUser = this.getById(userId);
    if (currentUser == null) {
     throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
    }
    return currentUser;
   }

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
  default   boolean isAdmin(HttpServletRequest request){
     // 仅管理员可查询
     Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
     User user = (User) userObj;
     return isAdmin(user);
    }

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
   default boolean isAdmin(User user){
     return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }



    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
   default UserVO getUserVO(User user){
     if (user == null) {
      return null;
     }
     UserVO userVO = new UserVO();
     BeanUtils.copyProperties(user, userVO);
     return userVO;
    }


}
