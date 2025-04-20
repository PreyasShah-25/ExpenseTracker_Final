<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title> Income</title>
    
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
                    <li class="breadcrumb-item active">Add Income</li>
                </ol>
            </nav>
        </div>
        
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Add New Income</h5>
                            
                            <form action="saveincome" method="post">
                                <div class="mb-3">
                                    <label for="title" class="form-label">Title</label>
                                    <input type="text" class="form-control" id="title" name="title" required>
                                </div>
                                <div class="mb-3">
                                    <label for="amount" class="form-label">Amount</label>
                                    <input type="text" class="form-control" id="amount" name="amount" required>
                                </div>
                                 <div class="mb-3">
                                    <label for="TranscationDate" class="form-label">TranscationDate</label>
                                    <input type="date" class="form-control" id="transcationDate" name="transcationDate" required>
                                </div>
                                <div class="mb-3">
                                    <label for="description" class="form-label">Description</label>
                                    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                                </div>
                                	<div class = "mb-3">
                                	<label for="accountId" class="form-label">Select Account</label>
                                        <select  class="form-select" id="accountId" name="accountId" required>>
									        <option   value="" >  Select Account </option>
									        <c:forEach items = "${allAccount}" var = "s">
									        	<option value="${s[0]}">${s[3]}   </option>        
									        </c:forEach>
									        </select><br><br>
                                	</div>
                                <button type="submit" class="btn btn-primary">Add Income</button> 
                                <a href="listincome" class="btn btn-secondary">List Income</a>
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


