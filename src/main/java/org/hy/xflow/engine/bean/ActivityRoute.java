package org.hy.xflow.engine.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.Date;
import org.hy.common.Help;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;
import org.hy.xflow.engine.enums.RouteTypeEnum;





/**
 * 工作流活动组件(节点)的路由表
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-04-17
 * @version     v1.0
 *              v2.0  2019-08-29  添加：fontColor 文字颜色的配置
 *              v3.0  2024-04-23  添加：界面UI的4个字段
 *              v4.0  2024-06-06  修正：枚举类型与JSON相互转换的问题
 */
public class ActivityRoute extends BaseModel
{
    private static final long serialVersionUID = -4724247321457107633L;
    
    
    /** 主键ID */
    private String                   activityRouteID;
    
    /** 活动路由Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。 */
    private String                   activityRouteCode;
    
    /** 活动路由名称 */
    private String                   activityRouteName;
    
    /** 工作流的模板ID */
    private String                   templateID;
    
    /** 工作流路由类型ID */
    private RouteTypeEnum            routeTypeID;
    
    /** 工作流路由类型（内存合成） */
    private RouteType                routeType;
    
    /** 工作流路由的参与人。谁从此路过。（内存合成） */
    private List<Participant>        participants;
    
    /** 本路由的参与人，是否为流程发起人。（内存合成） */
    private Participant              participantByCreater;
    
    /**
     * 本路由的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * Map.key为Participant.objectID，即另一个活动的ActivityID
     */
    private Map<String ,Participant> participantByActivitys;
    
    /** 工作流活动ID */
    private String                   activityID;
    
    /** 工作流活动编码 */
    private String                   activityCode;
    
    /** 路由A-B两端，从A到B的A端活动（内存合成） */
    private ActivityInfo             activity;
    
    /** 下一活动ID。可以为不同工作流模板的活动。即支持子流程 */
    private String                   nextActivityID;
    
    /** 下一活动编码 */
    private String                   nextActivityCode;
    
    /** 下一活动（内存合成） */
    private ActivityInfo             nextActivity;
    
    /** 有条件判定时，执行的XJava对象ID */
    private String                    conditionXJavaID;
    
    /** 有条件判定时，执行的对象方法名称 */
    private String                    conditionMethod;
    
    /** 有条件判定时，方法执行结果的对比值 */
    private String                    conditionValue;
    
    /** 有条件判定时，对比值的数据类型（1:数字；2:布尔值；3:文本） */
    private Integer                   conditionVType;
    
    /** 路由连接线的颜色 */
    private String                    lineColor;
    
    /** 路由连接线的文字颜色 */
    private String                    fontColor;
    
    /** 备注说明 */
    private String                    infoComment;
    
    /** 创建人员ID */
    private String                    createrID;
    
    /** 创建人员名称 */
    private String                    creater;
    
    /** 创建时间 */
    private Date                      createTime;
    
    /** 最后修改人员ID */
    private String                    lastUserID;
    
    /** 最后修改人员名称 */
    private String                    lastUser;
    
    /** 最后修改时间 */
    private Date                      lastTime;
    
    /** 权重。权重值越大，优先级越高 */
    private Integer                   weight;
    
    /** 界面UI：来自节点具体的端点 */
    private String                    fromPort;
    
    /** 界面UI：去往节点的具体端点 */
    private String                    toPort;
    
    /** 界面UI：是否挂载条件 */
    private Integer                   isHaveCondition;
    
    /** 界面UI：汇签类型路由的汇总值 */
    private Double                    summaryValues;
    
    
    
    /**
     * 判定用户信息是否当前活动路由的参与人之一
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-25
     * @version     v1.0
     *              v2.0  2024-04-11  添加：排除执行人、排除抄送人
     *
     * @param i_User
     * @return
     */
    public Participant isParticipant(User i_User)
    {
        if ( i_User == null )
        {
            return null;
        }
        if ( Help.isNull(this.participants) )
        {
            return null;
        }
        
        for (Participant v_Participant : this.participants)
        {
            if ( ParticipantTypeEnum.$ExcludeUser     == v_Participant.getObjectTypeEnum()
              || ParticipantTypeEnum.$ExcludeUserSend == v_Participant.getObjectTypeEnum() )
            {
                if ( v_Participant.getObjectID().equals(i_User.getUserID()) )
                {
                    return null;
                }
            }
            else if ( ParticipantTypeEnum.$User     == v_Participant.getObjectTypeEnum()
                   || ParticipantTypeEnum.$UserSend == v_Participant.getObjectTypeEnum() )
            {
                if ( v_Participant.getObjectID().equals(i_User.getUserID()) )
                {
                    return v_Participant;
                }
            }
            else if ( ParticipantTypeEnum.$Org     == v_Participant.getObjectTypeEnum()
                   || ParticipantTypeEnum.$OrgSend == v_Participant.getObjectTypeEnum() )
            {
                if ( v_Participant.getObjectID().equals(i_User.getOrgID()) )
                {
                    return v_Participant;
                }
            }
            else if ( ParticipantTypeEnum.$Role     == v_Participant.getObjectTypeEnum()
                   || ParticipantTypeEnum.$RoleSend == v_Participant.getObjectTypeEnum() )
            {
                if ( Help.isNull(i_User.getRoles()) )
                {
                    continue;
                }
                
                for (UserRole v_Role : i_User.getRoles())
                {
                    if ( v_Participant.getObjectID().equals(v_Role.getRoleID()) )
                    {
                        return v_Participant;
                    }
                }
            }
        }
        
        return null;
    }
    
    
    
