package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.poi.util.SystemOutLogger;
import domain.Zonglan;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>检测信息总览</title>\r\n");
      out.write(" \t<script type=\"text/javascript\" src=\"lhgcalendar/lhgcore.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"lhgcalendar/lhgcalendar.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"showDialog.js\"></script>\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("\t<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("\t<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        @media (min-width: 768px) {\r\n");
      out.write("           #slider_sub{\r\n");
      out.write("               width: 200px;\r\n");
      out.write("               margin-top: 51px;\r\n");
      out.write("               position: absolute;\r\n");
      out.write("               z-index: 1;\r\n");
      out.write("               height: 900px;\r\n");
      out.write("           }\r\n");
      out.write("            .mysearch{\r\n");
      out.write("                margin: 10px 0;\r\n");
      out.write("            }\r\n");
      out.write("            .page_main{\r\n");
      out.write("                margin-left: 205px;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        function deleteStudent(id){\r\n");
      out.write("            //用户安全提示\r\n");
      out.write("            if(confirm(\"您确定要删除吗？\")){\r\n");
      out.write("                //访问路径\r\n");
      out.write("                location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=delClassNo&id=\"+id;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        window.onload = function(){\r\n");
      out.write("            //给删除选中按钮添加单击事件\r\n");
      out.write("            document.getElementById(\"delSelectedClassNo\").onclick = function(){\r\n");
      out.write("                if(confirm(\"您确定要删除选中条目吗？\")){\r\n");
      out.write("\r\n");
      out.write("                   var flag = false;\r\n");
      out.write("                    //判断是否有选中条目\r\n");
      out.write("                    var cbs = document.getElementsByName(\"id\");\r\n");
      out.write("                    for (var i = 0; i < cbs.length; i++) {\r\n");
      out.write("                        if(cbs[i].checked){\r\n");
      out.write("                            //有一个条目选中了\r\n");
      out.write("                            flag = true;\r\n");
      out.write("                            break;\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    if(flag){//有条目被选中\r\n");
      out.write("                        //表单提交\r\n");
      out.write("                        document.getElementById(\"form\").submit();\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            //1.获取第一个cb\r\n");
      out.write("            document.getElementById(\"firstCb\").onclick = function(){\r\n");
      out.write("                //2.获取下边列表中所有的cb\r\n");
      out.write("                var cbs = document.getElementsByName(\"id\");\r\n");
      out.write("                //3.遍历\r\n");
      out.write("                for (var i = 0; i < cbs.length; i++) {\r\n");
      out.write("                    //4.设置这些cbs[i]的checked状态 = firstCb.checked\r\n");
      out.write("                    cbs[i].checked = this.checked;\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"navbar navbar-default navbar-static-top\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <!--缩放 -->\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#slider_sub\">\r\n");
      out.write("                <span class=\"sr-only\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a href=\"#\" class=\"navbar-brand\">告警信息管理</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right\" style=\"margin-right: 25px\">\r\n");
      out.write("            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user?method=findUser&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"><span class=\"badge\" style=\"background: #C12E2A\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span></a></li>\r\n");
      out.write("            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user?method=destroyUser\"><span class=\"glyphicon glyphicon-off\"></span>&nbsp;注销</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write(" \r\n");
      out.write("        <!-- 侧边栏  -->\r\n");
      out.write("        <div class=\"navbar-default navbar-collapse\" id=\"slider_sub\">\r\n");
      out.write("            <ul class=\"nav\">\r\n");
      out.write("                <li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t        <form class=\"form-inline\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=addClassNo\" method=\"post\">\r\n");
      out.write("\t\t\t            \r\n");
      out.write("\t\t\t            <!--搜索 -->\r\n");
      out.write("\t                    <div class=\"input-group mysearch\">\r\n");
      out.write("\t                        <input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.name[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"form-control\" id=\"exampleInputName2\" >\r\n");
      out.write("\t                        <span class=\"input-group-btn\">\r\n");
      out.write("\t                            <button type=\"submit\" class=\"btn btn-default\">\r\n");
      out.write("\t                                <span class=\"glyphicon glyphicon-search\"></span>\r\n");
      out.write("\t                            </button>\r\n");
      out.write("\t                        </span>\r\n");
      out.write("\t \r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t\t\t        </form>\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=addClassNo\" class=\"collapse\" data-toggle=\"collapse\">监测信息总览<span class=\"glyphicon glyphicon-chevron-right pull-right\"></span></a>\r\n");
      out.write("                     <!-- <ul id=\"sub2\" class=\"nav collapse\">\r\n");
      out.write("                        <li><a href=\"#\"><span class=\"glyphicon glyphicon-info-sign\"></span>&nbsp;信息管理</a></li>\r\n");
      out.write("                        <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span>&nbsp;学生管理</a></li>\r\n");
      out.write("                    </ul> -->\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/student?method=findAll\"  class=\"collapse\" data-toggle=\"collapse\">服务器状态<span class=\"glyphicon glyphicon-chevron-right pull-right\"></span></a>\r\n");
      out.write("                    \r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=findAll\"  class=\"collapse\" data-toggle=\"collapse\">告警信息<span class=\"glyphicon glyphicon-chevron-right pull-right\"></span></a>\r\n");
      out.write("                    \r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("<!--                 </li> -->\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write(" \r\n");
      out.write("    <!-- 主区域 -->\r\n");
      out.write("    <div class=\"page_main\" style=\"background: rgba(92,88,116,0.34)\">\r\n");
      out.write("        <ol class=\"breadcrumb\">\r\n");
      out.write("            <li><a href=\"#\">运维</a></li>\r\n");
      out.write("            <li><a href=\"#\">检测</a></li>\r\n");
      out.write("            <li><a href=\"#\">检测信息总览</a></li>\r\n");
      out.write("        </ol>\r\n");
      out.write(" \r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12 col-sm-3\">\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <!-- <div class=\"panel-header\">班级信息</div> -->\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"panel-body table-responsive\">\r\n");
      out.write("<Script Language=\"JavaScript\"> \r\n");
      out.write("    function find() \r\n");
      out.write("    { \r\n");
      out.write("    document.form1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=addClassNo\"; \r\n");
      out.write("    document.form1.submit(); \r\n");
      out.write("    } \r\n");
      out.write("     \r\n");
      out.write("    function export1() \r\n");
      out.write("    { \r\n");
      out.write("    document.form1.action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=export\"; \r\n");
      out.write("    document.form1.submit(); \r\n");
      out.write("    } \r\n");
      out.write("</Script>          \r\n");
      out.write("\t\t\t\t<form name=\"form1\" action=\"\" method=\"post\">\r\n");
      out.write("\t\t\t\t    <div style=\"float: right;margin: 5px;\">\r\n");
      out.write("\t\t\t\t<td style=\"text-align: right\">项目名称：</td>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: lieft\"><input type=\"text\" src=\"\"\r\n");
      out.write("\t\t\t\t");
if (request.getParameter("name") != null && !"".equals(request.getParameter("name")) && !"null".equals(request.getParameter("name"))){ 
      out.write("\tvalue = ");
      out.print(request.getParameter("name"));
}
      out.write("\tname=\"name\" /></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<td style=\"text-align: right\">服务器ip：</td>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: lieft\"><input type=\"text\" src=\"\"\r\n");
      out.write("\t\t\t\t");
if (request.getParameter("hostid") != null && !"".equals(request.getParameter("hostid")) && !"null".equals(request.getParameter("hostid"))){ 
      out.write("\tvalue = ");
      out.print(request.getParameter("hostid"));
}
      out.write("\tname=\"hostid\" /></td>\r\n");
      out.write("\t\t\t\t        <input class=\"btn btn-primary\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=findAll\" type =\"submit\" value = 查询 onClick=\"find()\"></input>\r\n");
      out.write("\t\t\t            <input class=\"btn btn-primary\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=export\" type =\"submit\" value = 导出 onClick=\"export1()\"></input>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t    ");
  System.out.println(request.getParameter("name")); 
      out.write("\r\n");
      out.write("                 </form>   \r\n");
      out.write("                    <form id=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=delSelectedClassNo\" method=\"post\">\r\n");
      out.write("                        <table class=\"table table-striped table-hover\" style=\"margin: 10px;\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("\t                            <tr>\r\n");
      out.write("\t                            \t<th hidden=\"hidden\"><input type=\"checkbox\" id=\"firstCb\"></th>\r\n");
      out.write("\t                            \t<th>项目</th>\r\n");
      out.write("\t                                <th>服务器</th>\r\n");
      out.write("\t                                <th>部署服务</th>\r\n");
      out.write("\t                                <th>部署路径</th>\r\n");
      out.write("\t                                <th>启动方式</th>\r\n");
      out.write("\t                                <th hidden=\"hidden\">详情</th>\r\n");
      out.write("\t                                \r\n");
      out.write("\t                            </tr>\r\n");
      out.write("                         </thead>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("  function func1(xiangqing){\r\n");
      out.write("\t//location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=delClassNo&id=\"+id;\r\n");
      out.write("\t\r\n");
      out.write("\t  alert(xiangqing);\r\n");
      out.write("  }\r\n");
      out.write("</script> \r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("  function func(id){\r\n");
      out.write("\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=delClassNo&id=\"+id;\r\n");
      out.write("  }\r\n");
      out.write("</script> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </table>\r\n");
      out.write("                        </form>\r\n");
      out.write("             \r\n");
      out.write("                        <nav aria-label=\"Page navigation\" class=\"pull-right\">\r\n");
      out.write("                            <ul class=\"pagination\" style=\"margin-top: 10px;\">\r\n");
      out.write("   \r\n");
      out.write("                                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t                ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=addClassNo&currentPage=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage - 1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&name=");
      out.print(request.getParameter("name"));
      out.write("&hostid=");
      out.print(request.getParameter("hostid"));
      out.write("&rows=10&name=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.name[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&address=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.address[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&email=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.email[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" aria-label=\"Previous\">\r\n");
      out.write("\t\t\t\t                        <span aria-hidden=\"true\">&laquo;</span>\r\n");
      out.write("\t\t\t\t                    </a>\r\n");
      out.write("\t\t\t\t                    </li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /index.jsp(258,20) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setBegin(1);
      // /index.jsp(258,20) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.totalPage}", java.lang.Integer.class, (PageContext)_jspx_page_context, null, false)).intValue());
      // /index.jsp(258,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("i");
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\r\n");
            out.write("\t\t\t\t                    ");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
            // /index.jsp(260,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage == i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
            if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t                        <li class=\"active\"><a href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/classno?method=addClassNo&currentPage=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&name=");
                out.print(request.getParameter("name"));
                out.write("&hostid=");
                out.print(request.getParameter("hostid"));
                out.write("&rows=10&name=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.name[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&address=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.address[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&email=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.email[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write('"');
                out.write('>');
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</a></li>\r\n");
                out.write("\t\t\t\t                    ");
                int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
            out.write("\r\n");
            out.write("\t\t\t\t                    ");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
            // /index.jsp(263,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage != i}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
            if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t                        <li><a href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/classno?method=addClassNo&currentPage=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&name=");
                out.print(request.getParameter("name"));
                out.write("&hostid=");
                out.print(request.getParameter("hostid"));
                out.write("&rows=10&name=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.name[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&address=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.address[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("&email=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.email[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write('"');
                out.write('>');
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</a></li>\r\n");
                out.write("\t\t\t\t                    ");
                int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
            out.write("\r\n");
            out.write("\t\t\t\t\r\n");
            out.write("\t\t\t\t                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t                <li>\r\n");
      out.write("\t\t\t\t                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/classno?method=addClassNol&currentPage=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&name=");
      out.print(request.getParameter("name"));
      out.write("&hostid=");
      out.print(request.getParameter("hostid"));
      out.write("&rows=10&name=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.name[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&address=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.address[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&email=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition.email[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" aria-label=\"Next\">\r\n");
      out.write("\t\t\t\t                        <span aria-hidden=\"true\">&raquo;</span>\r\n");
      out.write("\t\t\t\t                    </a>\r\n");
      out.write("\t\t\t\t                </li>\r\n");
      out.write("\t\t\t\t                <span style=\"font-size: 25px;margin-left: 5px;\">\r\n");
      out.write("\t\t\t\t                    \t共");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.totalCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("条记录，共");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.totalPage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("页\r\n");
      out.write("\t\t\t\t                </span>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write(" \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /index.jsp(222,28) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/index.jsp(222,28) '${pb.list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pb.list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /index.jsp(222,28) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("Zonglan");
    // /index.jsp(222,28) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("s");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t            <tr>\r\n");
          out.write("\t\t\t\t\t            \r\n");
          out.write("\t\t\t\t\t                <td hidden=\"hidden\"><input type=\"checkbox\" name=\"id\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.itemid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></td>\r\n");
          out.write("\t\t\t\t\t                <td hidden=\"hidden\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.itemid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.pro}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td> \r\n");
          out.write("\t\t\t\t\t                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.ho}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.bushu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.lujing}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.qidong}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t                <td hidden=\"hidden\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.xiangqing}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                                    <td><a class=\"btn btn-default btn-sm\" onclick=\"func1(&quot;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.xiangqing}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&quot;)\">详情</a>\r\n");
          out.write("\t\t\t\t\t                <a class=\"btn btn-default btn-sm\" onclick=\"func(&quot;");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Zonglan.itemid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&quot;)\">修改</a></td>\r\n");
          out.write("\t\t\t\t\t            </tr>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /index.jsp(245,32) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t                    <li class=\"disabled\">\r\n");
        out.write("\t\t\t\t                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /index.jsp(249,20) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pb.currentPage != 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t                    <li>\r\n");
        out.write("\t\t\t\t                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
