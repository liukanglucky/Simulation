var decToHex = function(str) {
	var res = [];
	for (var i = 0; i < str.length; i++)
		res[i] = ("00" + str.charCodeAt(i).toString(16)).slice(-4);
	return "\\u" + res.join("\\u");
}
var hexToDec = function(str) {
	str = str.replace(/\\/g, "%");
	return unescape(str);
}

//ajax获得object,自动填充
function getObj(id, fileid, tabname) {
	$.ajax({
		url : "input/defaultData.do",
		type : "post",
		dataType : "text",
		data : {
			"id" : id,
			"fileid" : fileid
		},
		success : function(data) {
			data = hexToDec(data);
			data = eval('(' + data + ')');
			defaultVal(tabname, data);
		},
		error : function(err) {
			alert("未能读取默认参数");
		}
	});
}

//自动填充页面元素
function defaultVal(id, data) {
	for ( var key in data) {
		var dom = $("#" + id + " input[name='" + key + "']");

		if (dom.size() <= 1) {
			var val = data[key];
			dom.val(val);
		} else {

			var valArray = data[key].split(",");

			if (valArray.length == dom.size() + 1) {
				for (var i = 0; i < dom.size(); i++) {
					//alert(dom[i]);
					dom[i].value = valArray[i];
				}
			}

		}

		dom = $("#" + id + " select[name='" + key + "']");

		if (dom.size() == 0)
			continue;

		if (dom.size() <= 1 && dom.size() > 0) {
			var val = data[key];
			dom.find("option[value='" + val + "']").attr("selected", true);
		} else {
			if (data[key].length > 0) {
				var valArray = data[key].split(",");

				if (valArray.length == dom.size() + 1) {
					for (var i = 0; i < dom.size(); i++) {
						//alert(valArray[i]);
						//alert($(dom[i]).find("option[value='"+valArray[i]+"']").size());
						$(dom[i]).find("option[value='" + valArray[i] + "']")
								.attr("selected", true);
					}
				}
			}

		}

	}

	//$("#form-tab2 input[name='speed1']")[0].val('1');	
}

//自动获得页面元素数值，形成map,保存输入数据
function autoGetVal(id, dataid, fileid) {
	//alert(id+dataid);
	var dom = $("#" + id + " input:text");

	var result = "";

	for (var i = 0; i < dom.size(); i++) {

		result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
	}

	dom = $("#" + id + " select");

	for (var i = 0; i < dom.size(); i++) {
		result += $(dom[i]).attr("name") + ":" + $(dom[i]).val() + ",";
		//alert($(dom[i]).val());
	}
	//alert(result);
	$.ajax({
		url : "input/saveData.do",
		type : "post",
		dataType : "text",
		data : {
			"data" : result,
			"id" : dataid,
			"fileid" : fileid
		},
		success : function(data) {
			alert(data);
		},
		error : function(err) {
			alert("保存失败");
		}
	});

}

//更改仿真类型
function changeType() {
	var val = $("#simType").val();

	var nowActive = $("#myTab .active").attr("class", "");

	$("#tabContent").slideUp();

}

function tabgo1() {
	$("#tabContent").slideDown();
	var id = "";
	var fileid = "";
	var tabname = "";
	if ($("#simType").val() == 0) {
		$('#tab-1').attr('href', '#tab1');
		$('#myTab a[href="#tab1"]').tab('show');
		id = "1";
		fileid = "1";
		tabname = "tab1";
	}
	if ($("#simType").val() == 1) {
		$('#tab-1').attr('href', '#tab1B');
		$('#myTab a[href="#tab1B"]').tab('show');
		id = "1";
		fileid = "1B";
		tabname = "tab1B";
	}

	getObj(id, fileid, tabname);

}

function tabgo2() {
	$("#tabContent").slideDown();
	$('#tab-2').attr('href', '#tab2');
	$('#myTab a[href="#tab2"]').tab('show');
	getObj("2", "2", "tab2");

}

function tabgo3() {
	$("#tabContent").slideDown();
	var id = "";
	var fileid = "";
	var tabname = "";
	if ($("#simType").val() == 0) {
		$('#tab-3').attr('href', '#tab3A');
		$('#myTab a[href="#tab3A"]').tab('show');
		id = "3A";
		fileid = "3A";
		tabname = "tab3A";
	}
	if ($("#simType").val() == 1) {
		$('#tab-3').attr('href', '#tab3B');
		$('#myTab a[href="#tab3B"]').tab('show');
		id = "3B";
		fileid = "3B";
		tabname = "tab3B";
	}
	
	getObj(id, fileid, tabname);
}
function tabgo4() {
	$("#tabContent").slideDown();
	var id = "";
	var fileid = "";
	var tabname = "";
	if ($("#simType").val() == 0) {
		$('#tab-4').attr('href', '#tab4A');
		$('#myTab a[href="#tab4A"]').tab('show');
		id = "3A";
		fileid = "4A";
		tabname = "tab4A";
	}
	if ($("#simType").val() == 1) {
		$('#tab-4').attr('href', '#tab4B');
		$('#myTab a[href="#tab4B"]').tab('show');
		id = "3B";
		fileid = "4B";
		tabname = "tab4B";
	}
	
	getObj(id, fileid, tabname);
}
function tabgo5() {
	$("#tabContent").slideDown();
	var id = "";
	var fileid = "";
	var tabname = "";
	if ($("#simType").val() == 0) {
		$('#tab-5').attr('href', '#tab5A');
		$('#myTab a[href="#tab5A"]').tab('show');
		id = "5A";
		fileid = "5A";
		tabname = "tab5A"
	}
	if ($("#simType").val() == 1) {
		$('#tab-5').attr('href', '#tab5B');
		$('#myTab a[href="#tab5B"]').tab('show');
		id = "5B";
		fileid = "5B";
		tabname = "tab5B"
	}
	getObj(id, fileid, tabname);
}
function tabgo6() {
	$("#tabContent").slideDown();
	var id = "";
	var fileid = "";
	var tabname = "";
	if ($("#simType").val() == 0) {
		$('#tab-6').attr('href', '#tab6A');
		$('#myTab a[href="#tab6A"]').tab('show');
		id = "5A";
		fileid = "6A";
		tabname = "tab6A"
	}
	if ($("#simType").val() == 1) {
		$('#tab-6').attr('href', '#tab6B');
		$('#myTab a[href="#tab6B"]').tab('show');
		id = "5B";
		fileid = "6B";
		tabname = "tab6B"
	}
	getObj(id, fileid, tabname);
}

function tabgo7() {
	$("#tabContent").slideDown();
	$('#tab-7').attr('href', '#tab7');
	$('#myTab a[href="#tab7"]').tab('show');
	getObj("7", "7", "tab7");

}

function tabgo8() {
	$("#tabContent").slideDown();
	$('#tab-8').attr('href', '#tab8');
	$('#myTab a[href="#tab8"]').tab('show');
	getObj("8", "8", "tab8");

}