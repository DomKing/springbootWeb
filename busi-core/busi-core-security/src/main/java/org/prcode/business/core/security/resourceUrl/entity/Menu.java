package org.prcode.business.core.security.resourceUrl.entity;

import java.io.Serializable;

/**
 * @ClassName: Menu
 * @Date: 2017-4-19 21:20
 * @Auther: kangduo
 * @Description: (菜单)
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 3965859156413630061L;

    private String id;
    private String parentId;
    private String urlDesc;
    private String url;
    private Integer level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
