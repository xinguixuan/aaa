function f1(title, url) {
	if ($('#tt').tabs("exists", title)) {
		$('#tt').tabs("select", title)
	} else {
		var content = "<iframe src ='" + url
				+ "' style='width:100%; height:100%;'/>"
		$('#tt').tabs('add', {
			closable : true,
			content : content,
			title : title
		})
	}
}
function f1(title, url) {
	if($('#tt').tabs("exists", title)) {
		$('#tt').tabs("select", title)
	} else {
		var content = "<iframe src ='" + url + "' style='width:100%; height:100%;'/>"
		$('#tt').tabs('add', {
			closable: true,
			content: content,
			title: title
		})
	}
}
$(function() {
	$('#cc1').combobox({
		valueField: 'id',
		textField: 'text'
	})

	$('#cc2').combobox({
		valueField: 'id',
		textField: 'text'
	})

	$('#cc3').combobox({
		valueField: 'id',
		textField: 'text'
	})

	$('#cc4').combobox({
		valueField: 'id',
		textField: 'text'
	})

	$('#dt1').datebox({
		showSeconds: false
	});

	$('#dt2').datebox({
		showSeconds: false
	});

	$('#dt3').datetimebox({
		showSeconds: true
	});

	$('#dt4').datetimebox({
		showSeconds: true
	});

	$('#dt5').datetimebox({
		showSeconds: true
	});

	$('#dt6').datetimebox({
		showSeconds: true
	});
})

//获取查询界面性别信息
$(function() {
	$('#cc1').combobox({
		url : '/aaa/userServelt.do?action=zhucesex',
		valueField : 'id',
		textField : 'text'
	})
})


// 获取查询界面账户类型信息
$(function(){
	$('#cc2').combobox({
		url:'/aaa/userServelt.do?action=zhlb',
		valueField : 'id',
		textField : 'text'
	})
})

//获取查询界面是否删除信息
$(function(){
	$('#cc3').combobox({
		url:'/aaa/userServelt.do?action=sfsc',
		valueField : 'id',
		textField : 'text'
	})
})

//获取查询界面是否生效信息
$(function(){
	$('#cc4').combobox({
		url:'/aaa/userServelt.do?action=sfsx',
		valueField : 'id',
		textField : 'text'
	})
})