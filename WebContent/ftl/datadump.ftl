<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "common-js.ftl"/>
    <#include "page.ftl"/>
    <#include "checkbox.ftl"/>
    <script>
    $(document).ready(function(){
		var currentPage=${page.currentPage};
		var totalPage=${page.totalPage};
		var prePage=${page.prePage};
		var nextPage=${page.nextPage};
		page(totalPage,currentPage,prePage,nextPage);
	})
	function backup(){
		$.post(
			"backup.do",
			function(data){
				var  list = eval(data);
				var userList=list[0].data;
	        	showBackupList(userList);
	        	currentPage=list[0].page.currentPage;
	            totalPage=list[0].page.totalPage;
	            prePage=list[0].page.prePage;
				nextPage=list[0].page.nextPage;
	            $("#page").empty();
	            page(totalPage,currentPage,prePage,nextPage);
			}
			)
	}
	<#--deleteBackups-->
	function deleteBackups() {
        var str="";
        $("input[id='subcheck']:checkbox").each(function(){ 
            if($(this).attr("checked")){
                str += $(this).val()+","
            }
        });
        $.post("deleteBackups.do",
        {nameList:str},
        function(){
        	queryByPage(1);
        }
        );
        $.post("dumpData.do");
    }
     function showBackupList(list){  	
        	$(".backupList").empty();
        	for(i=0;i<list.length;i++){
        	var appendStr="";
        	appendStr+="<tr class='backupList'>"+
      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].name+"></td>"+
        		"<td>"+list[i].id+"</td>"+
        		"<td>"+list[i].date+"</td>"+
	        	"<td>"+list[i].operater+"</td>"+
        		"<td><button class='btn btn-info' data-toggle='modal'"+
        		"onclick='resumeBackup("+list[i].name+
        		")'>恢复</button></td><tr>";
        		$("#backupTable").append(appendStr);
        	}
    }
    function resumeBackup(name){
    	$.post("resume.do",
        {backName:name},
        function(data){
        	alert(data);
        }
        );
    }
     <#--分页条-->
	function queryByPage(current){
		$.post("queryBackupByPage.do",
		{	
			currentPage:current,
			pageSize:10
		},
		function(json){
			var  list = eval(json);
			var data=list[0].data;
            showBackupList(data);
            currentPage=list[0].page.currentPage;
            totalPage=list[0].page.totalPage;
            prePage=list[0].page.prePage;
			nextPage=list[0].page.nextPage;
            $("#page").empty();
            page(totalPage,currentPage,prePage,nextPage);
            }
		);
	}
    </script>
  </head>
  <body>
  	<#if Session["user"]?exists>
    <#assign userSession = Session["user"]>
	</#if>
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
          <tr  class="info">
            <td><a href="dumpData.do">数据备份</td>
          </tr>
        </table>
      </div> 
      <div class="span8">
      <#if userSession.type = 1>
      	<div>
          <input type="button" class="btn btn-warning" value="备份" onclick="backup()">
          <input type="button" class="btn btn-warning" value="删除" onclick="deleteBackups()">
        </div>
   		</#if>
        <div>
          <table class="table"  id="backupTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">备份时间</font></td>
              <td align="center"><font color="white">操作人员</font></td>
              <#if userSession.type = 1>
              <td align="center"><font color="white">操作</font></td>
              </#if>
            </tr>
            <#list backupList as backup>
            <#--这是一段注释-->
      		<tr class="backupList">
      			<td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${backup.name}></td>
        		<td>${backup.id}</td>
        		<td>${backup.date}</td>
        		<td>${backup.operater}</td>
        		<#if userSession.type = 1>
        		<td><button class="btn btn-info" data-toggle="modal" onclick="resumeBackup('${backup.name}')">恢复</button></td>
        		</#if>
      		</tr>
      		</#list>
          </table> 
        </div>
        <div class="pagination pagination-centered" >
          <ul id="page">
          </ul>
        </div>
       </div>
     </div>
  </body>
</html>