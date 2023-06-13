package com.ruoyi.app.mapper;

import com.ruoyi.app.domain.HumanEntity;
import java.util.List;

/**
 * 人员基本信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
public interface HumanEntityMapper
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
     * 删除人员基本信息
     * 
     * @param id 人员基本信息主键
     * @return 结果
     */
    public int deleteHumanEntityById(Long id);

    /**
     * 批量删除人员基本信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHumanEntityByIds(Long[] ids);
}
