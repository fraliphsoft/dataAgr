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
					out.println("<div class='exampleBoard'>");
						out.println("<div class='exampleHeader'>Example " + i + "</div>");
						out.println("<div class='exampleContent'>" + e.getCode() + "</div>");
						out.println("<div class='exampleFooter'></div>");
					out.println("</div>");
				}
				session.removeAttribute("mid");
			%>
		</div>
	</div>
	
</body></html>