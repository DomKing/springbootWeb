package org.prcode.business.core.security.resourceUrl.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.core.security.resourceUrl.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: ResourceUrlDao
 * @Date: 2017-4-19 21:22
 * @Auther: kangduo
 * @Description: ()
 */
@Repository
public interface ResourceUrlDao {
    public List<Menu> getMenuListByUser(@Param("userId") String userId, @Param("systemCode") String systemCode);
}
