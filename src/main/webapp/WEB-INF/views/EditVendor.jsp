
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Edit Vendor</title>

    <jsp:include page="AdminCss.jsp"></jsp:include>
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
                    <li class="breadcrumb-item active">Edit Vendor</li>
                </ol>
            </nav>
        </div>

        <section class="section dashboard">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Vendor Details</h5>

                            <!-- Edit Vendor Form -->
                            <form action="updatevendor" method="post">
                                <div class="mb-3">
                                    <label class="form-label">Vendor Title</label>
                                    <input type="text" class="form-control" name="title" value="${vendor.title}" required>
                                </div>

                                <input type="hidden" name="vendorId" value="${vendor.vendorId}">

                                <button type="submit" class="btn btn-primary">Update Vendor</button>
                                <a href="listvendors" class="btn btn-secondary">Cancel</a>
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

    <!-- JavaScript to close sidebar when Edit Vendor is clicked -->
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("sidebar").classList.remove("open");
        });
    </script>

</body>
</html>
