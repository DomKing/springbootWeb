package org.prcode.business.core.security.role.entity;

import java.io.Serializable;

/**
 * @className: rolePrivilege
 * @date: 2017-4-22 15:52
 * @author: kangduo
 * @description: ()
 */
public class RolePrivilege implements Serializable{
    private static final long serialVersionUID = 5888472304440886625L;

    private Long resourceUrlId;
    private String urlDesc;
    private Long parentId;
    private Byte level;
    private Boolean hasPrivilege;

    public Long getResourceUrlId() {
        return resourceUrlId;
    }

    public void setResourceUrlId(Long resourceUrlId) {
        this.resourceUrlId = resourceUrlId;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Boolean isHasPrivilege() {
        return hasPrivilege;
    }

    public void setHasPrivilege(Boolean hasPrivilege) {
        this.hasPrivilege = hasPrivilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RolePrivilege that = (RolePrivilege) o;

        return resourceUrlId != null ? resourceUrlId.equals(that.resourceUrlId) : that.resourceUrlId == null;
    }

    @Override
    public int hashCode() {
        return resourceUrlId != null ? resourceUrlId.hashCode() : 0;
    }
}
