package org.prcode.business.core.security.resourceUrl.service;

import org.prcode.business.core.security.resourceUrl.entity.Menu;

import java.util.List;

/**
 * @ClassName: IResourceUrlService
 * @Date: 2017-4-19 21:19
 * @Auther: kangduo
 * @Description: (菜单权限service)
 */
public interface IResourceUrlService {

    List<Menu> getMenuListByUser(String userId, String systemCode);
}
