<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title>Hello :: Spring Application</title>
</head>
<body>
	<h1>
		Hello -
		<c:out value="${data.user}"></c:out>
		<br/>
		<c:out value="${data.counter}" /> Visit<c:if test="${data.counter>1}">s</c:if>
	</h1>
	<p>
		Greetings, it is now
		<c:out value="${data.get('now')}" default="None" />
	</p>

	<ul>
		<c:forEach var="aParam" items="${param}">
			<li>un parametre : <c:out value="${aParam.key}" /> = <c:out
					value="${aParam.value}" />
			</li>
		</c:forEach>
	</ul>
</body>
</html>