<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>ExpenseReport</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
 <link href="https://cdn.datatables.net/buttons/3.2.2/css/buttons.dataTables.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="HomeSideBar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>ExpenseReport</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="homedashboard">Home</a></li>
					<li class="breadcrumb-item active">ExpenseReport</li>
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
										Expense<span>/all</span>
									</h5>
									
									
									<table class="table datatable datatable-table table-hover" id="myExpense">
												<thead>
															<tr>
																
																<th>Title</th>
																<th>Amount</th>
																<th>TranscationDate</th>
																<th>Description</th>
																
															
															</tr>
												</thead>
			
								<tbody>
			
										<c:forEach items="${expenseList}" var="e">
														
												<tr>
														
														<td> ${e[7] }</td>
														<td> ${e[2] }</td>
														<td> ${e[8]}</td>
														<td> ${e[4] }</td>
														
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
	
	<script src ="https://cdn.datatables.net/buttons/3.2.2/js/dataTables.buttons.js"></script>
		<script src ="https://cdn.datatables.net/buttons/3.2.2/js/buttons.dataTables.js"></script>
		<script src ="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
		<script src ="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
		<script src ="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
		<script src ="https://cdn.datatables.net/buttons/3.2.2/js/buttons.html5.min.js"></script>
		<script src ="https://cdn.datatables.net/buttons/3.2.2/js/buttons.print.min.js"></script>

	    <script type="text/javascript">
	        $(document).ready(function() {
	           //new DataTable('#myExpense');
	            new DataTable('#myExpense', {
	                layout: {
	                    topStart: {
	                        buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
	                    }
	                }
	            });
	        });
	    </script>
  
 
 

	
	
	
	
</body>
</html>