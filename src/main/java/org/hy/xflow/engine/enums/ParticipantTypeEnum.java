package org.hy.xflow.engine.enums;

import org.hy.xflow.engine.common.BaseEnum;





/**
 * 参与人类型
 *
 * @author      ZhengWei(HY)
 * @createDate  2018-05-08
 * @version     v1.0
 */
public enum ParticipantTypeEnum implements BaseEnum<Integer>
{
    
    $User(         1 ,"执行人"),
    
    $Org(          2 ,"执行部门"),
    
    $Role(         3 ,"执行角色"),
    
    $UserSend(    11 ,"抄送人"),
    
    $OrgSend(     12 ,"抄送部门"),
    
    $RoleSend(    13 ,"抄送角色"),
    
    /**
     * 只用于模板定义阶段。工作流实例不能动态指定此类型的。
     * 
     * 此类型的参与人.objectID为空。
     * 
     * 可用于活动、路由的定义中。
     */
    $CreateUser(  21 ,"发起人"),
    
    /**
     * 只用于模板定义阶段。工作流实例不能动态指定此类型的。
     * 
     * 此类型的参与人.objecttID为活动节点编码。
     * 
     * 可用于活动、路由的定义中。
     */
    $ActivityUser(22 ,"活动实际操作人");
    
    
    
    /**
     * 值
     */
    private Integer value;
    
    /**
     * 描述
     */
    private String  desc;
    
    
    
    /**
     * 数值转为常量
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-08
     * @version     v1.0
     *
     * @param i_Value
     * @return
     */
    public static ParticipantTypeEnum get(Integer i_Value)
    {
        if ( i_Value == null )
        {
            return null;
        }
        
        for (ParticipantTypeEnum v_Enum : ParticipantTypeEnum.values())
        {
            if ( v_Enum.value.intValue() == i_Value.intValue() )
            {
                return v_Enum;
            }
        }
        
        return null;
    }
    
    
    
    ParticipantTypeEnum(Integer i_Value ,String i_Desc)
    {
        this.value = i_Value;
        this.desc  = i_Desc;
    }

    
    
    @Override
    public Integer getValue()
    {
        return this.value;
    }
    
    
    
    public String getDesc()
    {
        return this.desc;
    }
    
    

    @Override
    public String toString()
    {
        return this.value + "";
    }
    
}
