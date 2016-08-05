<%@ include file="layout/_header.jsp"%>
<t:handleSession/>
<div class="container">
	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<t:printCartItems/>
			<br/>
			<a href="home.jsp">&lt;&lt; Go Back</a>
		</div>
		<div class="col s3"></div>
	</div>
</div>

<%@ include file="layout/_footer.jsp"%>