<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<form action ="/Test_Fahrkartenautomat/login.do" method="post">
		<div>
			<h3>Login</h3>
			<input type = "text" placeholder="Benutzername" autocomplete="off" name = "Benutzername">
		</div>
		<div >
		<input type="password" placeholder="Passwort" name = "Passwort">
			<button type="submit">Login</button>
		</div>
	</form>
</div>