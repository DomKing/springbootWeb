package org.prcode.business.support.basic.cache.service;

import com.github.pagehelper.PageHelper;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.prcode.business.basedomain.commSysPara.dao.CommSysParaMapper;
import org.prcode.business.basedomain.commSysPara.domain.CommSysPara;
import org.prcode.business.basedomain.commSysPara.domain.CommSysParaExample;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @className: CommSysParaService
 * @date: 2017-04-01 14:53
 * @author: kangduo
 * @description: (param缓存实现类)
 */
@Service("commSysParaService")
public class CommSysParaServiceImpl implements CommSysParaService {

    private static final Logger logger = Logger.getLogger(CommSysParaServiceImpl.class);
    @Resource
    private CommSysParaMapper commSysParaMapper;

    /**
     * 查询指定code的value值，并存到redis，如果redis有值，则直接返回，不访问数据库
     * sync = true 表示并发情况下，只允许一个线程访问数据库
     *
     * @param paraCode code
     * @return 对应的值
     */
    @Cacheable(value = "mysql:commSysParaMapper:commSysPara", key = "#paraCode", sync = true)
    @Override
    public String getCommSysParaValue(String paraCode) {
        CommSysParaExample example = new CommSysParaExample();
        example.createCriteria().andSysParaCodeEqualTo(paraCode).andSysDelStateEqualTo(false);
        example.setOrderByClause("f_id desc");
        PageHelper.startPage(1, 1, false);
        List<CommSysPara> commSysParas = commSysParaMapper.selectByExample(example);
        if (commSysParas == null || commSysParas.size() == 0) {
            return null;
        }
        return commSysParas.get(0).getSysParaValue();
    }

    /**
     * 更新数据库的值，并更新redis的值
     *
     * @param paraCode  code
     * @param paraValue value
     * @return 更新后的值
     */
    @CachePut(value = "mysql:commSysParaMapper:commSysPara", key = "#paraCode")
    @Override
    public String updCommSysParaValue(String paraCode, String paraValue) {
        CommSysPara para = new CommSysPara();
        para.setSysParaValue(paraValue);
        para.setSysUpdTime(new Date());
        CommSysParaExample example = new CommSysParaExample();
        example.createCriteria().andSysParaCodeEqualTo(paraCode);
        commSysParaMapper.updateByExampleSelective(para, example);
        return paraValue;
    }

    /**
     * 数据库标记删除，并删除redis里的存值
     *
     * @param paraCode code
     */
    @CacheEvict(value = "mysql:commSysParaMapper:commSysPara", key = "#paraCode")
    @Override
    public void delCommSysParaValue(String paraCode) {
        CommSysPara para = new CommSysPara();
        para.setSysDelTime(new Date());
        para.setSysDelState(true);
        CommSysParaExample example = new CommSysParaExample();
        example.createCriteria().andSysParaCodeEqualTo(paraCode);
        commSysParaMapper.updateByExampleSelective(para, example);
    }

    /**
     * 清空para表在redis的缓存,系统初始化的时候清空
     */
    @CacheEvict(value = "mysql:commSysParaMapper:commSysPara", allEntries = true)
    @Override
    public void refreshSysParaCache() {
        logger.debug("==========清空redis中的参数缓存===========");
    }
}
