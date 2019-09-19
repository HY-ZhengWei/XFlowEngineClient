package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.xflow.engine.common.BaseModel;





/**
 * 工作流接口的数据类型（多路并行）
 *
 * @author      ZhengWei(HY)
 * @createDate  2019-09-19
 * @version     v1.0
 */
public class FlowDataRoute extends BaseModel
{
    
    private static final long serialVersionUID = -6280944110904092313L;

    /** 路由编码 */
    private String                activityRouteCode;
    
    /** 指定下一活动的动态参与人 */
    private List<UserParticipant> participants;

    
    
    /**
     * 获取：路由编码
     */
    public String getActivityRouteCode()
    {
        return activityRouteCode;
    }

    
    /**
     * 获取：指定下一活动的动态参与人
     */
    public List<UserParticipant> getParticipants()
    {
        return participants;
    }

    
    /**
     * 设置：路由编码
     * 
     * @param activityRouteCode 
     */
    public void setActivityRouteCode(String activityRouteCode)
    {
        this.activityRouteCode = activityRouteCode;
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
