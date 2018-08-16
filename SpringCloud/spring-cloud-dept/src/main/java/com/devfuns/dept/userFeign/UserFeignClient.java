package com.devfuns.dept.userFeign;

import com.devfuns.dept.pojo.CloudUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "spring-user")
public interface UserFeignClient {

    @RequestMapping(value = "/spring-user/user/findUserById/{id}", method = RequestMethod.GET)
    public Map findUserById(@PathVariable("id") Integer userId);

    /**
     * RequestParam注解，构建多参数请求
     * */
    @RequestMapping(value = "/spring-user/user/selectUserByUser")
    public List<CloudUser> selectUserByUser(@RequestParam("userName") String userName,
                                            @RequestParam("actName") String actName);

    @RequestMapping(value = "/spring-user/user/selectUserByUser")
    public List<CloudUser> selectUserByUserMapParam( @RequestParam Map<String,Object> map);

}
