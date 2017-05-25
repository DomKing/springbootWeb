package org.prcode.business.support.basic.cache.service;

/**
 * @ClassName: IBusiSupportCacheService
 * @Date: 2017-04-01 14:52
 * @Auther: kangduo
 * @Description: (param缓存)
 */
public interface ICommSysParaService {
    String getCommSysParaValue(String paraCode);

    String updCommSysParaValue(String paraCode, String paraValue);

    void delCommSysParaValue(String paraCode);

    void refreshSysParaCache();
}
