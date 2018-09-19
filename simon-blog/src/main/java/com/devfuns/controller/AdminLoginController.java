package com.devfuns.controller;

import com.devfuns.core.utils.AuthToken;
import com.devfuns.model.users.UserModel;
import com.devfuns.result.ActionResult;
import com.devfuns.result.ActionResultEnum;
import com.devfuns.service.IAdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by sim on 2018/8/29.
 * 管理员认证登录
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {


    @Resource
    IAdminService adminService;

    @RequestMapping("/adminLogin")
    public ActionResult adminLogin(String userName, String password) {
        ActionResult actionResult = new ActionResult();
        UserModel userModel =adminService.selectUserByNameAndPassword(userName,password);
        if (userModel != null) { // 登录成功
            actionResult.setData(userModel);
            // 生成token
            actionResult.setToken(AuthToken.getAuthTokenCode(userModel.getScreenName(),AuthToken.TRANSIENCE));
        } else {
            actionResult.setCode(ActionResultEnum.FAILURE);
            actionResult.setData("用户名或密码不正确");
        }

        return actionResult;
    }

    @RequestMapping("adminEditBlog")
    public ActionResult adminEditBlog() {
        ActionResult actionResult = new ActionResult();

        return actionResult;
    }

}
