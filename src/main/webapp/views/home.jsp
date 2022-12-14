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
        <a class="site-logo" href="${pageContext.request.contextPath}/home"><img src="${url}/admin/layout2/img/logo-big.png" alt="S-Phone" style="width: 60px; height:40px"></a>
        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>
        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
            <a id="cartQuantity" href="${pageContext.request.contextPath }/cart" class="top-cart-info-count">${cartQuantity } sản phẩm</a>
          </div>
          <i id="checkout" class="fa fa-shopping-cart" style="cursor: pointer;"></i>
        </div>

        <div class="header-navigation">
          <ul>
          <c:forEach items="${listCate}" var="c">
            <li class="dropdown">
              <a class="dropdown-toggle" href="${pageContext.request.contextPath}/product?cid=${c.id}&scid=0">
                ${c.name}
              </a>
              <!-- BEGIN DROPDOWN MENU -->
              <ul class="dropdown-menu">
               <c:forEach items="${listSubCate}" var="s">
               <c:if test="${ c.id == s.category.id}">
                <li><a href="${pageContext.request.contextPath}/product?cid=0&scid=${s.id}">${s.name}</a></li>
                </c:if>
                </c:forEach>
              </ul>
              <!-- END DROPDOWN MENU -->
           </c:forEach>
            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                <form action="${pageContext.request.contextPath}/search">
                  <div class="input-group">
                    <input type="text" placeholder="Search" class="form-control" name="kw">
                    <span class="input-group-btn">
                      <input class="btn btn-primary" type="submit" value="Search">
                    </span>
                  </div>
                </form>
              </div>
            </li>
            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>
    </div>
    <!-- Header END -->

    <!-- BEGIN SLIDER -->
    <div class="page-slider margin-bottom-35">
      <!-- LayerSlider start -->
      <div id="layerslider" style="width: 1400px; height: 400px; margin: 20px;">
        <!-- slide one start -->
        <div class="ls-slide ls-slide1" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 24,25,27,28;">
          <img src="https://cdn.hoanghamobile.com/i/home/Uploads/2022/10/21/iphone-14-1200x382.jpg" class="ls-bg" alt="Slide background">
        </div>
        <!-- slide one end -->

        <!-- slide two start -->
        <div class="ls-slide ls-slide2" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">
          <img src="https://cdn.hoanghamobile.com/i/home/Uploads/2022/10/04/tai-nghe-bwoo-1200x382.jpg" class="ls-bg" alt="Slide background">
        </div>
        <!-- slide two end -->

        <!-- slide three start -->
        <div class="ls-slide ls-slide3" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 92,93,105;">
          <img src="https://cdn.hoanghamobile.com/i/home/Uploads/2022/10/19/web-hotsale-samsung-galaxy-a-series-01.jpg" class="ls-bg" alt="Slide background">
        </div>
            <!-- slide three end -->

        <!-- slide four start -->
        <div class="ls-slide ls-slide4" data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">
          <img src="https://cdn.hoanghamobile.com/i/home/Uploads/2022/10/06/laptop-gaming-gigabyte-1200x382.jpg" class="ls-bg" alt="Slide background">
          </div>
        </div>
        <!-- slide four end -->
      </div>
      <!-- LayerSlider end -->
    </div>
    <!-- END SLIDER -->

    <div class="main">
      <div class="container">
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SALE PRODUCT -->
          <div class="col-md-12 sale-product">
            <h2>Sản phẩm mới</h2>
            <div class="owl-carousel owl-carousel5">
            <c:forEach items="${listSevenProduct}" var="p">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <c:url value="/image?fname=${p.picture}" var="imgUrl"></c:url>
					<img class="img-responsive" src="${imgUrl}"  alt="${p.name}" />
                  </div>
                  <h3><a href="${pageContext.request.contextPath}/detail?pid=${p.id}">${p.name}</a></h3>
                  <div class="pi-price">${String.format("%0,10.0f",p.price)} đ</div>
                    <a href="${pageContext.request.contextPath}/detail?pid=${p.id}" class="btn btn-default add2cart">Chi tiết</a>
                </div>
              </div>
             </c:forEach>
            </div>
          </div>
          <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40 ">
          <!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-4">
            <ul class="list-group margin-bottom-25 sidebar-menu">
             <c:forEach items="${listCate}" var="c">
              <li class="list-group-item clearfix"><a href="${pageContext.request.contextPath}/product?cid=${c.id}&scid=0"><i class="fa fa-angle-right"></i> ${c.name} </a></li>
			</c:forEach>
            </ul>
          </div>
          <!-- END SIDEBAR -->
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-8">
            <h2>Sản phẩm được mua nhiều</h2>
            <div class="owl-carousel owl-carousel3">
            <c:forEach items="${listSixProduct}" var="p">
              <div>
                <div class="product-item">
                  <div class="pi-img-wrapper">
                  <c:url value="/image?fname=${p.picture}" var="imgUrl"></c:url>
					<img class="img-responsive" src="${imgUrl}"  alt="${p.name}" />
                  </div>
                  <h3><a href="${pageContext.request.contextPath}/detail?pid=${p.id}">${p.name}</a></h3>
                  <div class="pi-price">${String.format("%0,10.0f",p.price)} đ</div>
                  <a href="${pageContext.request.contextPath}/detail?pid=${p.id}" class="btn btn-default add2cart">Chi tiết</a>
                </div>
              </div>
             </c:forEach>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>
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

    <!-- BEGIN fast view of a product -->
    <div id="product-pop-up" style="display: none; width: 700px;">
            <div class="product-page product-pop-up">
              <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-3">
                  <div class="product-main-image">
                    <img src="${url}/frontend/pages/img/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
                  </div>
                  <div class="product-other-images">
                    <a href="#" class="active"><img alt="Berry Lace Dress" src="${url}/frontend/pages/img/products/model3.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${url}/frontend/pages/img/products/model4.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${url}/frontend/pages/img/products/model5.jpg"></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-9">
                  <h2>Cool green dress with red bell</h2>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>$</span>47.00</strong>
                      <em>$<span>62.00</span></em>
                    </div>
                    <div class="availability">
                      Availability: <strong>In Stock</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat
Nostrud duis molestie at dolore.</p>
                  </div>
                  <div class="product-page-options">
                    <div class="pull-left">
                      <label class="control-label">Size:</label>
                      <select class="form-control input-sm">
                        <option>L</option>
                        <option>M</option>
                        <option>XL</option>
                      </select>
                    </div>
                    <div class="pull-left">
                      <label class="control-label">Color:</label>
                      <select class="form-control input-sm">
                        <option>Red</option>
                        <option>Blue</option>
                        <option>Black</option>
                      </select>
                    </div>
                  </div>
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">Add to cart</button>
                    <a href="shop-item.html" class="btn btn-default">More details</a>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
    </div>
    <!-- END fast view of a product -->

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

    <!-- BEGIN LayerSlider -->
    <script src="${url}/global/plugins/slider-layer-slider/js/greensock.js" type="text/javascript"></script><!-- External libraries: GreenSock -->
    <script src="${url}/global/plugins/slider-layer-slider/js/layerslider.transitions.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="${url}/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script><!-- LayerSlider script files -->
    <script src="${url}/frontend/pages/scripts/layerslider-init.js" type="text/javascript"></script>
    <!-- END LayerSlider -->

    <script src="${url}/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            LayersliderInit.initLayerSlider();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initTwitter();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
	<script>
	const checkout = document.getElementById("checkout");
	checkout.onclick = () => {location.replace("${pageContext.request.contextPath }/checkout");}
	</script>
    <script>
    function addToCart(id, price, amount,userID){
    	if(userID == null){
    		location.replace("${pageContext.request.contextPath }/login");
    	}else{
        	$.ajax({
    			url : "/BanHang/api/add-to-cart?id=" + id + "&price=" + price + "&amount=" + amount,
    			type : "get",
    			data : {
    				
    			},
    			success : function(data) {
    				const array = data.split("/")
    				document.getElementById("cartQuantity").innerText = array[0] + " sản phẩm"
    				document.getElementById("cartCharge").innerText = array[1] + "đ'";
    			},
    			error : function(xhr) {
    				console.log(xhr)
    			}
    		});
    	}
    }
    </script>
    
</body>
</html>