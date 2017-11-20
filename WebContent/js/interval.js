$(function(){
	
	var intervalGetServer =  setInterval(sendCommand_GetServerStatus, 1000);
	var intervalGetClients =  setInterval(sendCommand_GetClientsStatus, 1000);
	
});