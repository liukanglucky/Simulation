<html>
  <head>
    <meta charset="utf8">
    <title>仿真查询</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <#include "common-js.ftl"/>
    <#include "page.ftl"/>
    <#include "checkbox.ftl"/>

  </head>
  <body>
  <script src="js/custom/queryAndshow.js"></script>
  <script src="js/custom/query.js"></script>
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
          <tr>
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr class="info">
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
        
        <div>
          <table class="table" >
            <tr>
              <td align="center">模型类型</td>
              <td align="center">
                <select name="mt">
                  <option value="0">未知</option>
                  <option value="1">潜艇</option>
                  <option value="2">水面舰</option>
                  <option value="3">鱼雷</option>
                  <option value="4">海洋环境</option>
                </select>
              </td>
              <td align="center">仿真对象</td>
              <td align="center">
                <select name="sim">
                 <option value="0">未知</option>
                  <option value="1">001</option>
                  <option value="2">054A</option>
                  <option value="3">039</option>
                  <option value="4">鱼－7A</option>
                  <option value="5">鱼－10</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">声学模型</td>
              <td align="center">
                <select name="stype">
                <option value="0">未知</option>
                  <option value="1">舰艇目标声反射</option>
                  <option value="2">高频模型</option>
                  <option value="3">舰艇辐射</option>
                  <option value="4">鱼雷辐射</option>
                  <option value="5">舰艇自噪声</option>
                  <option value="6">鱼雷自噪声</option>
                  <option value="7">海洋环境</option>
                  <option value="8">声传播</option>
                </select>
              </td>
              <td align="center">数据类型</td>
              <td align="center">
                <select name="dt">
                  <option value="0">未知</option>
                  <option value="1">仿真数据</option>
                  <option value="2">分析数据</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">全文检索</td>
              <td align="center">
                <input type="text" name="comments">
              </td>
              <td colspan="2"><input type="button" class="btn btn-success" value="查询" onclick="queryModelData()"></td>
            </tr>
          </table>
        </div>

        <div>
          <a href="calManage.do" role="button" class="btn btn-info" >新建仿真</a>
          <#if userSession.type = 1>
              <input type="button" class="btn btn-warning" value="删除记录" onclick="deleteModelDatas()">
          </#if>
        </div>
        <br>
        
        <div id="main" style="height:400px;display:none"></div>

        <div>
          <font color="blue">点击记录查看输入输出数据及线谱</font><br>
          <table class="table" id="modelDataTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">类型</font></td>          
              <td align="center"><font color="white">声学特性</font></td>
              <td align="center"><font color="white">仿真对象</font></td>
              <td align="center"><font color="white">模型类型</font></td>
              <td align="center"><font color="white">仿真时间</font></td>
            </tr>
            <tr class = "modelDataList">
            </tr>
          </table> 
        </div>
        <div class="pagination pagination-centered" >
          <ul id="page">
          </ul>
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
        <div id="main1" style="height:200px;display:none" class="chart"></div>
        <div id="main2" style="height:200px;display:none" class="chart"></div>
        <div id="main3" style="height:200px;display:none" class="chart"></div>
        <div id="main4" style="height:200px;display:none" class="chart"></div>
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
  </body>
</html>