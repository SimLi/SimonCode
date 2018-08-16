package com.devperson.pojo;

import org.beetl.sql.core.annotatoin.AssignID;

public class UserAccount {
    private String accountName;

    @AssignID("guid")
    private String Id;

    private String accountUserName;
    private String accountPassword;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Override
    public String toString() {
        return "userAccount{" +
                "accountName='" + accountName + '\'' +
                ", Id='" + Id + '\'' +
                ", accountUserName='" + accountUserName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                '}';
    }
}
