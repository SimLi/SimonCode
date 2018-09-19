package com.devfuns.controller;

import com.devfuns.core.execute.BlogThreadPoolFactory;
import com.devfuns.core.execute.MyRunable;
import com.devfuns.core.utils.DateUtil;
import com.devfuns.model.article.Contents;
import com.devfuns.result.ActionResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("simonBlog")
public class BlogController {

    private static int i = 0;

    @Resource
    BlogThreadPoolFactory threadPoolFactory;

    /**
     * 查询默认的博客文章列表
     * 默认查询10条数据
     * */
    @RequestMapping("/findBlogContent")
    public ActionResult findBlogContent() {
        ActionResult actionResult = new ActionResult();

        return actionResult;
    }

    @RequestMapping("/submitRunable")
    public ActionResult submitRunable(String threadName) {
        ActionResult actionResult = new ActionResult();
        MyRunable runable = new MyRunable(DateUtil.formatDate(new Date(),DateUtil.getPatternSdfYyyymmddhhssmm()));
        threadPoolFactory.submitExecutorRunable(runable);


        return actionResult;
    }



}
