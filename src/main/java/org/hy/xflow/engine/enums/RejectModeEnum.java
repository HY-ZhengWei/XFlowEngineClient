package org.hy.xflow.engine.enums;

import org.hy.xflow.engine.common.BaseEnum;





/**
 * 驳回模式
 *
 * @author      ZhengWei(HY)
 * @createDate  2023-02-23
 * @version     v1.0
 */
public enum RejectModeEnum implements BaseEnum<String>
{
    
    /**
     * 自动模式：尽量不干预其它分支路线
     * 
     * 当多路并行分派，某一分支驳回时，自动判定是否需要协同其它分支一同驳回。
     *   情况1：驳回到的目地节点本身不是分派节点（或未经过分派路由），无需协同其它分支一同驳回。
     *   情况2：驳回到的目地节点本身就是分派节点，默认无需协同其它分支一同驳回，即不干预其它分支。
     *   情况3：驳回到的目地节点途中经过分派路由，需协同其它所有分支一同驳回。
     **/
    $Auto("auto" ,"自动模式"),
    
    /**
     * 协同模式：有条件时，其它分支一同驳回
     * 
     * 当多路并行分派，某一分支驳回时，建议其它分支一同驳回。
     *   情况1：驳回到的目地节点本身不是分派节点（或未经过分派路由），无需协同其它分支一同驳回。
     *   情况2：驳回到的目地节点本身就是分派节点，需协同其它所有分支一同驳回。也是与 “自动模式” 的最大区别点。
     *   情况3：驳回到的目地节点途中经过分派路由，需协同其它所有分支一同驳回。
     **/
    $Team("team" ,"协同模式");
    
    
    
    /**
     * 值
     */
    private String value;
    
    /**
     * 描述
     */
    private String  desc;
    
    
    
    /**
     * 数值转为常量
     * 
     * @author      ZhengWei(HY)
     * @createDate  2023-02-23
     * @version     v1.0
     *
     * @param i_Value
     * @return
     */
    public static RejectModeEnum get(String i_Value)
    {
        if ( i_Value == null )
        {
            return null;
        }
        
        for (RejectModeEnum v_Enum : RejectModeEnum.values())
        {
            if ( v_Enum.value.equalsIgnoreCase(i_Value.trim()) )
            {
                return v_Enum;
            }
        }
        
        return null;
    }
    
    
    
    RejectModeEnum(String i_Value ,String i_Desc)
    {
        this.value = i_Value;
        this.desc  = i_Desc;
    }

    
    
    @Override
    public String getValue()
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
        return this.value;
    }
    
}
