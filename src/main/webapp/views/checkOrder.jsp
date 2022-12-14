<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>


<body class="corporate">
<!-- BEGIN TOP BAR -->
<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+0868704516</span></li>
                    <!-- BEGIN CURRENCIES -->
                    <li class="shop-currencies">
                        <a href="javascript:void(0);">€</a>
                        <a href="javascript:void(0);">$</a>
                        <a href="javascript:void(0);" class="current">đ</a>
                    </li>
                    <!-- END CURRENCIES -->
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                    <c:choose>
                        <c:when test="${ user != null}">
                            <li><a >Tài khoản của tôi</a></li>
                            <li><a href="${pageContext.request.contextPath }/checkout">Đặt hàng</a></li>
                            <c:if test="${ user.is_seller == 1}">
                                <li><a href="${pageContext.request.contextPath}/seller">Cửa hàng</a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath }/order">Đơn hàng của tôi</a></li>
                            <li><a href="${pageContext.request.contextPath }/logout">Đăng xuất</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath }/login">Đăng nhập</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>
</div>
<!-- END TOP BAR -->
    <!-- BEGIN HEADER -->
    <div class="header">
      <div class="container">
          <a class="site-logo" href="${pageContext.request.contextPath}/home"><img src="${url}/admin/layout2/img/logo-big.png" alt="S-Phone" style="width: 60px; height:40px"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN NAVIGATION -->
        
        <!-- END NAVIGATION -->
      </div>
    </div>
    <!-- Header END -->

	<div class="main">
		<div class="container">
			<!-- BEGIN SIDEBAR & CONTENT -->
            <h3>Danh sách đơn hàng của bạn</h3>
			<c:choose>
				<c:when test="${ user != null && listCart != null}">
                    <table class="table table-striped table-bordered table-hover" id="datatable_orders">
                    <thead>
                    <tr role="row" class="heading">
                        <th width="5%">
                            ID
                        </th>
                        <th width="15%">
                            Tên người nhận
                        </th>
                        <th width="10%">
                            Số điện thoại
                        </th>
                        <th width="20%">
                            Địa chỉ
                        </th>
                        <th width="10%">
                            Sản phẩm
                        </th>
                        <th width="10%">
                            Giá
                        </th>
                        <th width="10%">
                            Số lượng
                        </th>
                        <th width="10%">
                            Ngày đặt hàng
                        </th>
                        <th width="10%">
                            Ngày giao hàng
                        </th>
                        <th width="10%">
                            Trạng thái
                        </th>
                        <th>
                            Thao tác
                        </th>
                    </tr>
					<c:forEach items="${listCart }" var="cart">
                                <tr role="row" class="filter">
                                    <td>
                                            ${cart.id }
                                    </td>
                                    <td>
                                            ${cart.name }
                                    </td>
                                    <td>
                                            ${cart.phone }
                                    </td>
                                    <td>
                                            ${cart.location }
                                    </td>
                                    <td>
                                            ${cart.product.name }
                                    </td>
                                    <td>
                                            ${String.format("%0,10.0f",cart.price)} đ
                                    </td>
                                    <td>
                                            ${cart.amount }
                                    </td>
                                    <td>
                                            ${cart.order_date.getTime() }
                                    </td>
                                    <td>
                                            ${cart.delivery_date.getTime() }
                                    </td>
                                    <td>${cart.status }</td>

                                    <td>
                                        <a> ${cart.status=="pending"? "Hủy đơn":"" } </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
				</c:when>
				<c:otherwise>
					<div class="row margin-bottom-20">
						<div class="col-md-12 col-sm-12">
                            <h4>Danh sách đơn hàng của bạn đang trống</h4>
                            <h4>Hãy chắc chắn rằng bạn đã đặt hàng!</h4>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			
			<!-- END SIDEBAR & CONTENT -->
		</div>
	</div>

	<!-- BEGIN PRE-FOOTER -->
    <div class="pre-footer mb-5">
      <div class="container">
      </div>
    </div>
    <!-- END PRE-FOOTER -->

