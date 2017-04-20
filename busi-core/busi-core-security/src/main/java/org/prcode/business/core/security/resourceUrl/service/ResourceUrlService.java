package org.prcode.business.core.security.resourceUrl.service;

import org.prcode.business.core.security.resourceUrl.dao.ResourceUrlDao;
import org.prcode.business.core.security.resourceUrl.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ResourceUrlService
 * @Date: 2017-4-19 21:22
 * @Auther: kangduo
 * @Description: (resourceUrlService)
 */
@Service
public class ResourceUrlService implements IResourceUrlService{
    @Resource
    private ResourceUrlDao resourceUrlDao;

    @Override
    public List<Menu> getMenuListByUser(String userId, String systemCode) {
        return resourceUrlDao.getMenuListByUser(userId, systemCode);
    }

}
