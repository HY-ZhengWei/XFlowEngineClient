package org.hy.xflow.engine.bean;

import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ActivityTypeEnum;





/**
 * 工作流活动(节点)类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-04-17
 * @version     v1.0
 *              v2.0  2024-06-06  修正：枚举类型与JSON相互转换的问题
 */
public class ActivityType extends BaseModel
{
    private static final long serialVersionUID = -4724247321457107633L;
    
    
    /** 工作流活动类型ID */
    private ActivityTypeEnum activityTypeID;
    
    /** 工作流活动类型名称 */
    private String           activityType;
    
    /** 备注说明 */
    private String           infoComment;
    
    /** 排列顺序 */
    private Integer          orderNo;
    
    
    
    /**
     * 获取：活动类型ID
     */
    public String getActivityTypeID()
    {
        if ( this.activityTypeID != null )
        {
            return this.activityTypeID.getValue();
        }
        else
        {
            return null;
        }
    }
    
    
    /**
     * 设置：活动类型ID
     */
    public void setActivityTypeID(String i_ActivityTypeID)
    {
        if ( i_ActivityTypeID != null )
        {
            this.activityTypeID = ActivityTypeEnum.get(i_ActivityTypeID);
        }
        else
        {
            this.activityTypeID = null;
        }
    }
    
    
    /**
     * 获取：工作流活动类型ID
     */
    public ActivityTypeEnum getActivityTypeIDEnum()
    {
        return this.activityTypeID;
    }

    
    /**
     * 设置：工作流活动类型ID
     * 
     * @param i_ActivityTypeID
     */
    public void setActivityTypeIDEnum(ActivityTypeEnum i_ActivityTypeID)
    {
        this.activityTypeID = i_ActivityTypeID;
    }
    
    
    /**
     * 获取：工作流活动类型名称
     */
    public String getActivityType()
    {
        return this.activityType;
    }

    
    /**
     * 设置：工作流活动类型名称
     * 
     * @param i_ActivityType
     */
    public void setActivityType(String i_ActivityType)
    {
        this.activityType = i_ActivityType;
    }
    
    
    /**
     * 获取：备注说明
     */
    public String getInfoComment()
    {
        return this.infoComment;
    }

    
    /**
     * 设置：备注说明
     * 
     * @param i_InfoComment
     */
    public void setInfoComment(String i_InfoComment)
    {
        this.infoComment = i_InfoComment;
    }

    
    /**
     * 获取：排列顺序
     */
    public Integer getOrderNo()
    {
        return orderNo;
    }

    
    /**
     * 设置：排列顺序
     * 
     * @param orderNo
     */
    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

}
