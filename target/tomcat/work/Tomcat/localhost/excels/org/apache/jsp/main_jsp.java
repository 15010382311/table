/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-04-16 23:42:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.ybzy.mvcproject.model.Tables;
import java.util.List;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<title>js</title>\r\n");
      out.write("\t\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\ttr{height: 20px;}\r\n");
      out.write("\t\t\ttd{padding: 10px; border: 1px;}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<table border=\"\" cellspacing=\"\" cellpadding=\"\">\r\n");
      out.write("\t\t<tr><td><form action=\"");
      out.print(request.getContextPath());
      out.write("/query.udo\" method=\"post\">\r\n");
      out.write("\t\t<table style=\"margin: 20px; padding: 5px; border: 1px bisque solid;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: right\">项目名称：</td>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: lieft\"><input type=\"text\" src=\"\"\r\n");
      out.write("\t\t");
if (request.getParameter("name") != null && !"".equals(request.getParameter("name"))){ 
      out.write("\tvalue = ");
      out.print(request.getParameter("name"));
}
      out.write(" , name=\"name\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: right\">服务器ip：</td>\r\n");
      out.write("\t\t\t\t<td style=\"text-align: lieft\"><input type=\"text\" src=\"\"\r\n");
      out.write("\t\t\t\t");
if (request.getParameter("hostid") != null && !"".equals(request.getParameter("hostid"))){ 
      out.write("\tvalue = ");
      out.print(request.getParameter("hostid"));
}
      out.write("\t, name=\"hostid\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tsrc=\"\" value=\"查询\" /></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form></td></tr>\r\n");
      out.write("\t\t<tr><td><table style=\"margin-left: 50px; padding: 0px;\"  border=\"5\" >\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t    <td>服务器IP</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>项目名称</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>cpu利用率</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>内存利用率</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>硬盘状态</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>首页访问状态</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>关键服务监测</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>网卡状态</td>>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
 
							List<Tables> list =(List<Tables>) request.getAttribute("userlist");
							
							if(list !=null && list.size()>0){
								for(Tables hosts :list){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t    <td>");
      out.print(hosts.getHostid());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getPro());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getCpu());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getMemory());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getDisk());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getShouye());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getService());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(hosts.getNetwork());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");
} 
		}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</table></td></tr>\r\n");
      out.write("  </table>\r\n");
      out.write("  <table border=\"\" cellspacing=\"\" cellpadding=\"\">\r\n");
      out.write("\t\t<tr><td><form action=\"");
      out.print(request.getContextPath());
      out.write("/export.udo?name=");
      out.print(request.getParameter("name"));
      out.write("&hostid=");
      out.print(request.getParameter("hostid"));
      out.write("\" method=\"post\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tsrc=\"\" value=\"导出\" /></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("  </table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
