clientsJson = [
	{"ip":"192.168.1.5",  "connect":"online",  "memory":"50%", "threads":"651"},
	{"ip":"192.168.1.2",  "connect":"offline",  "memory":"40%", "threads":"551"},
	{"ip":"192.168.1.3",  "connect":"online",  "memory":"60%", "threads":"881"},
	{"ip":"192.168.1.4",  "connect":"offline",  "memory":"30%", "threads":"381"}
]

selectButton = 
'<div class="btn-group">'+
'<button type="button" class="btn btn-primary btn-xs btn-info dropdown-toggle" data-toggle="dropdown">操作'+ 
    '<span class="caret"></span>'+
'</button>'+
'<ul class="dropdown-menu" role="menu">'+
   '<li><a href="#" class="select_delete_this">删除</a></li>'+
   '<li><a href="#" class="select_shutdown_this">关机</a></li>'+
'</ul>'+
'</div>';

function Clients(){
	
	this.currentNum = 0;
	this.maxNum = 50;
	
	
	/* 建立50 行*/
	this.showCreate = function(){

        var tds;
       	for (var i=0; i<this.maxNum; i++){
       		tds = '';
       		tds+='<td width="20%">'+''+'</td>'; 
       		tds+='<td width="20%">'+''+'</td>';
       		tds+='<td width="20%">'+''+'</td>';
       		tds+='<td width="20%">'+''+'</td>';
       		tds += '<td width="20%">'+selectButton+'</td>';
       		$("#clients_table").append('<tr>' + tds + '</tr>');
       		$("#clients_table tr:eq(" + i + ")").hide();
       	}
	};
	this.showCreate();
	
	
	/* 删除 */
	$("#clients_table").on("click", ".select_delete_this", function(){
		//alert("remove this")
		var callback_seccuss = function() {
			alert("ok")
		}
		var callback_fail = function() {
			alert("fail")
		}
		
		var $this = $(this);
		var $row = $(this).closest("tr"); //找到父行
		
		
		var clientip = $row.children('td').eq(0).text();
		var command = "remove";
		
		sendCommand_Client(clientip, command, callback_seccuss, callback_fail);
		
	});
	
	/* 关机 */
	$("#clients_table").on("click", ".select_shutdown_this", function(){
		//alert("shutdown this")
		
	});
	
	/* 刷新显示 */
	this.showRefresh = function(json){
		var td_index;
		var row_index = 0;
		
		$.each(json, function(index, client) {
			td_index = 0;
			$.each(client, function(attr, data) {
        		$("#clients_table tr:eq(" + index + ") td:eq("+td_index+")").text(data);
        		td_index++;
        	}); 
        	$("#clients_table tr:eq(" + index + ")").show();
        	row_index++;
		});
		
		for(var i=row_index; i<this.currentNum; i++){
			$("#clients_table tr:eq(" + i + ")").hide();
		}
		
		this.currentNum	= json.length;	
	};
	
}




