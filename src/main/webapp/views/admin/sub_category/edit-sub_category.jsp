<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>
<c:url value="/admin/sub_category/edit" var="edit"></c:url>

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
				Manage SubCategory</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/admin/dashboard">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/admin/sub_category/manage">Danh mục con</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">Sửa</a>
						</li>
					</ul>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN EDITTING CATEGORY -->
				
				<form role="form" action="${edit}" method="post"
					enctype="multipart/form-data">
					<input name="id" value="${subCategory.id}" hidden="">
						<div class="form-group">
							<label name="id">ID : ${subCategory.id } </label>
						</div>
						
						<div class="form-group">
							<label>Tên danh mục con:</label> <input class="form-control"
								placeholder="Hãy nhập tên danh mục con" name="name" value="${subCategory.name}" />
						</div>
						<div class="form-group">
							<label>ID danh mục cha:</label> <input class="form-control"
								placeholder="Hãy nhập id danh mục cha" name="category_id" value="${subCategory.getCategory().getId()}" />
						</div>
						<button type="submit" class="btn btn-primary">Sửa</button>
						<button type="reset" class="btn btn-danger">Hủy</button>
						<div class="${messageCSS }">
						  <strong><p>${message }</p></strong> 
						</div>
				</form>		
				
				<!-- END EDITTING CATEGORY -->
			</div>
		</div>
		<!-- END CONTENT -->

</body>
<!-- END BODY -->
</html>