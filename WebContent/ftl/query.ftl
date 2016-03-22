<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <#include "common-js.ftl"/>
    <#include "page.ftl"/>
    <#include "checkbox.ftl"/>

  </head>
  <body>
  <script src="js/custom/runAndshow.js"></script>
  <script>
  		var _dt = '';
	  	var _mt = '';
	  	var _sim = '';
	  	var _stype = '';
	  	var _comments= '';
	  	var _currentPage= '';
	  	var _pageSize = '';
	  <#--根据查询条件查询ModelData-->
	function queryModelData(){
	  	_dt = $("select[name='dt']").val();
	  	_mt = $("select[name='mt']").val(); 
	  	_sim = $("select[name='sim']").val();
	  	_stype = $("select[name='stype']").val();
	  	_comments= $("input[name='comments']").val();
	  	_currentPage= 1;
	  	_pageSize = 5;
	  	$.ajax({
  			type:"post",
  			url:"querySim.do",
  			data:{dt:_dt,mt:_mt,sim:_sim,stype:_stype,comments:_comments,currentPage:_currentPage,pageSize:_pageSize},
  			dataType:"json",
  			success:function(json){
  				var  list = eval(json);
				var data=list[0].data;
				show(data);
				_currentPage=list[0].page.currentPage;
	            totalPage=list[0].page.totalPage;
	            prePage=list[0].page.prePage;
				nextPage=list[0].page.nextPage;
	            $("#page").empty();
	            page(totalPage,_currentPage,prePage,nextPage);
	            },
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
	  }
  	<#--deleteUsers-->
	function deleteModelDatas() {
        var str="";
        $("input[id='subcheck']:checkbox").each(function(){ 
            if($(this).attr("checked")){
                str += $(this).val()+","
            }
        });
        $.post("deleteModelDatas.do",
        {idList:str},
        function(){
        	queryByPage(_currentPage);
        }
        );
    }
    function show(list){  	
        	$(".modelDataList").empty();
        	for(i=0;i<list.length;i++){
        	var appendStr="";
        	appendStr+="<tr class='modelDataList'>"+
      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].dataindex+"></td>";
      			if(list[i].dt==1){
      				appendStr+="<td onclick='findData("+list[i].dataindex+")'>仿真</td>";
      			}else{
      				appendStr+="<td onclick='findData("+list[i].dataindex+")'>分析</td>";
      			}
      			switch(list[i].stype){
      				case 1 :
      					appendStr+="<td  onclick='findData("+list[i].dataindex+")'>舰艇声反射</td>";
      					break;
      				case 2 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>高频混响</td>";
      					break;
      				case 3 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>舰艇辐射</td>";
      					break;
      				case 4 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>鱼雷辐射</td>";
      					break;
      				case 5 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>舰艇自噪声</td>";
      					break;
      				case 6 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>鱼雷自噪声</td>";
      					break;
      				case 7 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>海洋环境</td>";
      					break;
      				case 8 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>声传播</td>";
      					break;
      				default:
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>未知</td>";
      			}
      			switch(list[i].sim){
      				case 1 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>001</td>";
      					break;
      				case 2 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>039</td>";
      					break;
      				case 3 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>054A</td>";
      					break;
      				case 4 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>鱼－10</td>";
      					break;
      				case 5 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>鱼－7A</td>";
      					break;
      				default:
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>未知</td>";
      			}
      			switch(list[i].mt){
      				case 1 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>海洋环境</td>";
      					break;
      				case 2 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>潜艇</td>";
      					break;
      				case 3 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>水面舰</td>";
      					break;
      				case 4 :
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>鱼雷</td>";
      					break;
      				default:
      					appendStr+="<td onclick='findData("+list[i].dataindex+")'>uuu</td>";
      			}
      			appendStr+=
        		"<td onclick='findData("+list[i].dataindex+")'>"+list[i].date1+"-"+list[i].time1+"</td>"+
        		"</tr>";
        		$("#modelDataTable").append(appendStr);
        	}
    }
    <#--分页条-->
	function queryByPage(current){
	  	_currentPage= current;
	  	$.ajax({
  			type:"post",
  			url:"querySim.do",
  			data:{dt:_dt,mt:_mt,sim:_sim,stype:_stype,comments:_comments,currentPage:_currentPage,pageSize:_pageSize},
  			dataType:"json",
  			success:function(json){
  				var  list = eval(json);
				var data=list[0].data;
				show(data);
				_currentPage=list[0].page.currentPage;
	            totalPage=list[0].page.totalPage;
	            prePage=list[0].page.prePage;
				nextPage=list[0].page.nextPage;
	            $("#page").empty();
	            page(totalPage,_currentPage,prePage,nextPage);
	            },
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
	}
	function findData(dataindex){
	
		$.ajax({
  			type:"post",
  			url:"querySimById.do",
  			data:{id:dataindex},
  			dataType:"json",
  			success:function(json){
  				var  data = eval(json);
				var input = "吨位："+data.if1+"，吃水："+data.if2+" ，航速："+data.if3+"，输出频率："+data.if4+"-"+data.if5+"，采样率："+data.if6+" ，增益："+data.if7+"<br>\
		        灵敏度："+data.if8+"，阵元："+data.if9+"，总声级："+data.if10+" ,轴频："+data.if11+"，螺旋桨数："+data.if12+"\
		        ";
		        var output = "调制谱轴频频率：1.00，频带内总声级：168.00，螺旋桨叶片数：0.00";
		
		        $("#input").html(input);
		        $("#output").html(output);
        		var out1=new Array();
        		var out2=new Array();
        		var out3=new Array();
        		ou1=data.out1;
        		out2=data.out2;
        		out3=data.out3;
        		var line1 = new Array();
				var line2 = new Array();
				var line3 = new Array();
        		for(i=0;i<(out1.length)/3;)
        		{
        			line1[i]=out1.substr(i,3);
        			i+=3;
        		}
        		for(i=0;i<(out2.length)/3;)
        		{
        			line2[i]=out2.substr(i,3);
        			i+=3;
        		}
        		for(i=0;i<(out3.length)/3;)
        		{
        			line3[i]=out3.substr(i,3);
        			i+=3;
        		}
        		alert("显示数据id为"+data.dataindex+"曲线");
        		showData(line1,line2,line3,output);
	            },
  			error : function() {  
	              alert("异常！");
	        }
  		}
  		);
	}
  </script>
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
          <#if userSession.type = 1>
          <tr>
            <td><a href="#">模型管理</td>
          </tr>
          </#if>
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
                  <option value="1">海洋环境</option>
                  <option value="2">潜艇</option>
                  <option value="3">水面舰</option>
                  <option value="4">鱼类</option>
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