package org.hy.xflow.engine.bean;

import org.hy.xflow.engine.common.BaseModel;





/**
 * 未来操作人（主用于高速缓存的处理）
 *
 * @author      ZhengWei(HY)
 * @createDate  2019-09-11
 * @version     v1.0
 */
public class FutureOperator extends BaseModel
{
    
    private static final long serialVersionUID = -4997174540955780144L;
    
    /** 工作流实例ID */
    private String  workID;
    
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String  serviceDataID;
    
    /** 工作流的过程ID */
    private String  processID;
    
    /** 分单前的过程ID。合单前持续记录ID值 */
    private String  splitProcessID;
    
    /** 参与者类型 */
    private Integer objectType;
    
    /** 参与者ID */
    private String  objectID;
    
    
    
    /**
     * 获取：工作流实例ID
     */
    public String getWorkID()
    {
        return workID;
    }

    
    /**
     * 获取：第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     */
    public String getServiceDataID()
    {
        return serviceDataID;
    }

    
    /**
     * 获取：参与者类型
     */
    public Integer getObjectType()
    {
        return objectType;
    }

    
    /**
     * 获取：参与者ID
     */
    public String getObjectID()
    {
        return objectID;
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
     * 设置：第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息
     * 
     * @param serviceDataID 
     */
    public void setServiceDataID(String serviceDataID)
    {
        this.serviceDataID = serviceDataID;
    }

    
    /**
     * 设置：参与者类型
     * 
     * @param objectType 
     */
    public void setObjectType(Integer objectType)
    {
        this.objectType = objectType;
    }

    
    /**
     * 设置：参与者ID
     * 
     * @param objectID 
     */
    public void setObjectID(String objectID)
    {
        this.objectID = objectID;
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
     * @param processID 
     */
    public void setProcessID(String processID)
    {
        this.processID = processID;
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
