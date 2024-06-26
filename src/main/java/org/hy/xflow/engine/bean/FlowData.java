package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.RejectModeEnum;





/**
 * 工作流接口的数据类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-05-17
 * @version     v1.0
 *              v2.0  2019-09-19  添加：汇总值、汇总人数、操作文件、操作数据、备注说明
 *              v2.0  2024-06-06  修正：枚举类型与JSON相互转换的问题
 */
public class FlowData extends BaseModel
{

    private static final long serialVersionUID = -8362950623214901037L;
    
    
    
    /** 用户信息 */
    private User                       user;
    
    /** 工作流模板名称 */
    private String                     templateName;
    
    /** 模板版本号 */
    private Integer                    versionNo;
    
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String                     serviceDataID;
    
    /** 工作流实例ID */
    private String                     workID;
    
    /** 单路流转：路由编码 */
    private String                     activityRouteCode;
    
    /** 单路驳回：活动节点的编码 */
    private String                     activityCode;
    
    /** 单路流转&驳回：指定下一活动的动态参与人 */
    private List<UserParticipant>      participants;
    
    /** 多路并发的流转信息 */
    private List<FlowDataRoute>        routes;
    
    /** 多路并发的自由驳回的流转信息（未在工作流模板上预先配置驳回路由） */
    private List<FlowDataActivity>     activitys;
    
    /** 驳回模式。auto:自动模式；team：协同模式 */
    private RejectModeEnum             rejectMode;
    
    /** 汇总值 */
    private Double                     summary;
    
    /** 提交汇总的总人数 */
    private Integer                    counter;
    
    /** 操作文件信息，由第三方使用者定义其内容（拓展性数据） */
    private String                     operateFiles;
    
    /** 操作数据信息，由第三方使用者定义其内容（拓展性数据） */
    private String                     operateDatas;
    
    /** 备注说明 */
    private String                     infoComment;
    
    /** 汇签 */
    private ProcessCounterSignatureLog counterSignature;
    
    
    
    /**
     * 获取：用户信息
     */
    public User getUser()
    {
        return user;
    }
    

    
    /**
     * 获取：工作流模板名称
     */
    public String getTemplateName()
    {
        return templateName;
    }
    

    
    /**
     * 获取：第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     */
    public String getServiceDataID()
    {
        return serviceDataID;
    }
    

    
    /**
     * 获取：工作流实例ID
     */
    public String getWorkID()
    {
        return workID;
    }
    

    
    /**
     * 获取：单路流转：路由编码
     */
    public String getActivityRouteCode()
    {
        return activityRouteCode;
    }
    

    
    /**
     * 获取：单路流转&驳回：指定下一活动的动态参与人
     */
    public List<UserParticipant> getParticipants()
    {
        return participants;
    }
    

    
    /**
     * 设置：用户信息
     * 
     * @param user
     */
    public void setUser(User user)
    {
        this.user = user;
    }
    

    
    /**
     * 设置：工作流模板名称
     * 
     * @param templateName
     */
    public void setTemplateName(String templateName)
    {
        this.templateName = templateName;
    }
    

    
    /**
     * 设置：第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     * 
     * @param serviceDataID
     */
    public void setServiceDataID(String serviceDataID)
    {
        this.serviceDataID = serviceDataID;
    }
    

    
    /**
     * 设置：工作流实例ID
     * 
     * @param workID
     */
    public void setWorkID(String workID)
    {
        this.workID = workID;
    }
    

    
    /**
     * 设置：单路流转：路由编码
     * 
     * @param activityRouteCode
     */
    public void setActivityRouteCode(String activityRouteCode)
    {
        this.activityRouteCode = activityRouteCode;
    }
    

    
    /**
     * 设置：单路流转&驳回：指定下一活动的动态参与人
     * 
     * @param participants
     */
    public void setParticipants(List<UserParticipant> participants)
    {
        this.participants = participants;
    }


    
    /**
     * 获取：模板版本号
     */
    public Integer getVersionNo()
    {
        return versionNo;
    }
    

    
    /**
     * 设置：模板版本号
     * 
     * @param versionNo
     */
    public void setVersionNo(Integer versionNo)
    {
        this.versionNo = versionNo;
    }


    
    /**
     * 获取：汇总值
     */
    public Double getSummary()
    {
        return summary;
    }


    
    /**
     * 获取：提交汇总的总人数
     */
    public Integer getCounter()
    {
        return counter;
    }


    
    /**
     * 获取：操作文件信息，由第三方使用者定义其内容（拓展性数据）
     */
    public String getOperateFiles()
    {
        return operateFiles;
    }


    
    /**
     * 获取：操作数据信息，由第三方使用者定义其内容（拓展性数据）
     */
    public String getOperateDatas()
    {
        return operateDatas;
    }


    
    /**
     * 获取：备注说明
     */
    public String getInfoComment()
    {
        return infoComment;
    }


    
    /**
     * 设置：汇总值
     * 
     * @param summary
     */
    public void setSummary(Double summary)
    {
        this.summary = summary;
    }


    
    /**
     * 设置：提交汇总的总人数
     * 
     * @param counter
     */
    public void setCounter(Integer counter)
    {
        this.counter = counter;
    }



