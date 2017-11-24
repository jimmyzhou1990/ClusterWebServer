
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

function sendCommand_GetServerStatus(){
	$.ajax({
		url:"serverManagerServlet",
		async:true,
		type:"POST",
		data:{"sscon":"???"},
		
		success:function(data){
			GetServerSuccuss(data);
		},
		
		error: function(data){
			GetServerError(data);
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

function sendCommand_Client(clientip, command, cb_seccuss, cb_fail){
	$.ajax({
		url:"clientsManagerServlet",
		async:true,
		type:"POST",
		data:{"remove" : clientip},
		success:function(data){
			cb_seccuss();
		},
		error:function(){
			cb_fail();
		},
		dataType:"json"
	});	
	
}




function sendCommand_GetClientsStatus(){
	$.ajax({
		url:"clientsManagerServlet",
		async:true,
		type:"POST",
		data:{"get" : "all"},
		
		success:function(data){
			GetClientsSuccuss(data);
		},
		
		error: function(data){
			GetClientsError(data);
		},
		
		dataType:"json"
	});
}

