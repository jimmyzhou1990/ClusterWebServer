clientsJson = [
	{"ip":"192.168.1.5",  "connect":"online",  "memory":"50%", "threads":"651"},
	{"ip":"192.168.1.2",  "connect":"offline",  "memory":"40%", "threads":"551"},
	{"ip":"192.168.1.3",  "connect":"online",  "memory":"60%", "threads":"881"},
	{"ip":"192.168.1.4",  "connect":"offline",  "memory":"30%", "threads":"381"}
]


function showClients(){
	
	//alert(clientsJson[0].ip);
	
	function addRow(){
	
	}
	
	function deleteRow(){
		
	}
	
	function show(json){
        $.each(json, function(index, client) {
        	var tr = null;
        	$.each(client, function(attr, data) {
        		//tr+='<td>'+client[attr]+'</td>';
        		tr+='<td>'+data+'</td>';
        	});
            tr+='<td>'+ '<button type="button" class="btn btn-xs btn-danger">删除</button>' + '</td>'
            $("#clients_table").append('<tr>'+tr+'</tr>');
        });
	};
	
	show(clientsJson);
}

function Clients(){
	
	this.currentNum = 0;
	this.maxNum = 50;
	this.buttonClass = "row_button";
	
	
	this.add = function(){
		
	};
	
	this.remove = function(){
		
	};
	
	/* 建立50 行*/
	this.showCreate = function(){

        var tds;
       	for (var i=0; i<this.maxNum; i++){
       		tds = '';
       		tds+='<td>'+''+'</td>'; 
       		tds+='<td>'+''+'</td>';
       		tds+='<td>'+''+'</td>';
       		tds+='<td>'+''+'</td>';
       		tds+='<td>'+ '<button type="button" class="btn btn-xs btn-danger '+ this.buttonClass + '">删除</button>' + '</td>'
       		$("#clients_table").append('<tr>' + tds + '</tr>');
       		$("#clients_table tr:eq(" + i + ")").hide();
       	}
	};
	this.showCreate();
	
	
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
	
	/* 添加响应函数 */
	$(".add_client").click(function(){
		//alert("add");
		
	});
	
	/* 删除响应函数 */
	$("."+this.buttonClass).click(function(){
		//alert("delete");
	});
	
	
}




