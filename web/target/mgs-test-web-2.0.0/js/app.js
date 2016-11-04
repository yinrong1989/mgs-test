$(function(){

	var application = function(){
		//生成len 位的随机数据
		var genRadNum = function(len){
			var num = Math.floor(Math.random() * Math.pow(10,len)) + "";
			if(num.length < len){
				var s = "";
				for(i=0;i< len-num.length;i++){
					s += "0";
				}
				return s + "" + num;
			}
			return num;
		};
		//生成len 位的随机数据
		var genRadStr = function(len){
			var s = "";
			for(var i=0;i<len;i++){
				var j =Math.floor(Math.random()*2);
				if(j ==0){
					s += genOneNum();
				}else{
					s += genOneChar();
				}
			}
			return s;
		};

		var genOneNum = function(){
			 return Math.floor(Math.random()*10) + "";
		};

		var genOneChar = function(){
			return String.fromCharCode(97 + Math.floor(Math.random()*26));
		};

		var template = function(data){
			var txt = "";
			for(var i in data){
				if('success' != i){
					txt += "<p style='word-break:break-all;'>" + i + ":</p><pre>" + data[i] + "</pre>";
				}
			}
			return txt;
		};

		return {
			version: "1.0",
			init : function(){
				$("input[type=text]").blur(function(){
					$(this).val($(this).val().trim());
				});
			},
			//生成随机数
			genRadNum: function(pre,len){
				return pre + genRadNum(len);
			},
			//生成随机字符
			genRadStr: function(pre,len){
				return pre + genRadStr(len);
			},
			//loading
			loading:{
				show:function(){
					$(".loading").fadeIn("slow");
				},
				hide:function(){
					$(".loading").fadeOut("slow");
				}
			},
			//获得签名
			getSign:function(but,form,callback){
				var $but = $('#'+but);
				var $form = $('#'+form);
				$but.attr("disabled","disabled");
				var self = this;
				self.loading.show();
				$.ajax('sign.json',{
					type : 'POST',
					dataType : 'json',
					data : $form.serialize()
				}).done(function(data){
					if(data.success){
						$('#sign').val(data.sign);
						$('#linkString').val(data.signLinkStr);
					}else{
						bootbox.alert({
							title:'签名失败',
							message : '<div class="well">系统暂时故障，请稍后重试！</div>',
							callback : function(){}
						});
					}
					$but.removeAttr("disabled");
					self.loading.hide();
					if((typeof callback)=='function'){
						callback();
					}
				}).fail(function(req,status,e){
					$but.removeAttr("disabled");
					self.loading.hide();
					bootbox.alert({
						title:'签名失败',
						message : '<div class="well">系统暂时故障，请稍后重试！'+e+'</div>',
						callback : function(){}
					});
				});
			},
			//提交表单
			submit:function(but,form){
				var $but = $('#'+but);
				var $form = $('#'+form);
				$but.attr("disabled","disabled");
				var self = this;
				self.loading.show();
				$.ajax($form.attr("action"),{
					type : 'POST',
					dataType : 'json',
					data : $form.serialize()
				}).done(function(data){
					if(data.success=='true'){
						//成功
						bootbox.alert({
							title:'提交成功',
							message : '<div class="hero-unit"><p>'+template(data)+'</p></div>',
							callback : function(){}
						});
					}else{
						bootbox.alert({
							title:'返回信息',
							message : '<div class="hero-unit"><p>'+template(data)+'</p></div>',
							callback : function(){}
						});
					}
					$but.removeAttr("disabled");
					self.loading.hide();
				}).fail(function(req,status,e){
					$but.removeAttr("disabled");
					self.loading.hide();
					bootbox.alert({
						title:'提交失败',
						message : '<div class="well">系统暂时故障，请稍后重试！'+e+'</div>',
						callback : function(){}
					});
				});
			}
		};
	};

	var app = window.app = application();

	setTimeout(function(){app.init();},1);
});