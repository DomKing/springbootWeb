package org.prcode.basedomain.base;

import java.util.Date;

/**
 * @ClassName: BaseDomain
 * @Date: 2017-3-25 19:45
 * @Auther: kangduo
 * @Description: (数据库表需要继承的基类)
 */
public class BaseDomain {

    private Date sysAddTime;
    private Date sysUpdTime;
    private Date sysDelTime;
    private String sysAddUser;
    private String sysUpdUser;
    private String sysDelUser;
    private Boolean sysDelState;

    public Date getSysAddTime() {
        return sysAddTime;
    }

    public void setSysAddTime(Date sysAddTime) {
        this.sysAddTime = sysAddTime;
    }

    public Date getSysUpdTime() {
        return sysUpdTime;
    }

    public void setSysUpdTime(Date sysUpdTime) {
        this.sysUpdTime = sysUpdTime;
    }

    public Boolean getSysDelState() {
        return sysDelState;
    }

    public void setSysDelState(Boolean sysDelState) {
        this.sysDelState = sysDelState;
    }

    public Date getSysDelTime() {
        return sysDelTime;
    }

    public void setSysDelTime(Date sysDelTime) {
        this.sysDelTime = sysDelTime;
    }

    public String getSysAddUser() {
        return sysAddUser;
    }

    public void setSysAddUser(String sysAddUser) {
        this.sysAddUser = sysAddUser;
    }

    public String getSysUpdUser() {
        return sysUpdUser;
    }

    public void setSysUpdUser(String sysUpdUser) {
        this.sysUpdUser = sysUpdUser;
    }

    public String getSysDelUser() {
        return sysDelUser;
    }

    public void setSysDelUser(String sysDelUser) {
        this.sysDelUser = sysDelUser;
    }
}
