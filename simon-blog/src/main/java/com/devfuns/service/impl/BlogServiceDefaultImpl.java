package com.devfuns.service.impl;

import com.devfuns.mapper.ContentsMapper;
import com.devfuns.model.article.Contents;
import com.devfuns.service.IBlogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogServiceDefaultImpl implements IBlogService {

    @Resource
    ContentsMapper contentsMapper;

    /**
     * 查看博客文章类表，默认查询10条
     * */
    @Override
    public PageInfo<Contents> findBlogContent() {
        PageInfo<Contents> list = PageHelper.startPage(1,10).doSelectPageInfo(() -> {
            contentsMapper.selectContentPage();
        });
        return list;
    }

    @Override
    public Page<Contents> findBlogContentByPage() {
        Page<Contents> list = PageHelper.startPage(1,10).doSelectPage(() -> {
            contentsMapper.selectContentPage();
        });
        return list;
    }
}
