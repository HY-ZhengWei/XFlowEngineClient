package org.hy.xflow.engine.bean;

import org.hy.common.Date;
import org.hy.xflow.engine.common.BaseModel;





/**
 * 工作流实例流转过程中的汇签信息
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-04-03
 * @version     v1.0
 */
public class ProcessCounterSignature extends BaseModel
{

    private static final long serialVersionUID = 2433927916329135357L;
    
    
    
    /** 主键ID */
    private String                     pcsID;
    
    /** 工作流的过程ID */
    private String                     processID;
    
    /** 工作流实例ID */
    private String                     workID;
    
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String                     serviceDataID;
    
    /** 创建人员ID */
    private String                     createrID;
    
    /** 创建人员名称 */
    private String                     creater;
    
    /** 创建部门ID */
    private String                     createOrgID;
    
    /** 创建部门名称 */
    private String                     createOrg;
    
    /** 创建时间 */
    private Date                       createTime;
    
    /** 应当汇签人数 */
    private Integer                    csMaxUserCount;
    
    /** 最小汇签人数 */
    private Integer                    csMinUserCount;
    
    /** 汇签过期时间 */
    private Date                       csExpireTime;
    
    /** 汇签日志 */
    private ProcessCounterSignatureLog logs;

    
    
    /**
     * 获取：主键ID
     */
    public String getPcsID()
    {
        return pcsID;
    }

    
    /**
     * 设置：主键ID
     * 
     * @param i_PcsID 主键ID
     */
    public void setPcsID(String i_PcsID)
    {
        this.pcsID = i_PcsID;
    }

    
    /**
     * 获取：工作流的过程ID
     */
    public String getProcessID()
    {
        return processID;
    }

    
    /**
     * 设置：工作流的过程ID
     * 
     * @param i_ProcessID 工作流的过程ID
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
        return workID;
    }

    
    /**
     * 设置：工作流实例ID
     * 
     * @param i_WorkID 工作流实例ID
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
     * @param i_ServiceDataID 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     */
    public void setServiceDataID(String i_ServiceDataID)
    {
        this.serviceDataID = i_ServiceDataID;
    }

    
    /**
     * 获取：创建人员ID
     */
    public String getCreaterID()
    {
        return createrID;
    }

    
    /**
     * 设置：创建人员ID
     * 
     * @param i_CreaterID 创建人员ID
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
        return creater;
    }

    
    /**
     * 设置：创建人员名称
     * 
     * @param i_Creater 创建人员名称
     */
    public void setCreater(String i_Creater)
    {
        this.creater = i_Creater;
    }

    
    /**
     * 获取：创建部门ID
     */
    public String getCreateOrgID()
    {
        return createOrgID;
    }

    
    /**
     * 设置：创建部门ID
     * 
     * @param i_CreateOrgID 创建部门ID
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
        return createOrg;
    }

    
    /**
     * 设置：创建部门名称
     * 
     * @param i_CreateOrg 创建部门名称
     */
    public void setCreateOrg(String i_CreateOrg)
    {
        this.createOrg = i_CreateOrg;
    }

    
    /**
     * 获取：创建时间
     */
    public Date getCreateTime()
    {
        return createTime;
    }

    
    /**
     * 设置：创建时间
     * 
     * @param i_CreateTime 创建时间
     */
    public void setCreateTime(Date i_CreateTime)
    {
        this.createTime = i_CreateTime;
    }

    
    /**
     * 获取：应当汇签人数
     */
    public Integer getCsMaxUserCount()
    {
        return csMaxUserCount;
    }

    
    /**
     * 设置：应当汇签人数
     * 
     * @param i_CsMaxUserCount 应当汇签人数
     */
    public void setCsMaxUserCount(Integer i_CsMaxUserCount)
    {
        this.csMaxUserCount = i_CsMaxUserCount;
    }

    
    /**
     * 获取：最小汇签人数
     */
    public Integer getCsMinUserCount()
    {
        return csMinUserCount;
    }

    
    /**
     * 设置：最小汇签人数
     * 
     * @param i_CsMinUserCount 最小汇签人数
     */
    public void setCsMinUserCount(Integer i_CsMinUserCount)
    {
        this.csMinUserCount = i_CsMinUserCount;
    }

    
    /**
     * 获取：汇签过期时间
     */
    public Date getCsExpireTime()
    {
        return csExpireTime;
    }

    
    /**
     * 设置：汇签过期时间
     * 
     * @param i_CsExpireTime 汇签过期时间
     */
    public void setCsExpireTime(Date i_CsExpireTime)
    {
        this.csExpireTime = i_CsExpireTime;
    }

    
    /**
     * 获取：汇签日志
     */
    public ProcessCounterSignatureLog getLogs()
    {
        return logs;
    }

    
    /**
     * 设置：汇签日志
     * 
     * @param i_Logs 汇签日志
     */
    public void setLogs(ProcessCounterSignatureLog i_Logs)
    {
        this.logs = i_Logs;
    }
    
}
