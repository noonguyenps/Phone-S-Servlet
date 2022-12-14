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
<body class="page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo ">
	<div class="page-content-wrapper">
		<div class="page-content">
		<form action="" method="post">
			<div class="col-md-10">
				<label class="col-md-2">Từ ngày</label>
				<div class="col-md-4">
					<div class="input-group input-large date-picker input-daterange"
						data-date="10/11/2012" data-date-format="mm/dd/yyyy">
						<input type="date" class="form-control" name="from"
							value="${from }"> <span class="input-group-addon"> Đến
						</span> <input type="date" class="form-control" name="to" value="${to }">
					</div>
					<button type="submit" type="button" class="btn btn-primary">Thực hiện</button>
				</div>
			</div>
		</form>	
			<div class="row">
				<div class="col-md-6 col-xs-12">
					<table class="table">
						<tr>
							<th>Tên sản phẩm</th>
							<th>Doanh số</th>
							<th>Doanh thu</th>
						</tr>
						<c:forEach items="${stats}" var="s">
						<tr>
							<td>${s[0] }</td>
							<td>${s[1] }</td>
							<td>${String.format("%0,10.0f",s[3])} </td>
						</tr>
						</c:forEach>
					</table>
				</div>
				
				<div class="col-md-6 col-xs-12">
					 <canvas id="doanhSoStats"></canvas>
				</div>
				
				
				<div class="col-md-6 col-xs-12">
					 <canvas id="doanhThuStats"></canvas>
				</div>
				
			</div>
		</div>
	</div>		



<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
function getRandomRgb() {
	  var num = Math.round(0xffffff * Math.random());
	  var r = num >> 16;
	  var g = num >> 8 & 255;
	  var b = num & 255;
	  return 'rgb(' + r + ', ' + g + ', ' + b + ')';
}


let labels=[], infoDS=[], colors=[];
let infoDT=[];
<c:forEach items="${stats}" var="s">
	labels.push("${s[0]}")
	infoDS.push(${s[1]})
	infoDT.push(${s[2]})
</c:forEach>


for(let i=0; i<labels.length; i++){
	var color = getRandomRgb();
	colors.push(color)
}
/* DOANH SỐ STATS */
const dataDS = {
		  labels: labels,
		  datasets: [{
		    label: 'Thống kê doanh số',
		    data: infoDS,
		    backgroundColor: colors,
		    hoverOffset: 4
		  }]
		};
		

const dataDT = {
		  labels: labels,
		  datasets: [{
		    label: 'Thống kê doanh thu',
		    data: infoDT,
		    backgroundColor: colors,
		    borderColor: colors,
		    borderWidth: 1
		  }]
		};

const configDS = {
		  type: 'doughnut',
		  data: dataDS,
		};

const configDT = {
		  type: 'bar',
		  data: dataDT,
		  options: {
		    scales: {
		      y: {
		        beginAtZero: true
		      }
		    }
		  },
		};

let ctxDS = document.getElementById('doanhSoStats').getContext('2d')
new Chart(ctxDS, configDS)

let ctxDT = document.getElementById('doanhThuStats').getContext('2d')
new Chart(ctxDT, configDT)
/* END DOANH SỐ STATS */



</script>


<script type="text/javascript" src="${url}/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
</body>
<!-- END BODY -->
</html>