<!-- BEGIN PRE-FOOTER -->
<div class="pre-footer">
    <div class="container">
        <div class="row">
            <!-- BEGIN BOTTOM ABOUT BLOCK -->
            <div class="col-md-3 col-sm-6 pre-footer-col">
                <h2>Về chúng tôi</h2>
                <p>Trang web này thực hiện kinh doanh các đồ điện tử và thiết bị di động. </p>
                <p>Liên hệ với chúng tôi để biết thêm chi tiết.</p>
            </div>
            <!-- END BOTTOM ABOUT BLOCK -->
            <!-- BEGIN BOTTOM INFO BLOCK -->
            <div class="col-md-3 col-sm-6 pre-footer-col">
                <h2>Information</h2>
                <ul class="list-unstyled">
                    <li><i class="fa fa-angle-right"></i> <a href="#">Thông tin giao hàng</a></li>
                    <li><i class="fa fa-angle-right"></i> <a href="#">Chăm sóc khách hàng</a></li>
                    <li><i class="fa fa-angle-right"></i> <a href="#">Trạng thái đơn hàng</a></li>
                    <li><i class="fa fa-angle-right"></i> <a href="#">Giao hàng</a></li>
                    <li><i class="fa fa-angle-right"></i> <a href="#">Liên hệ với chúng tôi</a></li>
                    <li><i class="fa fa-angle-right"></i> <a href="#">Phương thức thanh toán</a></li>
                </ul>
            </div>
            <!-- END INFO BLOCK -->
            <!-- BEGIN BOTTOM CONTACTS -->
            <div class="col-md-3 col-sm-6 pre-footer-col">
                <h2>Our Contacts</h2>
                <address class="margin-bottom-40">
                    Số 1, Võ Văn Ngân, Linh Chiểu, Thủ Đức<br>
                    Hồ Chí Minh, Việt Nam<br>
                    Phone: 0868704516<br>
                    Fax: 0868704516<br>
                    Email: <a href="mailto:ngoctin2412@gmail.com">ngoctin2412@gmail.com</a><br>
                </address>
            </div>
            <!-- END BOTTOM CONTACTS -->
        </div>
        <hr>
        <div class="row">
            <!-- BEGIN SOCIAL ICONS -->
            <div class="col-md-6 col-sm-6">
                <ul class="social-icons">
                    <li><a class="rss" data-original-title="rss" href="#"></a></li>
                    <li><a class="facebook" data-original-title="facebook" href="#"></a></li>
                    <li><a class="twitter" data-original-title="twitter" href="#"></a></li>
                    <li><a class="googleplus" data-original-title="googleplus" href="#"></a></li>
                    <li><a class="linkedin" data-original-title="linkedin" href="#"></a></li>
                    <li><a class="youtube" data-original-title="youtube" href="#"></a></li>
                    <li><a class="vimeo" data-original-title="vimeo" href="#"></a></li>
                    <li><a class="skype" data-original-title="skype" href="#"></a></li>
                </ul>
            </div>
            <!-- END SOCIAL ICONS -->
            <!-- BEGIN NEWLETTER -->
            <div class="col-md-6 col-sm-6">
                <div class="pre-footer-subscribe-box pull-right">
                    <h2>Liên hệ quảng cáo</h2>
                    <form action="#">
                        <div class="input-group">
                            <input type="text" placeholder="email của bạn" class="form-control">
                            <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">Subscribe</button>
                  </span>
                        </div>
                    </form>
                </div>
            </div>
            <!-- END NEWLETTER -->
        </div>
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 padding-top-10">
                2022 © S-Phone Shop UI.
            </div>
            <div class="col-md-6 col-sm-6">
                <ul class="list-unstyled list-inline pull-right">
                    <li><img src="${url}/frontend/layout/img/payments/western-union.jpg" alt="We accept Western Union" title="We accept Western Union"></li>
                    <li><img src="${url}/frontend/layout/img/payments/american-express.jpg" alt="We accept American Express" title="We accept American Express"></li>
                    <li><img src="${url}/frontend/layout/img/payments/MasterCard.jpg" alt="We accept MasterCard" title="We accept MasterCard"></li>
                    <li><img src="${url}/frontend/layout/img/payments/PayPal.jpg" alt="We accept PayPal" title="We accept PayPal"></li>
                    <li><img src="${url}/frontend/layout/img/payments/visa.jpg" alt="We accept Visa" title="We accept Visa"></li>
                </ul>
            </div>
        </div>
    </div>
</div>

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="${url}/global/plugins/respond.min.js"></script>
    <![endif]-->
    <script src="${url}/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${url}/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${url}/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${url}/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>

    <script src="${url}/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();
            Layout.initUniform();
            Layout.initTwitter();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->