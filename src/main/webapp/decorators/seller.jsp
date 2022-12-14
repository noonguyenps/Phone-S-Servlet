<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>S-Phone | Seller - Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
<link href="${url}/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${url}/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="${url}/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${url}/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<link href="${url}/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${url}/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="${url}/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${url}/admin/layout2/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="${url}/admin/layout2/css/themes/grey.css" rel="stylesheet" type="text/css"/>
<link href="${url}/admin/layout2/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>


<body class="page-boxed page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-sidebar-closed-hide-logo">
	<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner container">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="${pageContext.request.contextPath}/home">
				<img src="${url}/admin/layout2/img/logo-big.png" alt="S-Phone" width="150px" height="60px" style="padding-top: 10px"/>
			</a>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-default">
						0 </span>
						</a>
<%--						<ul class="dropdown-menu">--%>
<%--							<li class="external">--%>
<%--								<h3><span class="bold">12 pending</span> notifications</h3>--%>
<%--								<a href="extra_profile.html">view all</a>--%>
<%--							</li>--%>
<%--							<li>--%>
<%--								<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">just now</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-success">--%>
<%--										<i class="fa fa-plus"></i>--%>
<%--										</span>--%>
<%--										New user registered. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">3 mins</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-danger">--%>
<%--										<i class="fa fa-bolt"></i>--%>
<%--										</span>--%>
<%--										Server #12 overloaded. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">10 mins</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-warning">--%>
<%--										<i class="fa fa-bell-o"></i>--%>
<%--										</span>--%>
<%--										Server #2 not responding. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">14 hrs</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-info">--%>
<%--										<i class="fa fa-bullhorn"></i>--%>
<%--										</span>--%>
<%--										Application error. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">2 days</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-danger">--%>
<%--										<i class="fa fa-bolt"></i>--%>
<%--										</span>--%>
<%--										Database overloaded 68%. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">3 days</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-danger">--%>
<%--										<i class="fa fa-bolt"></i>--%>
<%--										</span>--%>
<%--										A user IP blocked. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">4 days</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-warning">--%>
<%--										<i class="fa fa-bell-o"></i>--%>
<%--										</span>--%>
<%--										Storage Server #4 not responding dfdfdfd. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">5 days</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-info">--%>
<%--										<i class="fa fa-bullhorn"></i>--%>
<%--										</span>--%>
<%--										System Error. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--									<li>--%>
<%--										<a href="javascript:;">--%>
<%--										<span class="time">9 days</span>--%>
<%--										<span class="details">--%>
<%--										<span class="label label-sm label-icon label-danger">--%>
<%--										<i class="fa fa-bolt"></i>--%>
<%--										</span>--%>
<%--										Storage server failed. </span>--%>
<%--										</a>--%>
<%--									</li>--%>
<%--								</ul>--%>
<%--							</li>--%>
<%--						</ul>--%>
					</li>
					<!-- END NOTIFICATION DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<c:url value="/image?fname=${user.shop.avatar}" var="imgUrl"></c:url>
						<img alt="" class="img-circle" src="${imgUrl}"/>
						<span class="username username-hide-on-mobile">${user.shop.name }</span>
						<i class="fa fa-angle-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
						<li>
								<a href="${pageContext.request.contextPath }/logout">
								<i class="icon-key"></i> Log Out </a>
							</li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<div class="container">
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
					<li class="start ">
						<a href="/BanHang/seller/home">
						<i class="icon-home"></i>
						<span class="title">Dashboard</span>
						</a>
					</li>
					<li class="active open">
						<a href="javascript:;">
						<i class="icon-basket"></i>
						<span class="title">Sản phẩm</span>
						<span class="selected"></span>
						<span class="arrow open"></span>
						</a>
						<ul class="sub-menu">
							<li class="active">
								<a href="${pageContext.request.contextPath}/seller/product">
								<i class="icon-home"></i>
								Danh sách sản phẩm</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/seller/add-product">
								<i class="icon-basket"></i>
								Thêm sản phẩm</a>
							</li>

						</ul>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-rocket"></i>
						<span class="title">Đơn hàng</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="${pageContext.request.contextPath }/seller/order">Danh sách đơn hàng</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="javascript:;">
						<i class="icon-diamond"></i>
						<span class="title">Thông tin cửa hàng</span>
						<span class="arrow "></span>
						</a>
						<ul class="sub-menu">
							<li>
								<a href="${pageContext.request.contextPath }/seller/edit-info"> Thay đổi thông tin </a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/seller/stats">
								Thống kê</a>
							</li>

						</ul>
					</li>
					
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->
		
		<!-- Begin CONTENT -->
			<dec:body />
		<!-- End CONTENT -->

		<!-- BEGIN QUICK SIDEBAR -->
		<!--Cooming Soon...-->
		<!-- END QUICK SIDEBAR -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="page-footer">
		<div class="page-footer-inner">
			2022 © S-Phone Shop UI.
		</div>
		<div class="scroll-to-top">
			<i class="icon-arrow-up"></i>
		</div>
	</div>
	<!-- END FOOTER -->
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${url}/global/plugins/respond.min.js"></script>
<script src="${url}/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${url}/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${url}/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${url}/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${url}/global/plugins/flot/jquery.flot.js" type="text/javascript"></script>
<script src="${url}/global/plugins/flot/jquery.flot.resize.js" type="text/javascript"></script>
<script src="${url}/global/plugins/flot/jquery.flot.categories.js" type="text/javascript"></script>
<script src="${url}/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
<script src="${url}/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${url}/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${url}/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${url}/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${url}/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${url}/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${url}/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/layout.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/demo.js" type="text/javascript"></script>
<script src="${url}/admin/pages/scripts/ecommerce-index.js"></script>
<script src="${url}/admin/pages/scripts/profile.js" type="text/javascript"></script>
<script src="${url}/global/scripts/datatable.js"></script>
<script src="${url}/admin/pages/scripts/ecommerce-orders-view.js"></script>


<!-- END PAGE LEVEL SCRIPTS -->
<script>
	jQuery(document).ready(function() {
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		Demo.init(); // init demo features
		EcommerceIndex.init();
		Profile.init(); // init page demo
	});
</script>
<!-- END JAVASCRIPTS -->
</body>

</html>