    /**
     * 初始化合成1：工作流路由的参与人，是否为流程发起人。（内存合成）
     * 初始化合成2：工作流路由的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * 自动提前合成的原因是：一次合成多次使用，提高查询速度
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-09
     * @version     v1.0
     *
     */
    public void initParticipants()
    {
        this.participantByCreater   = null;
        this.participantByActivitys = new HashMap<String ,Participant>();
        
        if ( !Help.isNull(this.participants) )
        {
            for (Participant v_Part : this.participants)
            {
                if ( v_Part.getObjectTypeEnum() == ParticipantTypeEnum.$CreateUser )
                {
                    this.participantByCreater = v_Part;
                }
                
                if ( v_Part.getObjectTypeEnum() == ParticipantTypeEnum.$ActivityUser )
                {
                    this.participantByActivitys.put(v_Part.getObjectID() ,v_Part);
                }
            }
        }
    }
    
    
    
    /**
     * 获取：路由A-B两端，从A到B的A端活动（内存合成）
     */
    public ActivityInfo getActivity()
    {
        return activity;
    }
    
    
    /**
     * 获取：下一活动（内存合成）
     */
    public ActivityInfo getNextActivity()
    {
        return nextActivity;
    }
    
    
    /**
     * 设置：路由A-B两端，从A到B的A端活动（内存合成）
     * 
     * @param activity
     */
    public void setActivity(ActivityInfo activity)
    {
        this.activity = activity;
    }
    
    
    /**
     * 设置：下一活动（内存合成）
     * 
     * @param nextActivity
     */
    public void setNextActivity(ActivityInfo nextActivity)
    {
        this.nextActivity = nextActivity;
    }
    
    
    /**
     * 获取：主键ID
     */
    public String getActivityRouteID()
    {
        return activityRouteID;
    }
    
    
    /**
     * 设置：主键ID
     * 
     * @param activityRouteID
     */
    public void setActivityRouteID(String activityRouteID)
    {
        this.activityRouteID = activityRouteID;
    }
    
    
    /**
     * 获取：活动路由Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。
     */
    public String getActivityRouteCode()
    {
        return activityRouteCode;
    }

    
    /**
     * 设置：活动路由Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。
     * 
     * @param activityRouteCode
     */
    public void setActivityRouteCode(String activityRouteCode)
    {
        this.activityRouteCode = activityRouteCode;
    }


    /**
     * 获取：活动路由名称
     */
    public String getActivityRouteName()
    {
        return activityRouteName;
    }

    
    /**
     * 设置：活动路由名称
     * 
     * @param activityRouteName
     */
    public void setActivityRouteName(String activityRouteName)
    {
        this.activityRouteName = activityRouteName;
    }


    /**
     * 获取：工作流活动ID
     */
    public String getActivityID()
    {
        return this.activityID;
    }

    
    /**
     * 设置：工作流活动ID
     * 
     * @param i_ActivityID
     */
    public void setActivityID(String i_ActivityID)
    {
        this.activityID = i_ActivityID;
    }
    
    
    /**
     * 获取：工作流活动编码
     */
    public String getActivityCode()
    {
        return activityCode;
    }

    
    /**
     * 设置：工作流活动编码
     * 
     * @param activityCode
     */
    public void setActivityCode(String activityCode)
    {
        this.activityCode = activityCode;
    }


