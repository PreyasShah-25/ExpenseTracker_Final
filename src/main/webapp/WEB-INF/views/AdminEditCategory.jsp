<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Edit Category</title>

    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
	
	<div class ="d-flex flex-column min-vh-100"> 
	
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="AdminSideBar.jsp"></jsp:include>
   

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>Category</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                    <li class="breadcrumb-item active">Edit Category</li>
                </ol>
            </nav>
        </div>

        <section class="section dashboard">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit Category Details</h5>

                            <!-- Edit Category Form -->
                            <form action="adminupdatecategory" method="post">
                                <div class="mb-3">
                                    <label for="categoryName" class="form-label">Category Name</label>
                                    <input type="text" class="form-control" id="categoryName" name="categoryName" value="${category.categoryName}" required>
                                </div>

                                <!-- Hidden input to pass category ID -->
                                <input type="hidden" name="categoryId" value="${category.categoryId}">

                                <button type="submit" class="btn btn-primary">Update Category</button>
                                <a href="adminlistcategory" class="btn btn-secondary">Cancel</a>
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
	</div>
</body>
</html>