
<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.accenture.cq5.TopNav"%>
<%
TopNav tp = new TopNav(currentPage);
pageContext.setAttribute("tp",tp);
%>
<div class="top_navigation">
	<nav>
		<c:forEach var="navNode" items="${tp.navNodes }">
			<div>${navNode.title }
				<ul>
				<c:forEach var="navChild" items="${navNode.children }">
					<li><a href="${navChild.url }.html">${navChild.title }</a></li>
				</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</nav>
</div>
<div style="clear:both"></div>
