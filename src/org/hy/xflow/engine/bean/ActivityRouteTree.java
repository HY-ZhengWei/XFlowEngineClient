package org.hy.xflow.engine.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hy.common.Help;
import org.hy.common.PartitionMap;
import org.hy.common.TablePartition;
import org.hy.common.TablePartitionRID;
import org.hy.xflow.engine.common.BaseModel;
import org.hy.xflow.engine.enums.ActivityTypeEnum;





/**
 * 活动路由树。它体现的是某一模板的活动路由树信息。
 * 
 * 通过活动表、路由表组合生成的。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2018-04-19
 * @version     v1.0
 *              v2.0  2018-09-05  添加：支持多个结束出口的工作流程
 *              v3.0  2019-09-16  添加：allRoutesByNextACode属性，实现用当前活动、下一活动找路由信息。
 */
public class ActivityRouteTree extends BaseModel
{
    
    private static final long serialVersionUID = 5366730038571520921L;
    

    /** 模板的所有活动。Map.key为活动Code */
    private Map<String ,ActivityInfo>                allActivitys;
    
    
    
    /** 模板的所有路由。Map.key为活动Code */
    private PartitionMap<String ,ActivityRoute>      allRoutes;
     
    /** 模板的所有路由。Map.key为路由ID */
    private Map<String ,ActivityRoute>               allRoutesByID;
    
    /** 模板的所有路由。Map.key分区为活动Code ,Map主键索引为路由Code */
    private TablePartitionRID<String ,ActivityRoute> allRoutesByARCode;
    
    /** 模板的所有路由。Map.key分区为活动Code ,Map主键索引为下一个活动的Code */
    private TablePartitionRID<String ,ActivityRoute> allRoutesByNextACode;
    
    
    
    /** 模板的活动的所有参与人。Map.key为活动ID */
    private PartitionMap<String ,Participant>        allActivityPs;
    
    /** 模板的活动路由的所有参与人。Map.key为路由ID */
    private PartitionMap<String ,Participant>        allActivityRoutePs;
    
    
    
    /** 整个活动路由树的 "开始" 活动节点 */
    private ActivityInfo                             startActivity;
    
    /** 整个活动路由树的 "结束" 活动节点。Map.key为活动ID。支持多个结束出口的工作流程 */
    private Map<String ,ActivityInfo>                endActivitys;
    
    
    
    public ActivityRouteTree(Map<String ,ActivityInfo>           i_AllActivitys 
                            ,PartitionMap<String ,ActivityRoute> i_AllRoutes
                            ,PartitionMap<String ,Participant>   i_AllActivityPs
                            ,PartitionMap<String ,Participant>   i_AllActivityRoutePs)
    {
        this.allActivitys         = i_AllActivitys;
        this.allRoutes            = i_AllRoutes;
        this.allRoutesByID        = new HashMap<String ,ActivityRoute>();
        this.allRoutesByARCode    = new TablePartitionRID<String ,ActivityRoute>();
        this.allRoutesByNextACode = new TablePartitionRID<String ,ActivityRoute>();
        this.allActivityPs        = i_AllActivityPs;
        this.allActivityRoutePs   = i_AllActivityRoutePs;
        this.endActivitys         = new HashMap<String ,ActivityInfo>();
        
        if ( this.allActivityRoutePs == null )
        {
            this.allActivityRoutePs = new TablePartition<String ,Participant>();
        }
        
        if ( !Help.isNull(this.allActivitys) )
        {
            this.startActivity = this.allActivitys.values().iterator().next();
            for (ActivityInfo v_Activity : this.allActivitys.values())
            {
                if ( ActivityTypeEnum.$Finish.equals(v_Activity.getActivityTypeID()) )
                {
                    this.endActivitys.put(v_Activity.getActivityID() ,v_Activity);
                }
            }
        }
        
        this.makeActivityRouteTree();
    }
    
    
    
