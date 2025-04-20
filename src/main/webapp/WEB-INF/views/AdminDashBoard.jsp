
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>AdminDashboard</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


</head>
<body>


<div class=" d-flex flex-column min-vh-100">
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
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">

						<!-- Sales Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Users <span>| Overall</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-people"></i>
										</div>
										<div class="ps-3">
											<h6>${totalClients}</h6>
											<!-- <span class="text-success small pt-1 fw-bold">12%</span> <span
												class="text-muted small pt-2 ps-1">increase</span> -->

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End User Card -->

						<!-- Revenue Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card revenue-card">

								<!-- <div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div> -->

								<div class="card-body">
									<h5 class="card-title">
										Users <span>|  ${currentMonth}</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-people"></i>
										</div>
										<div class="ps-3">
											<h6>${thisMonthUsersCount}</h6>
											<!-- <span class="text-success small pt-1 fw-bold">8%</span> <span
												class="text-muted small pt-2 ps-1">increase</span> -->

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Revenue Card -->

						<!-- Customers Card -->
						<div class="col-xxl-4 col-xl-12">

							<div class="card info-card customers-card">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Expense <span>| Overall</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-currency-rupee"></i>
										</div>
										<div class="ps-3">
											<h6>60,354</h6>
											<!-- <span class="text-danger small pt-1 fw-bold">12%</span> <span
												class="text-muted small pt-2 ps-1">decrease</span> -->

										</div>
									</div>

								</div>
							</div>

						</div>
						<!-- End Customers Card -->

						<!-- Reports -->
						<div class="col-12">
							<div class="card">

								<!-- <div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>
 -->
							       <div class="card-body">
                  <h5 class="card-title">Reports <!-- <span>/Today</span> --> </h5>
                   <div class="row">
			<div class="col-lg-12">
				<canvas id="myBarChart"></canvas>

			</div>
		</div>
                </div>

              </div>
            </div><!-- End Reports -->
            
          </div>
        </div><!-- End Left side columns -->

      </div>
     
    </section>

  </main><!-- End #main -->

	<jsp:include page="AdminFooter.jsp"></jsp:include>
	<jsp:include page="AdminJs.jsp"></jsp:include>

</div>
	 <script>
        // Get canvas element
        const ctx = document.getElementById('myBarChart').getContext('2d');

        // Create Bar Chart
        const myBarChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June','July','August','September','October','November','December'],
                datasets: [{
                    label: 'Users Count Month wise',
                    data: [${monthWiseUsers[0]},${monthWiseUsers[1]},${monthWiseUsers[2]},${monthWiseUsers[3]},${monthWiseUsers[4]},${monthWiseUsers[5]},${monthWiseUsers[6]}],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.6)',
                        'rgba(54, 162, 235, 0.6)',
                        'rgba(255, 206, 86, 0.6)',
                        'rgba(75, 192, 192, 0.6)',
                        'rgba(153, 102, 255, 0.6)',
                        'rgba(255, 159, 64, 0.6)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>


	
	</div>
</body>
</html>
