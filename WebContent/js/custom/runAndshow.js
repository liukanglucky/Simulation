//返回结果全局变量
out1 = "";
out2 = "";
out3 = "";
para = "";
/**
 *  show data
 */
function showData(data1,data2,data3,text,text2) {
	var input = text2;
	var output = text;
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
	
	//alert(result);
	$('#myModal').modal("show");
	$("#input").html("");
	$("#output").html("");
	$("#main").html("");
	$("#main2").html("");
	$("#main3").html("");
	
	$.ajax({
		url : "input/run.do",
		type : "post",
		dataType : "text",
		data : {
			"data" : result,
			"id" : dataid,
		},
		success : function(data) {
			$('#myModal').modal("hide");
			if(data.indexOf("Exec_error") >0){
				alert(data);
			}else{
				data = eval(data);
				
				var line1 = new Array();
				var line2 = new Array();
				var line3 = new Array();
				var text = "";
				
				//model1-2 绘制三条曲线
				if(dataid == "1" || dataid == "2"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						if(temp[0] == 1)	line1 = temp[1].split("_");
						if(temp[0] == 2)	line2 = temp[1].split("_");
						if(temp[0] == 3)	line3 = temp[1].split("_");
					}
					showData(line1,line2,line3,"","");
					initResult(line1,line2,line3,"");
					return;
				}
				//model3-6 三条曲线 加输出参数
				if(dataid == "3A" || dataid == "3B" || dataid == "5A"|| dataid == "5B"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						if(temp[0] == 1)	line1 = temp[1].split("_");
						if(temp[0] == 2)	line2 = temp[1].split("_");
						if(temp[0] == 3)	line3 = temp[1].split("_");
						if(temp[0] == 4) 	text = temp[1];
					}
					showData(line1,line2,line3,text,"");
					return;
				}
				//model7
				if(dataid == "7"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						var temp3 = temp[1].split("_");
						text = "噪声信号频率上限:"+temp3[0]+","+"噪声信号频率下限:"+temp3[1];
						if(temp[0] == 1){
							var temp2 = temp[1].split("|");
							if(temp2.length != 2){ alert("返回数据格式错误");return;}
							line1 = temp2[1].split("_");
						}	
					}
					showData(line1,line2,line3,text,"");
					return;
				}
				//model8
				if(dataid == "8"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						
						var temp2 = temp[1].split("|");
						if(temp2.length != 2){ alert("返回数据格式错误");return;}
						line1 = temp2[1].split("_");
						
					}
					showData(line1,line2,line3,text,"");
					return;
				}
				
				
			}
			
		},
		error : function(err) {
			$('#myModal').modal("hide");
			alert("调用仿真模型失败");
		}
	});
}

//结构化返回值
function initResult(line1,line2,line3,para){
	for(var i=0; i < line1.length; i++){
		if(len(line1[i])==0)
			out1 = out1+"000";
		if(len(line1[i])==1)
			out1 = out1+"00"+line1[i];
		if(len(line1[i])==2)
			out1 = out1+"0"+line1[i];
		if(len(line1[i])==0)
			out1 = out1+line1[i];
	}
	for(var i=0; i < line2.length; i++){
		if(len(line2[i])==0)
			out2 = out2+"000";
		if(len(line2[i])==1)
			out2 = out2+"00"+line2[i];
		if(len(line2[i])==2)
			out1 = out1+"0"+line2[i];
		if(len(line2[i])==0)
			out1 = out1+line2[i];
	}
	for(var i=0; i < line3.length; i++){
		if(len(line3[i])==0)
			out3 = out3+"000";
		if(len(line3[i])==1)
			out3 = out3+"00"+line3[i];
		if(len(line1[i])==2)
			out3 = out1+"0"+line3[i];
		if(len(line1[i])==0)
			out3 = out3+line3[i];
	}
	para = $("#output").html();
}