    /**
     * 整个活动路由树的 "开始" 活动节点
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-24
     * @version     v1.0
     *
     * @return
     */
    public ActivityInfo getStartActivity()
    {
        return this.startActivity;
    }
    
    
    
    /**
     * 整个活动路由树的 "结束" 活动节点。Map.key为活动ID。支持多个结束出口的工作流程
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-24
     * @version     v1.0
     *
     * @return
     */
    public Map<String ,ActivityInfo> getEndActivity()
    {
        return this.endActivitys;
    }
    
    
    
    /**
     * 模板的所有活动。Map.key为活动Code
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-11-01
     * @version     v1.0
     *
     * @return
     */
    public Map<String ,ActivityInfo> getActivitys()
    {
        return this.allActivitys;
    }
    
    
    
    /**
     * 按活动编码获取活动对象。通过它可进入步获取下一步的所有节点 
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-19
     * @version     v1.0
     *
     * @param i_ActivityCode  活动编码
     * @return
     */
    public ActivityInfo getActivity(String i_ActivityCode)
    {
        return this.allActivitys.get(i_ActivityCode);
    }
    
    
    
    /**
     * 模板的所有路由。Map.key为路由ID
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-11-01
     * @version     v1.0
     * 
     * @return
     */
    public Map<String ,ActivityRoute> getActivityRoutes()
    {
        return this.allRoutesByID;
    }
    
    
    
    /**
     * 获取活动的具体的某一个路由信息
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-07
     * @version     v1.0
     *
     * @param i_ActivityCode       活动编码
     * @param i_ActivityRouteCode  路由编码
     * @return
     */
    public ActivityRoute getActivityRoute(String i_ActivityCode ,String i_ActivityRouteCode)
    {
        return this.allRoutesByARCode.get(i_ActivityCode).get(i_ActivityRouteCode);
    }
    
    
    
    /**
     * 获取两活动间的具体的某一个路由信息
     * 
     * @author      ZhengWei(HY)
     * @createDate  2019-09-16
     * @version     v1.0
     *
     * @param i_ActivityCode       活动编码
     * @param i_NextActivityCode   下一个活动的编码
     * @return
     */
    public ActivityRoute getActivityRouteByNext(String i_ActivityCode ,String i_NextActivityCode)
    {
        return this.allRoutesByNextACode.get(i_ActivityCode).get(i_NextActivityCode);
    }
    
    
    
    /**
     * 获取某一个路由信息
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-05-14
     * @version     v1.0
     *
     * @param i_ActivityRouteCode  路由ID
     * @return
     */
    public ActivityRoute getActivityRoute(String i_ActivityRouteID)
    {
        return this.allRoutesByID.get(i_ActivityRouteID);
    }
    
    
    
    /**
     * 按活动路由生成活动路由树
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-19
     * @version     v1.0
     *
     */
    @SuppressWarnings("unchecked")
    public void makeActivityRouteTree()
    {
        if ( Help.isNull(allActivitys) 
          || Help.isNull(allRoutes) 
          || Help.isNull(allActivityPs)
          || this.startActivity == null 
          || Help.isNull(this.endActivitys) )
        {
            return;
        }
        
        for (Map.Entry<String ,List<ActivityRoute>> v_Routes : this.allRoutes.entrySet())
        {
            this.allRoutesByARCode   .putRows(v_Routes.getKey() ,(Map<String ,ActivityRoute>)Help.toMap(v_Routes.getValue() ,"activityRouteCode"));
            this.allRoutesByNextACode.putRows(v_Routes.getKey() ,(Map<String ,ActivityRoute>)Help.toMap(v_Routes.getValue() ,"nextActivityCode"));
            
            for (ActivityRoute v_Route : v_Routes.getValue())
            {
                this.allRoutesByID.put(v_Route.getActivityRouteID() ,v_Route);
            }
        }
        
        this.makeActivityRouteTree(this.startActivity);
    }
    
    
    
