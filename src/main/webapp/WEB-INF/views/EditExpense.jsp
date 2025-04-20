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
            <h1>Dashboard</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item active">Update Expense</li>
                </ol>
            </nav>
        </div>

        <section class="section dashboard">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Update Expense Details</h5>

                            <!-- Update Account Form -->
                            <form action="updateexpense" method="post" id="editExpenseForm">
                                <div class="mb-3">
                                    <label class="form-label">Expense Title</label>
                                    <input type="text" class="form-control" name="title" value="${expense.title}" required>
                                </div>

                                <div class="mb-3">	
                                    <label class="form-label">Amount</label>
                                    <input type="number" class="form-control" name="amount" value="${expense.amount}" required>
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">Income Date</label>
                                    <input type="date" class="form-control" name="transcationDate" value="${expense.transcationDate}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="3" required>${expense.description}</textarea>
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
                                	 <div class = "mb-3">
                                	<label for="categoryId" class="form-label">Select Category</label>
                                        <select  class="form-select" id="categoryId" name="categoryId" required>
									        <option valu="" selected >Select Category </option>
									        <c:forEach items = "${allCategory}" var="category">
									        	<option value="${category.categoryId}"  ${category.categoryId == expense.categoryId? "selected":"" }>${category.categoryName}</option>        
									        </c:forEach>
									        </select><br>
                                	</div>
                                	 <div class = "mb-3">
                                	<label for="subCategoryId" class="form-label">Select SubCategory</label>
                                        <select  class="form-select" id="subCategoryId" name="subCategoryId" required>
									        <option   selected>  Select SubCategory </option>
									        <c:forEach items = "${allSubCategory}" var = "subcategory">
									        	<option value="${ subcategory.subCategoryId}" ${ subcategory.subCategoryId  == expense.subCategoryId? "selected":""}>${subcategory.title}</option>        
									        </c:forEach>
									        </select><br>
                                	</div>
                                	 <div class = "mb-3">
                                	<label for="vendorId" class="form-label">Select Vendor</label>
                                        <select  class="form-select" id="vendorId" name="vendorId" required>
									        <option   selected>  Select Vendor </option>
									        <c:forEach items = "${allVendor}" var = "vendor">
									        	<option value="${ vendor.vendorId}" ${ vendor.vendorId  == expense.vendorId? "selected":""} >${vendor.title}   </option>        
									        </c:forEach>
									        </select><br>
                                	</div>
                                

                                <!-- Hidden input to pass account ID -->
                                <input type="hidden" name="expenseId" value="${expense.expenseId}">

                                <button type="submit" class="btn btn-primary">Update Expense</button>
                                <a href="listexpense" class="btn btn-secondary">List Expense</a>
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