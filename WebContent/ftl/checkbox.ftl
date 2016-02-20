		<#--复选框事件  
     	全选、取消全选的事件 -->
     <script>
      	function selectAll(){
      		if ($("#SelectAll").attr("checked")) {  
        		$(":checkbox").attr("checked", true);  
    		} else {  
        		$(":checkbox").attr("checked", false);  
    		}  
		}  
		function setSelectAll(){  
    	<#--当没有选中某个子复选框时，SelectAll取消选中-->  
    		if (!$("#subcheck").checked) {  
        		$("#SelectAll").attr("checked", false);  
   			 }  
    			var chsub = $("input[type='checkbox'][id='subcheck']").length; <#--获取subcheck的个数  -->
    			var checkedsub = $("input[type='checkbox'][id='subcheck']:checked").length; <#--获取选中的subcheck的个数-->  
    		if (checkedsub == chsub) {  
        		$("#SelectAll").attr("checked", true);  
    			}  
		} 
	</script>
			