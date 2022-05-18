<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="domain.Zonglan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>检测信息总览</title>
 	<script type="text/javascript" src="lhgcalendar/lhgcore.js"></script>
	<script type="text/javascript" src="lhgcalendar/lhgcalendar.js"></script>
	<script type="text/javascript" src="showDialog.js"></script>
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
                location.href="${pageContext.request.contextPath}/classno?method=delClassNo&id="+id;
            }
        }

        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelectedClassNo").onclick = function(){
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
                var cbs = document.getElementsByName("id");
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
            <a href="#" class="navbar-brand">告警信息管理</a>
        </div>
        <ul class="nav navbar-nav navbar-right" style="margin-right: 25px">
            <li><a href="${pageContext.request.contextPath}/user?method=findUser&id=${user.id}"><span class="badge" style="background: #C12E2A">${user.username}</span></a></li>
            <li><a href="${pageContext.request.contextPath}/user?method=destroyUser"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
        </ul>
 
        <!-- 侧边栏  -->
        <div class="navbar-default navbar-collapse" id="slider_sub">
            <ul class="nav">
                <li>

			        <form class="form-inline" action="${pageContext.request.contextPath}/classno?method=addClassNo" method="post">
			            
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
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;学生管理</a></li>
                    </ul> -->
                </li>
                <li><a href="${pageContext.request.contextPath}/student?method=findAll"  class="collapse" data-toggle="collapse">服务器状态<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
                <li><a href="${pageContext.request.contextPath}/classno?method=findAll"  class="collapse" data-toggle="collapse">告警信息<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                    
                </li>
<%--                 <li><a href="${pageContext.request.contextPath}/course?method=findAll"  class="collapse" data-toggle="collapse">备份检查<span class="glyphicon glyphicon-chevron-right pull-right"></span></a> --%>
                    
<!--                 </li> -->
<%--                 <li><a href="${pageContext.request.contextPath}/about.jsp"  class="collapse" data-toggle="collapse">运维流程<span class="glyphicon glyphicon-chevron-right pull-right"></span></a> --%>
                    
                </li>
            </ul>
        </div>
    </nav>
 
    <!-- 主区域 -->
    <div class="page_main" style="background: rgba(92,88,116,0.34)">
        <ol class="breadcrumb">
            <li><a href="#">运维</a></li>
            <li><a href="#">检测</a></li>
            <li><a href="#">检测信息总览</a></li>
        </ol>
 
        <div class="row">
            <div class="col-md-12 col-sm-3">
                <div class="panel panel-default">
                    <!-- <div class="panel-header">班级信息</div> -->
                    
                    <div class="panel-body table-responsive">
<Script Language="JavaScript"> 
    function find() 
    { 
    document.form1.action="${pageContext.request.contextPath}/classno?method=addClassNo"; 
    document.form1.submit(); 
    } 
     
    function export1() 
    { 
    document.form1.action="${pageContext.request.contextPath}/classno?method=export"; 
    document.form1.submit(); 
    } 
</Script>          
				<form name="form1" action="" method="post">
				    <div style="float: right;margin: 5px;">
				<td style="text-align: right">项目名称：</td>
				<td style="text-align: lieft"><input type="text" src=""
				<%if (request.getParameter("name") != null && !"".equals(request.getParameter("name")) && !"null".equals(request.getParameter("name"))){ %>	value = <%=request.getParameter("name")%><%}%>	name="name" /></td>
			

			
				<td style="text-align: right">服务器ip：</td>
				<td style="text-align: lieft"><input type="text" src=""
				<%if (request.getParameter("hostid") != null && !"".equals(request.getParameter("hostid")) && !"null".equals(request.getParameter("hostid"))){ %>	value = <%=request.getParameter("hostid")%><%}%>	name="hostid" /></td>
				        <input class="btn btn-primary" href="${pageContext.request.contextPath}/classno?method=findAll" type ="submit" value = 查询 onClick="find()"></input>
			            <input class="btn btn-primary" href="${pageContext.request.contextPath}/classno?method=export" type ="submit" value = 导出 onClick="export1()"></input>
				    </div>
				    <%  System.out.println(request.getParameter("name")); %>
                 </form>   
                    <form id="form" action="${pageContext.request.contextPath}/classno?method=delSelectedClassNo" method="post">
                        <table class="table table-striped table-hover" style="margin: 10px;">
                            <thead>
	                            <tr>
	                            	<th hidden="hidden"><input type="checkbox" id="firstCb"></th>
	                            	<th>项目</th>
	                                <th>服务器</th>
	                                <th>部署服务</th>
	                                <th>部署路径</th>
	                                <th>启动方式</th>
	                                <th hidden="hidden">详情</th>
	                                
	                            </tr>
                         </thead>
<script type="text/javascript"> 
  function func1(xiangqing){
	//location.href="${pageContext.request.contextPath}/classno?method=delClassNo&id="+id;
	
	  alert(xiangqing);
  }
</script> 
<script type="text/javascript"> 
  function func(id){
	location.href="${pageContext.request.contextPath}/classno?method=delClassNo&id="+id;
  }
</script> 



                            <c:forEach items="${pb.list}" var="Zonglan" varStatus="s">
					            <tr>
					            
					                <td hidden="hidden"><input type="checkbox" name="id" value="${Zonglan.itemid}"></td>
					                <td hidden="hidden">${Zonglan.itemid}</td>
					                <td>${Zonglan.pro}</td> 
					                <td>${Zonglan.ho}</td>
					                <td>${Zonglan.bushu}</td>
					                <td>${Zonglan.lujing}</td>
					                <td>${Zonglan.qidong}</td>
					                <td hidden="hidden">${Zonglan.xiangqing}</td>
                                    <td><a class="btn btn-default btn-sm" onclick="func1(&quot;${Zonglan.xiangqing}&quot;)">详情</a>
					                <a class="btn btn-default btn-sm" onclick="func(&quot;${Zonglan.itemid}&quot;)">修改</a></td>
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
				
				                    <a href="${pageContext.request.contextPath}/classno?method=addClassNo&currentPage=${pb.currentPage - 1}&name=<%=request.getParameter("name")%>&hostid=<%=request.getParameter("hostid")%>&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
				                        <span aria-hidden="true">&laquo;</span>
				                    </a>
				                    </li>
				
				                <c:forEach begin="1" end="${pb.totalPage}" var="i" >
				
				                    <c:if test="${pb.currentPage == i}">
				                        <li class="active"><a href="${pageContext.request.contextPath}/classno?method=addClassNo&currentPage=${i}&name=<%=request.getParameter("name")%>&hostid=<%=request.getParameter("hostid")%>&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
				                    </c:if>
				                    <c:if test="${pb.currentPage != i}">
				                        <li><a href="${pageContext.request.contextPath}/classno?method=addClassNo&currentPage=${i}&name=<%=request.getParameter("name")%>&hostid=<%=request.getParameter("hostid")%>&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
				                    </c:if>
				
				                </c:forEach>
				
				                <li>
				                    <a href="${pageContext.request.contextPath}/classno?method=addClassNol&currentPage=${pb.currentPage + 1}&name=<%=request.getParameter("name")%>&hostid=<%=request.getParameter("hostid")%>&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
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