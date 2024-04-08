package org.hy.xflow.engine.bean;

import org.hy.common.Date;





/**
 * 工作流实例流转过程中的汇签记录
 *
 * @author      ZhengWei(HY)
 * @createDate  2024-04-03
 * @version     v1.0
 */
public class ProcessCounterSignatureLog extends ProcessCounterSignature
{

    private static final long serialVersionUID = 5065934259917211978L;
    
    
    
    /** 主键ID */
    private String  pcslID;
    
    /** 汇签时间 */
    private Date    csTime;
    
    /** 汇签类型ID，由第三方使用者定义其内容（拓展性数据） */
    private String  csTypeID;
    
    /** 汇签类型名称，由第三方使用者定义其内容（拓展性数据） */
    private String  csType;
    
    /** 汇签人员ID */
    private String  csUserID;
    
    /** 汇签人员名称 */
    private String  csUser;
    
    /** 汇签部门ID */
    private String  csOrgID;
    
    /** 汇签部门名称 */
    private String  csOrg;
    
    /** 汇签文件信息，由第三方使用者定义其内容（拓展性数据） */
    private String  csFiles;
    
    /** 汇签数据信息，由第三方使用者定义其内容（拓展性数据） */
    private String  csDatas;
    
    /** 汇签说明 */
    private String  csComment;


    
    /**
     * 获取：主键ID
     */
    public String getPcslID()
    {
        return pcslID;
    }

    
    /**
     * 设置：主键ID
     * 
     * @param i_PcslID 主键ID
     */
    public void setPcslID(String i_PcslID)
    {
        this.pcslID = i_PcslID;
    }


    /**
     * 获取：汇签时间
     */
    public Date getCsTime()
    {
        return csTime;
    }

    
    /**
     * 设置：汇签时间
     * 
     * @param i_CsTime 汇签时间
     */
    public void setCsTime(Date i_CsTime)
    {
        this.csTime = i_CsTime;
    }

    
    /**
     * 获取：汇签类型ID，由第三方使用者定义其内容（拓展性数据）
     */
    public String getCsTypeID()
    {
        return csTypeID;
    }

    
    /**
     * 设置：汇签类型ID，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param i_CsTypeID 汇签类型ID，由第三方使用者定义其内容（拓展性数据）
     */
    public void setCsTypeID(String i_CsTypeID)
    {
        this.csTypeID = i_CsTypeID;
    }

    
    /**
     * 获取：汇签类型名称，由第三方使用者定义其内容（拓展性数据）
     */
    public String getCsType()
    {
        return csType;
    }

    
    /**
     * 设置：汇签类型名称，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param i_CsType 汇签类型名称，由第三方使用者定义其内容（拓展性数据）
     */
    public void setCsType(String i_CsType)
    {
        this.csType = i_CsType;
    }

    
    /**
     * 获取：汇签人员ID
     */
    public String getCsUserID()
    {
        return csUserID;
    }

    
    /**
     * 设置：汇签人员ID
     * 
     * @param i_CsUserID 汇签人员ID
     */
    public void setCsUserID(String i_CsUserID)
    {
        this.csUserID = i_CsUserID;
    }

    
    /**
     * 获取：汇签人员名称
     */
    public String getCsUser()
    {
        return csUser;
    }

    
    /**
     * 设置：汇签人员名称
     * 
     * @param i_CsUser 汇签人员名称
     */
    public void setCsUser(String i_CsUser)
    {
        this.csUser = i_CsUser;
    }

    
    /**
     * 获取：汇签部门ID
     */
    public String getCsOrgID()
    {
        return csOrgID;
    }

    
    /**
     * 设置：汇签部门ID
     * 
     * @param i_CsOrgID 汇签部门ID
     */
    public void setCsOrgID(String i_CsOrgID)
    {
        this.csOrgID = i_CsOrgID;
    }

    
    /**
     * 获取：汇签部门名称
     */
    public String getCsOrg()
    {
        return csOrg;
    }

    
    /**
     * 设置：汇签部门名称
     * 
     * @param i_CsOrg 汇签部门名称
     */
    public void setCsOrg(String i_CsOrg)
    {
        this.csOrg = i_CsOrg;
    }

    
    /**
     * 获取：汇签文件信息，由第三方使用者定义其内容（拓展性数据）
     */
    public String getCsFiles()
    {
        return csFiles;
    }

    
    /**
     * 设置：汇签文件信息，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param i_CsFiles 汇签文件信息，由第三方使用者定义其内容（拓展性数据）
     */
    public void setCsFiles(String i_CsFiles)
    {
        this.csFiles = i_CsFiles;
    }

    
    /**
     * 获取：汇签数据信息，由第三方使用者定义其内容（拓展性数据）
     */
    public String getCsDatas()
    {
        return csDatas;
    }

    
    /**
     * 设置：汇签数据信息，由第三方使用者定义其内容（拓展性数据）
     * 
     * @param i_CsDatas 汇签数据信息，由第三方使用者定义其内容（拓展性数据）
     */
    public void setCsDatas(String i_CsDatas)
    {
        this.csDatas = i_CsDatas;
    }

    
    /**
     * 获取：汇签说明
     */
    public String getCsComment()
    {
        return csComment;
    }

    
    /**
     * 设置：汇签说明
     * 
     * @param i_CsComment 汇签说明
     */
    public void setCsComment(String i_CsComment)
    {
        this.csComment = i_CsComment;
    }
    
}
