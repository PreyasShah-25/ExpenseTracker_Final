<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="HomeSideBar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
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
										SubCategory<span>/all</span>
									</h5>
									
				<table  class="table datatable datatable-table table-hover" id="mySubCategory">
										<thead>
													<tr>
															<th>SubCategory</th>
															<th>Category</th>
															<th>FirstName</th>
															<th>Action</th>
											       </tr>
										</thead>
										
										<tbody>
											<c:forEach items="${scList}"  var ="s">
														<tr>
																<td>${s[2]}</td>
																<td>${s[5]}</td>
																<td>${s[4]}</td>
																
																<td><a href="viewsubcategory?subCategoryId=${s[0]}"><i class="bi bi-binoculars"></i>View</a>|
																<a href="deletesubcategory?subCategoryId=${s[0]}"><i class="bi bi-trash3"></i>Delete</a>|
																<a  href ="editsubcategory?subCategoryId=${s[0] }"><i class="bi bi-pencil-square"></i>Edit</a></td>
														
														</tr>											
											</c:forEach>
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
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin></script>

 	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>
  
 
 

	<script type="text/javascript">

	$( document ).ready(function() {
		let table = new DataTable('#mySubCategory');
	});
	</script>
	
	
	
</body>
</html>