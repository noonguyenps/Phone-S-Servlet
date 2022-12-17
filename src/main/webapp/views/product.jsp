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
            <a id="cartQuantity" class="top-cart-info-count">${cartQuantity } sản phẩm</a>
          </div>
            <i id="checkout" class="fa fa-shopping-cart" style="cursor: pointer;"></i>
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
          <ul>
          <c:forEach items="${listCate}" var="c">
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="${pageContext.request.contextPath}/product?cid=${c.id}&scid=0">
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
    <!-- Header END -->

    <div class="main">
      <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-5">
            <ul class="list-group margin-bottom-25 sidebar-menu">
            <c:forEach items="${listCate}" var="c">
            <li>
              <a href="${pageContext.request.contextPath}/product?cid=${c.id}&scid=0">
                ${c.name} 
             <i class="fa fa-angle-right"></i> </a> </li>
              <!-- BEGIN DROPDOWN MENU -->
               <ul class="dropdown-menu" style="display:block;">
               <c:forEach items="${listSubCate}" var="s">
               <c:if test="${ c.id == s.category.id}">
                <li><a href="${pageContext.request.contextPath}/product?cid=0&scid=${s.id}" class="collapsed"><i class="fa fa-angle-right"></i> ${s.name}</a></li>
                </c:if>
                </c:forEach>
              </ul>
              <!-- END DROPDOWN MENU -->
           </c:forEach>
            </ul>
          </div>
          <!-- END SIDEBAR -->
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <div class="row list-view-sorting clearfix">
              <div class="col-md-2 col-sm-2 list-view">
                <a href="#"><i class="fa fa-th-large"></i></a>
                <a href="#"><i class="fa fa-th-list"></i></a>
              </div>
            </div>
            <!-- BEGIN PRODUCT LIST -->
            <div class="row product-list" id="productContent">
              <!-- PRODUCT ITEM START -->
              
              <c:forEach items="${listAllProduct}" var="p">
              <%-- <c:forEach begin="0" end="2" var="i"> --%>
              <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="product-item">
                  <div class="pi-img-wrapper">
                    <c:url value="/image?fname=${p.picture}" var="imgUrl"></c:url>
					<img class="img-responsive" src="${imgUrl}"  alt="${p.name}" />
                  </div>
                  <h3><a href="${pageContext.request.contextPath}/detail?pid=${p.id}">${p.name}</a></h3>
                  <div class="pi-price">$${String.format("%0,10.0f",p.price)}</div>
                  <a href="${pageContext.request.contextPath}/detail?pid=${p.id}" class="btn btn-default add2cart">Chi tiết</a>
                </div>
                  </div>
               </c:forEach>
            
              <!-- PRODUCT ITEM END -->
            </div>
            <!-- END PRODUCT LIST -->
            <!-- BEGIN PAGINATOR -->
            <div class="row">
              <div class="col-md-8 col-sm-8">
                <ul class="pagination pull-right">
                  <li onclick="nextPageClick()"><a>&laquo;</a></li>
				  <c:forEach begin="1" end="${pages }" var="i">
                  	<li onclick="paging(${i})" ><a id="pageNumber${i }"  ${i==1? "style='background-color:yellow'":"" } >${i }</a></li>
                  </c:forEach>
                  <li onclick="prePageClick()"><a>&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- END PAGINATOR -->
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
    <!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
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
    
    
    <script>
	    function addToCart(id, price, amount){
	    	console.log(id)
	    	$.ajax({
				url : "/api/add-to-cart?id=" + id + "&price=" + price + "&amount=" + amount,
				type : "get",
				data : {
					
				},
				success : function(data) {
					const array = data.split("/")
					document.getElementById("cartQuantity").innerText = array[0] + " items"
					document.getElementById("cartCharge").innerText = array[1]
				},
				error : function(xhr) {
					console.log(xhr)
				}
			});
	    }
    </script>
    
    <script>
    	curPage = 1
    	function paging(page){
    		oldPage = curPage
    		document.getElementById("pageNumber" + oldPage).style.backgroundColor = ""
    		curPage = page
    		document.getElementById("pageNumber" + page).style.backgroundColor = "yellow"
    		
    		start = (page-1)*3
    		end = start + 2
    		if(end > ${listAllProduct.size()-1})
    			end = ${listAllProduct.size()}
    		console.log(start)
    		console.log(end)
    		document.getElementById("productContent").innerHTML = ""
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