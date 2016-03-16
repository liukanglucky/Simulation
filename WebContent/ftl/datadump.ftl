<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
    <#include "head.ftl"/>
    <div class="row-fluid" style="width:100%;margin-left:auto;margin-right:auto;">
    <div class = "span4">
   	 	<table class="table" >
          <tr style="background-color:#0088CC">
            <td align="center"><font color="white">功能列表</font></td>
          </tr>
          <tr>
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr >
            <td><a href="query.do">仿真查询</td>
          </tr>
         <tr>
            <td><a href="userManage.do">用户管理</a></td>
          </tr>
          <tr>
            <td><a href="#">模型管理</td>
          </tr>
          <tr  class="info">
            <td><a href="dumpData.do">数据备份</td>
          </tr>
        </table>
      </div> 
      <div class="span9">
        <div>
          <table class="table table-hover" >
            <tr>
              <td align="center">导出模型</td>
              <td align="center">
                <select name="utype">
                  <option >模型1</option><option >模型2</option>
                </select>
              </td>
              <td align="center">导出路径</td>
              <td align="center"><input type="text" name="name"></td>
              
              <td><input type="button" class="btn btn-success" value="导出"></td>
              
            </tr>
            <tr>
            	<td><a href="dataDump.do">测试导出数据</td>
            </tr>
          </table>
        </div>
  </body>
</html>