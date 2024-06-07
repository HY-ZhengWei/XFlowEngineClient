package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.common.PartitionMap;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;





/**
 * 工作流实例曾经流转过的节点
 *
 * @author      ZhengWei(HY)
 * @createDate  2023-01-31
 * @version     v1.0
 *              v2.0  2024-06-06  修正：枚举类型与JSON相互转换的问题
 */
public class ProcessActivitys extends BaseModel
{

    private static final long serialVersionUID = -3273240609655857309L;
    
    
    
    /** 工作流实例。应包含所有流转信息，即flow.processes有值 */
    private FlowInfo                                 flow;
    
    /** 当前流转信息 */
    private FlowProcess                              currentProcess;
    
    /** 当前活动节点 */
    private ActivityInfo                             currentActivity;
    
    /**
     * 工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     * Map.key 是流转ID
     */
    private PartitionMap<String ,ProcessParticipant> flowParticipants;
    
    /** 曾经流转过的节点及流转信息（同一活动节点，只保留最后一次的，不重复） */
    private List<FlowProcess>                        activitys;
    
    /** 当前查询人的参与类型 */
    private ParticipantTypeEnum                      participantType;

    
    
    public ProcessActivitys()
    {
        
    }
    
    
    
    public ProcessActivitys(FlowInfo                                 i_Flow
                           ,FlowProcess                              i_CurrentProcess
                           ,ActivityInfo                             i_CurrentActivity
                           ,PartitionMap<String ,ProcessParticipant> i_FlowParticipants
                           ,List<FlowProcess>                        i_Activitys
                           ,ParticipantTypeEnum                      i_ParticipantType)
    {
        this.flow             = i_Flow;
        this.currentProcess   = i_CurrentProcess;
        this.currentActivity  = i_CurrentActivity;
        this.flowParticipants = i_FlowParticipants;
        this.activitys        = i_Activitys;
        this.participantType  = i_ParticipantType;
    }
    
    
    
    /**
     * 获取：工作流实例。应包含所有流转信息，即flow.processes有值
     */
    public FlowInfo getFlow()
    {
        return flow;
    }

    
    /**
     * 设置：工作流实例。应包含所有流转信息，即flow.processes有值
     * 
     * @param i_Flow 工作流实例。应包含所有流转信息，即flow.processes有值
     */
    public void setFlow(FlowInfo i_Flow)
    {
        this.flow = i_Flow;
    }

    
    /**
     * 获取：当前流转信息
     */
    public FlowProcess getCurrentProcess()
    {
        return currentProcess;
    }

    
    /**
     * 设置：当前流转信息
     * 
     * @param i_CurrentProcess 当前流转信息
     */
    public void setCurrentProcess(FlowProcess i_CurrentProcess)
    {
        this.currentProcess = i_CurrentProcess;
    }

    
    /**
     * 获取：当前活动节点
     */
    public ActivityInfo getCurrentActivity()
    {
        return currentActivity;
    }

    
    /**
     * 设置：当前活动节点
     * 
     * @param i_CurrentActivity 当前活动节点
     */
    public void setCurrentActivity(ActivityInfo i_CurrentActivity)
    {
        this.currentActivity = i_CurrentActivity;
    }

    
    /**
     * 获取：工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     * Map.key 是流转ID
     */
    public PartitionMap<String ,ProcessParticipant> getFlowParticipants()
    {
        return flowParticipants;
    }

    
    /**
     * 设置：工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     * Map.key 是流转ID
     * 
     * @param i_FlowParticipants 工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     */
    public void setFlowParticipants(PartitionMap<String ,ProcessParticipant> i_FlowParticipants)
    {
        this.flowParticipants = i_FlowParticipants;
    }

    
    /**
     * 获取：曾经流转过的节点
     */
    public List<FlowProcess> getActivitys()
    {
        return activitys;
    }

    
    /**
     * 设置：曾经流转过的节点
     * 
     * @param i_Activitys 曾经流转过的节点
     */
    public void setActivitys(List<FlowProcess> i_Activitys)
    {
        this.activitys = i_Activitys;
    }
    
    
    /**
     * 获取：当前查询人的参与类型
     */
    public Integer getParticipantType()
    {
        if ( this.participantType != null )
        {
            return participantType.getValue();
        }
        else
        {
            return null;
        }
    }
    
    
    /**
     * 设置：当前查询人的参与类型
     * 
     * @param i_ParticipantType 当前查询人的参与类型
     */
    public void setParticipantType(Integer i_ParticipantType)
    {
        if ( i_ParticipantType != null )
        {
            this.participantType = ParticipantTypeEnum.get(i_ParticipantType);
        }
        else
        {
            this.participantType = null;
        }
    }

    
    /**
     * 获取：当前查询人的参与类型
     */
    public ParticipantTypeEnum getParticipantTypeEnum()
    {
        return participantType;
    }

    
    /**
     * 设置：当前查询人的参与类型
     * 
     * @param i_ParticipantType 当前查询人的参与类型
     */
    public void setParticipantTypeEnum(ParticipantTypeEnum i_ParticipantType)
    {
        this.participantType = i_ParticipantType;
    }
    
}
