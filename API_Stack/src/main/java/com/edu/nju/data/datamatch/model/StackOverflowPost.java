package com.edu.nju.data.datamatch.model;

/**
 * stack overflow的一个帖子实体
 */
public class StackOverflowPost {

    private long id;
    private String libName;
    private long postId;
    private long postTypeId;
    private long acceptedAnswerId;
    private long parentId;
    private java.sql.Timestamp creationDate;
    private java.sql.Timestamp deletionDate;
    private long score;
    private long viewCount;
    private String body;
    private long ownerUserId;
    private String ownerDisplayName;
    private long lastEditorUserId;
    private String lastEditorDisplayName;
    private java.sql.Timestamp lastEditDate;
    private java.sql.Timestamp lastActivityDate;
    private String title;
    private String tags;
    private long answerCount;
    private long commentCount;
    private long favoriteCount;
    private java.sql.Timestamp closedDate;
    private java.sql.Timestamp communityOwnedDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }


    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }


    public long getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(long postTypeId) {
        this.postTypeId = postTypeId;
    }


    public long getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(long acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }


    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }


    public java.sql.Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Timestamp creationDate) {
        this.creationDate = creationDate;
    }


    public java.sql.Timestamp getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(java.sql.Timestamp deletionDate) {
        this.deletionDate = deletionDate;
    }


    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }


    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }


    public long getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorUserId(long lastEditorUserId) {
        this.lastEditorUserId = lastEditorUserId;
    }


    public String getLastEditorDisplayName() {
        return lastEditorDisplayName;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        this.lastEditorDisplayName = lastEditorDisplayName;
    }


    public java.sql.Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(java.sql.Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }


    public java.sql.Timestamp getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(java.sql.Timestamp lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(long answerCount) {
        this.answerCount = answerCount;
    }


    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }


    public long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }


    public java.sql.Timestamp getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(java.sql.Timestamp closedDate) {
        this.closedDate = closedDate;
    }


    public java.sql.Timestamp getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(java.sql.Timestamp communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

}
