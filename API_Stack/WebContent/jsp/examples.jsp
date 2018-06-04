<%@page import="com.edu.nju.model.Example"%>
<%@page import="com.edu.nju.dao.Dao"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>  
<%@page import="org.springframework.context.ApplicationContext"%>  
<%@ include file="header.jsp" %>

	<div class="contentBoard">
		<div class="mainContent" id="examplesBoard">
			<%
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()); 
				Dao dao = (Dao)(ctx.getBean("dao"));
				java.util.List<Example> examples = dao.getExample((int)(session.getAttribute("mid")));
				for (int i=0; i<examples.size(); i++) {
					Example e = examples.get(i);
					out.println("<div class='exampleBoard panel panel-info'>");
						out.println("<div class='exampleHeader panel-heading'>Example " + i+1 + "</div>");
						out.println("<div class='exampleContent panel-body'>");
						for (String code:e.getCodeList()) {
							out.println("<div class='codeFrag'><row>" + code.replaceAll("  ", "&emsp;").replaceAll("(\r\n|\r|\n|\n\r)", "</row><row>") + "</row></div>");
						}
						out.println("</div>");
						out.println("<div class='exampleFooter panel-footer'></div>");
					out.println("</div>");
				}
				out.println("<script>highlightRender();</script>");
				session.removeAttribute("mid");
			%>
		</div>
	</div>
	
</body></html>