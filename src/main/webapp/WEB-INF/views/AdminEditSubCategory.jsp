<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Edit Subcategory</title>
    
    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <jsp:include page="AdminSideBar.jsp"></jsp:include>

    <main id="main" class="main">
        <div class="pagetitle">
            <h1>Dashboard</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
                    <li class="breadcrumb-item active">Edit Subcategory</li>
                </ol>
            </nav>
        </div>
        
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Edit SubCategory </h5>
                            
                            <form action="adminupdatesubcategory" method="post">
                                <div class="mb-3 col-md-6">
                                    <label for="title" class="form-label">Title</label>
                                    <input type="text" class="form-control" id="title" name="title" value="${subCategory.title}" required>
                                </div>
                                
                                	 <div class = "mb-3">
                                	<label class="form-label">Select Category</label>
                                        <select  class="form-select" id="categoryId" name="categoryId" required>
									        <option value ="${categoryId}" selected >  Select Category </option>
									        <c:forEach items="${allCategory}" var="category">
									        	<option value="${category.categoryId}"${category.categoryId == subCategory.categoryId?"selected":"" }>${category.categoryName}</option>        
									        </c:forEach>
									        </select><br>
                                	</div>
                                	<input type="hidden" name="subCategoryId" value="${subCategory.subCategoryId}">
                                  <button type="submit" class="btn btn-primary">Update Sub Category</button> 
                                <a href="listsubcategory" class="btn btn-secondary">List Sub Category</a> 
                            </form>
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


