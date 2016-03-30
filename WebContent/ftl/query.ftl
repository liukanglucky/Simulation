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
  <script src="js/custom/queryAndshow.js"></script>
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
  				
 				switch(data.stype){
 				case 0:
 					var input= "类型为:0";
 					var output= "类型为:0";
 					break;
 				case 1:
 					
 					if(data.dt==2){
 						var input="采样频率："+data.if1+"，声速："+data.if2+"，发射声源级："+data.if3+"，检测域："+data.if4+"，仿真总时间："+data.if5+"，仿真开始时刻："+data.if6+"，<br>"+
	 					"距离："+data.if7+"，信号形式：";
	 					switch(data.it3){
	 						case 1:
	 							input+="CW";
	 							break;
	 						case 2:
	 							input+="LFM";
	 							break;
	 						case 3:
	 							input+="HFM";
	 							break;
	 						default:
	 							input+="未知";
	 					};
 						
 					}else{
	 					var input="航速："+data.if1+"，航向："+data.if2+"，中心频率："+data.if3+"，带宽："+data.if4+"，脉宽："+data.if5+"，目标距离："+data.if6+"，<br>"+
	 					"俯仰角："+data.if7+"，水平角："+data.if8+"，周期时间窗口："+data.if9+"，采样频率："+data.if10+"，发射声源级："+data.if11+"，发射波束开角："+data.if12+"<br>"+
	 					"接收发射波束开角："+data.if13+"，包络：";
	 					switch(data.it2){
	 						case 1:
	 							input+="矩形";
	 							break;
	 						case 2:
	 							input+="梯形";
	 							break;
	 						default:
	 							input+="未知";
	 					}
	 					input+="，信号形式：";
	 					switch(data.it3){
	 						case 1:
	 							input+="CW";
	 							break;
	 						case 2:
	 							input+="LFM";
	 							break;
	 						case 3:
	 							input+="HFM";
	 							break;
	 						default:
	 							input+="未知";
	 					};
 						var output = "调制谱轴频频率："+data.outp1+"，频带内总声级："+data.outp1+"，螺旋桨叶片数："+data.outp1;
 					}
 						var output = "";
 					break;
 				case 2:
 					var input="纵波声速："+data.if1+"，横波声速："+data.if2+"，介质密度："+data.if3+"，纵波衰减："+data.if4+"，横波衰减："+data.if5+"，平均散射："+data.if6+"，<br>"+
 					"谱强度："+data.if7+"，谱系数："+data.if8+"，风速：("+data.if9+","+data.if10+","+data.if11+")，海流速度：("+data.if12+","+data.if13+","+data.if14+")，海深："+data.if15+"，<br>"+
 					"声速："+data.if16+"，衰减系数："+data.if17+"，海面谱系数："+data.if18+"，谱系数："+data.if19+"，平均散射："+data.if20+"，发射水平角："+data.if21+"，<br>"+
 					"垂直角："+data.if23+"，方位角："+data.if146+"，俯仰角："+data.if148+"，声源级："+data.if25+"，位置：("+data.if26+"，"+data.if27+","+data.if28+")速度：("+data.if29+","+data.if30+","+data.if31+")，<br>"+
 					"阵元："+data.if32+"，灵敏度："+data.if33+"，采样率："+data.if34+"，中心频率："+data.if35+"，带宽："+data.if36+"，脉宽："+data.if37;
 					var output ="";
 					break;
 				case 3:
 				case 4:
 					 var input ="吨位："+data.if1+"，吃水："+data.if2+" ，航速："+data.if3+"，输出频率："+data.if4+"-"+data.if5+"，采样率："+data.if6+" ，增益："+data.if7+"<br>";
 					 if(data.mt==2){
 					 	input +="灵敏度："+data.if8+"，阵元："+data.if9+"，模拟采样率："+data.if10+" ,带通：("+data.if11+","+data.if12+")，起始时刻："+data.if13+"，总长度："+data.if14+"<br>";
 					 	input +="模拟增益："+data.if15+"，"+"模拟灵敏度："+data.if16;
 					 	var output ="线谱频率：("+data.if17+","+data.if18+","+data.if19+","+data.if20+","+data.if21+","+data.if22+","+data.if23+","+data.if24+","+data.if25+","+data.if26+")<br>"+
 					 	"线谱强度：("+data.if37+","+data.if38+","+data.if39+","+data.if40+","+data.if41+","+data.if42+","+data.if43+","+data.if44+","+data.if45+","+data.if46+")<br>"+
 					 	"调制深度：("+data.if57+","+data.if58+","+data.if59+","+data.if60+","+data.if61+","+data.if62+","+data.if63+","+data.if64+","+data.if65+","+data.if66+")";
 					 	output +="调制谱轴频频率："+data.if77+"，频带内总声级："+data.if78+"，螺旋桨叶片数："+data.if79;
 					 }else{
 					 	input +="灵敏度："+data.if8+"，阵元："+data.if9+"，对应谱级："+data.if10+" ,轴频："+data.if11+"，螺旋桨数："+data.if12+"，总长度："+data.if13+"<br>";
 					 	<#--input +="模拟增益：，"+"模拟灵敏度：";-->
 					 	var output = "调制谱轴频频率："+data.if77+"，频带内总声级："+data.if78+"，螺旋桨叶片数："+data.if79;
 					 }
 					break;
 				case 5:
 				case 6:
 					 var input ="吨位："+data.if1+"，吃水："+data.if2+" ，航速："+data.if3+"，输出频率："+data.if4+"-"+data.if5+"，采样率："+data.if6+" ，增益："+data.if7+"<br>";
 					 if(data.mt==2){
 					 	input +="灵敏度："+data.if8+"，阵元："+data.if9+"，对应谱级："+data.if10+" ,轴频："+data.if11+"，螺旋桨数："+data.if12+"，总长度："+data.if13+"<br>";
 					 	input +="模拟增益："+data.if63+"，"+"模拟灵敏度："+data.if64;
 					 }else{
 					 	input +="灵敏度："+data.if8+"，阵元："+data.if9+"，模拟采样率："+data.if10+" ,带通："+data.if11+"，起始时刻："+data.if12+"，总长度："+data.if13+"<br>";
 					 	<#--input +="模拟增益：，"+"模拟灵敏度：";-->
 					 }
		        	 var output = "调制谱轴频频率："+data.if125+"，频带内总声级："+data.if126+"，螺旋桨叶片数："+data.if127;
 					break;
 				case 7:
 					var input ="海面风速："+data.if1+"，"+"海流速度："+data.if2+"，"+"降雨量："+data.if3+"，"+"长度："+data.if4+"，"+"中心频率："+data.if5+"<br>";
 					input+="海况："+data.it1+"，"+"每平方米舰船数："+data.it2+"，"+"螺旋桨末端转速："+data.it3<#--+"，"+"模型类型："+data.it4-->;
 					var  output = "";
 					break;
 				case 8:
 					var input ="海底地貌：";
 					switch(data.it1){
 						case 1:
 							input +="平底";
 							break;
 						case 2:
 							input +="斜坡";
 							break;
 						case 3:
 							input +="海沟";
 							break;
 						case 4:
 							input +="海山";
 							break;
 						case 5:
 							input +="其他";
 							break;
 					}
 					input +="，发射阵信息：";
 					switch(data.it2){
 						case 1:
 							input +="单元发射";
 							break;
 						case 2:
 							input +="线列阵";
 							break;
 						case 3:
 							input +="面阵";
 							break;
 						case 5:
 							input +="其他";
 							break;
 					}
 					input +="，发射信号形式：";
 					switch(data.it3){
 						case 1:
 							input +="宽带噪声";
 							break;
 						case 2:
 							input +="CW";
 							break;
 						case 5:
 							input +="其他";
 							break;
 					}
 					input +="，接收阵信息：";
 					switch(data.it4){
 						case 1:
 							input +="单元发射";
 							break;
 						case 2:
 							input +="线列阵";
 							break;
 						case 3:
 							input +="面阵";
 							break;
 						case 5:
 							input +="其他";
 							break;
 					}
 					input +="，海底地质类型：";
 					switch(data.it5){
 						case 1:
 							input +="粘土";
 							break;
 						case 2:
 							input +="粉砂";
 							break;
 						case 3:
 							input +="沙石";
 							break;
 						case 4:
 							input +="砾石";
 							break;
 						case 5:
 							input +="白垩";
 							break;
 						case 6:
 							input +="石灰石";
 							break;
 						case 7:
 							input +="玄武岩";
 							break;
 					}
 					input +="，海深个数："+data.if16+"，"+"射线数量："+data.if17+"<br>";
 					input +="中心频率："+data.if1+"，"+"海流速度："+data.if2+"，"+"海面反射系数："+data.if3+"，"+"海底衰减系数："+data.if4+"，"+"输出距离步长："+data.if5+"，"+"收发间距："+data.if7+"<br>";
 					input +="发射指向性："+data.if10+"，"+"发射声源级："+data.if11+"，"+"接收深度："+data.if12+"，"+"工作频段："+data.if13+"-"+data.if14+"，"+"海面风速："+data.if15;
 					var  output = "噪声信号频率上限："+data.if21+"，"+"噪声信号频率下限："+data.if22;
 					break;
 				default:
 					var input ="参数错误！";
 					var  output = "参数错误";
 				} 
        		var line1 = new Array();
				var line2 = new Array();
				var line3 = new Array();
        		for(i=0,j=0;j<(data.out1.length)/3;j++)
        		{
        			line1[j]=data.out1.substr(i,3);
        			i+=3;
        		}
        		for(i=0,j=0;j<(data.out2.length)/3;j++)
        		{
        			line2[j]=data.out2.substr(i,3);
        			i+=3;
        		}
        		for(i=0,j=0;j<(data.out3.length)/3;j++)
        		{
        			line3[j]=data.out3.substr(i,3);
        			i+=3;
        		}
        		showData(line1,line2,line3,input,output);
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
        <div id="main1" style="height:200px;display:none" class="chart"></div>
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
  </body>
</html>