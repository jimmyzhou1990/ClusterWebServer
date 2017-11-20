$(document).ready(function(){
	
	clientsManger = new Clients();
	
});

function GetClientsSuccuss(json) {
	clientsManger.showRefresh(json);
}

function GetClientsError(json) {
	clientsManger.showRefresh(json);
}
