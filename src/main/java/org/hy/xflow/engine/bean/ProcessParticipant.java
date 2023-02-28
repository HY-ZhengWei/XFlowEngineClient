package org.hy.xflow.engine.bean;

import org.hy.common.StringHelp;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;





/**
 * 工作流过程的动态参与人
 *
 * @author      ZhengWei
 * @createDate  2018-04-17
 * @version     v1.0
 */
public class ProcessParticipant extends Participant
{
    private static final long serialVersionUID = -4724247321457107633L;
    
    
    /** 主键ID */
    private String pwpID;
    
    /** 工作流的过程ID */
    private String processID;
    
    /** 分单前的过程ID。合单前持续记录ID值 */
    private String splitProcessID;
    
    /** 工作流实例ID */
    private String workID;
    
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String serviceDataID;
    
    /** 创建部门ID */
    private String createOrgID;
    
    /** 创建部门名称 */
    private String createOrg;
    
    
    
    /**
     * 初始化本类。用于父类转子类时
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-08
     * @version     v1.0
     *
     * @param i_User
     * @param i_Process
     * @param i_UserPart
     */
    public ProcessParticipant init(UserParticipant i_UserPart)
    {
        this.objectID       = i_UserPart.getObjectID();
        this.objectName     = i_UserPart.getObjectName();
        this.objectType     = i_UserPart.getObjectType();
        this.objectNo       = i_UserPart.getObjectNo();
        
        return this;
    }
    
    
    
    /**
     * 初始化本类。用于工作流过程流转时
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-08
     * @version     v1.0
     *
     * @param i_User
     * @param i_Process
     * @param i_UserPart
     */
    public ProcessParticipant init(User i_User ,FlowProcess i_Process ,UserParticipant i_UserPart)
    {
        this.pwpID          = StringHelp.getUUID();
        this.processID      = i_Process.getProcessID();
        this.splitProcessID = i_Process.getSplitProcessID();
        this.workID         = i_Process.getWorkID();
        this.serviceDataID  = i_Process.getServiceDataID();
        this.createTime     = i_Process.getCreateTime();
        this.createrID      = i_User.getUserID();
        this.creater        = i_User.getUserName();
        this.createOrgID    = i_User.getOrgID();
        this.createOrg      = i_User.getOrgName();
        this.objectID       = i_UserPart.getObjectID();
        this.objectName     = i_UserPart.getObjectName();
        this.objectType     = i_UserPart.getObjectType();
        this.objectNo       = i_UserPart.getObjectNo();
        
        return this;
    }
    
    
    
    /**
     * 初始化本类。用于工作流驳回时的流转
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-10
     * @version     v1.0
     *
     * @param i_User
     * @param i_Process
     * @param i_ToRejectProcess
     */
    public ProcessParticipant init_ToReject(User i_User ,FlowProcess i_Process ,FlowProcess i_ToRejectProcess)
    {
        this.pwpID          = StringHelp.getUUID();
        this.processID      = i_Process.getProcessID();
        this.splitProcessID = i_Process.getSplitProcessID();
        this.workID         = i_Process.getWorkID();
        this.serviceDataID  = i_Process.getServiceDataID();
        this.createTime     = i_Process.getCreateTime();
        this.createrID      = i_User.getUserID();
        this.creater        = i_User.getUserName();
        this.createOrgID    = i_User.getOrgID();
        this.createOrg      = i_User.getOrgName();
        this.objectID       = i_ToRejectProcess.getOperateUserID();
        this.objectName     = i_ToRejectProcess.getOperateUser();
        this.objectType     = ParticipantTypeEnum.$User;
        this.objectNo       = 0;
        
        return this;
    }
    
    
    
    /**
     * 获取：主键ID
     */
    public String getPwpID()
    {
        return this.pwpID;
    }

    
    /**
     * 设置：主键ID
     * 
     * @param i_PwpID
     */
    public void setPwpID(String i_PwpID)
    {
        this.pwpID = i_PwpID;
    }
    
    
    /**
     * 获取：工作流的过程ID
     */
    public String getProcessID()
    {
        return this.processID;
    }

    
    /**
     * 设置：工作流的过程ID
     * 
     * @param i_ProcessID
     */
    public void setProcessID(String i_ProcessID)
    {
        this.processID = i_ProcessID;
    }
    
    
    /**
     * 获取：工作流实例ID
     */
    public String getWorkID()
    {
        return this.workID;
    }

    
    /**
     * 设置：工作流实例ID
     * 
     * @param i_WorkID
     */
    public void setWorkID(String i_WorkID)
    {
        this.workID = i_WorkID;
    }
    
    
    /**
     * 获取：第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     */
    public String getServiceDataID()
    {
        return serviceDataID;
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
     * 获取：创建部门ID
     */
    public String getCreateOrgID()
    {
        return this.createOrgID;
    }

    
    /**
     * 设置：创建部门ID
     * 
     * @param i_CreateOrgID
     */
    public void setCreateOrgID(String i_CreateOrgID)
    {
        this.createOrgID = i_CreateOrgID;
    }
    
    
    /**
     * 获取：创建部门名称
     */
    public String getCreateOrg()
    {
        return this.createOrg;
    }

    
    /**
     * 设置：创建部门名称
     * 
     * @param i_CreateOrg
     */
    public void setCreateOrg(String i_CreateOrg)
    {
        this.createOrg = i_CreateOrg;
    }

    
    /**
     * 获取：分单前的过程ID。合单前持续记录ID值
     */
    public String getSplitProcessID()
    {
        return splitProcessID;
    }


    /**
     * 设置：分单前的过程ID。合单前持续记录ID值
     * 
     * @param splitProcessID
     */
    public void setSplitProcessID(String splitProcessID)
    {
        this.splitProcessID = splitProcessID;
    }

}
