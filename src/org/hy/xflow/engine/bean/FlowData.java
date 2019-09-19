package org.hy.xflow.engine.bean;

import java.util.List;

import org.hy.xflow.engine.bean.User;
import org.hy.xflow.engine.bean.UserParticipant;
import org.hy.xflow.engine.common.BaseModel;





/**
 * 工作流接口的数据类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-05-17
 * @version     v1.0
 *              v2.0  2019-09-19  添加：汇总值、汇总人数、操作文件、操作数据、备注说明
 */
public class FlowData extends BaseModel
{

    private static final long serialVersionUID = -8362950623214901037L;
    
    
    
    /** 用户信息 */
    private User                  user;
    
    /** 工作流模板名称 */
    private String                templateName;
    
    /** 模板版本号 */
    private Integer               versionNo;
    
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String                serviceDataID;
    
    /** 工作流实例ID */
    private String                workID;
    
    /** 路由编码 */
    private String                activityRouteCode;
    
    /** 指定下一活动的动态参与人 */
    private List<UserParticipant> participants;
    
    /** 汇总值 */
    private Double                summary;
    
    /** 提交汇总的总人数 */
    private Integer               counter;
    
    /** 操作文件信息，由第三方使用者定义其内容（拓展性数据） */
    private String                operateFiles;
    
    /** 操作数据信息，由第三方使用者定义其内容（拓展性数据） */
    private String                operateDatas;
    
    /** 备注说明 */
    private String                infoComment;
    
    
    
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
    
}
