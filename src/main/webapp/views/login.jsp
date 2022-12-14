<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>


<!-- BEGIN BODY -->
<body class="login">
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
	<form class="login-form" action="${pageContext.request.contextPath}/login" method="post">
		<h3 class="form-title">Đăng nhập</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span>
			Nhập tài khoản và mật khẩu</span>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Tên đăng nhập</label>
			<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="Tên đăng nhập" name="username"/>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Mật khẩu</label>
			<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="Mật khẩu" name="password"/>
			<p class="text-danger">${message}</p>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-success uppercase">Đăng nhập</button>
			<label class="rememberme check">
			<input type="checkbox" name="remember" value="1"/>Lưu</label>
			<a href="javascript:;" id="forget-password" class="forget-password">Quên mật khẩu?</a>
		</div>
		<div class="create-account">
			<p>
				<a href="javascript:;" id="register-btn" class="uppercase">Đăng ký</a>
			</p>
		</div>
	</form>
	<!-- END LOGIN FORM -->
	<!-- BEGIN FORGOT PASSWORD FORM -->
	<form class="forget-form" action="${pageContext.request.contextPath}/login" method="post">
		<h3>Quên mật khẩu ?</h3>
		<p>
			 Nhập email của bạn để thay đổi mật khẩu
		</p>
		<div class="form-group">
			<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email"/>
		</div>
		<div class="form-actions">
			<button type="button" id="back-btn" class="btn btn-default">Trở về</button>
			<button type="submit" class="btn btn-success uppercase pull-right">Xác nhận</button>
		</div>
	</form>
	<!-- END FORGOT PASSWORD FORM -->
	<!-- BEGIN REGISTRATION FORM -->
	<form class="register-form" action="${pageContext.request.contextPath}/register" method="post">
		<h3>Đăng ký</h3>
		<p class="hint">
			 Nhập thông tin để tiến hành đăng ký:
		</p>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Tên đăng nhập</label>
			<input class="form-control placeholder-no-fix" type="text" placeholder="Tên đăng nhập" name="username"/>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Mật khẩu</label>
			<input class="form-control placeholder-no-fix" type="text" placeholder="Mật khẩu" name="password"/>
		</div>
		<p class="hint">
			 Bạn là người dùng hay là người bán hàng ?
		</p>
		<div class="form-group">
			<input type="radio" id="seller" name="isSeller" value="1">
			<label for="seller">Người bán hàng</label>
			<input type="radio" id="customer" name="isSeller" value="0">
			<label for="customer">Người dùng</label>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Họ và tên</label>
			<input class="form-control placeholder-no-fix" type="text" placeholder="Họ và tên" name="name"/>
		</div>
		<p class="hint">
			 Giới tính của bạn?
		</p>
		<div class="form-group">
			<input type="radio" id="male" name="gender" value="1">
			<label for="male">Nam</label>
			<input type="radio" id="female" name="gender" value="0">
			<label for="female">Nữ</label>
		</div>
		<p class="hint">
			 Ngày sinh?
		</p>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Ngày sinh</label>
			<input class="form-control" placeholder="Ngày sinh" name="birthdate" type="date"/>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Số điện thoại</label>
			<input class="form-control placeholder-no-fix" type="number" placeholder="Số điện thoại" name="phone"/>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Email</label>
			<input class="form-control placeholder-no-fix" type="email" placeholder="Email" name="email"/>
		</div>
		
		
		<div class="form-actions">
			<button type="button" id="register-back-btn" class="btn btn-default">Trở lại</button>
			<input type="submit" id="register-submit-btn" class="btn btn-success uppercase pull-right" value="Đăng ký">
		</div>
	</form>
	<!-- END REGISTRATION FORM -->
</div>
<!-- END LOGIN -->

</body>
<!-- END BODY -->
</html>    