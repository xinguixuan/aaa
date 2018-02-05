$(function() {
	$('input.easyui-validatebox').validatebox(
			{
				tipOptions : {
					showEvent : 'mouseenter',
					hideEvent : 'mouseleave',
					showDelay : 0,
					hideDelay : 0,
					zIndex : '',
					content : '11111',
					onShow : function() {
						if (!$(this).hasClass('validatebox-invalid')) {
							if ($(this).tooltip('options').prompt) {
								$(this).tooltip('update',
										$(this).tooltip('options').prompt);
							} else {
								$(this).tooltip('tip').hide();
							}
						} else {
							$(this).tooltip('tip').css({
								color : '#000',
								borderColor : '#CC9933',
								backgroundColor : '#FFFFCC'
							});
						}
					},
					onHide : function() {
						if (!$(this).tooltip('options').prompt) {
							$(this).tooltip('destroy');
						}
					}
				}
			}).tooltip({
		position : 'right',
		content : function() {
			var opts = $(this).validatebox('options');
			return opts.prompt;
		},
		onShow : function() {
			$(this).tooltip('tip').css({
				color : '#000',
				borderColor : '#CC9933',
				backgroundColor : '#FFFFCC'
			});
		}
	});
});



function denglu(){
	var yzm = $('#yzm').textbox('getValue');
	var username = $('#username').textbox("getValue");
	var userpass = $('#userpass').textbox('getValue');
	$.ajax({
		url : "/aaa/userServelt.do",
		type : "post",
		contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
		data : {
			action : 'denglu',
			yzm : yzm,
			username : username,
			userpass : userpass
		},
		dataType : "text",
		success : function(data) {
			alert(data)
		}
	})
}