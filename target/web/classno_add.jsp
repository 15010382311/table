<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!-- HTML5文档-->
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>
    <script type="text/javascript" src="showDialog.js"></script>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('img/login-bg.jpg');">
<div class="container" style="width: 400px;">
    <div class="row" style="margin-top: 50px;">
		<div class="col-sm-6 col-sm-offset-3">
			<h1 class="text-center">
				<small>添加班级信息</small>
			</h1>
		</div>
	</div>
    <form action="${pageContext.request.contextPath}/classno?method=addClassNo" method="post">
        <div class="form-group">
            <label for="cno">班级编号：</label>
            <input type="text" class="form-control" id="cno" name="cno" placeholder="请输入班级编号：">
        </div>

        <div class="form-group">
            <label for="className">班级名称：</label>
            <input type="text" class="form-control" id="className" name="className" placeholder="请输入班级名称">
        </div>

        <div hidden="hidden" id="123" class="form-group">
            <label for="department">所属院系：</label>
            <input type="text" class="form-control" id="department" name="department" placeholder="请输入所属院系">
        </div>
        
        
 
<script type="text/javascript">
    function show(obj){
     //   alert("谢谢！");
        // document.getElementById("d").innerHTML = "显示需要组装的信息";
        // window.open ("page.html", "newwindow", "height=100, width=400, toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") 
    //window.open('index2.jsp?p1=2','_blank');
    var x = window.screen.height;
    var y = window.screen.width;
    var h = 500;
    var w = 800;
    var model = "title=word,resizable=yes,scrollbars=yes,height=" + h + ",width=" + w + ",status=yes,toolbar=no,menubar=no,location=no,top=" + (x-h)/2 + ",left=" + (y-w)/2;
    var url = "";
 
    url = "about.jsp";//弹出窗口的页面内容
    var oOpen = window.open(url,"adviceDetail",model);
    oOpen.focus();
    }
    </script>
   <p onclick="show(this)"> 点击</p>



        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>