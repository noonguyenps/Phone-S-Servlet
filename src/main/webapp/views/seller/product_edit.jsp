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
			<!-- BEGIN CONTENT -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
					<div class="modal fade" id="portlet-config" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true"></button>
									<h4 class="modal-title">Modal title</h4>
								</div>
								<div class="modal-body">Widget settings form goes here</div>
								<div class="modal-footer">
									<button type="button" class="btn blue">Save changes</button>
									<button type="button" class="btn default" data-dismiss="modal">Close</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
					<!-- BEGIN STYLE CUSTOMIZER -->
					<div class="theme-panel">
						<div class="toggler tooltips" data-container="body"
							data-placement="left" data-html="true"
							data-original-title="Click to open advance theme customizer panel">
							<i class="icon-settings"></i>
						</div>
						<div class="toggler-close">
							<i class="icon-close"></i>
						</div>
						<div class="theme-options">
							<div class="theme-option theme-colors clearfix">
								<span> THEME COLOR </span>
								<ul>
									<li class="color-default current tooltips" data-style="default"
										data-container="body" data-original-title="Default"></li>
									<li class="color-grey tooltips" data-style="grey"
										data-container="body" data-original-title="Grey"></li>
									<li class="color-blue tooltips" data-style="blue"
										data-container="body" data-original-title="Blue"></li>
									<li class="color-dark tooltips" data-style="dark"
										data-container="body" data-original-title="Dark"></li>
									<li class="color-light tooltips" data-style="light"
										data-container="body" data-original-title="Light"></li>
								</ul>
							</div>
							<div class="theme-option">
								<span> Theme Style </span> <select
									class="layout-style-option form-control input-small">
									<option value="square" selected="selected">Square
										corners</option>
									<option value="rounded">Rounded corners</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Layout </span> <select
									class="layout-option form-control input-small">
									<option value="fluid" selected="selected">Fluid</option>
									<option value="boxed">Boxed</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Header </span> <select
									class="page-header-option form-control input-small">
									<option value="fixed" selected="selected">Fixed</option>
									<option value="default">Default</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Top Dropdown</span> <select
									class="page-header-top-dropdown-style-option form-control input-small">
									<option value="light" selected="selected">Light</option>
									<option value="dark">Dark</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Sidebar Mode</span> <select
									class="sidebar-option form-control input-small">
									<option value="fixed">Fixed</option>
									<option value="default" selected="selected">Default</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Sidebar Style</span> <select
									class="sidebar-style-option form-control input-small">
									<option value="default" selected="selected">Default</option>
									<option value="compact">Compact</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Sidebar Menu </span> <select
									class="sidebar-menu-option form-control input-small">
									<option value="accordion" selected="selected">Accordion</option>
									<option value="hover">Hover</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Sidebar Position </span> <select
									class="sidebar-pos-option form-control input-small">
									<option value="left" selected="selected">Left</option>
									<option value="right">Right</option>
								</select>
							</div>
							<div class="theme-option">
								<span> Footer </span> <select
									class="page-footer-option form-control input-small">
									<option value="fixed">Fixed</option>
									<option value="default" selected="selected">Default</option>
								</select>
							</div>
						</div>
					</div>
					<!-- END STYLE CUSTOMIZER -->
					<!-- BEGIN PAGE HEADER-->
					<h3 class="page-title">
						Product Edit <small>create & edit product</small>
					</h3>
					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">Home</a>
								<i class="fa fa-angle-right"></i></li>
							<li><a href="#">eCommerce</a> <i class="fa fa-angle-right"></i>
							</li>
							<li><a href="#">Product Edit</a></li>
						</ul>
						<div class="page-toolbar">
							<div class="btn-group pull-right">
								<button type="button"
									class="btn btn-fit-height grey-salt dropdown-toggle"
									data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
									data-close-others="true">
									Actions <i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- END PAGE HEADER-->
					<!-- BEGIN PAGE CONTENT-->
					<div class="row">
						<div class="col-md-12">
							<!-- <form class="form-horizontal form-row-seperated" action="#"> -->
								<div class="portlet light">
									<div class="portlet-title">
										<div class="caption">
											<i class="icon-basket font-green-sharp"></i> <span
												class="caption-subject font-green-sharp bold uppercase">
												Edit Product </span> <span class="caption-helper">Man Tops</span>
										</div>
										<div class="actions btn-set">
											<button type="button" name="back"
												class="btn btn-default btn-circle">
												<i class="fa fa-angle-left"></i> Back
											</button>
											<button class="btn btn-default btn-circle ">
												<i class="fa fa-reply"></i> Reset
											</button>
											<button class="btn green-haze btn-circle">
												<i class="fa fa-check"></i> Save
											</button>
											<button class="btn green-haze btn-circle">
												<i class="fa fa-check-circle"></i> Save & Continue Edit
											</button>
											<div class="btn-group">
												<a class="btn yellow btn-circle" href="#"
													data-toggle="dropdown"> <i class="fa fa-share"></i>
													More <i class="fa fa-angle-down"></i>
												</a>
												<ul class="dropdown-menu pull-right">
													<li><a href="#"> Duplicate </a></li>
													<li><a href="#"> Delete </a></li>
													<li class="divider"></li>
													<li><a href="#"> Print </a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="portlet-body">
										<div class="tabbable">
											<ul class="nav nav-tabs">
												<li class="active"><a href="#tab_general"
													data-toggle="tab"> General </a></li>
												<li><a href="#tab_meta" data-toggle="tab"> Thống kê </a></li>
												<li><a href="#tab_reviews" data-toggle="tab">
														Reviews
												</a></li>
												<li><a href="#tab_history" data-toggle="tab">Order</a></li>
											</ul>
											
											
											<div class="tab-content no-space">
												<div class="tab-pane active" id="tab_general">
											
												<div class="form-body">
												<form role="form" action="/BanHang/seller/edit-product" method="post" enctype="multipart/form-data">
														<div class="form-group" style="display:none">
															<label class="col-md-2 control-label">ID: </label>
															<div class="col-md-10">
																<input type="text" class="form-control" name="productId"
																	placeholder="" value=${product.id }>
															</div>
														</div>

														<div class="form-group">
															<label class="col-md-2 control-label">Name: </label>
															<div class="col-md-10">
																<input type="text" class="form-control" name="name" placeholder="" value="${product.name }">
															</div>
														</div>

														<div class="form-group">
															<label class="col-md-2 control-label">Price: </label>
															<div class="col-md-10">
																<input class="form-control" name="price" value="${product.price }"></input>
															</div>
														</div>


														<div class="form-group">
															<label class="col-md-2 control-label">Description: </label>
															<div class="col-md-10">
																<textarea class="form-control" name="description">${product.description }</textarea>
															</div>
														</div>


														<div class="form-group">
															<label class="col-md-2 control-label">Categories:</label>
															<div class="col-md-10">
																<div class="form-control height-auto">
																	<div class="scroller" style="height: 275px;"
																		data-always-visible="1">
																		<ul class="list-unstyled">
																			<c:forEach items="${listCategory}" var="category">
															
																			<li><label>${category.name}</label>
																				<ul class="list-unstyled">
																				
																					<c:forEach items="${category.subCategories}" var="subCategory">
																					<li><label><input type="radio"
																							name="subCategory" value="${subCategory.id}" ${product.subCategory.id==subCategory.id? "checked":"" } >${subCategory.name }</label>
																					</li>

																					</c:forEach>
																				</ul>
																			</li>
																			</c:forEach>
																		</ul>
																	</div>
																</div>

															</div>
														</div>

														<div class="form-group">
															<label class="col-md-2 control-label">Amount: </label>
															<div class="col-md-10">
																<input class="form-control" name="amount" value="${product.amount }"></input>
															</div>
														</div>

														<div class="form-group">
															<label class="col-md-2 control-label">Status:</label>
															<div class="col-md-10">
																<select class="table-group-action-input form-control input-medium" name="status">
																	<option value=1  ${product.status==1? "selected":"" }>Đang bán</option>
																	<option value=0  ${product.status==0? "selected":"" }> Ngưng bán</option>
																	<option value=-1 ${product.status==-1? "selected":"" }>Tạm ẩn</option>
																</select>
															</div>
														</div>
														
														
														
														<div class="form-group">
															<label class="col-md-2 control-label">Picture: </label>
															<div class="col-md-10">
																<c:url value="/image?fname=${product.picture}" var="imgUrl"></c:url>
																<img class="img-responsive" width="400px" src="${imgUrl}" alt="">
																<label class="col-md-2 control-label">Ảnh Sản Phẩm</label> 
																<input  class="form-control" type="file" name="picture" value="${product.picture}" />
															</div>
														</div>
														<button style="float:right" type="submit" class="btn btn-primary">Edit</button>
														<button style="float:right" type="reset" class="btn btn-success">Reset</button>
												</form>
												</div>

												</div>
												<div class="tab-pane" id="tab_meta">
													
													
													<div class="row">
														<div class=" col-md-2 col-sm-6 col-xs-12">
															<div class="dashboard-stat blue">
																<div class="visual">
																	<i class="fa fa-comments"></i>
																</div>
																<div class="details">
																	<div class="number">
																		 ${deliveried[0]}
																	</div>
																	<div class="desc">
																		 Đơn đã giao
																	</div>
																</div>
																<a class="more" href="#">
																View more <i class="m-icon-swapright m-icon-white"></i>
																</a>
															</div>
														</div>
														<div class=" col-md-2 col-sm-6 col-xs-12">
															<div class="dashboard-stat blue">
																<div class="visual">
																	<i class="fa fa-shopping-cart"></i>
																</div>
																<div class="details">
																	<div class="number">
																		 ${deliveried[1] }
																	</div>
																	<div class="desc">
																		 Doanh số
																	</div>
																</div>
																<a class="more" href="#">
																View more <i class="m-icon-swapright m-icon-white"></i>
																</a>
															</div>
														</div>
														<div class=" col-md-2 col-sm-6 col-xs-12">
															<div class="dashboard-stat blue">
																<div class="visual">
																	<i class="fa fa-globe"></i>
																</div>
																<div class="details">
																	<div class="number">
																		 ${deliveried[2] }
																	</div>
																	<div class="desc">
																		 Doanh thu
																	</div>
																</div>
																<a class="more" href="#">
																View more <i class="m-icon-swapright m-icon-white"></i>
																</a>
															</div>
														</div>
														<div class=" col-md-2 col-sm-6 col-xs-12">
															<div class="dashboard-stat blue">
																<div class="visual">
																	<i class="fa fa-bar-chart-o"></i>
																</div>
																<div class="details">
																	<div class="number">
																		 ${pendingOrder }
																	</div>
																	<div class="desc">
																		 Đơn đợi xử lý
																	</div>
																</div>
																<a class="more" href="#">
																View more <i class="m-icon-swapright m-icon-white"></i>
																</a>
															</div>
														</div>
														<div class=" col-md-2 col-sm-6 col-xs-12">
															<div class="dashboard-stat blue">
																<div class="visual">
																	<i class="fa fa-bar-chart-o"></i>
																</div>
																<div class="details">
																	<div class="number">
																		 ${canceledOrder }
																	</div>
																	<div class="desc">
																		 Đơn hủy
																	</div>
																</div>
																<a class="more" href="#">
																View more <i class="m-icon-swapright m-icon-white"></i>
																</a>
															</div>
														</div>
														
													</div>
													
													
													
												</div>
												
												<div class="tab-pane" id="tab_reviews">
													<div class="table-container">
														<h1>${avgRating==null? "Chưa có đánh giá":avgRating }</h1>
														<table class="table table-striped table-bordered table-hover" id="datatable_reviews">
															<thead>
																<tr role="row" class="heading">
																	<th width="5%">ID</th>
																	<th width="10%">Username</th>
																	<th width="10%">Comment</th>
																	<th width="10%">Rating</th>
																	
																</tr>
																<c:forEach items="${product.reviews }" var="review">
																<tr role="row" class="filter">
																	<td>${review.id}</td>
																	<td>${review.user.username}</td>
																	<td>${review.comment}</td>
																	<td>${review.rating}/5</td>

																</tr>
																</c:forEach>
															</thead>
															<tbody>
															</tbody>
														</table>
													</div>
												</div>
												<div class="tab-pane" id="tab_history">
													<div class="table-container">
														<table class="table table-striped table-bordered table-hover" id="datatable_history">
															<thead>
																<tr role="row" class="heading">
																	<th width="10%">Người đặt</th>
																	<th width="10%">Điện thoại</th>
																	<th width="10%">Địa chỉ</th>
																	<th width="10%">Sản phẩm</th>
																	<th width="5%">Giá</th>
																	<th width="5%">Số lượng</th>
																	<th width="15%">Ngày đặt</th>
																	<th width="15%">Ngày giao</th>
																	<th width="10%">Trạng thái</th>
																	<th width="10%">Username</th>
																</tr>
																
																<c:forEach items="${product.carts }" var="cart">
																<tr role="row" class="filter">
																	<td>${cart.name }</td>
																	<td>${cart.phone }</td>
																	<td>${cart.location }</td>
																	<td>${cart.product.name }</td>
																	<td>${cart.price }</td>
																	<td>${cart.amount }</td>
																	<td>${cart.order_date.getTime() }</td>
																	<td>${cart.delivery_date.getTime() }</td>
																	<td>${cart.status }</td>
																	<td>${cart.user.username }</td>
																</tr>
																</c:forEach>
															</thead>
															<tbody>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							<!-- </form> -->
						</div>
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
	<script src="${url}/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="${url}/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="${url}/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script src="${url}/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${url}/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script
		src="${url}/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="${url}/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="${url}/global/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<script src="${url}/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="${url}/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="${url}/global/plugins/select2/select2.min.js"></script>
	<script type="text/javascript"
		src="${url}/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${url}/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
	<script type="text/javascript"
		src="${url}/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="${url}/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="${url}/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js"
		type="text/javascript"></script>
	<script
		src="${url}/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${url}/global/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
	<script src="${url}/global/plugins/plupload/js/plupload.full.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${url}/global/scripts/metronic.js" type="text/javascript"></script>
	<script src="${url}/admin/layout2/scripts/layout.js"
		type="text/javascript"></script>
	<script src="${url}/admin/layout2/scripts/demo.js"
		type="text/javascript"></script>
	<script src="${url}/global/scripts/datatable.js"></script>
	<script src="${url}/admin/pages/scripts/ecommerce-products-edit.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			EcommerceProductsEdit.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
	
	<script>
		function themHashtag(){
			var amount = document.getElementsByClassName("hashtagBlock").length;
			console.log(amount)
		}
	
	</script>

</body>
<!-- END BODY -->
</html>