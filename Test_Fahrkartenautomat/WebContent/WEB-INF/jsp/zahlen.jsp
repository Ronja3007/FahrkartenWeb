<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<div>
<h3><c:out value="${ueberschrift} kaufen"></c:out></h3>
</div>
<div>
	Preis: <c:out value="${preis}"></c:out> Euro
</div>
<c:if test="${rueckgeldZahl == 0}">
	<div>
	Bitte "werfen" Sie ihre Muenzen/Scheine ein:<br>
		<table>
			<c:forEach var="eintrag" items= "${zahlungsmittel}">
			<tr><td> 
				<form action="<c:url value ='/einzahlen.do'/>" method="post">
					<input type="hidden" name = "preisEinzahlen" value = "${preis}">
					<input type="hidden" name = "auswahl" value = "${auswahl}">
					<input type="hidden" name = "eingezahltBetrag" value = "${eintrag}">
					<button type="submit"><c:out value="${eintrag}0 Euro"></c:out></button>
				</form>
		   </td></tr>
			</c:forEach>	
		</table>
	</div>
</c:if>
<div>
Eingezahlt: <c:out value="${eingezahlt}"></c:out> Euro
</div>
<div>
fehlender Betrag: <c:out value="${fehlenderBetrag} Euro"></c:out>
</div>
<div>
Rueckgeld: <c:out value="${rueckgeld} Euro"></c:out>
</div>
<div>
	<ul>
		<c:forEach var="eintrag" items="${rueckgabeInTeilen}">
			<li><c:out value="${eintrag}0 Euro Muenze/Schein"></c:out></li>
		</c:forEach>
	</ul>
</div>