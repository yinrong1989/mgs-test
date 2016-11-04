$(function(){
	$("#signBut").click(function(event){
		event.preventDefault();
		//$(event.currentTarget);
		app.getSign('signBut','iForm');
	});
	
	$("#submitBut").click(function(event){
		event.preventDefault();
		app.submit('submitBut','iForm');
	});
});