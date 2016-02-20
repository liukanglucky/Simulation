<html>
  <head>
    <meta charset="utf8">
    <title>用户管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
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
	<#--根据id查询用户信息-->
  	function updateUser(userid){
  		$.ajax({
  			type:"post",
  			url:"queryUserById.do",
  			data:{id:userid},
  			dataType:"json",
  			success:function(data){
  				$('#id').val(data.id);
  				$('#username').val(data.name);
  				$('#password').val(data.password);
  				if(data.type==1){
  					$('#userAuth')[0].selectedIndex = 1;
  				}else{
  					$('#userAuth')[0].selectedIndex = 0;
  				}
  				$('#updateUser').modal();
  			},
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
  	}
  	<#--deleteUsers-->
	function deleteUsers() {
        var str="";
        $("input[id='subcheck']:checkbox").each(function(){ 
            if($(this).attr("checked")){
                str += $(this).val()+","
            }
        });
        $.post("deleteUsers.do",
        {idList:str},
        function(data){
        	var  list = eval(data);
			var userList=list[0].data;
        	showUser(userList);
        	currentPage=list[0].page.currentPage;
            totalPage=list[0].page.totalPage;
            prePage=list[0].page.prePage;
			nextPage=list[0].page.nextPage;
            $("#page").empty();
            page(totalPage,currentPage,prePage,nextPage);
        }
        );
    }
    function showUser(list){  	
        	$(".userList").empty();
        	for(i=0;i<list.length;i++){
        	var appendStr="";
        	appendStr+="<tr class='userList'>"+
      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].id+"></td>"+
        		"<td>"+list[i].id+"</td>"+
        		"<td>"+list[i].name+"</td>";
	        		if(list[i].auth==1){
	        			appendStr+="<td>管理员</td>";
	        		}else{
	        			appendStr+="<td>普通用户</td>";
	        		}
        		appendStr+="<td><button class='btn btn-info' data-toggle='modal'"+
        		" onclick='updateUser("+list[i].id+")'>更新</button></td><tr>";
        		$("#usrTable").append(appendStr);
        	}
    }
    <#--分页条-->
	function queryByPage(current){
		$.post("queryUserByPage.do",
		{	
			currentPage:current,
			pageSize:5
		},
		function(json){
			var  list = eval(json);
			var data=list[0].data;
            showUser(data);
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

    <#include "head.ftl"/>
    <div class="row-fluid" style="width:100%;margin-left:auto;margin-right:auto;">
    <div class = "span4">
   	 	<table class="table" >
          <tr style="background-color:#0088CC">
            <td align="center"><font color="white">功能列表</font></td>
          </tr>
          <tr class="info">
            <td><a href="userManage.do">用户管理</a></td>
          </tr>
          <tr>
            <td><a href="#">模型管理</td>
          </tr>
          <tr >
            <td><a href="querySim.do">仿真查询</td>
          </tr>
          <tr>
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr>
            <td><a href="#">数据备份</td>
          </tr>
        </table>
      </div> 
      <div class="span8">
        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加用户</a>
          <input type="button" class="btn btn-warning" value="删除用户" onclick="deleteUsers()">
        </div>
        <br>
        <div>
          <table class="table"  id="usrTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">用户名</font></td>
              <td align="center"><font color="white">类型</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
            <#list userDo as user>
            <#--这是一段注释-->
      		<tr class="userList">
      			<td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${user.id}></td>
        		<td>${user.id}</td>
        		<td>${user.name}</td>
        		<td><#if user.type = 1>管理员</#if><#if user.type = 2>普通用户</#if></td>
        		<td><button class="btn btn-info" data-toggle="modal" onclick="updateUser(${user.id})">更新</button></td>
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



    <!-- modal -->
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">增加用户</h3>
      </div>
      <div class="modal-body">
      <form action="addUser.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">用户名</td>
              <td align="center"><input type="text" name="name"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="type">
                  <option value=2>普通用户</option>
                  <option value=1>管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" name="passord"></td>
            </tr>
            <tr>
              <td colspan="2"><button class="btn btn-success" type="submit">新增</button></td>
            </tr>
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
    </div>

    <!-- update -->
    <div id="updateUser" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">更新用户</h3>
      </div>
      <div class="modal-body">
      <form action="updateUser.do" method="post">
        <table class="table table-hover" >
            <tr>
              <input type="hidden" id="id" name="id">
              <td align="center">有户名</td>
              <td align="center"><input type="text" id="username" name="name"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select id="userAuth" name="type">
                  <option value=2>普通用户</option><option value=1>管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" id="password" name="password"></td>
            </tr>  
            <tr>
              <td colspan="2"><button class="btn btn-success" type="submit">更新</button></td>
            </tr>
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
      
  </body>
</html>