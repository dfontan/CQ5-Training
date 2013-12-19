
<%@include file="/libs/foundation/global.jsp"%><%
%><%@ page import="com.accenture.cq5.Logo"%>
<%
Logo logo = new Logo(currentStyle);
pageContext.setAttribute("logo",logo);
%>
<div class="logoImage">
	<c:choose>
		<c:when test="${logo.noImage}">
			Logo Placeholder
		</c:when>
		<c:otherwise>
			<%logo.getLogoImage().draw(out); %>
		</c:otherwise>
	</c:choose>
</div>
<div style="clear:both"></div>
