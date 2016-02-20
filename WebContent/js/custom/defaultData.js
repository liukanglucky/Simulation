var decToHex = function(str) {
			    var res=[];
			    for(var i=0;i < str.length;i++)
			        res[i]=("00"+str.charCodeAt(i).toString(16)).slice(-4);
			    return "\\u"+res.join("\\u");
			}
			var hexToDec = function(str) {
			    str=str.replace(/\\/g,"%");
			    return unescape(str);
			}
			
			
			//自动填充页面元素
			function defaultVal(id,data){
				for(var key in data){
	        		var dom = $("#"+id+" input[name='"+key+"']");
	        		
	        		
	        		
        			if(dom.size() <= 1 ){
	        			var val = data[key];
	            		dom.val(val);
	        		}else{
	        			
	        			var valArray = data[key].split(",");
	        			
	        			if(valArray.length == dom.size()+1){
	        				for(var i = 0;i<dom.size();i++){
	        					//alert(dom[i]);
	        					dom[i].value = valArray[i];
	        				}
	        			}
	 
	        		}
	        			
        			dom = $("#"+id+" select[name='"+key+"']");
        			
        			if(dom.size() == 0)
        				continue;
        			
        			
        			if(dom.size() <= 1 && dom.size()>0){
	        			var val = data[key];
	        			dom.find("option[value='"+val+"']").attr("selected",true);
        			}else{
	        			if(data[key].length > 0){
	        				var valArray = data[key].split(",");

	        				if(valArray.length == dom.size()+1){
		        				for(var i = 0;i<dom.size();i++){
		        					//alert(valArray[i]);
		        					//alert($(dom[i]).find("option[value='"+valArray[i]+"']").size());
		        					$(dom[i]).find("option[value='"+valArray[i]+"']").attr("selected",true);
		        				}
		        			}
	        			}
	        			
	        		}
	        			
	        		
	        	}
	  
	        	//$("#form-tab2 input[name='speed1']")[0].val('1');	
			}
        	
			
			//自动获得页面元素数值，形成map,保存输入数据
			function autoGetVal(id,dataid){
				//alert(id+dataid);
				var dom = $("#"+id+" input:text");
				
				var result = "";
				
				for(var i = 0;i<dom.size();i++){
					
					result+=$(dom[i]).attr("name")+":"+$(dom[i]).val()+",";
				}
				
				
				dom = $("#"+id+" select");
				
				for(var i = 0;i<dom.size();i++){
					result+=$(dom[i]).attr("name")+":"+$(dom[i]).val()+",";
				}
				
				//alert(result);
				
				$.ajax({
	        		url:"input/saveData.do",
	        		type: "post",
	                dataType: "text",
	                data:{"data":result,"id":dataid},
	                success: function(data) {
	                	alert(data);
	                },
	                error: function(err) {
	                	alert("保存失败");
	                }
	        	}); 
				
			}
			
			//更改仿真类型
			function changeType(){
				var val = $("#simType").val();
				
				var nowActive = $("#myTab .active").attr("class","");
				
				$("#tabContent").slideUp();
	
			}
			
			
			function tabgo1()
	        {
				$("#tabContent").slideDown();
	        	$('#tab-1').attr('href','#tab1'); 
	            $('#myTab a[href="#tab1"]').tab('show');
	        	
	        	$.ajax({
	        		url:"input/defaultData.do?id=1",
	        		type: "post",
	                dataType: "text",
	                success: function(data) {
	                	data = hexToDec(data);
	                	data = eval('(' + data + ')');
	                	defaultVal('tab1',data);
	                },
	                error: function(err) {
	                	alert("未能读取默认参数");
	                }
	        	});  		
	        }
			
			
	        function tabgo2()
	        {
	        	$("#tabContent").slideDown();
	        	$('#tab-2').attr('href','#tab2'); 
	            $('#myTab a[href="#tab2"]').tab('show');
	        	
	        	$.ajax({
	        		url:"input/defaultData.do?id=2",
	        		type: "post",
	                dataType: "text",
	                success: function(data) {
	                	data = hexToDec(data);
	                	data = eval('(' + data + ')');
	                	defaultVal('tab2',data);
	                },
	                error: function(err) {
	                	alert("can not read default data");
	                }
	        	});  		
	        }
        	
          function tabgo3()
          {
        	$("#tabContent").slideDown();
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
        	$("#tabContent").slideDown();
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
        	 $("#tabContent").slideDown();
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
        	$("#tabContent").slideDown();
            if($("#simType").val()==0){
                $('#tab-6').attr('href','#tab6A'); 
                $('#myTab a[href="#tab6A"]').tab('show');
              }
            if($("#simType").val()==1){
                $('#tab-6').attr('href','#tab6B'); 
                $('#myTab a[href="#tab6B"]').tab('show');
              }
          }