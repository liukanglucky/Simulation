<html>
  <head>
    <meta charset="utf8">
    <title>模型管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <#include "common-js.ftl"/>
    <#include "page.ftl"/>
    <#include "checkbox.ftl"/>
    <script>
    $(document).ready(function(){
		page();
	})
    	<#--根据id查询模型信息-->
      	function updateModel(modelid){
      		$.ajax({
      			type:"post",
      			url:"queryModelById.do",
      			data:{id:modelid},
      			dataType:"json",
      			success:function(data){
      				$('#modelId').val(data.id);
      				$('#modelName').val(data.name);
      				$('#updateModel').modal();
      			},
      			error : function() {  
		              alert("异常！");
		        }
      		}
      		);
      	}
      	<#--deleteModels-->
			function deleteModels() {
            var str="";
            $("input[id='subcheck']:checkbox").each(function(){ 
                if($(this).attr("checked")){
                    str += $(this).val()+","
                }
            });
            $.post("deleteModels.do",
            {idList:str},
            function(data){
            	var  list = eval(data);
            	$(".modelList").empty();
            	for(i=0;i<list.length;i++){
            	var appendStr="";
            	appendStr+="<tr class='modelList'>"+
	      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].id+"></td>"+
	        		"<td>"+list[i].id+"</td>"+
	        		"<td>"+list[i].name+"</td>"+
	        		"<td><button class='btn btn-info' data-toggle='modal'"+
	        		" onclick='updateModel("+list[i].id+")'>更新</button></td><tr>";
	        		$("#modelTable").append(appendStr);
            	}
            	
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
          <form action="queryModelsByName.do" method="post">
          <table class="table table-hover" >
            <tr>
              <td align="center">模型类型名</td>
              <td align="center"><input type="text" name="name"></td>
              <td><button class="btn btn-success" type="submit">查询</button></td>
            </tr>
          </table>
          </form>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加模型</a>
          <input type="button" class="btn btn-warning" value="删除模型" onclick="deleteModels()">
        </div>
        <br>
        <div>
          <table class="table" id="modelTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">模型类型ID</font></td>
              <td align="center"><font color="white">模型类型名</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
             <#list modelList as model>
            <tr class="modelList">
              <td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${model.id}></td>
              <td>${model.id}</td>
        	  <td>${model.name}</td>
              <td><button class="btn btn-info" data-toggle="modal" onclick="updateModel(${model.id})">更新</button></td>
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
        <h3 id="myModalLabel">增加模型类型</h3>
      </div>
      <div class="modal-body">
      <form action="addModel.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">模型类型名</td>
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
    <div id="updateModel" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">更新模型</h3>
      </div>
      <div class="modal-body">
       <form action="updateModel.do" method="post">
        <table class="table table-hover" >
            <tr>
              <input type="hidden" id="modelId" name="id">
              <td align="center">模型类型</td>
              <td align="center"><input type="text" name="name" id="modelName"></td>
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