package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HumanEntityMapper;
import com.ruoyi.system.domain.HumanEntity;
import com.ruoyi.system.service.IHumanEntityService;

/**
 * 人员基本信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
@Service
public class HumanEntityServiceImpl implements IHumanEntityService 
{
    @Autowired
    private HumanEntityMapper humanEntityMapper;

    /**
     * 查询人员基本信息
     * 
     * @param id 人员基本信息主键
     * @return 人员基本信息
     */
    @Override
    public HumanEntity selectHumanEntityById(Long id)
    {
        return humanEntityMapper.selectHumanEntityById(id);
    }

    /**
     * 查询人员基本信息列表
     * 
     * @param humanEntity 人员基本信息
     * @return 人员基本信息
     */
    @Override
    public List<HumanEntity> selectHumanEntityList(HumanEntity humanEntity)
    {
        return humanEntityMapper.selectHumanEntityList(humanEntity);
    }

    /**
     * 新增人员基本信息
     * 
     * @param humanEntity 人员基本信息
     * @return 结果
     */
    @Override
    public int insertHumanEntity(HumanEntity humanEntity)
    {
        return humanEntityMapper.insertHumanEntity(humanEntity);
    }

    /**
     * 修改人员基本信息
     * 
     * @param humanEntity 人员基本信息
     * @return 结果
     */
    @Override
    public int updateHumanEntity(HumanEntity humanEntity)
    {
        return humanEntityMapper.updateHumanEntity(humanEntity);
    }

    /**
     * 批量删除人员基本信息
     * 
     * @param ids 需要删除的人员基本信息主键
     * @return 结果
     */
    @Override
    public int deleteHumanEntityByIds(Long[] ids)
    {
        return humanEntityMapper.deleteHumanEntityByIds(ids);
    }

    /**
     * 删除人员基本信息信息
     * 
     * @param id 人员基本信息主键
     * @return 结果
     */
    @Override
    public int deleteHumanEntityById(Long id)
    {
        return humanEntityMapper.deleteHumanEntityById(id);
    }
}
