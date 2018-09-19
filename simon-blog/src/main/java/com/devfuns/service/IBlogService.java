package com.devfuns.service;

import com.devfuns.model.article.Contents;
import com.github.pagehelper.PageInfo;

public interface IBlogService {

    PageInfo<Contents> findBlogContent();
}
