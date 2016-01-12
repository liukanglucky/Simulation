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
    <#include "functionList.ftl"/>
      <div class="span9">
        <div>
          <table class="table table-hover" >
            <tr>
              <td align="center">仿真类型</td>
              <td align="center">
                <select name="utype">
                  <option >数据仿真</option>
                </select>
              </td>
              <td align="center">选择实例数据</td>
              <td align="center">
                <input type="file">
              </td>
              <td colspan="2"><input type="button" class="btn btn-success" value="开始仿真" onClick="showData();"></td>
            </tr>
              
          
            
          </table>
        </div>

        <!-- 输入tab页面  begin-->
        <ul class="nav nav-tabs" id="myTab">
          <li class="active" ><a href="#tab1" data-toggle="tab">舰艇声反射</a></li>
          <li><a href="#tab2" data-toggle="tab">高频混响</a></li>
          <li><a href="#tab3" data-toggle="tab">舰艇辐射</a></li>
          <li><a href="#tab4" data-toggle="tab">鱼雷</a></li>
          <li><a href="#tab5" data-toggle="tab">舰艇自噪声</a></li>
          <li><a href="#tab6" data-toggle="tab">鱼雷自噪声</a></li>
          <li><a href="#tab7" data-toggle="tab">海洋环境</a></li>
          <li><a href="#tab8" data-toggle="tab">声传播</a></li>
        </ul>
         
        <div class="tab-content">
          <div class="active tab-pane" id="tab1">
            目标三维模型 : <input type="file"><br>
            仿真类型：
            <select name="utype">
              <option >潜艇</option>
            </select>
            <select name="utype">
              <option >001</option>
            </select>
            <br>
            采样频率KHz：<input type="text">
            检测域dB：<input type="text">
            <br>
            距离：<input type="text">
            
            声速m/s：<input type="text">
            <br>
            仿真总时间：<input type="text">
            发射信号形式： <select name="utype">
              <option >CW</option>
            </select>
            <br>
            声源级dB：<input type="text">
            仿真开始时刻：<input type="text">
          </div>
          <div class="tab-pane" id="tab2">2</div>
          <div class="tab-pane" id="tab3">3</div>
          <div class="tab-pane" id="tab4">4</div>
          <div class="tab-pane" id="tab5">5</div>
          <div class="tab-pane" id="tab6">6</div>
          <div class="tab-pane" id="tab7">7</div>
          <div class="tab-pane" id="tab8">8</div>
        </div>
        <!-- end -->
        <br>
        
        <div>
          <hr>
          <font color="blue">输入参数：</font><br>
          <div id="input"></div>
          <hr>
          <font color="blue">输出结果：</font><br>
          <div id="output"></div>
          <hr>
        </div>
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="height:400px;display:none"></div>

        

        
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
        var input = "吨位：0，吃水：0 ... ...";
        var output = "线谱频率：";

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