package com.devfuns.model.users;

import java.util.Date;

/**
 * Created by sim on 2018/8/29.
 */
public class UserModel {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String homeUrl;
    private String screenName;
    private long created;
    private int activated;
    private int logged;
    private String groupName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                ", screenName='" + screenName + '\'' +
                ", created=" + created +
                ", activated=" + activated +
                ", logged=" + logged +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
