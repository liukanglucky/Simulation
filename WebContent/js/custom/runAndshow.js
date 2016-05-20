//返回结果全局变量
//格式为001002003...
out1 = "";
out2 = "";
out3 = "";
out4 = "";
para = "";
/**
 *  show data
 */
function showData(data1,data2,data3,data4,text,text2,dataid,modelid) {
	
	var input = text2;
	var output = text;
	$("#input").html(input);

	if(dataid == "3A" || dataid == "3B" || dataid == "5A"|| dataid == "5B"){
		output = model3output(text);
	}
	
	$("#output").html(output);

//	$(".chart").css("display", "");
//	
//	$("#main").html("");
//	$("#main2").html("");
//	$("#main3").html("");


	// 使用
	require([ 'echarts', 'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('main'));
		var myChart2 = ec.init(document.getElementById('main2'));
		var myChart3 = ec.init(document.getElementById('main3'));
		var myChart4 = "";
		
		if(dataid == "1" || dataid == "2"){
			$("#main4").remove();
			var temphtml = '<div id="main4" style="height:200px;" class="chart"></div>';
			$("#main3").after(temphtml);
			$("#main4").html("");
			myChart4 = ec.init(document.getElementById('main4'));
			
		}
		
		

		var xdata = new Array(100);
		var xdata1 = new Array(100);
		var xdata2 = new Array(100);
		var xdata3 = new Array(100);
		var xdata4 = new Array(100);

		if(modelid == "1B" || dataid == "2"){
			
			for (var i = 0; i < data1.length; i++) {
				xdata1[i] = i;
			}
			for (var i = 0; i < data2.length; i++) {
				xdata2[i] = i;
			}
			for (var i = 0; i <360; i++) {
				xdata3[i] = i;
			}
			for (var i = 0; i < data4.length; i++) {
				xdata4[i] = i;
			}
		}else {
			
			for (var i = 0; i < data1.length; i++) {
				xdata1[i] = i;
			}
			for (var i = 0; i < data2.length; i++) {
				xdata2[i] = i;
			}
			for (var i = 0; i < data3.length; i++) {
				xdata3[i] = i;
			}
			for (var i = 0; i < data4.length; i++) {
				xdata4[i] = i;
			}
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
				data : xdata1,
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
				data : xdata2,
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
				data : xdata3,
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
		
		var option4 = {
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
					data : xdata4,
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
					data : data4
				} ]
			};
		
		
		// 为echarts对象加载数据
		myChart.setOption(option);
		myChart2.setOption(option2);
		myChart3.setOption(option3);
		myChart4.setOption(option4);
	});
}


