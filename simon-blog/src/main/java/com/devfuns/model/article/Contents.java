package com.devfuns.model.article;

public class Contents {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.cid
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.title
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.slug
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String slug;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.created
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.modified
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer modified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.author_id
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer authorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.type
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.status
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.tags
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String tags;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.categories
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String categories;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.hits
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer hits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.comments_num
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Integer commentsNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.allow_comment
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Boolean allowComment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.allow_ping
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Boolean allowPing;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.allow_feed
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private Boolean allowFeed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contents.content
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.cid
     *
     * @return the value of t_contents.cid
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.cid
     *
     * @param cid the value for t_contents.cid
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.title
     *
     * @return the value of t_contents.title
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.title
     *
     * @param title the value for t_contents.title
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.slug
     *
     * @return the value of t_contents.slug
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getSlug() {
        return slug;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.slug
     *
     * @param slug the value for t_contents.slug
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.created
     *
     * @return the value of t_contents.created
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.created
     *
     * @param created the value for t_contents.created
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.modified
     *
     * @return the value of t_contents.modified
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.modified
     *
     * @param modified the value for t_contents.modified
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setModified(Integer modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.author_id
     *
     * @return the value of t_contents.author_id
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.author_id
     *
     * @param authorId the value for t_contents.author_id
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.type
     *
     * @return the value of t_contents.type
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.type
     *
     * @param type the value for t_contents.type
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.status
     *
     * @return the value of t_contents.status
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.status
     *
     * @param status the value for t_contents.status
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.tags
     *
     * @return the value of t_contents.tags
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.tags
     *
     * @param tags the value for t_contents.tags
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.categories
     *
     * @return the value of t_contents.categories
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getCategories() {
        return categories;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.categories
     *
     * @param categories the value for t_contents.categories
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.hits
     *
     * @return the value of t_contents.hits
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.hits
     *
     * @param hits the value for t_contents.hits
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.comments_num
     *
     * @return the value of t_contents.comments_num
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Integer getCommentsNum() {
        return commentsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.comments_num
     *
     * @param commentsNum the value for t_contents.comments_num
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.allow_comment
     *
     * @return the value of t_contents.allow_comment
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Boolean getAllowComment() {
        return allowComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.allow_comment
     *
     * @param allowComment the value for t_contents.allow_comment
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.allow_ping
     *
     * @return the value of t_contents.allow_ping
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Boolean getAllowPing() {
        return allowPing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.allow_ping
     *
     * @param allowPing the value for t_contents.allow_ping
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setAllowPing(Boolean allowPing) {
        this.allowPing = allowPing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.allow_feed
     *
     * @return the value of t_contents.allow_feed
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public Boolean getAllowFeed() {
        return allowFeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.allow_feed
     *
     * @param allowFeed the value for t_contents.allow_feed
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setAllowFeed(Boolean allowFeed) {
        this.allowFeed = allowFeed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contents.content
     *
     * @return the value of t_contents.content
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contents.content
     *
     * @param content the value for t_contents.content
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}