    /**
     * 设置：操作文件信息，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param operateFiles
     */
    public void setOperateFiles(String operateFiles)
    {
        this.operateFiles = operateFiles;
    }


    
    /**
     * 设置：操作数据信息，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param operateDatas
     */
    public void setOperateDatas(String operateDatas)
    {
        this.operateDatas = operateDatas;
    }


    
    /**
     * 设置：备注说明
     * 
     * @param infoComment
     */
    public void setInfoComment(String infoComment)
    {
        this.infoComment = infoComment;
    }

    
    
    /**
     * 获取：多路并发的流转信息
     */
    public List<FlowDataRoute> getRoutes()
    {
        return routes;
    }

    
    
    /**
     * 设置：多路并发的流转信息
     * 
     * @param routes
     */
    public void setRoutes(List<FlowDataRoute> routes)
    {
        this.routes = routes;
    }


    
    /**
     * 获取：自由驳回的流转信息（未在工作流模板上预先配置驳回路由）
     */
    public List<FlowDataActivity> getActivitys()
    {
        return activitys;
    }


    
    /**
     * 设置：自由驳回的流转信息（未在工作流模板上预先配置驳回路由）
     * 
     * @param i_Activitys 自由驳回的流转信息（未在工作流模板上预先配置驳回路由）
     */
    public void setActivitys(List<FlowDataActivity> i_Activitys)
    {
        this.activitys = i_Activitys;
    }


    
    /**
     * 获取：单路驳回：活动节点的编码
     */
    public String getActivityCode()
    {
        return activityCode;
    }


    
    /**
     * 设置：单路驳回：活动节点的编码
     * 
     * @param i_ActivityCode 单路驳回：活动节点的编码
     */
    public void setActivityCode(String i_ActivityCode)
    {
        this.activityCode = i_ActivityCode;
    }
    
    
    /**
     * 获取：驳回模式。auto:自动模式；team：协同模式
     * 
     * @return
     */
    public String getRejectMode()
    {
        if ( this.rejectMode != null )
        {
            return rejectMode.getValue();
        }
        else
        {
            return null;
        }
    }
    
    
    /**
     * 设置：驳回模式。auto:自动模式；team：协同模式
     * 
     * @param i_RejectMode 驳回模式。auto:自动模式；team：协同模式
     */
    public void setRejectMode(String i_RejectMode)
    {
        if ( i_RejectMode != null )
        {
            this.rejectMode = RejectModeEnum.get(i_RejectMode);
        }
        else
        {
            this.rejectMode = null;
        }
    }


    
    /**
     * 获取：驳回模式。auto:自动模式；team：协同模式
     */
    public RejectModeEnum getRejectModeEnum()
    {
        return rejectMode;
    }

    
    
    /**
     * 设置：驳回模式。auto:自动模式；team：协同模式
     * 
     * @param i_RejectMode 驳回模式。auto:自动模式；team：协同模式
     */
    public void setRejectModeEnum(RejectModeEnum i_RejectMode)
    {
        this.rejectMode = i_RejectMode;
    }


    
    /**
     * 获取：汇签
     */
    public ProcessCounterSignatureLog getCounterSignature()
    {
        return counterSignature;
    }


    
    /**
     * 设置：汇签
     * 
     * @param i_CounterSignature 汇签
     */
    public void setCounterSignature(ProcessCounterSignatureLog i_CounterSignature)
    {
        this.counterSignature = i_CounterSignature;
    }
    
}
