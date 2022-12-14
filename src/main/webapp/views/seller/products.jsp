<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>

    
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
<link href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css" />
<link href="https://cdn.datatables.net/fixedheader/3.2.0/css/fixedHeader.bootstrap4.min.cs" />

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.2.0/js/dataTables.fixedHeader.min.js"></script>

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
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
				Thông tin sản phẩm
				</h3>
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/seller/home">Home</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">Sản phẩm</a>
						</li>
					</ul>
					<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<!-- Begin: life time stats -->
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift font-green-sharp"></i>
									<span class="caption-subject font-green-sharp bold uppercase">Danh sách sản phẩm</span>
								</div>
							</div>
							<div class="portlet-title">
								<div class="caption">
									<span>Danh mục sản phẩm : </span>
									<select id="selectSubCategory" name="selectSubCategory">
										<option value="" ${subCateId==""? "selected":"" }></option>
										<c:forEach items="${listSubCate}" var="subCate">
											<option value="${subCate.id }" ${subCateId==subCate.id? "selected":"" } >${subCate.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="portlet-body">
								<div class="table-container">
									<input type="text" class="form-control form-filter input-sm" name="product_history_desc" placeholder="Tên sản phẩm" name="txtTenSanPham" id="txtTenSanPham" value="${kw }">
									<div class="table-actions-wrapper">
										<span>
										</span>
										<select class="table-group-action-input form-control input-inline input-small input-sm" name="productStatus" id="productStatus">
											<option value="tatca" ${status=="tatca"? "selected":"" }>Tất cả</option>
											<option value="dangban" ${status=="dangban"? "selected":"" }>Đang bán</option>
											<option value="ngungban" ${status=="ngungban"? "selected":"" }>Ngừng bán</option>
											<option value="taman" ${status=="taman"? "selected":"" }>Tạm ẩn</option>
											<option value="hethang" ${status=="hethang"? "selected":"" }>Hết hàng</option>
										</select>
										<div class="btn btn-sm yellow" onclick="timKiemTheoStatus()"><i class="fa fa-check"></i> Tìm kiếm</div>
									</div>
									<table class="table table-striped table-bordered table-hover" id="datatable_products">
									<thead>
									<tr role="row" class="heading">
										<th width="10%">
											 ID
										</th>
										<th width="15%">
											 Tên sản phẩm
										</th>
										<th width="15%">
											 Hình ảnh
										</th>
										<th width="10%">
											 Giá cả
										</th>
										<th width="10%">
											 Danh mục
										</th>
										<th width="15%">
											 Số lượng
										</th>
										<th width="10%">
											 Trạng thái
										</th>
										<th width="10%">
											 Mô tả
										</th>
										<th width="10%">
											 Thao tác
										</th>
									</tr>
									

									</thead>
									
									<tbody id="productTableBody">
									<c:forEach items="${listProduct}" var="product" varStatus="STT">
									<tr role="row" class="filter">
										<td>
											${product.id }
										</td>
										<td>
											${product.name} 
										</td>
										
										<td>
											<c:url value="/image?fname=${product.picture}" var="imgUrl"></c:url>
											<img height="100" width="100" src="${imgUrl}" />
										</td>
										
										<td>
												${String.format("%0,10.0f",product.price)}
										</td>
										
										<td>
											${product.subCategory.name} 
										</td>
										<td>
											${product.amount} 
										</td>
										<td>
											${product.status==1? "Đang bán":product.status==0? "Ngưng bán":"Tạm ẩn" }
										</td>
										<td>
											${product.description }
										</td>
										<td>
											<div class="margin-bottom-5">
												<a class="btn btn-sm yellow" href="/BanHang/seller/edit-product?id=${product.id}"><i class="fa fa-pencil"></i>Sửa</a>
											</div>
											<a class="btn btn-sm red filter-cancel" href="/BanHang/seller/delete-product?id=${product.id}"><i class="fa fa-times"></i> Xóa</a>

										</td>
									</tr>
									</c:forEach>
									</tbody>
									</table>

								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item" onclick="prePageClick()"><a class="">Trước</a></li>
										
										<c:forEach begin="1" end="${pages }" var="i" >
											<li class="page-item" onclick="paging(${i})"><a id="pageNumber${i}" ${pageActive==i? "style='background-color:yellow'":"" } >${i }</a></li>						
										</c:forEach>
										
										<li class="page-item" onclick="nextPageClick()"><a class="">Sau</a></li>
									</ul>
								</nav>

							</div>
							</div>
						</div>
						<!-- End: life time stats -->
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
<script type="text/javascript" src="${url}/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${url}/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${url}/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${url}/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${url}/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/layout.js" type="text/javascript"></script>
<script src="${url}/admin/layout2/scripts/demo.js" type="text/javascript"></script>
<script src="${url}/global/scripts/datatable.js"></script>
<script src="${url}/admin/pages/scripts/ecommerce-products.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
        jQuery(document).ready(function() {    
           Metronic.init(); // init metronic core components
Layout.init(); // init current layout
Demo.init(); // init demo features
           EcommerceProducts.init();
        });
    </script>
<!-- END JAVASCRIPTS -->


<!-- MY SCRIPT -->

<script src="//code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	curPage = ${pageActive}
	
	function timKiemTheoStatus(){
		var status = document.getElementById("productStatus");
		var tenSanPham = document.getElementById("txtTenSanPham");
		var subCate = document.getElementById("selectSubCategory");
		console.log(subCate.value);
		console.log(tenSanPham.value);
		console.log(status.value);	
		window.location.href = "http://localhost:8080/BanHang/seller/product?kw=" + tenSanPham.value + "&status=" + status.value + "&subCate="+subCate.value;
	}
	
	function paging(page){
		body = document.getElementById("productTableBody")
		
		oldPage = curPage
		document.getElementById("pageNumber" + oldPage).style.backgroundColor = ""
		curPage = page
		document.getElementById("pageNumber" + page).style.backgroundColor = "yellow"
		
		kw = "${kw}"
		status = "${status}"
		subCate = "${subCateId}"
		$.ajax({
			url : "/BanHang/api/paging-seller",
			type : "get",
			data : {
				page: page,
				kw: kw,
				status: status,
				subCate: subCate
			},
			success : function(data) {
				body.innerHTML = data;
			},
			error : function(xhr) {
			}
		});
	}
	
	function nextPageClick(){
		pages = ${pages}
		if(curPage<pages)
			paging(curPage+1)
	}
	
	function prePageClick(){
		if(curPage>1)
			paging(curPage-1)
	}
</script>
		
</body>
<!-- END BODY -->
</html>    