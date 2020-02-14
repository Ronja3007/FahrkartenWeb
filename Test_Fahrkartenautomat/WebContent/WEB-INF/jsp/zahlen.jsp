<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<div>
	Preis: <c:out value="${preis}"></c:out>
</div>
<div>
	<table>
		<c:forEach var="eintrag" items= "zahlungsmittel">
		<tr><td> 
			<form action="<c:url value ='/zahlen.do'/>" method="post">
				<button type="submit"><c:out value="${eintrag}"></c:out></button>
			</form>
	   </td></tr>
		</c:forEach>	
	</table>
</div>