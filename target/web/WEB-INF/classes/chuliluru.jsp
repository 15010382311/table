<%@page import="cn.ybzy.mvcproject.model.ClassNo1"%>
<%@page import="cn.ybzy.mvcproject.model.XiangQing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%ClassNo1 xiangQing = new ClassNo1(); %>
<head>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/ueditor.config.js"></script>    
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/ueditor.all.min.js"> </script>    
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/lang/zh-cn/zh-cn.js"></script>
</head>
  <title>告警处理信息录入</title>   
  <%xiangQing = (ClassNo1) request.getAttribute("classNo1"); %>

  <script type="text/javascript"> 
  window.onload = function(){
	  
	  document.getElementById("bu1").click();
  }
  </script>
  

<script type="text/javascript">  
//var ue = UE.getEditor('content');

function set() {
  alert("a")
}

function setContent(is) {
    ue.setContent(is);
  // alert(isAppendTo)
}
</script>  
<script type="text/javascript">

function ss() {
  
	confirm("确认修改？")
 
}
</script>


 <div>
     <form action="${pageContext.request.contextPath}/classno?method=updateLuruchuli" method="post" > 
     <table cellspacing=0 border=1 class="mainTable">
        <caption>
            <h1>检测总览信息修改</h1>
        </caption>
       
        <tr>
            <td width="10%" class="titleBc">告警主机</td>
            <td > <%=xiangQing.getZhuji() %></td>
            <td class="titleBc">地址</td>
            <td class="titleBc"><%=xiangQing.getDizhi() %></td>
        </tr>
        <tr>
            <td class="titleBc">告警时间</td>
            <td colspan="1"><%=xiangQing.getTime() %></td>
            <td class="titleBc">告警等级</td>
            <td colspan="3"><%=xiangQing.getDengji() %></td>
        </tr>
        <tr>
            <td class="titleBc">告警信息</td>
            <td colspan="3"><%=xiangQing.getXinxi() %></td>
        </tr>
        <tr hidden="hidden">
        <td class="titleBc">id</td>
        <td colspan="3"><input value=<%=xiangQing.getAlertid() %>  style="width: 800px; type="text" class="form-control" id="credit" name="id" /></td>
        </tr>
        <tr>
                <td>处理记录</td>
                <td colspan="3"><textarea value=<%=xiangQing.getJilu() %> name="content" id="content" style="width: 800px; height: 400px; margin: 0 auto;"><%=xiangQing.getJilu() %></textarea></td>  
            </tr>  
            
            <tr>  
                <td>添加附件</td><td><input type="file" name="file"></td>  
            </tr>  
            <tr>  
                <td colspan="3"></td>
                <td><input type="submit" value="提交" onclick="ss()"></td> 
            </tr>
    </table> 
    </form>
</div>

<style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>

</body>
</html>