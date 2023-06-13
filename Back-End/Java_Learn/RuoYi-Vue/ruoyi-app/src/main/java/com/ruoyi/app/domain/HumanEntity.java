package com.ruoyi.app.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员基本信息对象 human_entity
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
public class HumanEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idCard;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 身份证信息 */
    @Excel(name = "身份证信息")
    private String idCardInfo;

    /** 银行卡信息 */
    @Excel(name = "银行卡信息")
    private String bankInfo;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 确认状态: 1未确认 / 2已确认 */
    @Excel(name = "确认状态: 1未确认 / 2已确认")
    private String confirmationStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setIdCardInfo(String idCardInfo) 
    {
        this.idCardInfo = idCardInfo;
    }

    public String getIdCardInfo() 
    {
        return idCardInfo;
    }
    public void setBankInfo(String bankInfo) 
    {
        this.bankInfo = bankInfo;
    }

    public String getBankInfo() 
    {
        return bankInfo;
    }
    public void setRegisterTime(Date registerTime) 
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() 
    {
        return registerTime;
    }
    public void setConfirmationStatus(String confirmationStatus) 
    {
        this.confirmationStatus = confirmationStatus;
    }

    public String getConfirmationStatus() 
    {
        return confirmationStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("idCard", getIdCard())
            .append("phone", getPhone())
            .append("idCardInfo", getIdCardInfo())
            .append("bankInfo", getBankInfo())
            .append("registerTime", getRegisterTime())
            .append("confirmationStatus", getConfirmationStatus())
            .toString();
    }
}
