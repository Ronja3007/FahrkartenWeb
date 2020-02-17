<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<form action ="/Test_Fahrkartenautomat/login.do" method="post">
		<div class="form-group">
			<div>
				<h2>Login</h2>
				<input type = "text" placeholder="Benutzername" autocomplete="off" name = "Benutzername">
			</div>
		</div>
		<div class="form-group">
			<div >
			<input type="password" placeholder="Passwort" name = "Passwort">
				<button type="submit">Login</button>
			</div>
		</div>
	</form>
</div>