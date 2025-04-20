
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Add SubCategory</title>
    
    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="AdminSideBar.jsp"></jsp:include>

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>SubCategory</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href=admindashboard>Home</a></li>
                    <li class="breadcrumb-item active">Add SubCategory</li>
                </ol>
            </nav>
        </div>
        
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Add New SubCategory</h5>
                            
                            <form action="adminsavesubcategory" method="post">
                                <div class="mb-3">
                                    <label for="subcategory" class="form-label">SubCategory </label>
                                    <input type="text" class="form-control" id="subcategoryName" name="title" required>
                                </div>
                                
                                <div class = "mb-3">
                                	<label for="categoryId" class="form-label">Select Category</label>
                                        <select  class="form-select" id="categoryId" name="categoryId" required>
									        <option value="" >  Select Category </option>
									        <c:forEach items = "${allCategory }" var = "s">
									        	<option value="${ s.categoryId}">${s.categoryName}   </option>        
									        </c:forEach>
									        </select><br><br>
                                	</div>
                                <button type="submit" class="btn btn-primary">Add SubCategory</button>
                            </form>
                            <br>
                            <a href="adminlistsubcategory" class="btn btn-secondary">List SubCategories</a>
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
