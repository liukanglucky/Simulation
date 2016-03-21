/**
 *  show data
 */
function showData(data1,data2,data3,text) {
	var input = "吨位：4000.00，吃水：6.00 ，航速：18.00，输出频率：100-1000，采样率：20.00 ，增益：80.00<br>\
        灵敏度：－200.00，阵元：48.00，总声级：166.00 ,轴频：1.80，螺旋桨数：5.00\
        ";
	var output = "调制谱轴频频率：1.00，频带内总声级：168.00，螺旋桨叶片数：0.00";

	$("#input").html(input);
	$("#output").html(output);

	$(".chart").css("display", "");

	// 使用
	require([ 'echarts', 'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('main'));
		var myChart2 = ec.init(document.getElementById('main2'));
		var myChart3 = ec.init(document.getElementById('main3'));

		var xdata = new Array(100);

		for (var i = 0; i < 500; i++) {
			xdata[i] = i;
		}

		var option = {

			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '回波频率谱' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			grid : {
				borderColor : '#cccccc',
				borderWidth : 0,
				backgroundColor : '#000',

			},
			xAxis : [

			{
				type : 'category',
				show : false,
				boundaryGap : false,
				data : xdata,
				splitLine : {
					show : false
				},
			} ],
			yAxis : [ {
				type : 'value',
				show : false,
				axisLabel : {
					formatter : ''
				},
				splitLine : {
					show : false
				},
			} ],
			series : [ {
				name : '回波频率谱',
				type : 'line',
				stack : '总量',
				symbol : 'none',

				itemStyle : {
					normal : {

						lineStyle : {
							width : 1,
							color : '#00cd00',
						},

					}
				},
				data : data1
			} ]
		};

		var option2 = {
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '目标强度方位变化' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			grid : {
				backgroundColor : '#000',
				borderColor : '#cccccc',
				borderWidth : 0
			},
			xAxis : [ {
				type : 'category',
				show : false,
				boundaryGap : false,
				data : xdata,
				splitLine : {
					show : false
				},
			} ],
			yAxis : [ {
				type : 'value',
				show : false,
				splitLine : {
					show : false
				},
			} ],
			series : [ {
				name : '目标强度方位变化',
				type : 'line',
				stack : '总量',
				symbol : 'none',
				itemStyle : {
					normal : {
						lineStyle : {
							width : 1,
							color : '#00cd00',
						}
					}
				},
				data : data2
			} ]
		};

		var option3 = {
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '回波信号' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			grid : {
				borderColor : '#cccccc',
				borderWidth : 0,
				backgroundColor : '#000',

			},
			xAxis : [ {
				type : 'category',
				show : false,
				boundaryGap : false,
				data : xdata,
				splitLine : {
					show : false
				},
			} ],
			yAxis : [ {
				type : 'value',
				show : false,
				splitLine : {
					show : false
				},
			} ],
			series : [ {
				name : '回波信号',
				type : 'line',
				stack : '总量',
				symbol : 'none',
				itemStyle : {
					normal : {
						lineStyle : {
							width : 1,
							color : '#00cd00',
						}
					}
				},
				data : data3
			} ]
		};

		// 为echarts对象加载数据
		myChart.setOption(option);
		myChart2.setOption(option2);
		myChart3.setOption(option3);
	});
}


/**
* 调用仿真模型接受返回值
**/
function run(id, dataid){
	var dom = $("#" + id + " input:text");

	var result = "";

	for (var i = 0; i < dom.size(); i++) {

		result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
	}

	dom = $("#" + id + " select");

	for (var i = 0; i < dom.size(); i++) {
		result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
	}
	
	alert(result);
	
	$.ajax({
		url : "input/run.do",
		type : "post",
		dataType : "text",
		data : {
			"data" : result,
			"id" : dataid,
		},
		success : function(data) {
			if(data.indexOf("Exec_error") >0){
				alert(data);
			}else{
				data = eval(data);
				
				var line1 = new Array();
				var line2 = new Array();
				var line3 = new Array();
				
				//model1-2 绘制三条曲线
				if(dataid == "1" || dataid == "2"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						if(temp[0] == 1)	line1 = temp[1].split("_");
						if(temp[0] == 2)	line2 = temp[1].split("_");
						if(temp[0] == 3)	line3 = temp[1].split("_");
					}
					showData(line1,line2,line3,"");
					return;
				}
				//model3-6 三条曲线 加输出参数
				if(dataid == "3A" || dataid == "3B" || dataid == "5A"|| dataid == "5B"){
					
				}
				//model7
				if(dataid == "7"){
					alert("暂未完成");
				}
				//model8
				if(dataid == "8"){
					alert("暂未完成");
				}
				
				
			}
			
		},
		error : function(err) {
			alert("调用仿真模型失败");
		}
	});
}