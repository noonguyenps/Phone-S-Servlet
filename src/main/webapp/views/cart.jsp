<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/assets" var="url"></c:url>


<!-- Body BEGIN -->
<body class="ecommerce">
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
                            <li><a href="/profile">Tài khoản của tôi</a></li>
                            <li><a href="${pageContext.request.contextPath }/checkout">Đặt hàng</a></li>
                            <c:if test="${ user.is_seller == 1}">
                                <li><a href="${pageContext.request.contextPath}/seller">Cửa hàng</a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath }/order">Đơn hàng</a></li>
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
          <a class="site-logo" href="${pageContext.request.contextPath}/home"><img src="${url}/admin/layout2/img/logo-big.png" alt="S-Phone" width="110px" height="80px" style="padding-top: 10px"/></a>
        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>
        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
            <a id="cartQuantity" href="${pageContext.request.contextPath }/cart" class="top-cart-info-count">${cartQuantity } sản phẩm</a>
          </div>
          <i id="checkout" class="fa fa-shopping-cart" style="cursor: pointer;"></i>
        </div>
      </div>
    </div>
    <!-- Header END -->

    <div class="main">
      <div class="container">
          <center>
              <h1>GIỎ HÀNG</h1>
          </center>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <div class="goods-page">
              <div class="goods-data clearfix">
                <div class="table-wrapper-responsive">
                <table>
                  <tr>
                    <th class="goods-page-image">Hình ảnh</th>
                    <th class="goods-page-description">Tên Sản phẩm</th>
                    <th class="goods-page-ref-no">Mã giỏ hàng</th>
                    <th class="goods-page-quantity">Số lượng</th>
                    <th class="goods-page-price">Đơn giá</th>
                  </tr>
                  
                  <c:forEach items="${cart.values()}" var="cart">
                  <tr>
                    <td class="goods-page-image">
                    	<c:url value="/image?fname=${cart.product.picture}" var="imgUrl"></c:url>
						<img height="100" width="150" src="${imgUrl}" />
                    </td>
                    <td class="goods-page-description">
                      <h3><a href="/detail?pid=${cart.product.id }">${cart.product.name }</a></h3>
                    </td>
                    <td class="goods-page-ref-no">
                      ${cart.id }
                    </td>
                    <td class="goods-page-quantity">
                      <div class="product-quantity">
                          <input id="product-quantity" type="number" value="${cart.amount }" class="product-quantity input-group" onblur="updateCart(${cart.product.id}, this)" min="0">
                      </div>
                    </td>
                    <td class="goods-page-price">
                      <strong>${String.format("%0,10.0f",cart.price)}<span>đ</span></strong>
                    </td>
                    <td class="del-goods-col">
                      <a class="del-goods" href="#">&nbsp;</a>
                    </td>
                  </tr>
                 </c:forEach>
                 

                </table>
                </div>

                <div class="shopping-total">
                  <ul>
                    <li class="shopping-total-price">
                      <em>Tổng cộng</em>
                      <strong id="cartCharge" class="price">${String.format("%0,10.0f",cartCharge)}<span>đ</span></strong>
                    </li>
                  </ul>
                </div>
              
              </div>
              <button class="btn btn-default"  onclick="window.location.href = 'http://localhost:8080/home';" >Tiếp tục mua sắm<i class="fa fa-shopping-cart"></i></button>
              <button class="btn btn-primary" type="submit"  onclick="window.location.href = 'http://localhost:8080/checkout';" >Thanh toán<i class="fa fa-check"></i></button>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->

        
      </div>
    </div>

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
                <h2>Thông tin</h2>
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
                <h2>Liên hệ với chúng tôi</h2>
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
<!-- END PRE-FOOTER -->

<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="container">
        <div class="row">
            <!-- BEGIN COPYRIGHT -->
            <div class="col-md-6 col-sm-6 padding-top-10">
                2022 © S-Phone Shop UI.
            </div>
            <!-- END COPYRIGHT -->
            <!-- BEGIN PAYMENTS -->
            <div class="col-md-6 col-sm-6">
                <ul class="list-unstyled list-inline pull-right">
                    <li><img src="${url}/frontend/layout/img/payments/western-union.jpg" alt="We accept Western Union" title="We accept Western Union"></li>
                    <li><img src="${url}/frontend/layout/img/payments/american-express.jpg" alt="We accept American Express" title="We accept American Express"></li>
                    <li><img src="${url}/frontend/layout/img/payments/MasterCard.jpg" alt="We accept MasterCard" title="We accept MasterCard"></li>
                    <li><img src="${url}/frontend/layout/img/payments/PayPal.jpg" alt="We accept PayPal" title="We accept PayPal"></li>
                    <li><img src="${url}/frontend/layout/img/payments/visa.jpg" alt="We accept Visa" title="We accept Visa"></li>
                </ul>
            </div>
            <!-- END PAYMENTS -->
        </div>
    </div>
</div>
<!-- END FOOTER -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="${url}/global/plugins/respond.min.js"></script>  
    <![endif]-->  
    <script src="${url}/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${url}/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${url}/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${url}/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src='${url}/global/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
    <script src="${url}/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->
    <script src="${url}/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="${url}/global/plugins/rateit/src/jquery.rateit.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js" type="text/javascript"></script><!-- for slider-range -->

    <script src="${url}/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initUniform();
            Layout.initSliderRange();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
    
    

    <!-- MY SCRIPT -->
    <script>
        function numberWithCommas(num) {
            return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        }
    	function updateCart(productId, input){
    		$.ajax({
    			url : "/api/update-cart",
    			type : "get",
    			data : {
    				id : productId,
    				amount : input.value
    			},
    			success: function(data){
					const array = data.split("/")
					document.getElementById("cartQuantity").innerText = array[0] + " sản phẩm"
					document.getElementById("cartCharge").innerText = numberWithCommas(Number(array[1]))+'đ'
    			},
    			error : function(xhr) {
    				console.log("error")
    			}
    		});
    	}
    </script>
    
</body>
<!-- END BODY -->
</html>