/**
* 调用仿真模型接受返回值
**/
function run(id, dataid,modelid){
	var dom = $("#" + id + " input:text");

	var simType=$("#simType").val();//zjh改，方便模型七八传值
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
//	$("#input").html("");
//	$("#output").html("");
//	$("#main").html("");
//	$("#main2").html("");
//	$("#main3").html("");
	
	

	
	$.ajax({
		url : "input/run.do",
		type : "post",
		dataType : "text",
		data : {
			"data" : result,
			"id" : dataid,
			"modelId": modelid,
			"simType":simType
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
				var line4 = new Array();
				var text = "";
				
				//model1-2 绘制四条曲线
				if(dataid == "1" || dataid == "2"){
					for(var i=0; i < data.length; i++){
						var temp = data[i].split(",");
						if(temp.length != 2){ alert("返回数据格式错误");return;}
						if(temp[0] == 1)	line1 = temp[1].split("_");
						if(temp[0] == 2)	line2 = temp[1].split("_");
						if(temp[0] == 3)	line3 = temp[1].split("_");
						if(temp[0] == 4)	line4 = temp[1].split("_");
						//alert(temp[0]);
					}
					initResult(line1,line2,line3,line4,"");
				
					showData(line1,line2,line3,line4,"","",dataid,modelid);
					returnObject(result,dataid);
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
					initResult(line1,line2,line3,"",text);
					showData(line1,line2,line3,"",text,"",dataid,modelid);
					returnObject(result,dataid);
					return;
				}
				//model7
				if(dataid == "7"){
					if(simType=="1"){
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
						initResult(line1,"","","",text);
						showData(line1,line2,line3,line4,text,"",dataid,modelid);
						returnObject(result,dataid);
						return;
					}else{
						for(var i=0; i < data.length; i++){
							//zjh, 解析出来的文件名里头有逗号所以把数据格式错误那注释掉了
							var temp = data[i].split("|");
							line1 = temp[1].split("_");
						//	if(temp.length != 2){ alert("返回数据格式错误");return;}
							
						//	var temp2 = temp[1].split("|");
						//	if(temp2.length != 2){ alert("返回数据格式错误");return;}
						//	line1 = temp2[1].split("_");
						}
						initResult(line1,"","","",text);
						showData(line1,line2,line3,line4,text,"",dataid,modelid);
						returnObject(result,dataid);
						return;
					}
					
				}
				//model8
				if(dataid == "8"){
					for(var i=0; i < data.length; i++){
						//zjh, 解析出来的文件名里头有逗号所以把数据格式错误那注释掉了
						var temp = data[i].split("|");
						line1 = temp[1].split("_");
					//	if(temp.length != 2){ alert("返回数据格式错误");return;}
						
					//	var temp2 = temp[1].split("|");
					//	if(temp2.length != 2){ alert("返回数据格式错误");return;}
					//	line1 = temp2[1].split("_");
					}
					initResult(line1,"","","",text);
					showData(line1,line2,line3,line4,text,"",dataid,modelid);
					returnObject(result,dataid);
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

//返回实体类并显示
function returnObject(result,dataid){
	//获得当前的实体类
//	alert("获得当前的实体类"+result+"******"+dataid);
	$.ajax({
		url : "input/getObjct.do",
		type : "post",
		dataType : "json",
		data : {
			"data" : result,
			"id" : dataid,
		},
		success : function(data1) {
//			alert(data1);
			
			var  data = eval(data1);
			//str转jsonObject
//			var data = JSON.parse(data1);
//			//显示在页面
//			alert(Object.prototype.toString.call(obj));
			var input ="";
			//alert(dataid);
			switch(dataid){
				case 1:
					input="航速："+data.speed+"，航向："+data.ang+"，中心频率："+data.fre+"，带宽："+data.bre+"，脉宽："+data.cre+"，目标距离："+data.distence+"，<br>"+
					"俯仰角："+data.ang1+"，水平角："+data.ang2+"，周期时间窗口："+data.time+"，采样频率："+data.cy1+"，发射声源级："+data.ss+"，发射波束开角："+data.ang3+"<br>"+
					"接收发射波束开角："+data.ang4+"，包络：";
					switch(data.type2){
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
					switch(data.type3){
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
					break;
				case 2:
					input="纵波声速："+data.speed1+"，横波声速："+data.speed2+"，介质密度："+data.jz+"，纵波衰减："+data.d1+"，横波衰减："+data.d2+"，平均散射："+data.num1+"，<br>"+
					"谱强度："+data.pu1+"，谱系数："+data.pu2+"，风速：("+data.wind+")，海流速度：("+data.fspeed+")，海深："+data.depth+"，<br>"+
					"声速："+data.speed3+"，衰减系数："+data.d3+"，海面谱系数："+data.pu3+"，谱系数："+data.pu4+"，平均散射："+data.num2+"，发射水平角："+data.ang1+"，<br>"+
					"垂直角："+data.ang2+"，方位角："+data.ang3+"，俯仰角："+data.ang4+"，声源级："+data.ss+"，位置：("+data.loc+")速度：("+data.speed+")，<br>"+
					"阵元："+data.num+"，灵敏度："+data.lm1+"，采样率："+data.cy1+"，中心频率："+data.fre1+"，带宽："+data.dk1+"，脉宽："+data.mk1;
					break;
				case '3A':
				case '4A':
				case '5A':
				case '6A':
					 input ="吨位："+data.weight+"，吃水："+data.depth+" ，航速："+data.speed+"，输出频率："+data.fre1+"，采样率："+data.cy1+" ，增益："+data.zy1+"<br>";
					 	input +="灵敏度："+data.lm1+"，阵元："+data.num+"，模拟采样率："+data.ss+" ,带通：("+data.fre2+")，起始时刻："+data.time1+"，总长度："+data.time2+"<br>";
					 	input +="模拟增益："+data.zy2+"，"+"模拟灵敏度："+data.lm2;
					 	break;
				case '3B':
				case '4B':	
				case '5B':
				case '6B':
					input ="吨位："+data.weight+"，吃水："+data.depth+" ，航速："+data.speed+"，输出频率："+data.fre1+"，采样率："+data.cy1+" ，增益："+data.zy1+"<br>";
					input +="灵敏度："+data.lm1+"，阵元："+data.num1+"，对应谱级："+data.ss+" ,轴频："+data.fre2+"，螺旋桨数："+data.num2+"<br>";
					break;
				case '7':
					input ="海面风速："+data.wspeed+"，"+"海流速度："+data.fspeed+"，"+"降雨量："+data.rain+"，"+"长度："+data.len+"，"+"中心频率："+data.fre+"<br>";
					input+="海况："+data.seacon+"，"+"每平方米舰船数："+data.num1+"，"+"螺旋桨末端转速："+data.sspeed;
					
					break;
				case '8':
					input ="海底地貌：";
					switch(data.type1){
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
					switch(data.type3){
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
					switch(data.type4){
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
					switch(data.type5){
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
					switch(data.type6){
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
					input +="，海深个数："+data.num1+"，"+"射线数量："+data.num2+"<br>";
					input +="中心频率："+data.fre+"，"+"海流速度："+data.wspeed+"，"+"海面反射系数："+data.ss1+"，"+"海底衰减系数："+data.ss2+"，"+"输出距离步长："+data.len1+"，"+"收发间距："+data.len3+"<br>";
					input +="发射指向性："+data.ss3+"，"+"发射声源级："+data.sn+"，"+"接收深度："+data.dep+"，"+"工作频段："+data.frew+"，"+"海面风速："+data.wspeed;
					
					break;
				default:
					input ="参数错误！";
					
			}
			$("#input").html(input);
		},
		
		error : function(){
			alert("获取实体类失败");
		}
		
	});
	//获得当前的实体类结束
}

//结构化返回值
function initResult(line1,line2,line3,line4,text){
	out1="";
	out2="";
	out3="";
	out4="";
	for(var i=0; i < line1.length; i++){
		if(len(line1[i])==0)
			out1 = out1+"000";
		if(len(line1[i])==1)
			out1 = out1+"00"+line1[i];
		if(len(line1[i])==2)
			out1 = out1+"0"+line1[i];
		if(len(line1[i])==3)
			out1 = out1+line1[i];
	}
	for(var i=0; i < line2.length; i++){
		if(len(line2[i])==0)
			out2 = out2+"000";
		if(len(line2[i])==1)
			out2 = out2+"00"+line2[i];
		if(len(line2[i])==2)
			out2 = out2+"0"+line2[i];
		if(len(line2[i])==3)
			out2 = out2+line2[i];
	}
	for(var i=0; i < line3.length; i++){
		if(len(line3[i])==0)
			out3 = out3+"000";
		if(len(line3[i])==1)
			out3 = out3+"00"+line3[i];
		if(len(line1[i])==2)
			out3 = out3+"0"+line3[i];
		if(len(line1[i])==3)
			out3 = out3+line3[i];
	}
	for(var i=0; i < line4.length; i++){
		if(len(line4[i])==0)
			out4 = out4+"000";
		if(len(line4[i])==1)
			out4 = out4+"00"+line4[i];
		if(len(line1[i])==2)
			out4 = out1+"0"+line3[i];
		if(len(line1[i])==3)
			out4 = out4+line3[i];
	}
	para = text;
}

//显示模型3——6输出参数
function model3output(text){
	var result = "";
	var textArray = text.split("_");
	var i = 0;
	if(textArray.length != 64) return;
	result = "线谱频率：";
	for(i = 0;i<20;i++){
		if((i+1)%10 == 0)	result += "<br>";
		result+=textArray[i]+",";
	}
	result += "<br>线谱强度：";
	for(i = 20;i<40;i++){
		if((i+1)%10 == 0)	result += "<br>";
		result+=textArray[i]+",";
	}
	result += "<br>调制深度：";
	for(i = 40;i<60;i++){
		if((i+1)%10 == 0)	result += "<br>";
		result+=textArray[i]+",";
	}
	result += "<br>调制谱轴频频率:"+textArray[60]+",频带内总声级:"+textArray[61]+",螺旋桨叶片数:"+textArray[62]+",仿真类型:";
	
	if(textArray[63] == "1") result+="模拟仿真";
	if(textArray[63] == "2") result+="分析数据";
	return result;
}

//自动获得页面元素数值，形成map,保存输入数据
function autoGetVal(id, dataid, fileid) {
	var dom = $("#" + id + " input:text");

	var result = "";
	var simType = $("#simType").val();
	//模拟仿真s1 = 2 type1 = 1 页面 ＝ 1;分析数据 s1 = 1 type1 = 2 页面 ＝ 0
	if(simType == "1" && dataid != "8"){
		result += "type1:1,s1:2,";
	}
	if(simType == "0"&& dataid != "8"){
		result += "type1:2,s1:1,";
	}
	
	//model1 有 file1 和 file2
	if(dataid == "1"){
		var file1 = $.trim($("#file").val().replace(/,/g,'')) ;
//		alert("#tab"+fileid+"file2");
//		alert($("#tab"+fileid+"file2").val());
		
		var file2 = $.trim($("#tab"+fileid+"file2").val().replace(/,/g,''));
		result = result + "file1:"+file1+",";
		result = result + "len1:"+len(file1)+",";
		result = result + "file2:"+file2+",";
		result = result + "len2:"+len(file2)+",";
		result = result + "dbspeed:"+$("#tab"+fileid+"dbspeed").val()+",";
		
	}else{
		//model 8 有三个文件
		if(dataid == "8"){
			var name1 = $.trim($("#name1").val().replace(/,/g,'')) ;
			var name2 = $.trim($("#name2").val().replace(/,/g,'')) ;
			var name3 = $.trim($("#name3").val().replace(/,/g,'')) ;
			result = result + "name1:"+name1+",";
			//alert(len(name1));
			result  = result + "namelen1:"+len(name1.replace(/,/g,''))+",";
			result = result + "name2:"+name2+",";
			result  = result + "namelen2:"+len(name2.replace(/,/g,''))+",";
			result = result + "name3:"+name3+",";
			result  = result + "namelen3:"+len(name3.replace(/,/g,''))+",";
			
		}
		
		if(dataid == "7"){
			var file1 = $.trim($("#file").val().replace(/,/g,'')) ;
			result = result + "file1:"+file1+",";
			result = result + "len1:"+len(file1)+",";
		}
		
		var file = $.trim($("#file").val().replace(/,/g,''));
		result+="file:"+file+",";
		result+="len:"+len(file)+",";
	}
	
	for (var i = 0; i < dom.size(); i++) {
		if($(dom[i]).attr("name") != "file2")
			result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
	}

	dom = $("#" + id + " select");

	for (var i = 0; i < dom.size(); i++) {
		result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
		//alert($(dom[i]).val());
	}
	
	alert(result);
	$.ajax({
		url : "input/saveData.do",
		type : "post",
		dataType : "text",
		data : {
			"data" : result,
			"id" : dataid,
			"fileid" : fileid,
			"output1" : out1,
			"output2" : out2,
			"output3" : out3,
			"output4" : out4,
			"para" : para,
		},
		success : function(data) {
			alert("保存成功");
		},
		error : function(err) {
			alert("保存失败");
		}
	});

}