<%@ include file="layout/_header.jsp"%>
<t:handleSession/>
<div class="container">
	<div class="row">
		<div class="col m3"></div>
		<div class="col m6">
		<h1>Shopping Arena</h1>
		<form action="CartServlet" method="post">
			<t:printProducts/>
		</form>
			
			<br />
			
			<a href="logout.jsp">Logout</a>
		</div>
		<div class="col m3"></div>
	</div>
</div>

<%@ include file="layout/_footer.jsp"%>