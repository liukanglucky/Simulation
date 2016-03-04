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
      			"<td><input type='checkbox' id='subcheck' onclick='setSelectAll()' value="+list[i].dataindex+"></td>"+
        		"<td>"+list[i].dataindex+"</td>"+
        		"<td>"+list[i].opertor+"</td>"+
        		"<td>"+list[i].data1+"</td>"+
        		"<td>"+list[i].dt+"</td>>"+
        		"<td>"+list[i].mt+"</td>"+
        		"<td>"+list[i].sim+"</td>"+
        		"<td>"+list[i].stype+"</td></tr>";
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
  </script>
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
            <td><a href="userManage.do">用户管理</a></td>
          </tr>
          <#if userSession.type = 1>
          <tr>
            <td><a href="#">模型管理</td>
          </tr>
          </#if>
          <tr class="info">
            <td><a href="query.do">仿真查询</td>
          </tr>
          <tr>
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr>
            <td><a href="datadump.html">数据备份</td>
          </tr>
        </table>
        </div>
      <div class="span8">
        <div>
          <table class="table" >
            <tr>
              <td align="center">模型类型</td>
              <td align="center">
                <select name="mt">
                  <option value="1">海洋环境</option>
                  <option value="2">潜艇</option>
                  <option value="3">水面舰</option>
                  <option value="4">鱼类</option>
                </select>
              </td>
              <td align="center">仿真对象</td>
              <td align="center">
                <select name="sim">
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
                  <option value="1">舰艇自噪声</option>
                  <option value="2">高频模型</option>
                  <option value="3">舰艇目标声反射</option>
                  <option value="4">鱼类辐射</option>
                </select>
              </td>
              <td align="center">数据类型</td>
              <td align="center">
                <select name="dt">
                  <option value="1">仿真数据</option><option value="2">分析数据</option>
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
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">修改时间</font></td>
              <td align="center"><font color="white">修改人</font></td>
              <td align="center"><font color="white">仿真类型</font></td>
              <td align="center"><font color="white">模型类型</font></td>
              <td align="center"><font color="white">仿真对象</font></td>
              <td align="center"><font color="white">声学特性</font></td>
            </tr>
            <tr class = "modelDataList">
            </tr>
          </table> 
        </div>
        <div class="pagination pagination-centered" >
          <ul id="page">
          </ul>
        </div>

        
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
    <script>
      function showData(){
        var input = "吨位：4000.00，吃水：6.00 ，航速：18.00，输出频率：100-1000，采样率：20.00 ，增益：80.00<br>\
        灵敏度：－200.00，阵元：48.00，总声级：166.00 ,轴频：1.80，螺旋桨数：5.00\
        ";
        var output = "调制谱轴频频率：1.00，频带内总声级：168.00，螺旋桨叶片数：0.00";

        $("#input").html(input);
        $("#output").html(output);

        $("#main").css("display","");
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['回波频率谱','目标强度方位变化','回波信号','反射信号']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['1','2','3','4','5','6','7']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'回波频率谱',
            type:'line',
            stack: '总量',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'目标强度方位变化',
            type:'line',
            stack: '总量',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[220, 182, 191, 234, 290, 330, 310]
        },
        {
            name:'回波信号',
            type:'line',
            stack: '总量',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[150, 232, 201, 154, 190, 330, 410]
        },
        {
            name:'反射信号',
            type:'line',
            stack: '总量',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[320, 332, 301, 334, 390, 330, 320]
        }
    ]
};
                    
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
          );
      }
    </script>
  </body>
</html>