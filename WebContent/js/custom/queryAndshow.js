function showData(data1,data2,data3,text1,text2) {
	var input = text1;
	var output = text2;
	$("#input").html(input);
	$("#output").html(output);

	$(".chart").css("display", "");

	// 使用
	require([ 'echarts', 'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('main1'));
		var myChart2 = ec.init(document.getElementById('main2'));
		var myChart3 = ec.init(document.getElementById('main3'));

		var xdata = new Array(1000);

		for (var i = 0; i < 1000; i++) {
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
