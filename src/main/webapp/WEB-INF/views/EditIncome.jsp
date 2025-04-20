<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Update Income</title>

    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>

    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="HomeSideBar.jsp"></jsp:include>

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>Income</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="homedashboard">Home</a></li>
                    <li class="breadcrumb-item active">Update Income</li>
                </ol>
            </nav>
        </div>

        <section class="section dashboard">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Update Income Details</h5>

                            <!-- Update Account Form -->
                            <form action="updateincome" method="post" id="editIncomeForm">
                                <div class="mb-3">
                                    <label class="form-label">Income Title</label>
                                    <input type="text" class="form-control" name="title" value="${income.title}" required>
                                </div>

                                <div class="mb-3">	
                                    <label class="form-label">Amount</label>
                                    <input type="number" class="form-control" name="amount" value="${income.amount}" required>
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">Income Title</label>
                                    <input type="date" class="form-control" name="transcationDate" value="${income.transcationDate}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="3" required>${income.description}</textarea>
                                </div>
                                <div class = "mb-3">
                                	<label for="accountId" class="form-label">Select Account</label>
                                        <select  class="form-select" id="accountId" name="accountId" required>
									        <option   selected >  Select Account </option>
									        <c:forEach items = "${allAccount}" var = "account">
									        	<option value="${ account.accountId}"  ${account.accountId == account.accountId? "selected":"" }>${account.title}</option>        
									        </c:forEach>
									        </select><br>
                                	</div>

                                <!-- Hidden input to pass account ID -->
                                <input type="hidden" name="incomeId" value="${income.incomeId}">

                                <button type="submit" class="btn btn-primary">Update Income</button>
                                <a href="listincome" class="btn btn-secondary">List Income</a>
                            </form>
                            <!-- End Form -->

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <jsp:include page="AdminFooter.jsp"></jsp:include>
    <jsp:include page="AdminJs.jsp"></jsp:include>

    <!-- JavaScript to close sidebar when Edit is clicked -->
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Close sidebar when Edit Account form is loaded
            document.getElementById("sidebar").classList.remove("open");
        });
    </script>

</body>
</html>