package com.devfuns.service.impl;

import com.devfuns.model.article.Contents;
import com.devfuns.service.IBlogService;
import com.github.pagehelper.PageInfo;

public class BlogServiceDefaultImpl implements IBlogService {

    /**
     * 查看博客文章类表，默认查询10条
     * */
    @Override
    public PageInfo<Contents> findBlogContent() {
        return null;
    }
}
