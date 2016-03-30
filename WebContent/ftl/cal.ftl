<html>
  <head>
    <meta charset="utf8">
    <title>仿真计算</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </head>
  <body>
  	<#if Session["user"]?exists>
    <#assign userSession = Session["user"]>
	</#if>
    <#include "head.ftl"/>
    <div class="row-fluid" style="width:100%;margin-left:auto;margin-right:auto;">
      <div class = "span6">
        <div class = "span8">
        <table class="table" >
          <tr style="background-color:#0088CC">
            <td align="center"><font color="white">功能列表</font></td>
          </tr>
          <tr class="info">
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr >
            <td><a href="query.do">仿真查询</td>
          </tr>
          <tr>
            <td><a href="userManage.do">用户管理</a></td>
          </tr>
          <tr>
            <td><a href="dumpData.do">数据备份</td>
          </tr>
        </table> 
      </div>
        <table class="table">
          <tr>
            <td align="center">仿真类型：</td>
            <td align="center">
              <select name="s1" style="width:90px; height:20px" id="simType" onChange="changeType();" >
                <option value="1">模拟仿真</option>
                <option value="0">分析数据</option>
              </select>
            </td>
            <td align="center">选择实例数据：</td>
            <td align="center" style="width:90px; height:20px">
              <input type="text" id="file" >
            </td>
          </tr> 
        </table>
        <script src="js/custom/runAndshow.js"></script>
        <script src="js/custom/defaultData.js"></script>
        <!-- 输入tab页面  begin-->
        <ul class="nav nav-tabs" id="myTab" style="font-size:12px;">
          <li><a href="#" onclick="tabgo1()" id="tab-1">舰艇声反射</a></li>
          <li><a href="#" onclick="tabgo2()" id="tab-2">高频混响</a></li>
          <li><a href="#" onclick="tabgo3()" id="tab-3">舰艇辐射</a></li>
          <li><a href="#" onclick="tabgo4()" id="tab-4">鱼雷</a></li>
          <li><a href="#" onclick="tabgo5()" id="tab-5">舰艇自噪声</a></li>
          <li><a href="#" onclick="tabgo6()" id="tab-6">鱼雷自噪声</a></li>
          <li><a href="#tab7" onclick="tabgo7()" id="tab-7">海洋环境</a></li>
          <li><a href="#tab8" onclick="tabgo8()" id="tab-8">声传播</a></li>
        </ul>
         
        <div class="tab-content" id="tabContent">
          <#include "tab/tab1.ftl"/>
          <#include "tab/tab1B.ftl"/>
          <#include "tab/tab2.ftl"/>
          <#include "tab/tab3A.ftl"/>
          <#include "tab/tab3B.ftl"/>
          <#include "tab/tab4A.ftl"/>
          <#include "tab/tab4B.ftl"/>
          <#include "tab/tab5A.ftl"/>
          <#include "tab/tab5B.ftl"/>
          <#include "tab/tab6A.ftl"/>
          <#include "tab/tab6B.ftl"/>
          <#include "tab/tab7.ftl"/>
          <#include "tab/tab8.ftl"/>
        </div>
        
      </div>
      <div class="span6">
        <div>
          <font color="blue">输入参数：</font><br>
          <div id="input"></div>
          <hr>
          <font color="blue">输出结果：</font><br>
          <div id="output"></div>
          <hr>
        </div>
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="height:200px;display:none" class="chart"></div>
        <div id="main2" style="height:200px;display:none" class="chart"></div>
        <div id="main3" style="height:200px;display:none" class="chart"></div>
        <!-- ECharts单文件引入 -->
        <script src="js/echarts.js"></script>
        <script type="text/javascript">
            // 路径配置
            require.config({
                paths: {
                    echarts: 'js'
                }
            });
            
        </script>

      </div>
    </div>
    
    
    <!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
	  <div class="modal-header">
	    <!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>-->
	    <h3 id="myModalLabel">提示</h3>
	  </div>
	  <div class="modal-body">
	    正在计算，请稍等...<br>
	    强行关闭将可能导致端口占用，无法继续执行计算。<br>
	  </div>
	  <div class="modal-footer">
	    
	  </div>
	</div>
    
  </body>
</html>