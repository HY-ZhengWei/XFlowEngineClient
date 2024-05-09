package org.hy.xflow.engine.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.Date;
import org.hy.common.Help;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ActivityTypeEnum;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;





/**
 * 工作流活动组件(节点)信息表
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-04-17
 * @version     v1.0
 *              v2.0  2019-08-29  添加：fontColor 文字颜色的配置
 */
public class ActivityInfo extends BaseModel
{
    private static final long serialVersionUID = -4724247321457107633L;
    
    
    /** 本活动组件（节点）的参与人。谁从此路过。（内存合成） */
    private List<Participant> participants;
    
    /** 本活动组件（节点）的参与人，是否为流程发起人。（内存合成） */
    private Participant participantByCreater;
    
    /**
     * 本活动组件（节点）的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * Map.key为Participant.objectID，即另一个活动的ActivityID
     */
    private Map<String ,Participant> participantByActivitys;
    
    /** 本活动组件（节点）的所有通过路由信息（内存合成） */
    private List<ActivityRoute> routes;
    
    /** 工作流活动ID */
    private String activityID;
    
    /** 工作流活动Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。 */
    private String activityCode;
    
    /** 工作流的模板ID */
    private String templateID;
    
    /** 活动名称 */
    private String activityName;
    
    /** 活动类型ID */
    private ActivityTypeEnum activityTypeID;
    
    /** 活动类型（内存合成） */
    private ActivityType activityType;
    
    /** 位置x坐标值 */
    private Double  x;
    
    /** 位置y坐标值 */
    private Double  y;
    
    /** 位置z坐标值 */
    private Double  z;
    
    /** 图标高度 */
    private Double  height;
    
    /** 图标宽度 */
    private Double  width;
    
    /** 图标路径 */
    private String  iconURL;
    
    /** 活动节点的背景色 */
    private String  backgroudColor;
    
    /** 活动节点的边框线颜色 */
    private String  lineColor;
    
    /** 活动节点的标记块颜色 */
    private String  flagColor;
    
    /** 活动节点的文字颜色 */
    private String  fontColor;
    
    /** 备注说明 */
    private String  infoComment;
    
    /** 汇总通过值。当大于等于此值后，才能继续向下流转 */
    private Double  summaryPass;
    
    /** 汇总人数的限制。当大于等于此值后，才能继续向下流转 */
    private Integer counterPass;
    
    /** 汇总类型。指summaryPass和counterPass的关系是与，还是或 */
    private String  passType;
    
    /** 配置页面的路径，可由终端用户决定配置页面的展示样子。用于配置阶段，并非实例流转。 */
    private String  configPageURL;
    
    /** 配置页面的数据。将保存配置页面中的数据到工作流系统中，当再次打开配置时，通过POST请求传递参数的方式给配置页面。 */
    private String  configPageDatas;
    
    /** 规则引擎的配置代码 */
    private String  xrouteConfig;
    
    /** 创建人员ID */
    private String  createrID;
    
    /** 创建人员名称 */
    private String  creater;
    
    /** 创建时间 */
    private Date    createTime;
    
    /** 最后修改人员ID */
    private String  lastUserID;
    
    /** 最后修改人员名称 */
    private String  lastUser;
    
    /** 最后修改时间 */
    private Date    lastTime;
    
    
    
