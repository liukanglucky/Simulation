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
              <td align="center">模型类型</td>
              <td align="center">
                <select name="utype">
                  <option >海洋环境</option>
                  <option >潜艇</option>
                  <option >水面舰</option>
                  <option >鱼类</option>
                </select>
              </td>
              <td align="center">仿真对象</td>
              <td align="center">
                <select name="utype">
                  <option >001</option><option >002</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">声学模型</td>
              <td align="center">
                <select name="utype">
                  <option >舰艇自噪声</option>
                  <option >高频模型</option>
                  <option >舰艇目标声反射</option>
                  <option >鱼类辐射</option>
                </select>
              </td>
              <td align="center">数据类型</td>
              <td align="center">
                <select name="utype">
                  <option >仿真数据</option><option ></option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">全文检索</td>
              <td align="center">
                <input type="text" >
              </td>
              <td colspan="2"><input type="button" class="btn btn-success" value="查询"></td>
            </tr>
              
          
            
          </table>
        </div>

        <div>
          <a href="simAdd.do" role="button" class="btn btn-info" >新建仿真</a>
          <input type="button" class="btn btn-warning" value="删除记录">
        </div>
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

        <div>
          <font color="blue">点击记录查看输入输出数据及线谱</font><br>
          <table class="table table-hover" >
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox"><font color="white">全选</font></td>
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">名称</font></td>
              <td align="center"><font color="white">修改时间</font></td>
              <td align="center"><font color="white">修改人</font></td>
              <td align="center"><font color="white">所属对象</font></td>
              <td align="center"><font color="white">数据类型</font></td>
              <td align="center"><font color="white">模型特性</font></td>
            </tr>
            <tr onClick="showData();" >
              <td><input type="checkbox"></td>
              <td>1</td>
              <td>仿真</td>
              <td>2015-11-14</td>
              <td>admin</td>
              <td>039</td>
              <td>仿真</td>
              <td>噪声</td>
            </tr>
            <tr onClick="showData();">
              <td><input type="checkbox"></td>
              <td>1</td>
              <td>仿真</td>
              <td>2015-11-14</td>
              <td>admin</td>
              <td>039</td>
              <td>仿真</td>
              <td>噪声</td>
            </tr>
            <tr onClick="showData();">
             <td><input type="checkbox"></td>
              <td>1</td>
              <td>仿真</td>
              <td>2015-11-14</td>
              <td>admin</td>
              <td>039</td>
              <td>仿真</td>
              <td>噪声</td>
            </tr>
            <tr onClick="showData();">
              <td><input type="checkbox"></td>
              <td>1</td>
              <td>仿真</td>
              <td>2015-11-14</td>
              <td>admin</td>
              <td>039</td>
              <td>仿真</td>
              <td>噪声</td>
            </tr>
          </table> 
        </div>
        <div class="pagination">
          <ul>
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li ><a href="#">2</a></li>
            <li ><a href="#">3</a></li>
            <li ><a href="#">4</a></li>
            <li ><a href="#">5</a></li>
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