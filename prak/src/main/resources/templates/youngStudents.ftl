<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Студенты младше 25</title>
</head>
<body>
    <h1>Студенты младше 25 лет</h1>
    <#list students as student>
        <li>${student.firstname} | ${student.middlename} | ${student.birthdate}</li>
    </#list>
</body>
</html>