    /**
     * 获取：工作流的模板ID
     */
    public String getTemplateID()
    {
        return this.templateID;
    }

    
    /**
     * 设置：工作流的模板ID
     * 
     * @param i_TemplateID
     */
    public void setTemplateID(String i_TemplateID)
    {
        this.templateID = i_TemplateID;
    }
    
    
    /**
     * 获取：工作流路由类型ID
     */
    public String getRouteTypeID()
    {
        if ( this.routeTypeID != null )
        {
            return this.routeTypeID.getValue();
        }
        else
        {
            return null;
        }
    }
    
    
    /**
     * 获取：工作流路由类型（内存合成）
     */
    public void setRouteTypeID(String i_RouteTypeID)
    {
        if ( i_RouteTypeID != null )
        {
            this.routeTypeID = RouteTypeEnum.get(i_RouteTypeID);
        }
        else
        {
            this.routeTypeID = null;
        }
    }
    
    
    /**
     * 获取：工作流路由类型ID
     */
    public RouteTypeEnum getRouteTypeIDEnum()
    {
        return routeTypeID;
    }
    
    
    /**
     * 设置：工作流路由类型ID
     * 
     * @param routeTypeID
     */
    public void setRouteTypeIDEnum(RouteTypeEnum routeTypeID)
    {
        this.routeTypeID = routeTypeID;
    }
    
    
    /**
     * 获取：工作流路由类型（内存合成）
     */
    public RouteType getRouteType()
    {
        return routeType;
    }

    
    /**
     * 设置：工作流路由类型（内存合成）
     * 
     * @param routeType
     */
    public void setRouteType(RouteType routeType)
    {
        this.routeType = routeType;
    }
    
    
    /**
     * 获取：工作流路由的参与人。谁从此路过。（内存合成）
     */
    public List<Participant> getParticipants()
    {
        return participants;
    }

    
    /**
     * 设置：工作流路由的参与人。谁从此路过。（内存合成）
     * 
     * @param participants
     */
    public void setParticipants(List<Participant> participants)
    {
        this.participants = participants;
        
        this.initParticipants();
    }
    
    
    /**
     * 获取：本活动组件（节点）的参与人，是否为流程发起人。（内存合成）
     */
    public Participant getParticipantByCreater()
    {
        return participantByCreater;
    }

    
    /**
     * 设置：本活动组件（节点）的参与人，是否为流程发起人。（内存合成）
     * 
     * @param participantByCreater
     */
    public void setParticipantByCreater(Participant participantByCreater)
    {
        this.participantByCreater = participantByCreater;
    }


    /**
     * 获取：* 本路由的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * Map.key为Participant.objectID，即另一个活动的ActivityID
     */
    public Map<String ,Participant> getParticipantByActivitys()
    {
        return participantByActivitys;
    }

    
    /**
     * 设置：* 本路由的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * Map.key为Participant.objectID，即另一个活动的ActivityID
     * 
     * @param participantByActivitys
     */
    public void setParticipantByActivitys(Map<String ,Participant> participantByActivitys)
    {
        this.participantByActivitys = participantByActivitys;
    }


    /**
     * 获取：下一活动ID。可以为不同工作流模板的活动。即支持子流程
     */
    public String getNextActivityID()
    {
        return this.nextActivityID;
    }

    
    /**
     * 设置：下一活动ID。可以为不同工作流模板的活动。即支持子流程
     * 
     * @param i_NextActivityID
     */
    public void setNextActivityID(String i_NextActivityID)
    {
        this.nextActivityID = i_NextActivityID;
    }
    
    
    /**
     * 获取：下一活动编码
     */
    public String getNextActivityCode()
    {
        return nextActivityCode;
    }

    
    /**
     * 设置：下一活动编码
     * 
     * @param nextActivityCode
     */
    public void setNextActivityCode(String nextActivityCode)
    {
        this.nextActivityCode = nextActivityCode;
    }


