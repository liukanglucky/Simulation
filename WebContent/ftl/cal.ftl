<html>
  <head>
    <meta charset="utf8">
    <title>仿真计算</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </head>
  <body>
    <#include "head.ftl"/>
    <div class="row-fluid" style="width:100%;margin-left:auto;margin-right:auto;">
      <div class = "span6">
        <div class = "span8">
        <table class="table" >
          <tr style="background-color:#0088CC">
            <td align="center"><font color="white">功能列表</font></td>
          </tr>
          <tr>
            <td><a href="userManage.do">用户管理</a></td>
          </tr>
          <tr>
            <td><a href="#">模型管理</td>
          </tr>
          <tr >
            <td><a href="#">仿真查询</td>
          </tr>
          <tr class="info">
            <td><a href="calManage.do">仿真计算</td>
          </tr>
          <tr>
            <td><a href="#">数据备份</td>
          </tr>
        </table> 
      </div>
        <table class="table">
          <tr>
            <td align="center">仿真类型：</td>
            <td align="center">
              <select name="utype" style="width:90px; height:20px" id="simType">
                <option value="1">数据仿真</option>
                <option value="0">分析数据</option>
              </select>
            </td>
            <td align="center">选择实例数据：</td>
            <td align="center" style="width:90px; height:20px">
              <input type="file">
            </td>
          </tr> 
        </table>
        <script src="js/custom/defaultData.js"></script>
        <script>
          function tabgo3()
          {
            if($("#simType").val()==0){
                $('#tab-3').attr('href','#tab3A'); 
                $('#myTab a[href="#tab3A"]').tab('show');
              }
            if($("#simType").val()==1){
                $('#tab-3').attr('href','#tab3B'); 
                $('#myTab a[href="#tab3B"]').tab('show');
              }
          }
          function tabgo4()
          {
            if($("#simType").val()==0){
                $('#tab-4').attr('href','#tab4A'); 
                $('#myTab a[href="#tab4A"]').tab('show');
              }
            if($("#simType").val()==1){
                $('#tab-4').attr('href','#tab4B'); 
                $('#myTab a[href="#tab4B"]').tab('show');
              }
          }
          function tabgo5()
          {
            if($("#simType").val()==0){
                $('#tab-5').attr('href','#tab5A'); 
                $('#myTab a[href="#tab5A"]').tab('show');
              }
            if($("#simType").val()==1){
                $('#tab-5').attr('href','#tab5B'); 
                $('#myTab a[href="#tab5B"]').tab('show');
              }
          }
          function tabgo6()
          {
            if($("#simType").val()==0){
                $('#tab-6').attr('href','#tab6A'); 
                $('#myTab a[href="#tab6A"]').tab('show');
              }
            if($("#simType").val()==1){
                $('#tab-6').attr('href','#tab6B'); 
                $('#myTab a[href="#tab6B"]').tab('show');
              }
          }
        </script>
        <!-- 输入tab页面  begin-->
        <ul class="nav nav-tabs" id="myTab" style="font-size:12px;">
          <li class="active" ><a href="#tab1" data-toggle="tab">舰艇声反射</a></li>
          <li><a href="#" onclick="tabgo2()" id="tab-2">高频混响</a></li>
          <li><a href="#" onclick="tabgo3()" id="tab-3">舰艇辐射</a></li>
          <li><a href="#" onclick="tabgo4()" id="tab-4">鱼雷</a></li>
          <li><a href="#" onclick="tabgo5()" id="tab-5">舰艇自噪声</a></li>
          <li><a href="#" onclick="tabgo6()" id="tab-6">鱼雷自噪声</a></li>
          <li><a href="#tab7" data-toggle="tab">海洋环境</a></li>
          <li><a href="#tab8" data-toggle="tab">声传播</a></li>
        </ul>
         
        <div class="tab-content">
          <#include "tab/tab1.ftl"/>
          <#include "tab/tab2.ftl"/>
          <#include "tab/tab3A.ftl"/>
          <#include "tab/tab3B.ftl"/>
          <#include "tab/tab4A.ftl"/>
          <#include "tab/tab4B.ftl"/>
          <#include "tab/tab5A.ftl"/>
          <#include "tab/tab5B.ftl"/>
          <#include "tab/tab6A.ftl"/>
          <#include "tab/tab6B.ftl"/>
          <#include "tab/tab7.ftl"/>
          <#include "tab/tab8.ftl"/>
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

        $(".chart").css("display","");
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'));
                var myChart2 = ec.init(document.getElementById('main2')); 
                var myChart3 = ec.init(document.getElementById('main3'));  
                
                var xdata = new Array(500);
                var data1 = new Array(500);
                var data2 = new Array(500);
                var data3 = new Array(500);

                for(var i=0;i<500;i++){
                  xdata[i] = i;
                  data1[i] = Math.random()+10;
                  data2[i] = 5;
                  data3[i] = Math.random()*5+5;
                }


                var option = {

    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['回波频率谱']
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
    grid:{
      borderColor:'#cccccc',
      borderWidth:0,
      backgroundColor:'#000',
      
    },
    xAxis : [

        {
            type : 'category',
            show:false,
            boundaryGap : false,
            data : xdata,
            splitLine:{
              show:false
            },
        }
    ],
    yAxis : [
        {
            type : 'value',
            show:false,
             axisLabel : {
                formatter: ''
            },
            splitLine:{
              show:false
            },
        }
    ],
    series : [
        {
            name:'回波频率谱',
            type:'line',
            stack: '总量',
            symbol:'none',

            
            itemStyle: {normal: {

              lineStyle:{
                width:1,
                color:'#00cd00',
            },

            }},
            data:data1
        }
    ]
};
                    
              var option2 = {
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['目标强度方位变化']
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
    grid:{
      backgroundColor:'#000',
      borderColor:'#cccccc',
      borderWidth:0
    },
    xAxis : [
        {
            type : 'category',
            show:false,
            boundaryGap : false,
            data : xdata,
            splitLine:{
              show:false
            },
        }
    ],
    yAxis : [
        {
            type : 'value',
            show:false,
            splitLine:{
              show:false
            },
        }
    ],
    series : [
        {
            name:'目标强度方位变化',
            type:'line',
            stack: '总量',
            symbol:'none',
            itemStyle: {normal:{lineStyle:{width:1,color:'#00cd00',}}},
            data:data2
        }
    ]
};  
  
              var option3 = {
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['回波信号']
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
    grid:{
      borderColor:'#cccccc',
      borderWidth:0,
      backgroundColor:'#000',
      
    },
    xAxis : [
        {
            type : 'category',
            show:false,
            boundaryGap : false,
            data : xdata,
            splitLine:{
              show:false
            },
        }
    ],
    yAxis : [
        {
            type : 'value',
            show:false,
            splitLine:{
              show:false
            },
        }
    ],
    series : [
        {
            name:'回波信号',
            type:'line',
            stack: '总量',
            symbol:'none',
            itemStyle: {normal:{lineStyle:{width:1,color:'#00cd00',}}},
            data:data3
        }
    ]
};


                // 为echarts对象加载数据 
                myChart.setOption(option); 
                myChart2.setOption(option2); 
                myChart3.setOption(option3); 
            }
          );
      }
    </script>
  </body>
</html>