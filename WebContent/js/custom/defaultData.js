//自动填充页面元素
			function defaultVal(id,data){
				for(var key in data){
	        		var dom = $("#"+id+" input[name='"+key+"']");
	        		if( dom.size()>0){
	        			if(dom.size() <= 1 && dom.size()>0 ){
		        			var val = data[key];
		            		dom.val(val);
		        		}else{
		        			var valArray = data[key].split(",");
		        			if(valArray.length == dom.size()+1){
		        				for(var i = 0;i<dom.size();i++){
		        					dom[i].value = valArray[i];
		        				}
		        			}
		        		}
	        		}
        			var dom1 = $("#"+id+" select[name='"+key+"']");
        			if(dom1.size()>0){
	        			if(dom1.size() <= 1 && dom1.size()>0){
		        			var val = data[key];
		        			dom1.find("option[text='"+data[key]+"']").attr("selected",true); 
		        		}else{
		        			if(data[key].length>0){
		        				var valArray = data[key].split(",");
			        			if(valArray.length == dom1.size()+1){
			        				for(var i = 0;i<dom1.size();i++){
			        					$(dom1[i]).find("option[text='"+data[key]+"']").attr("selected",true);
			        				}
			        			}
		        			}	
		        		}
        			}
	        	}
			}
        	
			
	        function tabgo2()
	        {
	        	$('#tab-2').attr('href','#tab2'); 
	            $('#myTab a[href="#tab2"]').tab('show');
	        	
	        	$.ajax({
	        		url:"input/defaultData2.do",
	        		type: "post",
	                dataType: "json",
	                success: function(data) {
	                	data = eval(data);	
	                	defaultVal('tab2',data);
	                },
	                error: function(err) {
	                	alert("can not read default data");
	                }
	        	});   
	        }
	     