<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<div>
Willkommen!<br>Was moechtest du tun?
</div>
<div>
	<table>
		<c:forEach var="eintrag" items="${menue}">
			<c:if test="${eintrag != 'Zeitkarte kaufen'}">
			<tr><td>
				<form action="<c:url value ='/zahlen.do'/>" method="post">
				<button type="submit"><c:out value="${eintrag}"></c:out></button>
				</form>
			</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Zeitkarte kaufen'}">
				<tr><td>
						<form action="<c:url value ='/menue.do'/>" method="post">
						<input type="hidden" name = "untermenue" value = "1">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
		</c:forEach>
	</table>
</div>