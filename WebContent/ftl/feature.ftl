<html>
  <head>
    <meta charset="utf8">
    <title>声学特性管理</title>
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
	<#--根据id查询声学特性信息-->
  	function updateFeature(featureid){
  		$.ajax({
  			type:"post",
  			url:"queryFeatureById.do",
  			data:{id:featureid},
  			dataType:"json",
  			success:function(data){
  				$('#featureId').val(data.id);
  				$('#featureName').val(data.name);
  				$('#updateFeature').modal();
  			},
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
  	}
  	<#--deleteSims-->
	function deleteFeatures() {
    var str="";
    $("input[id='subcheck']:checkbox").each(function(){ 
        if($(this).attr("checked")){
            str += $(this).val()+","
        }
    });
    $.post("deleteFeatures.do",
        {idList:str},
        function(data){
        	var  list = eval(data);
        	var featureList=list[0].data;
        	showFeature(featureList);
        	currentPage=list[0].page.currentPage;
            totalPage=list[0].page.totalPage;
            prePage=list[0].page.prePage;
			nextPage=list[0].page.nextPage;
            $("#page").empty();
            page(totalPage,currentPage,prePage,nextPage);
        }
     	);
	}
	function showFeature(list){
		$(".featureList").empty();
    	for(i=0;i<list.length;i++){
    	var appendStr="";
    	appendStr+="<tr class='featureList'>"+
  			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].id+"></td>"+
    		"<td>"+list[i].id+"</td>"+
    		"<td>"+list[i].name+"</td>"+
    		"<td><button class='btn btn-info' data-toggle='modal'"+
    		" onclick='updateFeature("+list[i].id+")'>更新</button></td><tr>";
    		$("#featureTable").append(appendStr);
    	}
	}
	<#--分页条-->
	function queryByPage(current){
		$.post("queryFeatureByPage.do",
		{	
			currentPage:current,
			pageSize:5
		},
		function(json){
			var  list = eval(json);
			var data=list[0].data;
            showFeature(data);
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
          <form action="queryFeaturesByName.do" method="post">
          <table class="table table-hover" >
            <tr>
              <td align="center">声学特性名</td>
              <td align="center"><input type="text" name="name"></td>
              <td><button class="btn btn-success" type="submit">查询</button></td>
            </tr>
          </table>
          </form>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加声学特性</a>
          <input type="button" class="btn btn-warning" value="删除声学特性" onclick="deleteFeatures()">
        </div>
        <br>
        <div>
          <table class="table" id="featureTable">
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">声学特性ID</font></td>
              <td align="center"><font color="white">声学特性名</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
             <#list featureList as feature>
            <tr class="featureList">
              <td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${feature.id}></td>
              <td>${feature.id}</td>
        	  <td>${feature.name}</td>
              <td><button class="btn btn-info" data-toggle="modal" onclick="updateFeature(${feature.id})">更新</button></td>
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
        <h3 id="myModalLabel">增加声学特性</h3>
      </div>
      <div class="modal-body">
      <form action="addFeature.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">声学特性名</td>
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
    <div id="updateFeature" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">更新声学特性</h3>
      </div>
      <div class="modal-body">
       <form action="updateFeature.do" method="post">
        <table class="table table-hover" >
            <tr>
              <input type="hidden" id="featureId" name="id">
              <td align="center">声学特性</td>
              <td align="center"><input type="text" name="name" id="featureName"></td>
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