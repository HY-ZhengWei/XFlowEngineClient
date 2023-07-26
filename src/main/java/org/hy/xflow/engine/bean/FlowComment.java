package org.hy.xflow.engine.bean;

import org.hy.common.Date;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ParticipantTypeEnum;





/**
 * 工作流备注
 *
 * @author      ZhengWei(HY)
 * @createDate  2023-07-26
 * @version     v1.0
 */
public class FlowComment extends BaseModel
{
    private static final long serialVersionUID = 3713919197608368458L;
    
    
    
    /** 工作流备注主键ID */
    private String  fcID;
                    
    /** 工作流实例ID */
    private String  workID;
           
    /** 第三方使用系统的业务数据ID。即支持用第三方ID也能找到工作流信息 */
    private String  serviceDataID;
           
    /** 工作流备注分类 */
    private String  commentType;
           
    /** 工作流备注标题 */
    private String  commentTitle;
           
    /** 工作流备注内容 */
    private String  comment;
           
    /** 工作流备注图片 */
    private String  commentImages;
           
    /** 工作流备注文件 */
    private String  commentFiles;
    
    /** 参与者类型  */
    private ParticipantTypeEnum objectType;
    
    /** 创建人员ID */
    private String  createrID;
    
    /** 创建人员名称 */
    private String  creater;
    
    /** 创建部门ID */
    private String  createOrgID;
    
    /** 创建部门名称 */
    private String  createOrg;
    
    /** 创建时间 */
    private Date    createTime;

    
    /**
     * 获取：工作流备注主键ID
     */
    public String getFcID()
    {
        return fcID;
    }

    
    /**
     * 设置：工作流备注主键ID
     * 
     * @param i_FcID 工作流备注主键ID
     */
    public void setFcID(String i_FcID)
    {
        this.fcID = i_FcID;
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
     * 获取：工作流备注分类
     */
    public String getCommentType()
    {
        return commentType;
    }

    
    /**
     * 设置：工作流备注分类
     * 
     * @param i_CommentType 工作流备注分类
     */
    public void setCommentType(String i_CommentType)
    {
        this.commentType = i_CommentType;
    }

    
    /**
     * 获取：工作流备注标题
     */
    public String getCommentTitle()
    {
        return commentTitle;
    }

    
    /**
     * 设置：工作流备注标题
     * 
     * @param i_CommentTitle 工作流备注标题
     */
    public void setCommentTitle(String i_CommentTitle)
    {
        this.commentTitle = i_CommentTitle;
    }

    
    /**
     * 获取：工作流备注内容
     */
    public String getComment()
    {
        return comment;
    }

    
    /**
     * 设置：工作流备注内容
     * 
     * @param i_Comment 工作流备注内容
     */
    public void setComment(String i_Comment)
    {
        this.comment = i_Comment;
    }

    
    /**
     * 获取：工作流备注图片
     */
    public String getCommentImages()
    {
        return commentImages;
    }

    
    /**
     * 设置：工作流备注图片
     * 
     * @param i_CommentImages 工作流备注图片
     */
    public void setCommentImages(String i_CommentImages)
    {
        this.commentImages = i_CommentImages;
    }

    
    /**
     * 获取：工作流备注文件
     */
    public String getCommentFiles()
    {
        return commentFiles;
    }

    
    /**
     * 设置：工作流备注文件
     * 
     * @param i_CommentFiles 工作流备注文件
     */
    public void setCommentFiles(String i_CommentFiles)
    {
        this.commentFiles = i_CommentFiles;
    }

    
    /**
     * 获取：参与者类型
     */
    public ParticipantTypeEnum getObjectType()
    {
        return objectType;
    }

    
    /**
     * 设置：参与者类型
     * 
     * @param i_ObjectType 参与者类型
     */
    public void setObjectType(ParticipantTypeEnum i_ObjectType)
    {
        this.objectType = i_ObjectType;
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

}