    /**
     * 获取：有条件判定时，执行的XJava对象ID
     */
    public String getConditionXJavaID()
    {
        return this.conditionXJavaID;
    }

    
    /**
     * 设置：有条件判定时，执行的XJava对象ID
     * 
     * @param i_ConditionXJavaID
     */
    public void setConditionXJavaID(String i_ConditionXJavaID)
    {
        this.conditionXJavaID = i_ConditionXJavaID;
    }
    
    
    /**
     * 获取：有条件判定时，执行的对象方法名称
     */
    public String getConditionMethod()
    {
        return this.conditionMethod;
    }

    
    /**
     * 设置：有条件判定时，执行的对象方法名称
     * 
     * @param i_ConditionMethod
     */
    public void setConditionMethod(String i_ConditionMethod)
    {
        this.conditionMethod = i_ConditionMethod;
    }
    
    
    /**
     * 获取：有条件判定时，方法执行结果的对比值
     */
    public String getConditionValue()
    {
        return this.conditionValue;
    }

    
    /**
     * 设置：有条件判定时，方法执行结果的对比值
     * 
     * @param i_ConditionValue
     */
    public void setConditionValue(String i_ConditionValue)
    {
        this.conditionValue = i_ConditionValue;
    }
    
    
    /**
     * 获取：有条件判定时，对比值的数据类型（1:数字；2:布尔值；3:文本）
     */
    public Integer getConditionVType()
    {
        return this.conditionVType;
    }

    
    /**
     * 设置：有条件判定时，对比值的数据类型（1:数字；2:布尔值；3:文本）
     * 
     * @param i_ConditionVType
     */
    public void setConditionVType(Integer i_ConditionVType)
    {
        this.conditionVType = i_ConditionVType;
    }
    
    
    /**
     * 获取：路由连接线的颜色
     */
    public String getLineColor()
    {
        return lineColor;
    }

    
    /**
     * 设置：路由连接线的颜色
     * 
     * @param lineColor
     */
    public void setLineColor(String lineColor)
    {
        this.lineColor = lineColor;
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
     * 获取：创建人员ID
     */
    public String getCreaterID()
    {
        return this.createrID;
    }

    
    /**
     * 设置：创建人员ID
     * 
     * @param i_CreaterID
     */
    public void setCreaterID(String i_CreaterID)
    {
        this.createrID = i_CreaterID;
    }
    
    
    /**
     * 获取：创建人员名称
     */
    public String getCreater()
    {
        return this.creater;
    }

    
    /**
     * 设置：创建人员名称
     * 
     * @param i_Creater
     */
    public void setCreater(String i_Creater)
    {
        this.creater = i_Creater;
    }
    
    
    /**
     * 获取：创建时间
     */
    public Date getCreateTime()
    {
        return this.createTime;
    }

    
    /**
     * 设置：创建时间
     * 
     * @param i_CreateTime
     */
    public void setCreateTime(Date i_CreateTime)
    {
        this.createTime = i_CreateTime;
    }
    
    
    /**
     * 获取：最后修改人员ID
     */
    public String getLastUserID()
    {
        return this.lastUserID;
    }

    
    /**
     * 设置：最后修改人员ID
     * 
     * @param i_LastUserID
     */
    public void setLastUserID(String i_LastUserID)
    {
        this.lastUserID = i_LastUserID;
    }
    
    
    /**
     * 获取：最后修改人员名称
     */
    public String getLastUser()
    {
        return this.lastUser;
    }

    
    /**
     * 设置：最后修改人员名称
     * 
     * @param i_LastUser
     */
    public void setLastUser(String i_LastUser)
    {
        this.lastUser = i_LastUser;
    }
    
    
    /**
     * 获取：最后修改时间
     */
    public Date getLastTime()
    {
        return this.lastTime;
    }

    
    /**
     * 设置：最后修改时间
     * 
     * @param i_LastTime
     */
    public void setLastTime(Date i_LastTime)
    {
        this.lastTime = i_LastTime;
    }

    
    /**
     * 获取：路由连接线的文字颜色
     */
    public String getFontColor()
    {
        return fontColor;
    }

    
    /**
     * 设置：路由连接线的文字颜色
     * 
     * @param fontColor
     */
    public void setFontColor(String fontColor)
    {
        this.fontColor = fontColor;
    }


    /**
     * 获取：权重。权重值越大，优先级越高
     */
    public Integer getWeight()
    {
        return weight;
    }

    
    /**
     * 设置：权重。权重值越大，优先级越高
     * 
     * @param i_Weight 权重。权重值越大，优先级越高
     */
    public void setWeight(Integer i_Weight)
    {
        this.weight = i_Weight;
    }


    /**
     * 获取：界面UI：来自节点具体的端点
     */
    public String getFromPort()
    {
        return fromPort;
    }

    
    /**
     * 设置：界面UI：来自节点具体的端点
     * 
     * @param i_FromPort 界面UI：来自节点具体的端点
     */
    public void setFromPort(String i_FromPort)
    {
        this.fromPort = i_FromPort;
    }

    
    /**
     * 获取：界面UI：去往节点的具体端点
     */
    public String getToPort()
    {
        return toPort;
    }

    
    /**
     * 设置：界面UI：去往节点的具体端点
     * 
     * @param i_ToPort 界面UI：去往节点的具体端点
     */
    public void setToPort(String i_ToPort)
    {
        this.toPort = i_ToPort;
    }

    
    /**
     * 获取：界面UI：是否挂载条件
     */
    public Integer getIsHaveCondition()
    {
        return isHaveCondition;
    }


    /**
     * 设置：界面UI：是否挂载条件
     * 
     * @param i_IsHaveCondition 界面UI：是否挂载条件
     */
    public void setIsHaveCondition(Integer i_IsHaveCondition)
    {
        this.isHaveCondition = i_IsHaveCondition;
    }

    
    /**
     * 获取：界面UI：汇签类型路由的汇总值
     */
    public Double getSummaryValues()
    {
        return summaryValues;
    }


    /**
     * 设置：界面UI：汇签类型路由的汇总值
     * 
     * @param i_SummaryValues 界面UI：汇签类型路由的汇总值
     */
    public void setSummaryValues(Double i_SummaryValues)
    {
        this.summaryValues = i_SummaryValues;
    }

}
