package org.hy.xflow.engine.common;

import java.util.ArrayList;
import java.util.List;

import org.hy.common.Help;
import org.hy.common.StringHelp;
import org.hy.common.app.Param;
import org.hy.common.net.ClientSocket;
import org.hy.common.net.ClientSocketCluster;
import org.hy.common.net.common.ClientCluster;
import org.hy.common.net.data.CommunicationRequest;
import org.hy.common.xml.XJava;





/**
 * 基础服务类
 * 
 * @author      ZhengWei(HY)
 * @createDate  2014-10-22
 * @version     v1.0
 *              v2.0  2020-01-02  1. 添加：工作流引擎集群
 */
public class BaseService extends Base
{
    
    /**
     * 工作流引擎集群，同步引擎数据
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-01-02
     * @version     v1.0
     *
     * @param i_RequestData
     */
    public void clusterSyncFlowCache(CommunicationRequest i_RequestData)
    {
        List<ClientCluster> v_Servers = this.getFlowClusterServers();
        
        if ( Help.isNull(v_Servers) )
        {
            return;
        }
        
        ClientSocketCluster.sends(v_Servers ,false ,this.getClusterTimeout() ,i_RequestData);
    }
    
    
    
    
    /**
     * 获取工作流引擎集群的服务列表（工作流的高速引擎数据将在列表中相互分发同步）
     * 
     * （单服务时，须为空）
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-01-01
     * @version     v1.0
     *
     * @return
     */
    public List<ClientCluster> getFlowClusterServers()
    {
        Param v_Param = XJava.getParam("FlowClusterServers");
        if ( v_Param == null || Help.isNull(v_Param.getValue()) )
        {
            return null;
        }
        
        String []           v_ClusterServers = StringHelp.replaceAll(XJava.getParam("FlowClusterServers").getValue() ,new String[]{" " ,"\t" ,"\r" ,"\n"} ,new String[]{""}).split(",");
        List<ClientCluster> v_Clusters       = new ArrayList<ClientCluster>();
        
        for (String v_Server : v_ClusterServers)
        {
            String [] v_HostPort = (v_Server.trim() + ":1721").split(":");
            
            v_Clusters.add(new ClientSocket(v_HostPort[0] ,Integer.parseInt(v_HostPort[1])));
        }
        
        return v_Clusters;
    }
    
    
    
    /**
     * 集群并发通讯的超时时长(单位：毫秒)
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-01-23
     * @version     v1.0
     *
     * @return
     */
    public long getClusterTimeout()
    {
        return Long.parseLong(XJava.getParam("ClusterTimeout").getValue());
    }
    
}
