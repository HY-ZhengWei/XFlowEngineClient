package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.xflow.engine.common.BaseModel;





/**
 * 工作流接口的数据类型（用于自由驳回）
 *
 * @author      ZhengWei(HY)
 * @createDate  2023-02-22
 * @version     v1.0
 */
public class FlowDataActivity extends BaseModel
{
    
    private static final long serialVersionUID = -1518568050042573365L;

    /** 活动节点编码 */
    private String                activityCode;
    
    /** 指定下一活动的动态参与人 */
    private List<UserParticipant> participants;

    
    
    /**
     * 获取：活动节点编码
     */
    public String getActivityCode()
    {
        return activityCode;
    }


    
    /**
     * 设置：活动节点编码
     * 
     * @param i_ActivityCode 活动节点编码
     */
    public void setActivityCode(String i_ActivityCode)
    {
        this.activityCode = i_ActivityCode;
    }



    /**
     * 获取：指定下一活动的动态参与人
     */
    public List<UserParticipant> getParticipants()
    {
        return participants;
    }

    
    
    /**
     * 设置：指定下一活动的动态参与人
     * 
     * @param participants
     */
    public void setParticipants(List<UserParticipant> participants)
    {
        this.participants = participants;
    }
    
}
