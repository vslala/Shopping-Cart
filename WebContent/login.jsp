<%@ include file="layout/_header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<form action="LoginServlet" method="post">
				<div class="row">
					<input type="text" name="username" placeholder="enter username" />
				</div>
				<div class="row">
					<input type="password" name="password" placeholder="enter password" />
				</div>
				<div class="row">
					<button class="btn blue" type="submit">Login</button>
				</div>
			</form>
		</div>
		<div class="col s3"></div>

	</div>
</div>

<%@ include file="layout/_footer.jsp"%>