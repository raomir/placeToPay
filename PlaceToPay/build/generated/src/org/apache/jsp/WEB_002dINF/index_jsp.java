package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/../WEB-INF/css.jsp");
    _jspx_dependants.add("/WEB-INF/../WEB-INF/js.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"hola card\">\n");
      out.write("        <form class=\"card-header card-title\" action=\"nuevo\">\n");
      out.write("            <button type=\"enviar\" class=\"btn btn-primary\" >Nueva Transferencia</button>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("            <table class=\"table\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">RequesId</th>\n");
      out.write("                    <th scope=\"col\">Nombre</th>\n");
      out.write("                    <th scope=\"col\">CC</th>\n");
      out.write("                    <th scope=\"col\">Total</th>\n");
      out.write("                    <th scope=\"col\">Status</th>\n");
      out.write("                    <th scope=\"col\">Mensaje</th>\n");
      out.write("                    <th scope=\"col\">Fecha</th>\n");
      out.write("                    <th scope=\"col\">Reason</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody> \n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"row\"></th>\n");
      out.write("                    <td>Mark</td>\n");
      out.write("                    <td>Otto</td>\n");
      out.write("                    <td>@mdo</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("\t<script src=\"styles/bootstrap4/popper.js\"></script>\n");
      out.write("\t<script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/greensock/TweenMax.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/greensock/TimelineMax.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/scrollmagic/ScrollMagic.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/greensock/animation.gsap.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/greensock/ScrollToPlugin.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n");
      out.write("\t<script src=\"plugins/scrollTo/jquery.scrollTo.min.js\"></script>\n");
      out.write("\t<script src=\"plugins/easing/easing.js\"></script>\n");
      out.write("\t<script src=\"js/custom.js\"></script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
