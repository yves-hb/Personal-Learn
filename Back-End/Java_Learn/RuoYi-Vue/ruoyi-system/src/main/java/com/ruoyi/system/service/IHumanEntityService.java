package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HumanEntity;

/**
 * 人员基本信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
public interface IHumanEntityService 
{
    /**
     * 查询人员基本信息
     * 
     * @param id 人员基本信息主键
     * @return 人员基本信息
     */
    public HumanEntity selectHumanEntityById(Long id);

    /**
     * 查询人员基本信息列表
     * 
     * @param humanEntity 人员基本信息
     * @return 人员基本信息集合
     */
    public List<HumanEntity> selectHumanEntityList(HumanEntity humanEntity);

    /**
     * 新增人员基本信息
     * 
     * @param humanEntity 人员基本信息
     * @return 结果
     */
    public int insertHumanEntity(HumanEntity humanEntity);

    /**
     * 修改人员基本信息
     * 
     * @param humanEntity 人员基本信息
     * @return 结果
     */
    public int updateHumanEntity(HumanEntity humanEntity);

    /**
     * 批量删除人员基本信息
     * 
     * @param ids 需要删除的人员基本信息主键集合
     * @return 结果
     */
    public int deleteHumanEntityByIds(Long[] ids);

    /**
     * 删除人员基本信息信息
     * 
     * @param id 人员基本信息主键
     * @return 结果
     */
    public int deleteHumanEntityById(Long id);
}
