/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.64
 * Generated at: 2022-11-09 07:29:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class findIdPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/template/footer.jsp", Long.valueOf(1667795532121L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1654647991285L));
    _jspx_dependants.put("jar:file:/C:/sevenfactory/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/sevenfactory_project/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- 동적인 페이지 포함 -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/template/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("아이디 찾기", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("	 \n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("   \n");
      out.write("   var authKey = \"\";\n");
      out.write("   var mId = \"\";\n");
      out.write("   // AJAX 를 통해 아이디를 찾는다.\n");
      out.write("   $(document).ready(function(){\n");
      out.write("      $('#findIdBtn').click(function(){\n");
      out.write("         $.ajax({\n");
      out.write("            url: 'findId',\n");
      out.write("            type: 'POST',\n");
      out.write("            dataType: 'json',\n");
      out.write("            data: 'mName=' + $('#mName').val() + '&mEmail=' + $('#mEmail').val(),\n");
      out.write("            success: function(data) {\n");
      out.write("               if ( data.result != \"NO\" ) {\n");
      out.write("                  \n");
      out.write("                     mId = data.result;\n");
      out.write("                  \n");
      out.write("                  $.ajax({\n");
      out.write("                     url : 'emailAuth',\n");
      out.write("                     type : 'POST',\n");
      out.write("                     dataType : 'json',\n");
      out.write("                     data : 'mEmail=' + $('#mEmail').val(),\n");
      out.write("                     success : function(data) {\n");
      out.write("                           alert('인증번호를 발송했습니다.');\n");
      out.write("                           authKey = data.authKey;\n");
      out.write("                     },\n");
      out.write("                     error : function() {\n");
      out.write("                        alert('AJAX 통신이 실패했습니다.');\n");
      out.write("                     }\n");
      out.write("                  });\n");
      out.write("               } else {\n");
      out.write("                  alert('일치하는 이메일 정보가 없습니다. 다시 작성해 주세요.');\n");
      out.write("               }\n");
      out.write("            },\n");
      out.write("            error: function() {\n");
      out.write("               alert('AJAX 통신이 실패했습니다.');\n");
      out.write("            }\n");
      out.write("         });\n");
      out.write("      });\n");
      out.write("         \n");
      out.write("      $('#realFindIdBtn').click(function(){\n");
      out.write("\n");
      out.write("         if ($('#authKey').val() == authKey && authKey != \"\") {\n");
      out.write("            alert('인증되었습니다.');\n");
      out.write("               $('#findIdResult').text(mId);\n");
      out.write("         }else if(mId == \"\"){\n");
      out.write("            alert('이메일인증을 진행하세요.');\n");
      out.write("         }\n");
      out.write("         else {\n");
      out.write("            alert('인증번호를 확인하세요.');\n");
      out.write("         }\n");
      out.write("         \n");
      out.write("      });\n");
      out.write("   \n");
      out.write("   \n");
      out.write("   });\n");
      out.write("   \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("   .find-id-box {width: 1000px; margin: 250px auto 50px; }\n");
      out.write("   .find-id-box #bold {font-weight: bold; font-size: 14px;}\n");
      out.write("   .find-id-box #nobold{font-size: 12px; margin: 0;}\n");
      out.write("   .find-id-box #tableon {font-size: 12px; font-weight: bold; color: gray; padding-left: 10px;}\n");
      out.write("   .find-id-box table {width: 1000px; border-collapse: collapse; border-bottom: 1px solid black; border-top: 1px solid black; }\n");
      out.write("   .find-id-box table tr td {padding: 15px 15px;}\n");
      out.write("   .find-id-box table tr td:nth-of-type(1) {text-align: center; font-weight: bold; background: #F9F9F9; width: 200px; font-size: 14px;} \n");
      out.write("   .find-id-box table tr:nth-of-type(2) td, .find-id-box table tr:nth-of-type(1) td {border-bottom: 1px solid lightgray;}\n");
      out.write("   .find-id-box table input[type=text] {width: 300px; padding: 3px 10px; border: 1px solid lightgray; }\n");
      out.write("   .find-id-box table input[type=text]:hover, .find-id-box table input[type=text]:focus {outline: none;}\n");
      out.write("   .find-id-box table input[type=button] {padding: 3px; width: 120px; background-color: darkgray; color: white; font-weight: bold; border: none;}\n");
      out.write("   .find-id-box table input[type=button]:hover,  .find-id-box table input[type=button]:focus {outline: none;}\n");
      out.write("   #findIdResult {display: inline-block; padding-left: 20px; color:red;}\n");
      out.write("   .btnbox {width: 1000px; text-align: center;}\n");
      out.write("   #findPwBtn {width: 190px; padding: 7px 10px; border: none; background-color: darkgray; color:white; margin-top: 30px;}\n");
      out.write("   #findPwBtn:hover {outline: none; background-color: #353535;}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<div class=\"find-id-box\">\n");
      out.write("\n");
      out.write("   <p id=\"bold\">아이디 찾기</p>\n");
      out.write("   <hr id=\"line\"/>\n");
      out.write("   <p id=\"nobold\">회원가입 시, 입력하신 회원정보 또는 본인인증으로 아이디를 확인할 수 있습니다.<p>\n");
      out.write("   <p id=\"nobold\">인증번호는 가입 시 적어주신 이메일로 보내드립니다.<p>\n");
      out.write("   <form method=\"POST\">\n");
      out.write("      <br/><p id=\"tableon\">  본인확인용 정보로 찾기</p>  \n");
      out.write("      <table>\n");
      out.write("         <tr>\n");
      out.write("            <td>이 름</td>\n");
      out.write("            <td> <input class=\"findId-text\" id=\"mName\" type=\"text\" name=\"mName\" autofocus /></td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>이메일</td>\n");
      out.write("            <td>\n");
      out.write("               <input class=\"findId-text\" id=\"mEmail\" type=\"text\" name=\"mEmail\"/>\n");
      out.write("               <input id=\"findIdBtn\" type=\"button\" value=\"인증번호 받기\" />\n");
      out.write("            </td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>인증번호 입력</td>\n");
      out.write("            <td>\n");
      out.write("               <input id=\"authKey\" type=\"text\" name=\"authKey\" />\n");
      out.write("               <input id=\"realFindIdBtn\" type=\"button\" value=\"아이디 찾기\" />\n");
      out.write("             <div id=\"findIdResult\"></div>  <!-- AJAX 처리 결과가 나타나는 위치이다. -->                  \n");
      out.write("            </td>\n");
      out.write("         </tr>\n");
      out.write("         \n");
      out.write("      </table>\n");
      out.write("      <div class=\"btnbox\">\n");
      out.write("         <input id=\"findPwBtn\"  type=\"button\" value=\"비밀번호 찾기\" onclick=\"location.href='findPwPage'\"/>\n");
      out.write("      </div>\n");
      out.write("      <br/><br/>\n");
      out.write("   </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- 정적인 페이지 포함 -->\n");
      out.write("\n");
      out.write("<style>\n");
      out.write(".fa-2x {\n");
      out.write("	font-size: 13px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("	src=\"https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=wkmpm92bc1&submodules=geocoder\">\n");
      out.write("	\n");
      out.write("</script>\n");
      out.write("<div>\n");
      out.write("	<div class=\"footer\">\n");
      out.write("		<ul class=\"footer_menu\">\n");
      out.write("			<li>이용약관</li>\n");
      out.write("			<li>개인정보보호정책</li>\n");
      out.write("			<li>이메일 무단 수집 금지</li>\n");
      out.write("			<li>영상정보처리기기 설치 및 운영방침</li>\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("		</ul>\n");
      out.write("		<ul class=\"company_info\">\n");
      out.write("			<li>우편번호 : 24901</li>\n");
      out.write("			<li>주소 : 대전광역시 서구 대덕대로 182 오라클빌딩 10층</li>\n");
      out.write("			<li>전화번호 : 02-313-7300</li>\n");
      out.write("			<li>팩스번호 : 02-313-0516</li>\n");
      out.write("			<li>이메일 : admin@sevenfactory.com</li>\n");
      out.write("		</ul>\n");
      out.write("		<ul class=\"company_info\">\n");
      out.write("			<li>사업체명 : sevenfactory</li>\n");
      out.write("			<li>대표자 : 강현 김승현 송인재 송지섭</li>\n");
      out.write("			<li>사업자등록번호 : 325-88-00678</li>\n");
      out.write("			<li>통신판매신고번호 : 2022-대전둔산-03148호</li>\n");
      out.write("		</ul>\n");
      out.write("		<p>Copyright © 2022 OsjMesiJJe inc. All rights reserved.</p>\n");
      out.write("	</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/template/footer.jsp(22,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginDTO eq null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("				<a id=\"loginout\" href=\"sellerLoginform\"><i\n");
          out.write("					class=\"fas fa-sign-in-alt fa-2x\">사업자LOGIN</i></a>\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}