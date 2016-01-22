<html>
  <head>
    <meta charset="utf8">
    <title>对象管理</title>
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
	<#--根据id查询仿真对象信息-->
  	function updateSim(simid){
  		$.ajax({
  			type:"post",
  			url:"querySimById.do",
  			data:{id:simid},
  			dataType:"json",
  			success:function(data){
  				$('#simId').val(data.id);
  				$('#simName').val(data.name);
  				$('#updateSim').modal();
  			},
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
  	}
  	<#--deleteSims-->
	function deleteSims() {
    var str="";
    $("input[id='subcheck']:checkbox").each(function(){ 
        if($(this).attr("checked")){
            str += $(this).val()+","
        }
    });
    $.post("deleteSims.do",
        {idList:str},
        function(data){
        	var  list = eval(data);
        	showSim(list);
    	}
    );
    }
    function showSim(list){
    	$(".modelList").empty();
        	for(i=0;i<list.length;i++){
        	var appendStr="";
        	appendStr+="<tr class='simList'>"+
      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].id+"></td>"+
        		"<td>"+list[i].id+"</td>"+
        		"<td>"+list[i].name+"</td>"+
        		"<td><button class='btn btn-info' data-toggle='modal'"+
        		" onclick='updateSim("+list[i].id+")'>更新</button></td><tr>";
        		$("#simTable").append(appendStr);
        	}
    }
    <#--分页条-->
	function queryByPage(current){
		$.post("querySimByPage.do",
		{	
			currentPage:current,
			pageSize:2
		},
		function(json){
			var  list = eval(json);
			var data=list[0].data;
            showSim(data);
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
    <#include "functionList.ftl"/>
      <div class="span9">
        <div>
          <form action="querySimsByName.do" method="post">
          <table class="table table-hover" >
            <tr>
              <td align="center">仿真对象名</td>
              <td align="center"><input type="text" name="name"></td>
              <td><button class="btn btn-success" type="submit">查询</button></td>
            </tr>
          </table>
          </form>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加仿真对象</a>
          <input type="button" class="btn btn-warning" value="删除仿真对象" onclick="deleteSims()">
        </div>
        <br>
        <div>
          <table class="table" id="simTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">仿真对象ID</font></td>
              <td align="center"><font color="white">仿真对象名</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
             <#list simList as sim>
            <tr class="simList">
              <td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${sim.id}></td>
              <td>${sim.id}</td>
        	  <td>${sim.name}</td>
              <td><button class="btn btn-info" data-toggle="modal" onclick="updateSim(${sim.id})">更新</button></td>
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
        <h3 id="myModalLabel">增加仿真对象</h3>
      </div>
      <div class="modal-body">
      <form action="addSim.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">仿真对象名</td>
              <td align="center"><input type="text" name="name"></td>
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
    <div id="updateSim" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">更新仿真对象</h3>
      </div>
      <div class="modal-body">
       <form action="updateSim.do" method="post">
        <table class="table table-hover" >
            <tr>
              <input type="hidden" id="simId" name="id">
              <td align="center">仿真对象</td>
              <td align="center"><input type="text" name="name" id="simName"></td>
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