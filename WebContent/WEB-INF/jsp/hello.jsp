<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title>Hello :: Spring Application</title>
</head>
<body>
	<h1>
		Hello -
		<c:out value="${data.get('user')}"></c:out>
		<spring:message code="product.name"></spring:message>
	</h1>
	<p>
		Greetings, it is now
		<c:out value="${data.get('now')}" default="None" />
	</p>
	<p>${hp.a} + ${hp.b} = ${hp.a+hp.b}</p>
</body>
</html>