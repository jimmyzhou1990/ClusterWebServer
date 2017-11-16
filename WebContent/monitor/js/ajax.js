
function fn3(){
	$.ajax({
		url:"/WEB22/ajaxServlet2",
		async:true,
		type:"POST",
		data:{"name":"lucy","age":18},
		success:function(data){
			alert(data.name);
		},
		error:function(){
			alert("请求失败");
		},
		dataType:"json"
	});
}