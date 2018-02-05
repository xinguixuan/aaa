<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
<script src="../easyui/jquery-3.2.1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../easyui/jquery.easyui.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../easyui/easyui-lang-zh_CN.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../js/userselect.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	<div id="cc" class="easyui-layout" style="width: 600px; height: 400px;"
		fit="true">
		<div data-options="region:'north',title:'North Title',split:true"
			style="height: 100px;">管理员查询系统</div>
		<div data-options="region:'west',title:'查询条件',split:true"
			style="width: 400px;">
			<div id="aa" class="easyui-accordion"
				style="width: 400px; height: 100%;">
				<div title="查询" style="overflow: auto; width: 100%;">
					<div style="margin: 20px 0;"></div>
					<div class="easyui-panel" style="width: 100%; padding: 30px 60px">
						<div style="margin-bottom: 5px">
							<div>邮箱:</div>
							<input class="easyui-textbox" style="width: 100%; height: 32px">
						</div>
						<div style="margin-bottom: 5px">
							<div>密码:</div>
							<input class="easyui-textbox" style="width: 100%; height: 32px">
						</div>
						<div style="margin-bottom: 5px">
							<div>生日:</div>
							<input class="easyui-textbox" style="width: 100%; height: 32px">
						</div>
						<div style="margin-bottom: 5px">
							<div>简介:</div>
							<input class="easyui-textbox" style="width: 100%; height: 32px">
						</div>
						<div style="margin-bottom: 5px">
							<div>生日范围开始时间:</div>
							<input id="dt1" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div style="margin-bottom: 5px">
							<div>生日范围开始时间:</div>
							<input id="dt2" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div style="margin-bottom: 5px">
							<div>性别:</div>
							<input style="width: 100%; height: 32px" id="cc1" name="dept">
						</div>
						<div style="margin-bottom: 5px">
							<div>账户类型:</div>
							<input style="width: 100%; height: 32px" id="cc2" name="dept">
						</div>
						<div style="margin-bottom: 5px">
							<div>是否已删除:</div>
							<input style="width: 100%; height: 32px" id="cc3" name="dept">
						</div>
						<div style="margin-bottom: 5px">
							<div>是否已生效:</div>
							<input style="width: 100%; height: 32px" id="cc4" name="dept">
						</div>
						<div style="margin-bottom: 5px">
							<div>创建时间范围起始时间:</div>
							<input id="dt3" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div style="margin-bottom: 5px">
							<div>创建时间范围结束时间:</div>
							<input id="dt4" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div style="margin-bottom: 5px">
							<div>修改时间范围起始时间:</div>
							<input id="dt5" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div style="margin-bottom: 5px">
							<div>修改时间范围结束时间:</div>
							<input id="dt6" type="text" name="birthday" style="width: 100%;"></input>
						</div>
						<div>
							<a href="#" class="easyui-linkbutton"
								style="width: 100%; height: 32px">查询</a>
						</div>
					</div>

				</div>
				<div title="Title2"
					data-options="iconCls:'icon-reload',selected:true"
					style="padding: 10px;">content2</div>
				<div title="Title3">content3</div>
			</div>

		</div>
		<div data-options="region:'center',title:'center title'"
			style="padding: 5px; background: #eee;">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
				<div title="Tab1" style="padding: 20px; display: none;">tab11
				</div>
			</div>
		</div>
	</div>
</body>
</html>