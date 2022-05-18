<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>日历选择框</title>
			<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	</head>
	
	<body>
		发布时间:
		<input class="Wdate" type="text" name="publishtime" id="publishtime"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"//设置日历格式显示年月日  时分秒
			readonly="readonly"  />
	</body>
</html>
