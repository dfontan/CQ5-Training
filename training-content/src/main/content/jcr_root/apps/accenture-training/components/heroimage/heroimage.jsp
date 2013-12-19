<%--

  Contextual Footer component.

--%><%
%><%@include file="/libs/foundation/global.jsp"%>
<%@page import="com.accenture.cq5.HeroImage, com.day.cq.wcm.foundation.Image" %>
<%
    HeroImage hero = new HeroImage(resource);
    pageContext.setAttribute("hero",hero);
%>
<div class="heroImage">
    <%hero.getImage().draw(out); %>
</div>