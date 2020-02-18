<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div>
	<h3>Service</h3>
</div>
<div>
Uebersicht Fuellstand:
<table border="1">
	<tr><th>Faecher</th><th>Anzahl</th></tr>
	<c:forEach var="entry" items="${fuellstand}">
	  <tr><td><c:out value="${entry.key} Euro"/></td><td><c:out value="${entry.value}"/></td></tr>
	</c:forEach>
</table>
</div>
<div>
Was moechten Sie tun?  
</div>
<div>
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
	<input type="text" name = "anzahl">
	<button type="submit">LOS</button>
</form>
</div>
<div>
<a href=<c:url value='/logout.do'/>><button>Logout</button></a>  
</div>