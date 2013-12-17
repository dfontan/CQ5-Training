<%--

  Contextual Footer component.

--%><%
%><%@include file="/libs/foundation/global.jsp"%>
<%@page import="com.accenture.cq5.ContextualFooter" %>
<%
	ContextualFooter footer = new ContextualFooter(currentPage, currentStyle);
	pageContext.setAttribute("footer",footer);
%>
<footer>
    <nav>
    	<c:forEach var="navPage" items="${footer.footerPages }">
    		<div>
    			<a href="${navPage.url }.html">${navPage.title }</a>
    		</div>
    	</c:forEach>      
    </nav>
    <div>
    	<p>${footer.disclaimerText }</p>
    </div>
</footer>