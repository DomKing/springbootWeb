package org.prcode.business.support.basic.cache.service;

/**
 * @className: IBusiSupportCacheService
 * @date: 2017-04-01 14:52
 * @author: kangduo
 * @description: (param缓存)
 */
public interface CommSysParaService {
    String getCommSysParaValue(String paraCode);

    String updCommSysParaValue(String paraCode, String paraValue);

    void delCommSysParaValue(String paraCode);

    void refreshSysParaCache();
}
