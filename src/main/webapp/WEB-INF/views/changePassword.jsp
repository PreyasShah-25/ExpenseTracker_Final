<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Change Password</title>

    <jsp:include page="AdminCss.jsp"></jsp:include>

    <style>
        .change-password-container {
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            width: 100%;
            max-width: 400px;
        }
    </style>
</head>

<body>
	<div class = "d-flex flex-column min-vh-100">
    <div class="change-password-container">
        <div class="card shadow-sm">
            <div class="card-body">
                <h5 class="card-title text-center pb-0 fs-4">Change Password</h5>
                <p class="text-center small">Enter your details to reset your password</p>

                <form action="updatepassword" method="post" class="row g-3 needs-validation">
                    <div class="col-12">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" name="email" class="form-control" id="email" required>
                    </div>
                    <div class="col-12">
                        <label for="otp" class="form-label">OTP</label>
                        <input type="text" name="otp" class="form-control" id="otp" required>
                    </div>
                    <div class="col-12">
                        <label for="password" class="form-label">New Password</label>
                        <input type="password" name="password" class="form-control" id="password" required>
                    </div>
                    <div class="col-12">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" required>
                    </div>
                    <div class="col-12">
                        <button class="btn btn-primary w-100" type="submit">Update Password</button>
                    </div>
                    <div class="col-12 text-center">
                        <p class="small mb-0"><a href="login">Back to Login</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="AdminJs.jsp"></jsp:include>
	</div>
</body>

</html>