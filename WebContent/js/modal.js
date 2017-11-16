$(function(){
    // dom加载完毕
    $("#ipInvalidAlert").hide();
    $("#requestErrorAlert").hide();
    
    var $m_btn = $('#add_client #add_server');
    var $modal = $('#ipModal');
    var tiggleSource = "";
    $m_btn.on('click', function(){
        $modal.modal({backdrop: 'static'});
    });

    // 测试 bootstrap 居中
    $modal.on('show.bs.modal', function(event){
    	var $this = $(this);
    	var $modal_dialog = $this.find('.modal-dialog');
    	// 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
    	$this.css('display', 'block');
        $modal_dialog.css({'margin-top': Math.max(0, ($(window).height() - $modal_dialog.height()) / 2) });
        
        var button = $(event.relatedTarget) // 触发事件的按钮  
        var recipient = button.data('source') // 解析出source内容 
        tiggleSource = recipient;
    });
    
    //确认ip
    $("#confirmIP").click(function(){
    	var ip = $("#inputIP").val();
    	var valid = false;
    	
        $("#ipInvalidAlert").hide();
        $("#requestErrorAlert").hide();
    	
    	function CheckIP(ip){
    		//alert(ip)
    		var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
    		return reg.test(ip);
    	}
    	
    	if (CheckIP(ip)){
    		
    		
    		if (tiggleSource == "add_client"){
    			//alert("add_client");
    			sendCommand_AddClient(ip);
    		}
    		else if (tiggleSource == "add_server"){
    			//alert("add_server");
    			sendCommand_AddServer(ip);
    		}
    		
    		
    	}
    	else{
    		$("#ipInvalidAlert").show();
    	}
    	
    });
        
});


