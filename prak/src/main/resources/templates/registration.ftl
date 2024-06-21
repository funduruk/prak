<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <script>
        function validateForm() {
            var password = document.forms["registrationForm"]["password"].value;
            var errorMessage = "";

            if (password.length <= 8) {
                errorMessage += "Password must be longer than 8 characters.\n";
            }
            if (!/[A-Z]/.test(password)) {
                errorMessage += "Password must contain at least one uppercase letter.\n";
            }
            if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
                errorMessage += "Password must contain at least one special character.\n";
            }

            if (errorMessage) {
                alert(errorMessage);
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h1>Registration</h1>
<form name="registrationForm" action="/registration" method="post" onsubmit="return validateForm()">
    Username: <input type="text" name="name" required>
    Email: <input type="email" name="email" required>
    Number phone: <input type="text" name="phoneNumber" required>
    Password: <input type="password" name="password" required>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Go!">
</form>

<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>
