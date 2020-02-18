<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<div>
	<h3>Willkommen!</h3>Was moechtest du tun?
</div>
<div>
	<table>
		<c:forEach var="eintrag" items="${menue}">
			<c:if test="${eintrag ==  'Einzelfahrkarte kaufen'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "4">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  '10er Streifenkarte kaufen'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "5">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'TagesTicket Plus kaufen'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "6">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  '4er Ticket kaufen'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "7">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Ferienticket kaufen'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "8">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Wochenkarte'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "1">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Monatskarte'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "2">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Jahreskarte'}">
				<tr><td>
						<form action="<c:url value ='/zahlen.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "3">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
			<c:if test="${eintrag ==  'Zeitkarte kaufen'}">
				<tr><td>
						<form action="<c:url value ='/menue.do'/>" method="post">
						<input type="hidden" name = "auswahl" value = "9">
						<button type="submit"><c:out value="${eintrag}"></c:out></button>
						</form>
					</td></tr>
			</c:if>
		</c:forEach>
	</table>
</div>