$(function(){

var fillData = function(event){
	event.preventDefault();
	var ids = [{'name':'uid','len':10,'pre':'','mod':'str'}];
	$.each(ids,function(n,item) {
		var str = "";
		if(item.mod =='int'){
			str = app.genRadNum(item.pre,item.len);
		}else{
			str = app.genRadStr(item.pre,item.len);
		}
		$('#'+item.name).val(str);
	});
};

$("#fillBut").click(function(event){
	app.loading.show();
	fillData(event);
	app.loading.hide();
});

$("#signBut").click(function(event){
	event.preventDefault();
	//$(event.currentTarget);
	app.getSign('signBut','iForm');
});

$("#submitBut").click(function(event){
	event.preventDefault();
	app.submit('submitBut','iForm');
});

$("#autoBut").click(function(event){
	$but = $("#autoBut");
	$but.attr("disabled","disabled");
	$("#fillBut").click();
	app.getSign('signBut','iForm',function(){
		app.submit('submitBut','iForm');
	});
	$but.removeAttr("disabled");
});

});