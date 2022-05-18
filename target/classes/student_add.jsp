<%@page import="cn.ybzy.mvcproject.model.XiangQing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%XiangQing xiangQing = new XiangQing(); %>
<head>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/ueditor.config.js"></script>    
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/ueditor.all.min.js"> </script>    
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/e/lang/zh-cn/zh-cn.js"></script>
</head>
  <title>检测总览信息修改</title>   
  <%xiangQing = (XiangQing) request.getAttribute("xiangQings"); %>

  <script type="text/javascript"> 
  window.onload = function(){
	  
	  document.getElementById("bu1").click();
  }
  </script>
  

<script type="text/javascript">  
var ue = UE.getEditor('content');

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

<button  id="bu1" onclick="setContent(&quot;<%=xiangQing.getXiangqing() %>&quot;)">显示详情</button>
 <div>
     <form action="${pageContext.request.contextPath}/classno?method=updateZonglan" method="post" > 
     <table cellspacing=0 border=1 class="mainTable">
        <caption>
            <h1>检测总览信息修改</h1>
        </caption>
       
        <tr>
            <td width="10%" class="titleBc">项目</td>
            <td > <%=xiangQing.getPro()%></td>
            <td class="titleBc">服务器</td>
            <td class="titleBc"><%=xiangQing.getHo()%></td>
        </tr>
        <tr>
            <td class="titleBc">部署服务</td>
            <td colspan="3"><%=xiangQing.getBushu() %></td>
        </tr>
        <tr>
            <td class="titleBc">部署路径</td>
            <td colspan="3"><input value=<%=xiangQing.getLujing() %>  style="width: 800px; type="text" class="form-control" id="credit" name="lujing" /></td>
        </tr>
        <tr hidden="hidden">
        <td class="titleBc">id</td>
        <td colspan="3"><input value=<%=xiangQing.getItemid() %>  style="width: 800px; type="text" class="form-control" id="credit" name="itemid" /></td>
        </tr>
        <tr>
            <td class="titleBc">启动方式</td>
            <td colspan="3"><input value=<%=xiangQing.getQidong() %>   style="width: 800px;  type="text" class="form-control" id="credit" name="qidong"/> <tr>  
                <td>详情</td>
                <td colspan="3"><textarea name="content" id="content" style="width: 800px; height: 400px; margin: 0 auto;"></textarea></td>  
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