
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Expense Tracker | Homedashboard</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <jsp:include page="AdminCss.jsp"></jsp:include>

</head>

<body>
	<div class = "d-flex flex-column min-vh-100">

	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<jsp:include page="HomeSideBar.jsp"></jsp:include>
  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Dashboard</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="homedashboard">Home</a></li>
          <li class="breadcrumb-item active">Dashboard</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="row">

        <!-- Left side columns -->
        <div class="col-lg-12">
          <div class="row">
          
          <!-- Account Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">

								<div class="card-body">
									<h5 class="card-title">
										Accounts <span>| Total</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-people"></i>
										</div>
										<div class="ps-3">
											<h6>${totalAccountsOfUser}</h6>
											<!-- <span class="text-success small pt-1 fw-bold"></span><span
												class="text-muted small pt-2 ps-1">increase</span> -->

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Account Card -->
						
          <!-- Expense Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">

								<div class="card-body">
									<h5 class="card-title">
										Expense <span>| Overall</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-cash-stack"></i>
										</div>
										<div class="ps-3">
											<h6>${totalExpense}</h6>
											<!-- <span class="text-success small pt-1 fw-bold"></span><span
												class="text-muted small pt-2 ps-1">increase</span> -->

										</div>
									</div>
								</div>

							</div>
						</div>
		  <!-- End Expense Card -->
          <!-- Income Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">

								<div class="card-body">
									<h5 class="card-title">
										Income <span>| Overall</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-currency-rupee"></i>
										</div>
										<div class="ps-3">
											<h6>${totalIncome}</h6>
											<!-- <span class="text-success small pt-1 fw-bold"></span><span
												class="text-muted small pt-2 ps-1">increase</span> -->

										</div>
									</div>
								</div>

							</div>
						</div>
		  <!-- End Income Card -->

            <!-- Reports -->
            <div class="col-12">
              <div class="card">

                <div class="card-body">
                  <h5 class="card-title">Reports <span>/Today</span></h5>
                </div>
                <div class="col-lg-12">
				
				
				<!-- Bar Chart -->
              <canvas id="barChart" style="max-height: 400px;"></canvas>
              <script>
                document.addEventListener("DOMContentLoaded", () => {
                  new Chart(document.querySelector('#barChart'), {
                    type: 'bar',
                    data: {
                      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                      datasets: [{
                        label: 'Bar Chart',
                        data: [12, 59, 80, 81, 56, 55, 40],
                        backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(255, 159, 64, 0.2)',
                          'rgba(255, 205, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(153, 102, 255, 0.2)',
                          'rgba(201, 203, 207, 0.2)'
                        ],
                        borderColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 159, 64)',
                          'rgb(255, 205, 86)',
                          'rgb(75, 192, 192)',
                          'rgb(54, 162, 235)',
                          'rgb(153, 102, 255)',
                          'rgb(201, 203, 207)'
                        ],
                        borderWidth: 1
                      }]
                    },
                    options: {
                      scales: {
                        y: {
                          beginAtZero: true
                        }
                      }
                    }
                  });
                });
              </script>
              <!-- End Bar CHart -->

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

	

</body>
</html>