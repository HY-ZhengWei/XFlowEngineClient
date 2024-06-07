package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.common.PartitionMap;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;





/**
 * 查询用户可以走的路由的数据结构。
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-05-28
 * @version     v1.0
 *              v2.0  2024-06-06  修正：枚举类型与JSON相互转换的问题
 */
public class NextRoutes extends BaseModel
{
    private static final long serialVersionUID = -8064344771494245788L;

    
    
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
    
    /** 查询用户可以走的路由 */
    private List<ActivityRoute>                      routes;
    
    /** 曾经流转过的节点及流转信息（同一活动节点，只保留最后一次的，不重复） */
    private List<FlowProcess>                        activitys;
    
    /** 历次的汇总信息（按时间倒序排列） */
    private List<FlowProcess>                        summarys;
    
    /** 当前查询人的参与类型 */
    private ParticipantTypeEnum                      participantType;
    
    
    
    public NextRoutes()
    {
        
    }
    
    
    
    public NextRoutes(FlowInfo                                 i_Flow
                     ,FlowProcess                              i_CurrentProcess
                     ,ActivityInfo                             i_CurrentActivity
                     ,PartitionMap<String ,ProcessParticipant> i_FlowParticipants
                     ,List<ActivityRoute>                      i_Routes
                     ,List<FlowProcess>                        i_Activitys
                     ,ParticipantTypeEnum                      i_ParticipantType)
    {
        this.flow             = i_Flow;
        this.currentProcess   = i_CurrentProcess;
        this.currentActivity  = i_CurrentActivity;
        this.flowParticipants = i_FlowParticipants;
        this.routes           = i_Routes;
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
     * 获取：当前流转信息
     */
    public FlowProcess getCurrentProcess()
    {
        return currentProcess;
    }
    

    
    /**
     * 获取：当前活动节点
     */
    public ActivityInfo getCurrentActivity()
    {
        return currentActivity;
    }
    

    
    /**
     * 设置：工作流实例。应包含所有流转信息，即flow.processes有值
     * 
     * @param flow
     */
    public void setFlow(FlowInfo flow)
    {
        this.flow = flow;
    }
    

    
    /**
     * 设置：当前流转信息
     * 
     * @param currentProcess
     */
    public void setCurrentProcess(FlowProcess currentProcess)
    {
        this.currentProcess = currentProcess;
    }
    

    
    /**
     * 设置：当前活动节点
     * 
     * @param currentActivity
     */
    public void setCurrentActivity(ActivityInfo currentActivity)
    {
        this.currentActivity = currentActivity;
    }


    
    /**
     * 获取：查询用户可以走的路由
     */
    public List<ActivityRoute> getRoutes()
    {
        return routes;
    }
    


    /**
     * 设置：查询用户可以走的路由
     * 
     * @param routes
     */
    public void setRoutes(List<ActivityRoute> routes)
    {
        this.routes = routes;
    }


    
    /**
     * 获取：工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     *      Map.key 是流转ID
     */
    public PartitionMap<String ,ProcessParticipant> getFlowParticipants()
    {
        return flowParticipants;
    }
    

    
    /**
     * 设置：工作流流转过程的动态参与人信息（所有流转过程的所有动态参与人）
     *      Map.key 是流转ID
     * 
     * @param flowParticipants
     */
    public void setFlowParticipants(PartitionMap<String ,ProcessParticipant> flowParticipants)
    {
        this.flowParticipants = flowParticipants;
    }

    
    
    /**
     * 获取：历次的汇总信息（按时间倒序排列）
     */
    public List<FlowProcess> getSummarys()
    {
        return summarys;
    }

    

    /**
     * 设置：历次的汇总信息（按时间倒序排列）
     * 
     * @param summarys
     */
    public void setSummarys(List<FlowProcess> summarys)
    {
        this.summarys = summarys;
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


    
    /**
     * 获取：曾经流转过的节点及流转信息（同一活动节点，只保留最后一次的，不重复）
     */
    public List<FlowProcess> getActivitys()
    {
        return activitys;
    }


    
    /**
     * 设置：曾经流转过的节点及流转信息（同一活动节点，只保留最后一次的，不重复）
     * 
     * @param i_Activitys 曾经流转过的节点及流转信息（同一活动节点，只保留最后一次的，不重复）
     */
    public void setActivitys(List<FlowProcess> i_Activitys)
    {
        this.activitys = i_Activitys;
    }
    
}
