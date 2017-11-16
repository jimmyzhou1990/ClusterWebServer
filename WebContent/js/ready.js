$(document).ready(function(){
	
	clientsJson = [
		{"ip":"192.168.1.1",  "connect":"online",  "memory":"50%", "threads":"651"},
		{"ip":"192.168.1.2",  "connect":"offline",  "memory":"40%", "threads":"551"},
		{"ip":"192.168.1.3",  "connect":"online",  "memory":"60%", "threads":"881"},
		{"ip":"192.168.1.4",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.5",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.6",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.7",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.8",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.9",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.10",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.11",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.12",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.13",  "connect":"offline",  "memory":"30%", "threads":"381"}
	];
	
	clientsJson1 = [
		{"ip":"192.168.1.5",  "connect":"online",  "memory":"50%", "threads":"651"},
		{"ip":"192.168.1.3",  "connect":"online",  "memory":"60%", "threads":"881"},
		{"ip":"192.168.1.8",  "connect":"offline",  "memory":"30%", "threads":"381"},
		{"ip":"192.168.1.8",  "connect":"offline",  "memory":"30%", "threads":"381"}
	];
	
	clientsJson2 = [
		{"ip":"192.168.1.5",  "connect":"online",  "memory":"50%", "threads":"651"}
	];
	
	var clientsManger = new Clients();

	clientsManger.showRefresh(clientsJson1);
	clientsManger.showRefresh(clientsJson);
	//clientsManger.showRefresh(clientsJson2);
});
