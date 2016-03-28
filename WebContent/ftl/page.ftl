<script>
	function page(totalPage,currentPage,prePage,nextPage){
		var pageLength=5;<#--奇数-->
		if(totalPage<pageLength+1){
			if(currentPage==1){
				$("#page").append("<li class='disabled'><a href='javascript:void(0)'>&laquo;</a></li>");
				$("#page").append("<li class='disabled'><a href='javascript:void(0)'>首页</a></li>");
			}else{
				$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(" +prePage+ ")'>&laquo;</a></li>");
				$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(1)'>首页</a></li>");
			}
			for(i=1;i<totalPage+1;i++){
				if(i==currentPage){
					$("#page").append("<li class='active'><a href='javascript:void(0)'>"+i+"</a></li>");
				}else{
					$("#page").append("<li ><a href='javascript:void(0)' onclick='queryByPage(" +i+")'>"+i+"</a></li>");
				}
			}
			if(totalPage==currentPage){
				$("#page").append("<li class='disabled'><a href='javascript:void(0)'>&raquo;</a></li>");
			}else{
				$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+nextPage+")'>&raquo;</a></li>");
			}
			<#--style1-->
			<#--|<<|首页｜1｜2｜3｜>>|-->
		}else{
			if(currentPage<(pageLength+1)/2+1){
				if(currentPage==1){
					$("#page").append("<li class='disabled'><a href='javascript:void(0)'>&laquo;</a></li>");
					$("#page").append("<li class='disabled'><a href='javascript:void(0)'>首页</a></li>");
				}else{
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(" +prePage+ ")'>&laquo;</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(1)'>首页</a></li>");
				}
				for(i=1;i<pageLength+1;i++){
					if(i==currentPage){
						$("#page").append("<li class='active'><a href='javascript:void(0)'>"+i+"</a></li>");
					}else{
						$("#page").append("<li ><a href='javascript:void(0)' onclick='queryByPage(" +i+")'>"+i+"</a></li>");
					}
				}
				$("#page").append("<li><a href='javascript:void(0)'>..</a></li>");
				if(totalPage==currentPage){
					$("#page").append("<li class='disabled'><a href='javascript:void(0)'>末页</a></li>");
					$("#page").append("<li class='disabled'><a href='javascript:void(0)'>&raquo;</a></li>");
				}else{
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+totalPage+")'>末页</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+nextPage+")'>&raquo;</a></li>");
				}
				<#--style2-->
				<#--|<<|首页｜1｜2｜3｜4|5|..|末页｜>>|-->
			}else{
				if((totalPage-currentPage)<(pageLength+1)/2){
					$("#page").append("<li><a href='javascript:void(0)'>&laquo;</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(1)'>首页</a></li>");
					$("#page").append("<li><a href='javascript:void(0)'>..</a></li>");
					for(i=(totalPage-pageLength+1);i<totalPage+1;i++){
						if(i==currentPage){
							$("#page").append("<li class='active'><a href='javascript:void(0)'>"+i+"</a></li>");
						}else{
							$("#page").append("<li ><a href='javascript:void(0)' onclick='queryByPage(" +i+")'>"+i+"</a></li>");
						}
					}
					if(totalPage==currentPage){
						$("#page").append("<li class='disabled'><a href='javascript:void(0)'>末页</a></li>");
						$("#page").append("<li class='disabled'><a href='javascript:void(0)'>&raquo;</a></li>");
					}else{
						$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+totalPage+")'>末页</a></li>");
						$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+nextPage+")'>&raquo;</a></li>");
					}
					<#--style3-->
					<#--|<<|首页｜..|totel－4｜..|totel||末页｜>>|-->
				}else{
					$("#page").append("<li><a href='javascript:void(0)'>&laquo;</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage(1)'>首页</a></li>");
					$("#page").append("<li><a href='javascript:void(0)'>..</a></li>");
					for(i=currentPage-2;i<currentPage+3;i++){
						if(i==currentPage){
							$("#page").append("<li class='active'><a href='javascript:void(0)'>"+i+"</a></li>");
						}else{
							$("#page").append("<li ><a href='javascript:void(0)' onclick='queryByPage(" +i+")'>"+i+"</a></li>");
						}
					}
					$("#page").append("<li><a href='javascript:void(0)'>..</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+totalPage+")'>末页</a></li>");
					$("#page").append("<li><a href='javascript:void(0)' onclick='queryByPage("+nextPage+")'>&raquo;</a></li>");
					<#--style4-->
					<#--|<<|首页｜..|current－2|..｜current|..|current+2|..|末页｜>>|-->
				}
			}
		}
	}
</script>