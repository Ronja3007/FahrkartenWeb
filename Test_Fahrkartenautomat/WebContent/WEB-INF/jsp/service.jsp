<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div>
	<h3>Service</h3>
</div>
<div>
Uebersicht Fuellstand:
<table border="1">
	<tr><th>Faecher</th><th>Anzahl</th><th>Max. Fuellstand</th></tr>
	<c:forEach var="entry" items="${fuellstand}">
	  <tr><td><c:out value="${entry.key} Euro"/></td><td><c:out value="${entry.value}"/></td>
	  <td><c:if test="${entry.key < 5}">
	  		<c:out value="${maxzahlMuenzen}"></c:out>
	  	</c:if>
	  	<c:if test="${entry.key >= 5}">
	  		<c:out value="${maxzahlScheine}"></c:out>
	  	</c:if>
	  	</td></tr>
	</c:forEach>
</table>
</div>
<div>
	Was moechten Sie tun?  
</div>
<div>
<br>
<form action ="/Test_Fahrkartenautomat/service.do" method="post">
	<select name="welchesFach">
		<c:forEach var="eintrag" items= "${faecher}">
				<option value="${eintrag}"><c:out value="${eintrag}"></c:out></option>
		</c:forEach>
	</select> Euro Fach 
	<select name="auffuellenOderLeeren">
		<option value="auffuellen">auffuellen</option>
		<option value = "leeren">leeren</option>
	</select> <br>
	Wie viel kommt dazu/weg?
	<input type="text" name = "anzahl" autocomplete="off">
	<button type="submit">LOS</button>
</form>
</div>
<div>
    <br>
	<form action="/Test_Fahrkartenautomat/service.do" method= "post">
		<input type="hidden" name = "allesLeer" value = "leer">
		<button type="submit" style="background-color: red;">Alle Faecher leeren</button>
	</form>
	<br>
	<form action="/Test_Fahrkartenautomat/service.do" method= "post">
		<input type="hidden" name = "mitte" value = "mitte">
		<button type="submit" style="background-color: orange;">Alle Faecher auf Mittelstand</button>
	</form>
	<br>
</div>
<div>
<a href=<c:url value='/logout.do'/>><button>Logout</button></a>  
</div>