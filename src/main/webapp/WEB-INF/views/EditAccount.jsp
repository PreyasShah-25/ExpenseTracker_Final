<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Update Account</title>

    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>

    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="HomeSideBar.jsp"></jsp:include>

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>Accounts</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="homedashboard">Home</a></li>
                    <li class="breadcrumb-item active">Update Account</li>
                </ol>
            </nav>
        </div>

        <section class="section dashboard">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Update Account Details</h5>

                            <!-- Update Account Form -->
                            <form action="updateaccount" method="post" id="editAccountForm">
                                <div class="mb-3">
                                    <label class="form-label">Account Title</label>
                                    <input type="text" class="form-control" name="title" value="${account.title}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Amount</label>
                                    <input type="number" class="form-control" name="amount" value="${account.amount}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="3" required>${account.description}</textarea>
                                </div>

                                <!-- Hidden input to pass account ID -->
                                <input type="hidden" name="accountId" value="${account.accountId}">

                                <button type="submit" class="btn btn-primary">Update Account</button>
                                <a href="listaccount" class="btn btn-secondary">Cancel</a>
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