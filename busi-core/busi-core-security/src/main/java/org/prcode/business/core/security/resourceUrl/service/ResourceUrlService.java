package org.prcode.business.core.security.resourceUrl.service;

import org.prcode.business.core.security.resourceUrl.entity.Menu;

import java.util.List;

/**
 * @className: IResourceUrlService
 * @date: 2017-4-19 21:19
 * @author: kangduo
 * @description: (菜单权限service)
 */
public interface ResourceUrlService {

    List<Menu> getMenuListByUser(String userId, String systemCode);
}
