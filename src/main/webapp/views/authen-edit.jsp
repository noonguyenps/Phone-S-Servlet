<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>


<!-- BEGIN BODY -->
<body class="login">
<p class="text-danger">${message}</p>


<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGO -->
<div class="logo">
	<a href="${pageContext.request.contextPath }/home">
	<img src="${url}/admin/layout2/img/logo-big.png" alt=""/>
	</a>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
	<!-- BEGIN LOGIN FORM -->
	<form class="login-form" action="${pageContext.request.contextPath}/authentication" method="post">
		<h3 class="form-title">Authentication</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span>
			Enter verify code. </span>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Code</label>
			<input class="form-control form-control-solid placeholder-no-fix" type="text" placeholder="Verify Number" name="code"/>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-success uppercase" value="Submit">Submit</button>
		</div>
	</form>
</div>
<!-- END LOGIN -->

</body>
<!-- END BODY -->
</html>    