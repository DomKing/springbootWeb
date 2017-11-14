package org.prcode.business.core.security.resourceUrl.service;

import org.prcode.business.core.security.resourceUrl.dao.ResourceUrlDao;
import org.prcode.business.core.security.resourceUrl.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: ResourceUrlService
 * @date: 2017-4-19 21:22
 * @author: kangduo
 * @description: (resourceUrlService)
 */
@Service("resourceUrlService")
public class ResourceUrlServiceImpl implements ResourceUrlService {
    @Resource
    private ResourceUrlDao resourceUrlDao;

    @Override
    public List<Menu> getMenuListByUser(Long userId, String systemCode) {
        return resourceUrlDao.getMenuListByUser(userId, systemCode);
    }

}
