<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">

<title>Stock Web Application</title>
</head>
<body>

	<div align="center" class="form" id="stockid">
		<table border="1" cellpadding="5">
			
				<h3>
					List of Stocks
				</h3>
			
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Current Price (in USD)</th>
				<th>Last Updated Date</th>
			</tr>
			<c:if test="${stocks.size() > 0}">
					<c:forEach var="stock" items="${stocks}">
						<tr>
							<td><c:out value="${stock.id}" /></td>
							<td><c:out value="${stock.name}" /></td>
							<td><c:out value="${stock.currentPrice}" /></td>
							<td><c:out value="${stock.lastUpdate}" /></td>
						</tr>
					</c:forEach>
				</c:if>
		</table>
	</div>

</body>
</html>