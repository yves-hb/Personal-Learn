package com.ruoyi.app.service.impl;

import com.ruoyi.app.domain.HumanEntity;
import com.ruoyi.app.mapper.HumanEntityMapper;
import com.ruoyi.app.service.IHumanEntityService;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String importHumanData(List<HumanEntity> humanEntities, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(humanEntities) || humanEntities.size() == 0){
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if (isUpdateSupport){
            for (HumanEntity humanEntity : humanEntities) {
                try{
                    this.insertHumanEntity(humanEntity);
                    successNum++;
                    successMsg.append("账号 ").append(humanEntity.getName()).append(" 导入成功，共成功导入").append(successNum).append("条 <br/>");
                }catch (Exception e){
                    failureNum++;
                    failureMsg.append("账号 ").append(humanEntity.getName()).append(" 导入失败，失败原因：").append(e.getMessage());
                }
            }
        }else {
            for (HumanEntity humanEntity : humanEntities) {
                try{

                    this.insertHumanEntity(humanEntity);
                    successNum++;
                    successMsg.append("账号 ").append(humanEntity.getName()).append(" 导入成功，共成功导入").append(successNum).append("条 <br/>");
                }catch (Exception e){
                    failureNum++;
                    failureMsg.append("账号 ").append(humanEntity.getName()).append(" 导入失败，失败原因：").append(e.getMessage());
                }
            }
        }
        if (failureNum > 0){
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }else{
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
    }
}
