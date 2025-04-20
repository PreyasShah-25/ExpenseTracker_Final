<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


</head>
<body>

<div class = " d-flex flex-column min-vh-100 ">


	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSideBar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 500px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row" >
						<!-- Reports -->
						<div class="col-12">
							<div class="card">

							 
								<div class="card-body">
									<h5 class="card-title">
										Vendor<span>/View </span>
									</h5>
									<table class="table datatable datatable-table table-hover" id="viewVendor">

											<thead>
													<tr>
														<!-- <th> CategoryId</th> -->
														<th>Title</th>
											
													</tr>
											</thead>
	
												<tbody>
														<tr> 
															<%-- <td>${category[0][0] }</td> --%>
															<td> ${vendor.title}</td>
																
														</tr>	
												</tbody>	
</table>
									
									
									

					<br><br>
					<br><br>
					

								</div>

							</div>
						</div>
						<!-- End Reports -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
	<!-- main content end  -->


	<jsp:include page="AdminFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>
	
	

	</div>
	
</body>
</html>