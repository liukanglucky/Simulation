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
	//alert("dataid is "+id +" fileid is "+fileid);
	getMt();
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
			//alert(data);
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
		
		if(key == "file" || key=="file1"){
			$("#file").val(data[key].replace(/,/g,''));
			continue;
		}
		if(key=="file2"){
			//alert("#"+id+"file2");
			$("#"+id+"file2").val(data[key].replace(/,/g,''));
			//alert(""+data[key].replace(/,/g,'')+"");
			continue;
		}
		//model8 use start
		if(key == "name1"){
			$("#name1").val(data[key].replace(/,/g,''));
			continue;
		}
		
		if(key == "name2"){
			$("#name2").val(data[key].replace(/,/g,''));
			continue;
		}
		
		if(key == "name3"){
			$("#name3").val(data[key].replace(/,/g,''));
			continue;
		}
		//model8 use end
		
		var dom = $("#" + id + " input[name='" + key + "']");

		if (dom.size() <= 1) {
			var val = data[key];
			dom.val(val);
		} else {
			
			var valArray = data[key].split(",");

			if (valArray.length == dom.size() + 1 || key == "speed") {
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
	
	if ($("#simType").val() == 1) {
		$("#tab2save").attr("onClick","autoGetVal('tab2','2','2B');");
		getObj("2", "2B", "tab2");
	}
	if ($("#simType").val() == 0) {
		$("#tab2save").attr("onClick","autoGetVal('tab2','2','2A');");
		getObj("2", "2A", "tab2");
	}
	$('#myTab a[href="#tab2"]').tab('show');
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
	
	//仿真
	if ($("#simType").val() == 1) {
		$("#tab8file1").html('<td>海深文件</td><td colspan="5"><input type="file" id="name1file" onChange="getFile(\'1\');"><input type="text" name="name1" id="name1"></td>');
		$("#tab8file2").html('<td>海底底质</td><td colspan="5"><input type="file" id="name2file" onChange="getFile(\'2\');"><input type="text" name="name2" id="name2"></td>');
		$("#tab8file3").html('<td>剖面文件</td><td colspan="5"><input type="file" id="name3file" onChange="getFile(\'3\');"><input type="text" name="name3" id="name3"></td>');
	
		$("#tab8save").attr("onClick","autoGetVal('tab8','8','8B');");
		$('#myTab a[href="#tab8"]').tab('show');
		getObj("8", "8B", "tab8");
	}
	
	//分析
	if ($("#simType").val() == 0) {
		$("#tab8file1").html('<td>实测文件</td><td colspan="5"><input type="file" id="name1file" onChange="getFile(\'1\');"><input type="text" name="name1" id="name1"></td>');
		$("#tab8file2").html('<td>样本文件</td><td colspan="5"><input type="file" id="name2file" onChange="getFile(\'2\');"><input type="text" name="name2" id="name2"></td>');
		$("#tab8file3").html('');
		
		$("#tab8save").attr("onClick","autoGetVal('tab8','8','8A');");
		$('#myTab a[href="#tab8"]').tab('show');
		getObj("8", "8A", "tab8");
	}
	
	

}

function len(s) { 
	var l = 0; 
	var a = s.split(""); 
	for (var i=0;i<a.length;i++) { 
		if (a[i].charCodeAt(0)<299) { 
			l++; 
		} else { 
			l+=2; 
		} 
	} 
	return l; 
}

function getMt(){
	$.ajax({
		url : "loadMt.do",
		type : "post",
		dataType : "text",
		success : function(data) {
			//data = hexToDec(data);
			data = eval('(' + data + ')');
			data = eval(data);
			var html = '<option value="0"></option>';
			for(var d in data){
				var o = data[d];
				var temp = '<option value="'+o['index']+'">'+o['name']+'</option>';
				html+=temp;
			}
			$("select[name='simname']").html(html);
			//alert(html);
		},
		error : function(err) {
			alert("未能读取默认参数");
		}
	});
}

function getFile(id){
	//规定file选择框的名称比对应text的名称多后面多“file”
	if(id="1"){
		$("#name1").val($("#name1file").val().split("\\").pop());
	}
	if(id="2"){
		$("#name2").val($("#name2file").val().split("\\").pop());
	}
	if(id="3"){
		if($("#name3file").val() != "" && $("#name3file").val() != null)
		$("#name3").val($("#name3file").val().split("\\").pop());
	}
}

function calFile(){
	$("#file").val($("#calfile").val().split("\\").pop());
}

function tab1File(){
	$("#tab1file2").val($("#tab1getfile").val().split("\\").pop());
}

function tab1BFile(){
	$("#tab1Bfile2").val($("#tab1Bgetfile").val().split("\\").pop());
}