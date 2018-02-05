<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom ValidateBox Tooltip - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/zhuce.js"></script>
<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
</head>
<body>
	<h2>注册系统界面</h2>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-panel" title="账户信息"
		style="width: 400px; padding: 10px 60px 20px 60px">
		<form action="/aa/x2.do?action = zhuce" method="post"
			name="denglubiao">
			<table cellpadding="5">
				<tr>
					<td>账号:</td>
					<td><input id="username" onclick="" class="easyui-textbox"
						placeholder="请输入账号" name="username"
						data-options="required:true,validType:'email'"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input id="userpass" class="easyui-textbox"
						placeholder="请输入密码" name="userpass"
						data-options="required:true,validType:'length[6,15]'"></td>
				</tr>
				<tr>
					<td>昵称:</td>
					<td><input id="name" class="easyui-textbox"
						placeholder="请输入昵称" name="name"
						data-options="required:true,validType:'length[1,6]'"></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input id="sex" name="dept"></td>
				</tr>
				<tr>
					<td>简介:</td>
					<td><input id="descr" placeholder="请输入简介"
						class="easyui-textbox" name="jianjie"
						data-options="required:true,validType:'length[1,6]'"></td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><input id="birthdate" placeholder="请输入生日"
						class="easyui-datebox" data-options="required:true"></td>
				</tr>
				<tr>
					<td>验证码:</td>
					<td><input id="yzm" placeholder="请输入验证码"
						class="easyui-textbox" name="zcyzm"
						data-options="required:true,validType:'length[4,4]'"></td>
				</tr>
				<tr>
					<td></td>
					<td><img src="/aaa/userServelt.do?action=yzm"
						onclick="this.src='/aaa/userServelt.do?action=yzm&'+Math.random();" /><span
						class="easyui-validatebox textbox">点击图片更换</span></td>
				</tr>
			</table>
			<input type="button" id="" value="注册" onclick="zhuce()" />
		</form>
	</div>
</body>
</html>
