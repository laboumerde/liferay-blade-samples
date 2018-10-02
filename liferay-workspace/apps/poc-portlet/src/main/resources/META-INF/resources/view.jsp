<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="poc.caption"/></b>
	
	<br/>Et le titre : <%= request.getAttribute("pocTest") %>
</p>