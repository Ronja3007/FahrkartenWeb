<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>         
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!doctype html>
<html lang="de">
  <head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/0be993e115.js" crossorigin="anonymous"></script>
    <title>Fahrkarten und Tickets</title>
    <link rel="STYLESHEET" type="text/css" href="<c:url value="/include/stylesheet.css"/>">
  </head>
       <body> 
       <h1>Fahrkarten und Tickets kaufen</h1>
     	   <div id="message" style="color: red;">
                <c:out value="${notifications}"/>
            </div>
            <div id="inhalt">
                <c:import url="${url}"></c:import>
            </div>
    <footer style = "position: fixed; padding: 10px; bottom: 0; left: 0; right: 0">
    <table>
    <tr><td><form action="/Test_Fahrkartenautomat/menue.do" method="post">
          <button style="background-color: green">zurueck zum Hauptmenue</button> 
          </form></td>
          <td><form action="/Test_Fahrkartenautomat/logout.do" method="post">
          <button>Service</button>  
          </form></td></tr>
    </table>   
    </footer> 
    </body>
</html>