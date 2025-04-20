
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item"><a class="nav-link collapsed" href="admindashboard">
                <i class="bi bi-grid"></i> <span>Dashboard</span>
        </a></li>
        <!-- End Dashboard Nav -->

        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-person"></i><span>Users</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="components-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="signup"> <i class="bi bi-circle"></i><span>Add User</span>
                </a></li>
                <li><a href="listuser"> <i class="bi bi-circle"></i><span>List User</span>
                </a></li>
            </ul></li>
        <!-- End Users Nav -->
        
        
         <li class="nav-item"><a class="nav-link ${pageContext.request.servletPath ==  '/WEB-INF/views/AdminNewAccount.jsp' ? '' : 'collapsed'}" 
            data-bs-target="#account-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-wallet"></i><span>Account</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="account-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewaccount"> <i class="bi bi-circle"></i><span>Add Account</span>
                </a></li>
                <li><a href="adminlistaccount"> <i class="bi bi-circle"></i><span>List Account</span>
                </a></li>
            </ul></li>
        

        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#vendors-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-briefcase"></i><span>Vendors</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="vendors-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewvendor"> <i class="bi bi-circle"></i><span>Add Vendor</span>
                </a></li>
                <li><a href="adminlistvendor"> <i class="bi bi-circle"></i><span>List Vendor</span>
                </a></li>
            </ul></li>
        <!-- End Vendors Nav -->

        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#category-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-gem"></i><span>Category</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="category-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewcategory"> <i class="bi bi-circle"></i><span>Add Category</span>
                </a></li>
                <li><a href="adminlistcategory"> <i class="bi bi-circle"></i><span>List Categories</span> 
                </a></li>
            </ul></li>
        <!-- End Category Nav -->
        
        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#subcategory-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-layers"></i><span>Sub Category</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="subcategory-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewsubcategory"> <i class="bi bi-circle"></i><span>Add Sub Category</span>
                </a></li>
                <li><a href="adminlistsubcategory"> <i class="bi bi-circle"></i><span>List Sub Categories</span> 
                </a></li>
            </ul></li>
        <!-- End Sub Category Nav -->

        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#expense-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-cash"></i><span>Expense</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="expense-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewexpense"> <i class="bi bi-circle"></i><span>Add Expense</span>
                </a></li>
                <li><a href="adminlistexpense"> <i class="bi bi-circle"></i><span>List Expense</span>
                </a></li>
            </ul></li>
        <!-- End Expense Nav -->
        
        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#income-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-cash-stack"></i><span>Income</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="income-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminnewincome"> <i class="bi bi-circle"></i><span>Add Income</span>
                </a></li>
                <li><a href="adminlistincome"> <i class="bi bi-circle"></i><span>List Incomes</span>
                </a></li>
            </ul></li>
        <!-- End Income Nav -->
        <li class="nav-item"><a class="nav-link collapsed"
            data-bs-target="#report-nav" data-bs-toggle="collapse" href="#"> <i
                class="bi bi-cash-stack"></i><span>Reports</span><i
                class="bi bi-chevron-down ms-auto"></i>
        </a>
            <ul id="report-nav" class="nav-content collapse "
                data-bs-parent="#sidebar-nav">
                <li><a href="adminexpensereport"> <i class="bi bi-circle"></i><span>Expense Report</span>
                </a></li>
                <li><a href="adminincomereport"> <i class="bi bi-circle"></i><span>Income Report</span>
                </a></li>
                <li><a href="adminuserreport"> <i class="bi bi-circle"></i><span>User Report</span>
                </a></li>
            </ul></li>
        <!-- End Income Nav -->
        <li class="nav-item">
    <a class="nav-link d-flex align-items-center" href="logout">
        <i class="bi bi-box-arrow-right"></i><span>Logout</span>
</a>
</li>
        
        
    </ul>

</aside>