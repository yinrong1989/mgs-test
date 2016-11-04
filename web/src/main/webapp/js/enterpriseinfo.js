$(function(){
var fillData = function(event){
	event.preventDefault();
	var ids = [{'name':'enterprise_name','len':20,'pre':'','mod':'str'},
	           {'name':'legal_person','len':5,'pre':'','mod':'str'},
	           {'name':'member_name','len':5,'pre':'','mod':'str'},
	           {'name':'legal_person_phone','len':10,'pre':'1','mod':'int'},
	           {'name':'website','len':10,'pre':'','mod':'str'},
	           {'name':'address','len':10,'pre':'','mod':'str'},
	           {'name':'license_no','len':10,'pre':'','mod':'str'},
	           {'name':'license_address','len':10,'pre':'','mod':'str'},
	           {'name':'business_scope','len':10,'pre':'','mod':'str'},
	           {'name':'telephone','len':8,'pre':'','mod':'int'},
	           {'name':'organization_no','len':10,'pre':'','mod':'int'},
	           {'name':'summary','len':8,'pre':'','mod':'str'}];
	$.each(ids,function(n,item) {
		var str = "";
		if(item.mod =='int'){
			str = app.genRadNum(item.pre,item.len);
		}else{
			str = app.genRadStr(item.pre,item.len);
		}
		$('#'+item.name).val(str);
	});
	
	$('#license_expire_date').val(app.genRadNum('2015011',1));
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