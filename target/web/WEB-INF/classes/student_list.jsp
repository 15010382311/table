<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>服务器状态巡检</title>
 
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">
        @media (min-width: 768px) {
           #slider_sub{
               width: 200px;
               margin-top: 51px;
               position: absolute;
               z-index: 1;
               height: 900px;
           }
            .mysearch{
                margin: 10px 0;
            }
            .page_main{
                margin-left: 205px;
            }
        }
    </style>
    <script>
        function deleteStudent(id){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="${pageContext.request.contextPath}/student?method=delStudent&id="+id;
            }
        }

        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelectedStudent").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){

                   var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("id");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }

        }

    </script>
</head>
<body>
    <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <!--缩放 -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#slider_sub">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">运维信息管理</a>
        </div>
        <ul class="nav navbar-nav navbar-right" style="margin-right: 25px">
            <li><a href="${pageContext.request.contextPath}/user?method=findUser&id=${user.id}"><span class="badge" style="background: #C12E2A">${user.username}</span></a></li>
            <li><a href="${pageContext.request.contextPath}/user?method=destroyUser"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
        
        </ul>
 
        <!-- 侧边栏  -->
        <div class="navbar-default navbar-collapse" id="slider_sub">
            <ul class="nav">
                <li>

			        <form class="form-inline" action="${pageContext.request.contextPath}/student?method=findAll" method="post">
			            
			            <!--搜索 -->
	                    <div class="input-group mysearch">
	                        <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
	                        <span class="input-group-btn">
	                            <button type="submit" class="btn btn-default">
	                                <span class="glyphicon glyphicon-search"></span>
	                            </button>
	                        </span>
	 
	                    </div>
			        </form>

                    
                </li>
                <li><a href="${pageContext.request.contextPath}/classno?method=addClassNo" class="collapse" data-toggle="collapse">监测信息总览<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                     <!-- <ul id="sub2" class="nav collapse">
                        <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;信息管理</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;巡检信息</a></li>
                    </ul> -->
                </li>
                 
                <li><a href="${pageContext.request.contextPath}/student?method=addStudent"  class="collapse" data-toggle="collapse">服务器状态<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
                <li><a href="${pageContext.request.contextPath}/classno?method=findAll"  class="collapse" data-toggle="collapse">告警信息<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
<%--                 <li><a href="${pageContext.request.contextPath}/course?method=findAll"  class="collapse" data-toggle="collapse">备份检查<span class="glyphicon glyphicon-chevron-right pull-right"></span></a> --%>
                    
<!--                 </li> -->
<%--                 <li><a href="${pageContext.request.contextPath}/about.jsp"  class="collapse" data-toggle="collapse">运维流程<span class="glyphicon glyphicon-chevron-right pull-right"></span></a> --%>
                    
<!--                 </li> -->
            </ul>
        </div>
    </nav>
 
    <!-- 主区域 -->
    <div class="page_main" style="background: rgba(92,88,116,0.34)">
        <ol class="breadcrumb">
            <li><a href="#">运维</a></li>
            <li><a href="#">巡检</a></li>
            <li><a href="#">巡检信息</a></li>
        </ol>
 
        <div class="row">
            <div class="col-md-12 col-sm-3">
                <div class="panel panel-default">
                    <!-- <div class="panel-header">学生信息</div> -->
                    
                    <div class="panel-body table-responsive">
                    
				
				    <div style="float: right;margin: 5px;">

<Script Language="JavaScript"> 
    function find() 
    { 
    document.form1.action="${pageContext.request.contextPath}/student?method=findAll"; 
    document.form1.submit(); 
    } 
     
    function export1() 
    { 
    document.form1.action="${pageContext.request.contextPath}/student?method=export"; 
    document.form1.submit(); 
    } 
