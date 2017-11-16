
function sendCommand_AddServer(serverip){
	$.ajax({
		url:"serverManagerServlet",
		async:true,
		type:"POST",
		data:{"ssip":serverip},
		success:function(data){
			//alert("修改成功!");
			$("#ipModal").modal('hide');
		},
		error:function(){
			//alert("请求失败!");
			$("#requestErrorAlert").show();
		},
		dataType:"json"
	});
}

function sendCommand_AddClient(clientip) {
	$.ajax({
		url:"clientsManagerServlet",
		async:true,
		type:"POST",
		data:{"add" : clientip},
		success:function(data){
			//alert("修改成功!");
			$("#ipModal").modal('hide');
		},
		error:function(){
			//alert("请求失败!");
			$("#requestErrorAlert").show();
		},
		dataType:"json"
	});	
}