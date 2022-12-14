<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>


<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-boxed page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-sidebar-closed-hide-logo">
<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
				Quản lý cửa hàng</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/admin/dashboard">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">Cửa hàng</a>
							<i class="fa fa-angle-right"></i>
						</li>
					</ul>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN EDITTING CATEGORY -->
				<table id="example" class="table table-striped table-bordered"
						style="width: 100%">
						<thead>
							<tr>
								<th>STT</th>
								<th>Id</th>
								<th>Địa chỉ</th>
								<th>Tên cửa hàng</th>
								<th>Ảnh</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
					
							<c:forEach items="${shopList}" var="shop" varStatus="STT">
								<tr>
									<td>${STT.index+1}</td>
									<td>${shop.id}</td>
									<td>${shop.location}</td>
									<td>${shop.name}</td>
									<c:url value="/image?fname=${shop.avatar} " var="imgUrl"></c:url>
									<td><img height="150" width="200" alt="Avatar shop" src="${imgUrl }"></td>
									<td><a
										href="<c:url value='/admin/shop/delete?id=${shop.id}'/>"
										class="center">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<script>
						$(document).ready(function() {
							var table = $('#example').DataTable({
								fixedHeader : true
							});
						});
					</script>
				
				<!-- END EDITTING CATEGORY -->
			</div>
		</div>
		<!-- END CONTENT -->

</body>
<!-- END BODY -->
</html>