</Script> 


			<form name="form1" action="" method="post">	
		    
				<td style="text-align: right">项目名称：</td>
				<td style="text-align: lieft"><input type="text" src=""
				<%if (request.getParameter("name") != null && !"".equals(request.getParameter("name"))){ %>	value = <%=request.getParameter("name")%><%}%>	name="name" /></td>
			

			
				<td style="text-align: right">服务器ip：</td>
				<td style="text-align: lieft"><input type="text" src=""
				<%if (request.getParameter("hostid") != null && !"".equals(request.getParameter("hostid"))){ %>	value = <%=request.getParameter("hostid")%><%}%>	name="hostid" /></td>
			
				        <input class="btn btn-primary" href="${pageContext.request.contextPath}/student?method=findAll" type ="submit" value = 查询 onClick="find()"></input>
			            <input class="btn btn-primary" href="${pageContext.request.contextPath}/student?method=export" type ="submit" value = 导出 onClick="export1()"></input>
		   </form>
		   
<%-- 		   <form action="${pageContext.request.contextPath}/student?method=export" method="post"> --%>
		   
<!-- 		   </form> -->

	   
				    </div>
                    
                    <form id="form" action="${pageContext.request.contextPath}/student?method=delSelectedStudent" method="post">
                        <table class="table table-striped table-hover" style="margin: 10px;">
                        
                            <thead>
	                            <tr>
	                            	<th><input type="checkbox" id="firstCb"></th>
	                            	<th>服务器</th>
	                                <th>项目</th>
	                                <th>Cpu</th>
	                                <th>内存</th>
	                                <th>硬盘状态</th>
	                                <th>首页状态</th>
	                                <th>关键服务</th> 
	                                <th>网卡</th>
	                            </tr>
	      
                            </thead>
                            
        
                            <c:forEach items="${pb.list}" var="student" varStatus="s">
                           
					            <tr>
					                <td><input type="checkbox" name=hostid value="${student.hostid}"></td>
					                <td width="260" style="word-wrap: break-word; word-break: break-all;">${student.hostid}</td> 
					                <td width="260" style="word-wrap: break-word; word-break: break-all;">${student.pro}</td>
					                <td>${student.cpu}</td>
					                <td>${student.memory}</td>
					                <td width="260" style="word-wrap: break-word; word-break: break-all;">${student.disk}</td>
					                <td>${student.shouye}</td>
					                <td>${student.service}</td>
					                <td>${student.network}</td>
<%-- 					                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/student?method=findStudent&id=${student.id}">修改</a>&nbsp; --%>
<%-- 					                    <a class="btn btn-default btn-sm" href="javascript:deleteStudent(${student.id});">删除</a></td> --%>
					            </tr>

					        </c:forEach>
					        
                          
                        </table>
                        </form>
     
                        
                        
                        <nav aria-label="Page navigation" class="pull-right">
                            <ul class="pagination" style="margin-top: 10px;">
   
                                <c:if test="${pb.currentPage == 1}">
				                    <li class="disabled">
				                </c:if>
				
				                <c:if test="${pb.currentPage != 1}">
				                    <li>
				                </c:if>
				
				                    <a href="${pageContext.request.contextPath}/student?method=findAll&currentPage=${pb.currentPage - 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
				                        <span aria-hidden="true">&laquo;</span>
				                    </a>
				                    </li>
				
				                <c:forEach begin="1" end="${pb.totalPage}" var="i" >
				
				                    <c:if test="${pb.currentPage == i}">
				                        <li class="active"><a href="${pageContext.request.contextPath}/student?method=findAll&currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
				                    </c:if>
				                    <c:if test="${pb.currentPage != i}">
				                        <li><a href="${pageContext.request.contextPath}/student?method=findAll&currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
				                    </c:if>
				
				                </c:forEach>
				
				                <li>
				                    <a href="${pageContext.request.contextPath}/student?method=findAll&currentPage=${pb.currentPage + 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
				                        <span aria-hidden="true">&raquo;</span>
				                    </a>
				                </li>
				                <span style="font-size: 25px;margin-left: 5px;">
				                    	共${pb.totalCount}条记录，共${pb.totalPage}页
				                </span>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
 
        </div>
    </div>

</body>
</html>