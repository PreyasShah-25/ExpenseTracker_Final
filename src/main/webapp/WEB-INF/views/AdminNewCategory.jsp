
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Add Category</title>
    
    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="AdminSideBar.jsp"></jsp:include>

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>Category</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                    <li class="breadcrumb-item active">Add Category</li>
                </ol>
            </nav>
        </div>
        
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Add New Category</h5>
                            
                            <form action="adminsavecategory" method="post">
                                <div class="mb-3">
                                    <label for="categoryName" class="form-label">Category Name</label>
                                    <input type="text" class="form-control" id="categoryName" name="categoryName" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Add Category</button>
                            </form>
                            <br>
                            <a href="adminlistcategory" class="btn btn-secondary">List Categories</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <jsp:include page="AdminFooter.jsp"></jsp:include>
    <jsp:include page="AdminJs.jsp"></jsp:include>
</body>
</html>
