<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Prak</title>
    <link type="text/css" rel="stylesheet" href="../static/style/styles.css"/>
</head>
<body>
<#if user.email??>
    <h1>База данных студентов</h1>
    <h3>Привет, ${user.username}, рады вас видеть</h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="выйти">
    </form>
    <form action="/userlist" method="get">
        <input type="submit" value="Студенты"/>
    </form>
<#else>
    <form action="/login" method="get">
        <input type="submit" value="Войти">
    </form>
</#if>
</body>
</html>