    /**
     * 创建一个简单的活动实例。主要是：防止递归引用，对外界传递数据使用。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2019-09-19
     * @version     v1.0
     *
     * @return
     */
    public ActivityInfo toSimple()
    {
        ActivityInfo v_Activity = new ActivityInfo();
        
        v_Activity.setTemplateID(     this.getTemplateID());
        v_Activity.setActivityID(     this.getActivityID());
        v_Activity.setActivityCode(   this.getActivityCode());
        v_Activity.setActivityName(   this.getActivityName());
        v_Activity.setActivityType(   this.getActivityType());
        v_Activity.setInfoComment(    this.getInfoComment());
        v_Activity.setSummaryPass(    this.getSummaryPass());
        v_Activity.setCounterPass(    this.getCounterPass());
        v_Activity.setPassType(       this.getPassType());
        v_Activity.setConfigPageURL(  this.getConfigPageURL());
        v_Activity.setConfigPageDatas(this.getConfigPageDatas());
        v_Activity.setXrouteConfig(   this.getXrouteConfig());
        
        return v_Activity;
    }
    
    
    /**
     * 判定用户信息是否当前活动的参与人之一
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
     * 初始化合成1：工作流活动的参与人，是否为流程发起人。（内存合成）
     * 初始化合成2：工作流活动的参与人，是否为另一个活动的实际操作人。（内存合成）
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
     * 获取：本活动组件（节点）的参与人。谁从此路过。（内存合成）
     */
    public List<Participant> getParticipants()
    {
        return participants;
    }
    
    
    /**
     * 设置：本活动组件（节点）的参与人。谁从此路过。（内存合成）
     * 
     * @param participants
     */
    public void setParticipants(List<Participant> participants)
    {
        this.participants = participants;
        
        initParticipants();
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
     * 获取：本活动组件（节点）的参与人，是否为另一个活动的实际操作人。（内存合成）
     * 
     * Map.key为Participant.objectID，即另一个活动的ActivityID
     */
    public Map<String ,Participant> getParticipantByActivitys()
    {
        return participantByActivitys;
    }
    
    
    /**
     * 设置：本活动组件（节点）的参与人，是否为另一个活动的实际操作人。（内存合成）
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
     * 获取：本活动组件（节点）的所有通过路由信息（内存合成）
     */
    public List<ActivityRoute> getRoutes()
    {
        return routes;
    }

    
    /**
     * 设置：本活动组件（节点）的所有通过路由信息（内存合成）
     * 
     * @param routes
     */
    public void setRoutes(List<ActivityRoute> routes)
    {
        this.routes = routes;
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
     * 获取：工作流活动Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。
     */
    public String getActivityCode()
    {
        return activityCode;
    }

    
    /**
     * 设置：工作流活动Code。作为与外界交互的编码。同一版本的工作流下是惟一的，不同版本的同类工作流可以相同。
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
     * 获取：活动名称
     */
    public String getActivityName()
    {
        return this.activityName;
    }

    
    /**
     * 设置：活动名称
     * 
     * @param i_ActivityName
     */
    public void setActivityName(String i_ActivityName)
    {
        this.activityName = i_ActivityName;
    }
    
    
    /**
     * 获取：活动类型ID
     */
    public ActivityTypeEnum getActivityTypeID()
    {
        return this.activityTypeID;
    }

    
    /**
     * 设置：活动类型ID
     * 
     * @param i_ActivityTypeID
     */
    public void setActivityTypeID(ActivityTypeEnum i_ActivityTypeID)
    {
        this.activityTypeID = i_ActivityTypeID;
    }
    
    
    /**
     * 获取：活动类型（内存合成）
     */
    public ActivityType getActivityType()
    {
        return activityType;
    }
    
    
    /**
     * 设置：活动类型（内存合成）
     * 
     * @param activityType
     */
    public void setActivityType(ActivityType activityType)
    {
        this.activityType = activityType;
    }
    

    /**
     * 获取：位置x坐标值
     */
    public Double getX()
    {
        return this.x;
    }

    
    /**
     * 设置：位置x坐标值
     * 
     * @param i_X
     */
    public void setX(Double i_X)
    {
        this.x = i_X;
    }
    
    
    /**
     * 获取：位置y坐标值
     */
    public Double getY()
    {
        return this.y;
    }

    
    /**
     * 设置：位置y坐标值
     * 
     * @param i_Y
     */
    public void setY(Double i_Y)
    {
        this.y = i_Y;
    }
    
    
    /**
     * 获取：位置z坐标值
     */
    public Double getZ()
    {
        return this.z;
    }

    
    /**
     * 设置：位置z坐标值
     * 
     * @param i_Z
     */
    public void setZ(Double i_Z)
    {
        this.z = i_Z;
    }
    
    
    /**
     * 获取：图标高度
     */
    public Double getHeight()
    {
        return this.height;
    }

    
    /**
     * 设置：图标高度
     * 
     * @param i_Height
     */
    public void setHeight(Double i_Height)
    {
        this.height = i_Height;
    }
    
    
    /**
     * 获取：图标宽度
     */
    public Double getWidth()
    {
        return this.width;
    }

    
    /**
     * 设置：图标宽度
     * 
     * @param i_Width
     */
    public void setWidth(Double i_Width)
    {
        this.width = i_Width;
    }
    
    
    /**
     * 获取：图标路径
     */
    public String getIconURL()
    {
        return this.iconURL;
    }

    
    /**
     * 设置：图标路径
     * 
     * @param i_IconURL
     */
    public void setIconURL(String i_IconURL)
    {
        this.iconURL = i_IconURL;
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
     * 获取：活动节点的背景色
     */
    public String getBackgroudColor()
    {
        return backgroudColor;
    }

    
    /**
     * 设置：活动节点的背景色
     * 
     * @param backgroudColor
     */
    public void setBackgroudColor(String backgroudColor)
    {
        this.backgroudColor = backgroudColor;
    }

    
    /**
     * 获取：活动节点的边框线颜色
     */
    public String getLineColor()
    {
        return lineColor;
    }

    
    /**
     * 设置：活动节点的边框线颜色
     * 
     * @param lineColor
     */
    public void setLineColor(String lineColor)
    {
        this.lineColor = lineColor;
    }

    
    /**
     * 获取：活动节点的标记块颜色
     */
    public String getFlagColor()
    {
        return flagColor;
    }

    
    /**
     * 设置：活动节点的标记块颜色
     * 
     * @param flagColor
     */
    public void setFlagColor(String flagColor)
    {
        this.flagColor = flagColor;
    }

    
    /**
     * 获取：活动节点的文字颜色
     */
    public String getFontColor()
    {
        return fontColor;
    }


    /**
     * 设置：活动节点的文字颜色
     * 
     * @param fontColor
     */
    public void setFontColor(String fontColor)
    {
        this.fontColor = fontColor;
    }

    
    /**
     * 获取：汇总通过值。当大于等于此值后，才能继续向下流转
     */
    public Double getSummaryPass()
    {
        return Help.NVL(summaryPass);
    }

    
    /**
     * 设置：汇总通过值。当大于等于此值后，才能继续向下流转
     * 
     * @param summaryPass
     */
    public void setSummaryPass(Double summaryPass)
    {
        this.summaryPass = summaryPass;
    }

    
    /**
     * 获取：汇总人数的限制。当大于等于此值后，才能继续向下流转
     */
    public Integer getCounterPass()
    {
        return Help.NVL(counterPass);
    }


    /**
     * 获取：汇总类型。指summaryPass和counterPass的关系是与，还是或
     */
    public String getPassType()
    {
        return passType;
    }

    
    /**
     * 设置：汇总人数的限制。当大于等于此值后，才能继续向下流转
     * 
     * @param counterPass
     */
    public void setCounterPass(Integer counterPass)
    {
        this.counterPass = counterPass;
    }

    
    /**
     * 设置：汇总类型。指summaryPass和counterPass的关系是与，还是或
     * 
     * @param passType
     */
    public void setPassType(String passType)
    {
        this.passType = passType;
    }

    
    /**
     * 获取：配置页面的路径，可由终端用户决定配置页面的展示样子。用于配置阶段，并非实例流转。
     */
    public String getConfigPageURL()
    {
        return configPageURL;
    }

    
    /**
     * 获取：配置页面的数据。将保存配置页面中的数据到工作流系统中，当再次打开配置时，通过POST请求传递参数的方式给配置页面。
     */
    public String getConfigPageDatas()
    {
        return configPageDatas;
    }

    
    /**
     * 获取：规则引擎的配置代码
     */
    public String getXrouteConfig()
    {
        return xrouteConfig;
    }

    
    /**
     * 设置：配置页面的路径，可由终端用户决定配置页面的展示样子。用于配置阶段，并非实例流转。
     * 
     * @param configPageURL
     */
    public void setConfigPageURL(String configPageURL)
    {
        this.configPageURL = configPageURL;
    }

    
    /**
     * 设置：配置页面的数据。将保存配置页面中的数据到工作流系统中，当再次打开配置时，通过POST请求传递参数的方式给配置页面。
     * 
     * @param configPageDatas
     */
    public void setConfigPageDatas(String configPageDatas)
    {
        this.configPageDatas = configPageDatas;
    }

    
    /**
     * 设置：规则引擎的配置代码
     * 
     * @param xrouteConfig
     */
    public void setXrouteConfig(String xrouteConfig)
    {
        this.xrouteConfig = xrouteConfig;
    }

}
