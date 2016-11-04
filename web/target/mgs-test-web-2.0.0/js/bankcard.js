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

$("#encryptBut").click(function(event){
	event.preventDefault();
	var no = $('#bank_account_no_src').val();
	var name = $('#account_name_src').val();
	
	if(no == '' || name == ''){
		bootbox.alert({
			title:'加密错误',
			message : '<div class="well">卡号或户名不能为空!</div>',
			callback : function(){}
		});
		return ;
	}
	var srcdata ={};
	srcdata['bank_account_no_src']=no;
	srcdata['account_name_src']=name;
	srcdata['service']='create_bank_card';
	srcdata['_input_charset']=$('#_input_charset').val();
	encrypt('encryptBut',srcdata);
});


var encrypt = function(but,srcdata){
	var $but = $('#'+but);
	$but.attr("disabled","disabled");
	app.loading.show();
	$.ajax('encrypt.json',{
		type : 'POST',
		dataType : 'json',
		data : srcdata
	}).done(function(data){
		$('#bank_account_no').val(data["bank_account_no"]);
		$('#account_name').val(data["account_name"]);
		$but.removeAttr("disabled");
		app.loading.hide();
	}).fail(function(req,status,e){
		$but.removeAttr("disabled");
		app.loading.hide();
		bootbox.alert({
			title:'加密失败',
			message : '<div class="well">系统暂时故障，请稍后重试！'+e+'</div>',
			callback : function(){}
		});
	});
};

});