    /**
     * 按活动路由生成活动路由树（递归）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-19
     * @version     v1.0
     *
     * @param io_CurrentActivity  当前活动
     */
    private void makeActivityRouteTree(ActivityInfo io_CurrentActivity)
    {
        io_CurrentActivity.setParticipants(allActivityPs.get(io_CurrentActivity.getActivityID()));
        List<ActivityRoute> v_CurrentARoutes = allRoutes.get(io_CurrentActivity.getActivityCode());
        
        // System.out.println(log(io_CurrentActivity));
        
        if ( !Help.isNull(v_CurrentARoutes) )
        {
            io_CurrentActivity.setRoutes(v_CurrentARoutes);
            
            for (ActivityRoute v_CurrentARoute : v_CurrentARoutes)
            {
                v_CurrentARoute.setActivity(io_CurrentActivity);
                v_CurrentARoute.setParticipants(allActivityRoutePs.get(v_CurrentARoute.getActivityRouteID()));
                
                if ( !Help.isNull(v_CurrentARoute.getNextActivityID()) )
                {
                    ActivityInfo v_NextActivity = allActivitys.get(v_CurrentARoute.getNextActivityCode());
                    
                    if ( v_NextActivity != null )
                    {
                        v_CurrentARoute.setNextActivity(v_NextActivity);
                        
                        // System.out.println(log(v_CurrentARoute));
                        
                        if ( !Help.isNull(v_NextActivity.getRoutes()) )
                        {
                            // 已经有路由信息的将不再递归，一般为自循环活动或驳回的活动。防止死循环。
                        }
                        else if ( v_NextActivity == this.startActivity )
                        {
                            // 不等于开始活动才递归。防止死循环
                        }
                        else if ( this.endActivitys.containsKey(v_NextActivity.getActivityID()) )
                        {
                            // 不等于结束活动才递归。防止死循环
                        }
                        else
                        {
                            makeActivityRouteTree(v_NextActivity);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * 输出日志
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-25
     * @version     v1.0
     *
     * @param i_Activity
     * @return
     */
    @SuppressWarnings("unused")
    private String log(ActivityInfo i_Activity)
    {
        StringBuilder v_Log = new StringBuilder();
        
        v_Log.append("\n").append(i_Activity.getActivityName());
        
        if ( !Help.isNull(i_Activity.getParticipants()) )
        {
            for (int i=0; i<i_Activity.getParticipants().size(); i++)
            {
                Participant v_Participant = i_Activity.getParticipants().get(i);
                v_Log.append("\n\t参与人").append(i+1).append("  ").append(v_Participant.getParticipantType().getParticipantType()).append(":").append(v_Participant.getObjectName());
            }
            
            v_Log.append("\n");
        }
        
        return v_Log.toString();
    }
    
    
    
    /**
     * 输出日志
     * 
     * @author      ZhengWei(HY)
     * @createDate  2018-04-24
     * @version     v1.0
     *
     * @param i_CurrentARoute
     * @return
     */
    @SuppressWarnings("unused")
    private String log(ActivityRoute i_CurrentARoute)
    {
        StringBuilder v_Log = new StringBuilder();
        
        v_Log.append("【").append(i_CurrentARoute.getActivity().getActivityName()).append("】");
        v_Log.append("  ---").append(i_CurrentARoute.getActivityRouteName()).append("--->  ");
        v_Log.append("【").append(i_CurrentARoute.getNextActivity().getActivityName()).append("】");
        
        if ( !Help.isNull(i_CurrentARoute.getParticipants()) )
        {
            for (int i=0; i<i_CurrentARoute.getParticipants().size(); i++)
            {
                Participant v_Participant = i_CurrentARoute.getParticipants().get(i);
                v_Log.append("\n\t参与人").append(i+1).append("  ").append(v_Participant.getParticipantType().getParticipantType()).append(":").append(v_Participant.getObjectName());
            }
            
            v_Log.append("\n");
        }
        
        return v_Log.toString();
    }
    
}
