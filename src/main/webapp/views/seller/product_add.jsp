<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body class="page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo ">
<!-- BEGIN HEADER -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
				Dashboard
				</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/seller/home">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">Thêm sản phẩm</a>
						</li>
					</ul>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->

					<div class="form-body">
						<form role="form" method="post" enctype="multipart/form-data">

							<div class="form-group">
								<label class="col-md-2 control-label">Tên sản phẩm: </label>
								<div class="col-md-10">
									<input type="text" class="form-control" name="name"
										placeholder="" value="">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label">Giá: </label>
								<div class="col-md-10">
									<input class="form-control" name="price" type="number"
										value="">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-2 control-label">Mô tả: </label>
								<div class="col-md-10">
									<textarea class="form-control" name="description"></textarea>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-2 control-label">Danh mục:</label>
								<div class="col-md-10">
									<div class="form-control height-auto">
										<div class="scroller" style="height: 275px;"
											data-always-visible="1">
											<ul class="list-unstyled">
												<c:forEach items="${listCategory}" var="category">

													<li><label>${category.name}</label>
														<ul class="list-unstyled">

															<c:forEach items="${category.subCategories}"
																var="subCategory">
																<li>
																	<label><input type="radio" name="subCategory" value="${subCategory.id}">${subCategory.name }</label>
																</li>

															</c:forEach>
														</ul></li>
												</c:forEach>
											</ul>
										</div>
									</div>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label">Số lượng: </label>
								<div class="col-md-10">
									<input class="form-control" name="amount"
										value=""></input>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label">Trạng thái:</label>
								<div class="col-md-10">
									<select
										class="table-group-action-input form-control input-medium"
										name="status">
										<option value=1 >Đang
											bán</option>
										<option value=0 >
											Ngưng bán</option>
										<option value=-1 >Tạm
											ẩn</option>
									</select>
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-2 control-label">Hình ảnh: </label>
								<div class="col-md-10">
									<c:url value="/image?fname=" var="imgUrl"></c:url>
									<img class="img-responsive" width="400px" src="${imgUrl}"
										alt=""> <label class="col-md-2 control-label">Ảnh Sản Phẩm</label> <input class="form-control" type="file" name="picture" value="" />
								</div>
							</div>
							<button style="float: right" type="submit"
								class="btn btn-primary">Thêm</button>
							<button style="float: right" type="reset" class="btn btn-success">Hủy bỏ</button>
						</form>
					</div>

					<!-- END PAGE CONTENT-->
			</div>
		</div>
		<!-- END CONTENT -->
		
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
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${url}/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/layout.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/demo.js" type="text/javascript"></script>
<script src="${url}/admin/pages/scripts/ecommerce-index.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
        jQuery(document).ready(function() {    
           Metronic.init(); // init metronic core components
Layout.init(); // init current layout
Demo.init(); // init demo features
           EcommerceIndex.init();
        });
    </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>    