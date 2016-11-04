$(function(){

var fillData = function(event){
	event.preventDefault();
	var ids = [{'name':'member_name','len':5,'pre':'','mod':'str'}];
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

});